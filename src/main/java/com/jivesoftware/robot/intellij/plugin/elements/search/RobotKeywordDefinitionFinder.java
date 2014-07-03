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

    public static final String ROBOT_KEYWORD_ANNOTATION = "org.robotframework.javalib.annotation.RobotKeyword";

    private final Project project;
    private final String searchTerm;
    private final String methodText;
    private final String normalizedText;
    private final KeywordScope scope;
    private final List<PsiElement> results;
    private final SearchType searchType;
    private final boolean wrapPsiMethods;

    public RobotKeywordDefinitionFinder(Project project, String searchTerm, KeywordScope scope) {
        this(project, searchTerm, scope, SearchType.EXACT_MATCH);
    }

    public RobotKeywordDefinitionFinder(Project project, String searchTerm, KeywordScope scope, SearchType searchType) {
        this(project, searchTerm, scope, searchType, false);
    }

    public RobotKeywordDefinitionFinder(Project project, String searchTerm, KeywordScope scope, SearchType searchType, boolean wrapPsiMethods) {
        this.project = project;
        this.searchTerm = searchTerm;
        this.methodText = RobotPsiUtil.robotKeywordToMethodFast(searchTerm);
        this.normalizedText = methodText.toLowerCase();
        this.scope = scope;
        this.searchType = searchType;
        this.wrapPsiMethods = wrapPsiMethods;
        results = Lists.newArrayList();
    }

    public void process() {
        //Find Java methods for the keyword
        if (scope == KeywordScope.ROBOT_AND_JAVA_KEYWORDS || scope == KeywordScope.JAVA_KEYWORDS) {
            switch (searchType) {
                case FIND_ALL:
                    RobotJavaPsiUtil.findAllJavaRobotKeywords(project, results, wrapPsiMethods);
                    break;
                case EXACT_MATCH:
                    Optional<PsiMethod> result = RobotJavaPsiUtil.findUniqueJavaKeywordForRobotKeyword(project, searchTerm, wrapPsiMethods);
                    if (result.isPresent()) {
                        results.add(result.get());
                    }
                    break;
                case STARTS_WITH:
                    RobotJavaPsiUtil.findAllJavaRobotKeywordsStartingWith(project, results, searchTerm, wrapPsiMethods);
                    break;
            }
        }

        if (searchType == SearchType.EXACT_MATCH && results.size() > 0) {
            return;
        }

        //Find Robot keyword definitions from robot files
        if (scope == KeywordScope.ROBOT_AND_JAVA_KEYWORDS || scope == KeywordScope.ROBOT_KEYWORDS) {
            switch (searchType) {
                case STARTS_WITH:
                    RobotPsiUtil.findAllRobotKeywordDefsInRobotFilesStartingWith(project, results, normalizedText);
                    break;
                case FIND_ALL:
                    RobotPsiUtil.findAllRobotKeywordDefsInRobotFiles(project, results);
                    break;
                case EXACT_MATCH:
                default:
                    Optional<RobotKeywordTitle> result = RobotPsiUtil.findUniqueKeywordDefByName(searchTerm, project);
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
