package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.collect.Lists;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.impl.java.stubs.index.JavaStubIndexKeys;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.references.PsiMethodWithRobotName;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords AND robot keywords defined in Robot files.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotKeywordDefinitionFinder implements Processor<PsiFile> {

    public static final String ROBOT_KEYWORD_ANNOTATION = "org.robotframework.javalib.annotation.RobotKeyword";

    public static enum KEYWORD_SCOPE {ROBOT_KEYWORDS, JAVA_KEYWORDS, ROBOT_AND_JAVA_KEYWORDS}
    public static enum SEARCH_TYPE {FIND_ALL, EXACT_MATCH, STARTS_WITH}

    private final Project project;
    private final String searchTerm;
    private final String methodText;
    private final String normalizedText;
    private final KEYWORD_SCOPE scope;
    private final List<PsiElement> results;
    private final SEARCH_TYPE searchType;
    private final boolean wrapPsiMethods;
    private final KeywordPredicate predicateForJavaMethods;

    public RobotKeywordDefinitionFinder(Project project, String searchTerm, KEYWORD_SCOPE scope) {
        this(project, searchTerm, scope, SEARCH_TYPE.EXACT_MATCH);
    }

    public RobotKeywordDefinitionFinder(Project project, String searchTerm, KEYWORD_SCOPE scope, SEARCH_TYPE searchType) {
        this(project, searchTerm, scope, searchType, false);
    }

    public RobotKeywordDefinitionFinder(Project project, String searchTerm, KEYWORD_SCOPE scope, SEARCH_TYPE searchType, boolean wrapPsiMethods) {
        this.project = project;
        this.searchTerm = searchTerm;
        this.methodText = RobotPsiUtil.robotKeywordToMethodFast(searchTerm);
        this.normalizedText = methodText.toLowerCase();
        this.scope = scope;
        this.searchType = searchType;
        this.wrapPsiMethods = wrapPsiMethods;
        results = Lists.newArrayList();
        switch (searchType) {
            case FIND_ALL:
                predicateForJavaMethods = ALL_PREDICATE;
                break;
            case EXACT_MATCH:
                predicateForJavaMethods = EXACT_NAME_PREDICATE;
                break;
            case STARTS_WITH:
                predicateForJavaMethods = STARTS_WITH_PREDICATE;
                break;
            default:
                predicateForJavaMethods = null;
        }
    }

    @Override
    public boolean process(PsiFile file) {
        return addResultsForJavaFile(file, results);
    }

    public void process() {
        //Find Java methods for the keyword
        if (scope == KEYWORD_SCOPE.ROBOT_AND_JAVA_KEYWORDS || scope == KEYWORD_SCOPE.JAVA_KEYWORDS) {
            switch (searchType) {
                case FIND_ALL:
                    addAllJavaKeywordMethods();
                    break;
                case EXACT_MATCH:
                    addJavaMethodsWithExactName(results);
                    break;
                case STARTS_WITH:
                    addAllJavaKeywordMethods();
                    break;
            }
        }

        if (searchType == SEARCH_TYPE.EXACT_MATCH && results.size() > 0) {
            return;
        }

        //Find Robot keyword definitions from robot files
        if (scope == KEYWORD_SCOPE.ROBOT_AND_JAVA_KEYWORDS || scope == KEYWORD_SCOPE.ROBOT_KEYWORDS) {
            List<RobotKeywordDef> robotKeywordDefs;
            switch (searchType) {
                case STARTS_WITH:
                    robotKeywordDefs =  RobotPsiUtil.findAllRobotKeywordDefsInRobotFilesStartingWith(project, normalizedText);
                    break;
                case FIND_ALL:
                    robotKeywordDefs = RobotPsiUtil.findAllRobotKeywordDefsInRobotFiles(project);
                    break;
                case EXACT_MATCH:
                    robotKeywordDefs = RobotPsiUtil.findKeywordDefsByName(searchTerm, project);
                    break;
                default:
                    robotKeywordDefs = RobotPsiUtil.findKeywordDefsByName(searchTerm, project);
                    break;
            }
            results.addAll(robotKeywordDefs);
        }
    }

    private void addJavaMethodsWithExactName(List<PsiElement> resultsToAdd) {
        Collection<PsiMethod> methods = StubIndex.getElements(JavaStubIndexKeys.METHODS, methodText, project, GlobalSearchScope.projectScope(project), PsiMethod.class);
        for (PsiMethod method : methods) {
            if (EXACT_NAME_PREDICATE.includeJavaMethod(normalizedText, method)) {
                if (wrapPsiMethods) {
                    resultsToAdd.add(new PsiMethodWithRobotName(method.getNode()));
                } else {
                    resultsToAdd.add(method);
                }
            }
        }
        if (resultsToAdd.isEmpty()) {
            addAllJavaKeywordMethods();
        }
    }

    private void addAllJavaKeywordMethods() {
        String searchWord = "RobotKeyword";
        GlobalSearchScope javaFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), JavaFileType.INSTANCE);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(searchWord, javaFilesInProject, this, false);
    }

    private boolean addResultsForJavaFile(PsiFile psiFile, List<PsiElement> resultsToAdd) {
        if (psiFile instanceof PsiJavaFile) {
            PsiClass[] classes = ((PsiClassOwner) psiFile).getClasses();
            for (PsiClass psiClass : classes) {
                for (PsiMethod psiMethod : psiClass.getMethods()) {
                    if (predicateForJavaMethods.includeJavaMethod(normalizedText, psiMethod)) {
                        if (wrapPsiMethods) {
                            resultsToAdd.add(new PsiMethodWithRobotName(psiMethod.getNode()));
                        } else {
                            resultsToAdd.add(psiMethod);
                        }
                        if (searchType == SEARCH_TYPE.EXACT_MATCH) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public List<PsiElement> getResults() {
        return results;
    }

    public static interface KeywordPredicate {
        public boolean includeJavaMethod(String searchTextAsMethod, PsiMethod el);
    }

    public static final KeywordPredicate EXACT_NAME_PREDICATE = new KeywordPredicate() {
        @Override
        public boolean includeJavaMethod(String normalizedText, PsiMethod el) {
            String methodText = el.getName();
            if (!methodText.equalsIgnoreCase(normalizedText)) {
                return false;
            }
            PsiModifierList modifierList = el.getModifierList();
            return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
        }
    };

    public static final KeywordPredicate ALL_PREDICATE = new KeywordPredicate() {
        @Override
        public boolean includeJavaMethod(String normalizedText, PsiMethod el) {
            PsiModifierList modifierList = el.getModifierList();
            return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
        }
    };

    public static final KeywordPredicate STARTS_WITH_PREDICATE = new KeywordPredicate() {
        @Override
        public boolean includeJavaMethod(String normalizedText, PsiMethod el) {
            String methodText = el.getName();
            if (!methodText.toLowerCase().startsWith(normalizedText)) {
                return false;
            }
            PsiModifierList modifierList = el.getModifierList();
            return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
        }
    };
}
