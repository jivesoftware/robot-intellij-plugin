package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;

import java.util.List;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords AND robot keywords defined in Robot files.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotKeywordDefinitionFinder {

    private final PsiElement sourceElement;
    private final String searchTerm;
    private final String methodText;
    private final String normalizedText;
    private final KeywordScope scope;
    private final List<PsiElement> results;
    private final SearchType searchType;
    private final boolean wrapPsiMethods;
    private final boolean isSeachTextFromRobotFile;

    public RobotKeywordDefinitionFinder(PsiElement sourceElement, KeywordScope scope) {
        this(sourceElement, scope, SearchType.FIRST_EXACT_MATCH);
    }

    public RobotKeywordDefinitionFinder(PsiElement sourceElement, KeywordScope scope, SearchType searchType) {
        this(sourceElement, scope, searchType, false);
    }

    public RobotKeywordDefinitionFinder(PsiElement sourceElement, KeywordScope scope, SearchType searchType, boolean wrapPsiMethods) {
        this(sourceElement, scope, searchType, wrapPsiMethods, true);
    }

    public RobotKeywordDefinitionFinder(PsiElement sourceElement, KeywordScope scope, SearchType searchType, boolean wrapPsiMethods,
                                        boolean isSearchTextFromRobotFile) {
        this.sourceElement = sourceElement;
        this.searchTerm = sourceElement.getText();
        this.methodText = RobotPsiUtil.robotKeywordToMethodFast(searchTerm);
        this.normalizedText = methodText.toLowerCase();
        this.scope = scope;
        this.searchType = searchType;
        this.wrapPsiMethods = wrapPsiMethods;
        this.isSeachTextFromRobotFile = isSearchTextFromRobotFile;
        results = Lists.newArrayList();
    }

    public void process() {
        final Project project = sourceElement.getProject();
        // Find Java methods for the keyword
        if (scope.includesJavaFiles()) {
            switch (searchType) {
                case FIND_ALL:
                    RobotJavaPsiUtil.findAllJavaRobotKeywords(project, results, wrapPsiMethods);
                    break;
                case FIND_ALL_IN_SCOPE:
                    RobotJavaPsiUtil.findAllJavaRobotKeywordsInScope(sourceElement, results, wrapPsiMethods);
                    break;
                case FIRST_EXACT_MATCH:
                    Optional<PsiMethod> result = RobotJavaPsiUtil.findUniqueJavaKeywordForRobotKeyword(project, searchTerm, wrapPsiMethods);
                    if (result.isPresent()) {
                        results.add(result.get());
                        return;
                    }
                    break;
                case FIND_ALL_EXACT_MATCHES:
                    List<PsiMethod> javaResults = RobotJavaPsiUtil.findJavaKeywordsForRobotKeyword(project, searchTerm, wrapPsiMethods);
                    results.addAll(javaResults);
                    break;
                case FIND_ALL_EXACT_MATCHES_IN_SCOPE:
                    RobotJavaPsiUtil.findJavaKeywordsForRobotKeywordInScope(sourceElement, results, true);
                    break;
                case STARTS_WITH:
                    RobotJavaPsiUtil.findAllJavaRobotKeywordsStartingWith(project, results, searchTerm, wrapPsiMethods);
                    break;
            }
        }

        //Find Robot keyword definitions from robot files
        if (scope.includesRobotFiles()) {
            switch (searchType) {
                case STARTS_WITH:
                    RobotPsiUtil.findAllRobotKeywordDefsInRobotFilesStartingWith(project, results, normalizedText);
                    break;
                case FIND_ALL:
                    RobotPsiUtil.findAllRobotKeywordDefsInRobotFiles(project, results);
                    break;
                case FIND_ALL_IN_SCOPE:
                    RobotPsiUtil.findAllRobotKeywordDefsInRobotFilesInScope(sourceElement, results);
                    break;
                case FIND_ALL_EXACT_MATCHES:
                    List<RobotKeywordTitle> matchingKeywordTitles = RobotPsiUtil.findMatchingKeywordDefsByName(searchTerm, project, isSeachTextFromRobotFile);
                    results.addAll(matchingKeywordTitles);
                    break;
                case FIND_ALL_EXACT_MATCHES_IN_SCOPE:
                    RobotPsiUtil.findMatchingKeywordDefsByNameInScope(sourceElement, results);
                    break;
                case FIRST_EXACT_MATCH:
                default:
                    Optional<RobotKeywordTitle> result = RobotPsiUtil.findUniqueKeywordDefByName(searchTerm, project, isSeachTextFromRobotFile);
                    if (result.isPresent()) {
                        results.add(result.get());
                    }
                    break;
            }
        }
    }

    public List<PsiElement> getResults() {
        return results;
    }

}
