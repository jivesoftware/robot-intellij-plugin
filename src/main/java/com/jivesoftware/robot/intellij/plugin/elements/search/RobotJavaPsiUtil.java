package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.intellij.ide.highlighter.JavaClassFileType;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.impl.java.stubs.index.JavaStubIndexKeys;
import com.intellij.psi.search.*;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.util.indexing.FileBasedIndex;
import com.jivesoftware.robot.intellij.plugin.elements.references.PsiMethodWithRobotName;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Created by charles.capps on 6/24/14.
 */
public class RobotJavaPsiUtil {
    public static final String ROBOT_KEYWORD_ANNOTATION_SHORT = "RobotKeyword";

    public static boolean isJavaRobotKeyword(PsiElement element) {
        if (!(element instanceof PsiMethod)) {
            return false;
        }
        PsiModifierList psiModifierList = ((PsiMethod) element).getModifierList();
        return psiModifierList.findAnnotation(RobotKeywordDefinitionFinder.ROBOT_KEYWORD_ANNOTATION) != null;
    }

    public static boolean isPsiMethodRobotKeyword(PsiMethod element) {
        PsiModifierList psiModifierList = element.getModifierList();
        return psiModifierList.findAnnotation(RobotKeywordDefinitionFinder.ROBOT_KEYWORD_ANNOTATION) != null;
    }

    @NotNull
    public static void findAllJavaRobotKeywords(Project project, List<PsiElement> results, boolean wrapPsiMethods) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        GlobalSearchScope javaFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), JavaFileType.INSTANCE);

        RobotKeywordPsiAnnotationProcessor processor = new RobotKeywordPsiAnnotationProcessor(results, SearchType.FIND_ALL, Optional.<String>absent(), wrapPsiMethods);

        STUB_INDEX.processElements(JavaStubIndexKeys.ANNOTATIONS, ROBOT_KEYWORD_ANNOTATION_SHORT, project, javaFilesInProject, PsiAnnotation.class, processor);
    }

    @NotNull
    public static void findAllJavaRobotKeywordsStartingWith(Project project, List<PsiElement> results, String startsWith, boolean wrapPsiMethods) {
        // First process the stub index that has all Java files in the current project
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        GlobalSearchScope javaFiles = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), JavaFileType.INSTANCE);
        RobotKeywordPsiAnnotationProcessor processor = new RobotKeywordPsiAnnotationProcessor(results, SearchType.STARTS_WITH, Optional.of(startsWith), wrapPsiMethods);
        STUB_INDEX.processElements(JavaStubIndexKeys.ANNOTATIONS, ROBOT_KEYWORD_ANNOTATION_SHORT, project, javaFiles, PsiAnnotation.class, processor);

        // Next, attempt to find Keywords from external sources using the Word Index on the word "RobotKeyword".
        PsiSearchHelper PSI_SEARCH_HELPER = PsiSearchHelper.SERVICE.getInstance(project);
        GlobalSearchScope outsideProjectScope = GlobalSearchScope.allScope(project).intersectWith(GlobalSearchScope.notScope(GlobalSearchScope.projectScope(project)));
        GlobalSearchScope javaOutsideProjectScope = GlobalSearchScope.getScopeRestrictedByFileTypes(outsideProjectScope, JavaFileType.INSTANCE);
        TextOccurenceProcessor textOccurenceProcessor = new RobotAnnotationTextOccurrenceProcessor(results, SearchType.FIND_ALL, Optional.of(startsWith), wrapPsiMethods);
        PSI_SEARCH_HELPER.processElementsWithWord(textOccurenceProcessor, javaOutsideProjectScope, ROBOT_KEYWORD_ANNOTATION_SHORT, UsageSearchContext.IN_CODE, true);
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
            return new PsiMethodWithRobotName(method.getNode());
        }
        return method;
    }
}
