package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.impl.compiled.ClsMethodImpl;
import com.intellij.psi.impl.java.stubs.index.JavaStubIndexKeys;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.ProjectScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.search.searches.AnnotatedElementsSearch;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.util.Processor;
import com.intellij.util.Query;
import com.jivesoftware.robot.intellij.plugin.elements.references.PsiMethodWithRobotName;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Created by charles.capps on 6/24/14.
 */
public class RobotJavaPsiUtil {
    public static final String ROBOT_KEYWORD_ANNOTATION_LONG = "org.robotframework.javalib.annotation.RobotKeyword";

    public static boolean isJavaRobotKeyword(PsiElement element) {
        if (!(element instanceof PsiMethod)) {
            return false;
        }
        PsiModifierList psiModifierList = ((PsiMethod) element).getModifierList();
        return psiModifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION_LONG) != null;
    }

    public static boolean isPsiMethodRobotKeyword(PsiMethod element) {
        PsiModifierList psiModifierList = element.getModifierList();
        return psiModifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION_LONG) != null;
    }

    @NotNull
    public static void findAllJavaRobotKeywords(Project project, List<PsiElement> results, boolean wrapPsiMethods) {
        // Search for all methods annotated with @RobotKeyword
        GlobalSearchScope allScope = ProjectScope.getAllScope(project);
        PsiClass robotKeywordAnnotation = getRobotKeywordPsiClass(project);
        Query<PsiMethod> query = AnnotatedElementsSearch.searchPsiMethods(robotKeywordAnnotation, allScope);
        Processor<PsiMethod> methodProcessor = new RobotKeywordJavaMethodProcessor(results, SearchType.FIND_ALL, Optional.<String>absent(), wrapPsiMethods);
        query.forEach(methodProcessor);
    }

    @NotNull
    public static void findAllJavaRobotKeywordsStartingWith(Project project, List<PsiElement> results, String startsWith, boolean wrapPsiMethods) {
        // Search for all methods annotated with @RobotKeyword that start with the given text
        GlobalSearchScope allScope = ProjectScope.getAllScope(project);
        PsiClass robotKeywordAnnotation = getRobotKeywordPsiClass(project);
        Query<PsiMethod> query = AnnotatedElementsSearch.searchPsiMethods(robotKeywordAnnotation, allScope);
        Processor<PsiMethod> methodProcessor = new RobotKeywordJavaMethodProcessor(results, SearchType.STARTS_WITH, Optional.of(startsWith), wrapPsiMethods);
        query.forEach(methodProcessor);
    }

    public static PsiClass getRobotKeywordPsiClass(Project project) {
        return JavaPsiFacade.getInstance(project).findClass(ROBOT_KEYWORD_ANNOTATION_LONG, ProjectScope.getLibrariesScope(project));
    }

    @NotNull
    public static Optional<PsiMethod> findUniqueJavaKeywordForRobotKeyword(Project project, String robotKeywordName, boolean wrapPsiMethods) {
        //First attempt to find the Java method with the exact name using the Method stub index:
        final String methodName = RobotPsiUtil.robotKeywordToMethodFast(robotKeywordName);
        final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(robotKeywordName);
        Collection<PsiMethod> methods = StubIndex.getElements(JavaStubIndexKeys.METHODS, methodName, project, GlobalSearchScope.allScope(project), PsiMethod.class);

        for (PsiMethod method : methods) {
            if (!isPsiMethodRobotKeyword(method)) {
                continue;
            }
            String methodNameLower = method.getName().toLowerCase();
            if (methodNameLower.equals(normalizedName)) {
                return Optional.of(wrap(method, wrapPsiMethods));
            }
        }

        //If no results are found, attempt to search the words index by the method name (since it is case insensitive, we might get results that we didn't get above.)
        GlobalSearchScope javaFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.allScope(project), JavaFileType.INSTANCE);
        List<PsiElement> results = Lists.newArrayList();
        RobotJavaKeywordProcessor processor = new RobotJavaKeywordProcessor(results, SearchType.EXACT_MATCH, Optional.of(methodName), wrapPsiMethods);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(methodName, javaFilesInProject, processor, false);
        if (results.size() > 0) {
            return Optional.of((PsiMethod)results.get(0));
        }
        return Optional.absent();
    }


    public static PsiMethod wrap(PsiMethod method, boolean wrapPsiMethods) {
        if (wrapPsiMethods) {
            if (method instanceof ClsMethodImpl) {
                return new PsiMethodWithRobotName(((ClsMethodImpl) method).getStub());
            }
            return new PsiMethodWithRobotName(method.getNode());
        }
        return method;
    }
}
