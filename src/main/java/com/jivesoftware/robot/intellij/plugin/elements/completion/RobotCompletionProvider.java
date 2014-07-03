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
import com.jivesoftware.robot.intellij.plugin.elements.search.KeywordScope;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotTagFinder;
import com.jivesoftware.robot.intellij.plugin.elements.search.SearchType;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Handles auto-completion of Java-defined keywords when writing Robot Code.
 * Apparently, the RobotKeywordUsagesProvider already handles auto-completing robot-defined keywords.
 */
public class RobotCompletionProvider extends CompletionProvider<CompletionParameters> {

    public RobotCompletionProvider() {
        super();
    }

    private Set<LookupElement> getTagCompletions(Project project, CompletionParameters parameters, String currentlyTyped) {
        Set<LookupElement> myTagCompletions = Sets.newHashSet();
        populateTags(project, myTagCompletions, currentlyTyped);
        return myTagCompletions;
    }

    private Set<LookupElement> getKeywordCompletions(Project project, CompletionParameters parameters, String text) {
        Set<LookupElement> myKeywordCompletions = Sets.newHashSet();
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
                new RobotKeywordDefinitionFinder(project, text, KeywordScope.ROBOT_AND_JAVA_KEYWORDS, SearchType.STARTS_WITH, true);
        robotKeywordDefinitionFinder.process();
        List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
        Set<String> includedNames = Sets.newHashSet();
        for (PsiElement el : results) {
            if (el instanceof PsiMethod) {
                PsiMethod method = (PsiMethod) el;
                if (includedNames.contains(method.getName())) {
                    continue;
                }
                String parameterText = PresentationPsiUtil.getPresentableMethodParametersText(method);
                populateMe.add(LookupElementBuilder.create(method)
                        .withCaseSensitivity(false)
                        .withTailText(parameterText, true)
                        .withIcon(RobotIcons.METHOD));
                includedNames.add(method.getName());
            } else if (el instanceof RobotKeywordTitle) {
                RobotKeywordTitle robotKeywordTitle = (RobotKeywordTitle) el;
                if (includedNames.contains(robotKeywordTitle.getName())) {
                    continue;
                }
                String argumentsText = PresentationPsiUtil.getRobotKeywordArgumentTest(robotKeywordTitle);
                populateMe.add(LookupElementBuilder.create(robotKeywordTitle)
                        .withCaseSensitivity(false)
                        .withTailText(argumentsText, true)
                        .withIcon(RobotIcons.KEYWORD));
                includedNames.add(robotKeywordTitle.getName());
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
