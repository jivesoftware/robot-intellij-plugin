package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.google.common.collect.Sets;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.PresentationPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.KeywordScope;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.elements.search.SearchType;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import com.jivesoftware.robot.intellij.plugin.settings.RobotConfigurable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Does the real work for Autocompletion of Keywords.
 */
public class RobotKeywordCompletionHelper implements RobotCompletionHelper {
    public static final RobotKeywordCompletionHelper INSTANCE = new RobotKeywordCompletionHelper();

    private RobotKeywordCompletionHelper() {

    }

    @Override
    public void handleCompletions(LeafPsiElement leaf, CompletionParameters parameters, @NotNull CompletionResultSet result, String text) {
        Set<LookupElement> keywordCompletions = getKeywordCompletions(leaf, parameters, text);
        result.addAllElements(keywordCompletions);
    }

    private Set<LookupElement> getKeywordCompletions(LeafPsiElement leaf, CompletionParameters parameters, String text) {
        Set<LookupElement> myKeywordCompletions = Sets.newHashSet();
        populateKeywords(leaf, myKeywordCompletions, text);
        return myKeywordCompletions;
    }

    private void populateKeywords(LeafPsiElement leaf, Collection<LookupElement> populateMe, String text) {
        Project project = leaf.getProject();
        final SearchType SEARCH_TYPE = RobotConfigurable.isAutocompleteKeywordsStrict(project) ?
                SearchType.FIND_ALL_IN_SCOPE :
                SearchType.FIND_ALL;
        RobotKeywordDefinitionFinder robotKeywordDefinitionFinder =
                new RobotKeywordDefinitionFinder(leaf, text, KeywordScope.ROBOT_AND_JAVA_KEYWORDS, SEARCH_TYPE, true);
        robotKeywordDefinitionFinder.process();
        List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
        Set<String> includedNames = Sets.newHashSet();
        for (PsiElement el : results) {
            if (el instanceof PsiMethod) {
                PsiMethod method = (PsiMethod) el;
                // Remove duplicates
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
}
