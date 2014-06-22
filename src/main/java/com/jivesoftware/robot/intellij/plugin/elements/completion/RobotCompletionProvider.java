package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.google.common.collect.Sets;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.elements.PresentationPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotTagFinder;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Handles auto-completion of Java-defined keywords when writing Robot Code.
 * Apparently, the RobotKeywordUsagesProvider already handles auto-completing robot-defined keywords.
 */
public class RobotCompletionProvider extends CompletionProvider<CompletionParameters> {

    private Set<LookupElement> myTagCompletions;
    private Set<LookupElement> myKeywordCompletions;

    public RobotCompletionProvider() {
        super();
    }

    private Set<LookupElement> getTagCompletions(Project project, CompletionParameters parameters, String currentlyTyped) {
        if (myTagCompletions != null && parameters.getInvocationCount() > 1) {
            return myTagCompletions;
        }
        myTagCompletions = Sets.newHashSet();
        populateTags(project, myTagCompletions, currentlyTyped);
        return myTagCompletions;
    }

    private Set<LookupElement> getKeywordCompletions(Project project, CompletionParameters parameters, String text) {
        if (myKeywordCompletions != null && parameters.getInvocationCount() > 1) {
            return myKeywordCompletions;
        }
        myKeywordCompletions = Sets.newHashSet();
        populateKeywords(project, myKeywordCompletions, text);
        return myKeywordCompletions;
    }

    private void populateTags(Project project, Collection<LookupElement> populateMe, String currentlyTyped) {
        RobotTagFinder robotTagFinder = new RobotTagFinder(project);
        robotTagFinder.process();
        List<String> tags = robotTagFinder.getResults();
        for (String tag : tags) {
            if (tag.equals(currentlyTyped)) {
                continue;
            }
            populateMe.add(LookupElementBuilder.create(tag));
        }
    }

    private void populateKeywords(Project project, Collection<LookupElement> populateMe, String text) {
        RobotKeywordDefinitionFinder robotKeywordDefinitionFinder =
                new RobotKeywordDefinitionFinder(project, text,
                        RobotKeywordDefinitionFinder.KEYWORD_SCOPE.ROBOT_AND_JAVA_KEYWORDS,
                        RobotKeywordDefinitionFinder.SEARCH_TYPE.STARTS_WITH, true);
        robotKeywordDefinitionFinder.process();
        List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
        for (PsiElement el : results) {
            if (el instanceof PsiMethod) {
                PsiMethod method = (PsiMethod) el;
                String parameterText = PresentationPsiUtil.getPresentableMethodParametersText(method);
                populateMe.add(LookupElementBuilder.create(method)
                        .withCaseSensitivity(false)
                        .withTailText(parameterText, true)
                        .withIcon(RobotIcons.METHOD));
            } else if (el instanceof RobotKeywordDef) {
                RobotKeywordDef robotKeywordDef = (RobotKeywordDef) el;
                String argumentsText = PresentationPsiUtil.getRobotKeywordArgumentTest(robotKeywordDef);
                populateMe.add(LookupElementBuilder.create(robotKeywordDef)
                        .withCaseSensitivity(false)
                        .withTailText(argumentsText, true)
                        .withIcon(RobotIcons.KEYWORD));
            }
        }
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
        PsiElement element = parameters.getOriginalPosition();
        if (!(element instanceof LeafPsiElement)) {
            return;
        }
        LeafPsiElement leaf = (LeafPsiElement) element;
        String text = leaf.getText();
        if (leaf.getElementType() == RobotTypes.TAG_TOKEN) {
            handleTagTokens(leaf, parameters, result);
        } else if (leaf.getElementType() == RobotTypes.ROBOT_KEYWORD_TOKEN) {
            handleKeywordTokens(leaf, parameters, result, text);
        }

    }

    private void handleTagTokens(LeafPsiElement leaf, @NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        Set<LookupElement> tagCompletions = getTagCompletions(leaf.getProject(), parameters, leaf.getText());
        result.addAllElements(tagCompletions);
    }

    private void handleKeywordTokens(LeafPsiElement leaf, CompletionParameters parameters, @NotNull CompletionResultSet result, String text) {
        Set<LookupElement> keywordCompletions = getKeywordCompletions(leaf.getProject(), parameters, text);
        result.addAllElements(keywordCompletions);
    }
}
