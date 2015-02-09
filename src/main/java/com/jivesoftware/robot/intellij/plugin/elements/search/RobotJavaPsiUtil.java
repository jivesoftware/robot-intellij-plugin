package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.intellij.codeInsight.AnnotationUtil;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.impl.PsiClassImplUtil;
import com.intellij.psi.impl.PsiImplUtil;
import com.intellij.psi.impl.compiled.ClsMethodImpl;
import com.intellij.psi.impl.java.stubs.index.JavaStubIndexKeys;
import com.intellij.psi.search.*;
import com.intellij.psi.search.searches.AnnotatedElementsSearch;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.util.PsiClassUtil;
import com.intellij.psi.util.PsiUtilBase;
import com.intellij.util.Processor;
import com.intellij.util.Query;
import com.jivesoftware.robot.intellij.plugin.elements.references.PsiMethodWithRobotName;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordArg;
import com.jivesoftware.robot.intellij.plugin.psi.RobotLibrarySetting;
import com.jivesoftware.robot.intellij.plugin.psi.RobotSettingList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.robotframework.javalib.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by charles.capps on 6/24/14.
 */
public class RobotJavaPsiUtil {
    public static final String ROBOT_KEYWORD_ANNOTATION_SHORT = "RobotKeyword";
    public static final String ROBOT_KEYWORD_ANNOTATION_LONG = "org.robotframework.javalib.annotation.RobotKeyword";
    public static final String ROBOT_KEYWORDS_ANNOTATION_LONG = "org.robotframework.javalib.annotation.RobotKeywords";

    public static boolean isJavaRobotKeyword(PsiElement element) {
        if (!(element instanceof PsiMethod)) {
            return false;
        }
        PsiMethod psiMethod = (PsiMethod) element;
        PsiModifierList psiModifierList = psiMethod.getModifierList();
        if (psiModifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION_LONG) == null) {
            return false; // Must be annotated with @RobotKeyword
        }
        if (!psiModifierList.hasModifierProperty(PsiModifier.PUBLIC)) {
            return false; // RobotKeywords must be public!
        }
        PsiClass psiClass = psiMethod.getContainingClass();
        if (psiClass == null) {
            return false; // Must be in a class
        }
        PsiModifierList classModifierList = psiClass.getModifierList();
        // RobotKeywords must be in a class annotated with @RobotKeywords
        return classModifierList != null &&
               classModifierList.findAnnotation(ROBOT_KEYWORDS_ANNOTATION_LONG) != null;
    }

    public static boolean isPsiMethodRobotKeyword(PsiMethod element) {
        PsiModifierList psiModifierList = element.getModifierList();
        return psiModifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION_LONG) != null;
    }

    public static void findAllJavaRobotKeywords(Project project, List<PsiElement> results, boolean wrapPsiMethods) {
        // Search for all methods annotated with @RobotKeyword
        GlobalSearchScope allScope = ProjectScope.getAllScope(project);
        PsiClass robotKeywordAnnotation = getRobotKeywordPsiClass(project);
        if (robotKeywordAnnotation == null) {
            return; // If @RobotKeyword isn't on the classpath, just return.
        }
        Query<PsiMethod> query = AnnotatedElementsSearch.searchPsiMethods(robotKeywordAnnotation, allScope);
        Processor<PsiMethod> methodProcessor = new RobotJavaMethodProcessor(results, SearchType.FIND_ALL, Optional.<String>absent(), wrapPsiMethods);
        query.forEach(methodProcessor);
    }

    public static void findAllJavaRobotKeywordsInScope(PsiElement sourceElement, List<PsiElement> results, boolean wrapPsiMethods) {
        // Get all Java keywords in the project
        List<PsiElement> allJavaKeywords = Lists.newArrayList();
        findAllJavaRobotKeywords(sourceElement.getProject(), allJavaKeywords, true);

        // Filter by only those keywords that are in scope of sourceElement.
        List<PsiMethod> keywordsInScope = filterJavaKeywordsByScope(sourceElement, allJavaKeywords);
        results.addAll(keywordsInScope);
    }

    private static List<PsiMethod> filterJavaKeywordsByScope(PsiElement inScopeOf, List<? extends PsiElement> psiMethods) {
        // First find all Library settings in scope
        List<RobotLibrarySetting> librarySettings = RobotResourceFileUtil.findAllLibraryImportsInScope(inScopeOf);
        // Next assume the any argument could be an ant-style path
        // Transform the ant paths into paths that match fully qualified Java class names
        Set<String> antPathClassMatchers = Sets.newHashSet();
        for (RobotLibrarySetting librarySetting: librarySettings) {
            List<RobotSettingList> robotSettingLists = librarySetting.getSettingListList();
            for (RobotSettingList robotSettingList: robotSettingLists) {
                List<RobotKeywordArg> robotKeywordArgs = robotSettingList.getKeywordArgList();
                for (RobotKeywordArg robotKeywordArg: robotKeywordArgs) {
                    String antPath = robotKeywordArg.getText();
                    antPathClassMatchers.add(transformAntPathToClassMatcher(antPath));
                }
            }
        }

        List<PsiMethod> filteredList = Lists.newArrayList();

        // Filter by Java keywords that match the found ant paths
        for (PsiElement el: psiMethods) {
            if (!(el instanceof PsiMethod)) {
                continue;
            }
            if (includeJavaKeyword((PsiMethod)el, antPathClassMatchers)) {
                filteredList.add((PsiMethod)el);
            }
        }

        return filteredList;
    }

    private static boolean includeJavaKeyword(PsiMethod psiMethod, Set<String> antPaths) {
        PsiClass psiClass = psiMethod.getContainingClass();
        if (psiClass == null) {
            return false;
        }
        String qualifiedName = psiClass.getQualifiedName();
        if (qualifiedName == null) {
            return false;
        }

        AntPathMatcher a = new AntPathMatcher();
        a.setPathSeparator(".");

        // If any path matches, return true
        for (String antPath: antPaths) {
            if (a.match(antPath, qualifiedName)) {
                return true;
            }
        }
        return false;
    }

    private static String transformAntPathToClassMatcher(String antPath) {
        if (antPath.endsWith("*.class")) {
            antPath = antPath.substring(0, antPath.length() - ".class".length());
        }
        return antPath.replace("/", ".");
    }

    public static void findAllJavaRobotKeywordsStartingWith(Project project, List<PsiElement> results, String startsWith, boolean wrapPsiMethods) {
        // Search for all methods annotated with @RobotKeyword that start with the given text
        GlobalSearchScope allScope = ProjectScope.getAllScope(project);
        PsiClass robotKeywordAnnotation = getRobotKeywordPsiClass(project);
        if (robotKeywordAnnotation == null) {
            // If @RobotKeyword isn't on the classpath, fall back to using word index.
            findAllJavaKeywordsStartingWithUsingWordIndex(project, results, startsWith, wrapPsiMethods);
            return;
        }
        Query<PsiMethod> query = AnnotatedElementsSearch.searchPsiMethods(robotKeywordAnnotation, allScope);
        Processor<PsiMethod> methodProcessor = new RobotJavaMethodProcessor(results, SearchType.STARTS_WITH, Optional.of(startsWith), wrapPsiMethods);
        query.forEach(methodProcessor);
    }

    public static void findAllJavaKeywordsStartingWithUsingWordIndex(Project project, List<PsiElement> results, String startsWith, boolean wrapPsiMethods) {
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

    @Nullable
    public static PsiClass getRobotKeywordPsiClass(Project project) {
        return JavaPsiFacade.getInstance(project).findClass(ROBOT_KEYWORD_ANNOTATION_LONG, ProjectScope.getAllScope(project));
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

        GlobalSearchScope javaFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.allScope(project), JavaFileType.INSTANCE);
        List<PsiElement> results = Lists.newArrayList();

        //If no results are found, attempt to search the words index by the method name (since it is case insensitive, we might get results that we didn't get above.)
        RobotJavaFileProcessor processor = new RobotJavaFileProcessor(results, SearchType.FIRST_EXACT_MATCH, Optional.of(normalizedName), wrapPsiMethods);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(methodName, javaFilesInProject, processor, false);
        if (results.size() > 0) {
            return Optional.of((PsiMethod)results.get(0));
        }

        //If still no results are found, assume the Java method has the "underscore" style and search with words index again
        final String underscoreMethod = RobotPsiUtil.robotKeywordToUnderscoreStyleMethod(robotKeywordName);
        if (!underscoreMethod.equals(normalizedName)) {
            RobotJavaFileProcessor underscoreProcessor = new RobotJavaFileProcessor(results, SearchType.FIRST_EXACT_MATCH, Optional.of(underscoreMethod), wrapPsiMethods);
            PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(underscoreMethod, javaFilesInProject, underscoreProcessor, false);
            if (results.size() > 0) {
                return Optional.of((PsiMethod) results.get(0));
            }
        }

        return Optional.absent();
    }

    @NotNull
    public static List<PsiMethod> findJavaKeywordsForRobotKeyword(Project project, String robotKeywordName, boolean wrapPsiMethods) {
        //First attempt to find the Java method with the exact name using the Method stub index:
        final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(robotKeywordName);
        final String methodName = RobotPsiUtil.robotKeywordToMethodFast(robotKeywordName);

        List<PsiElement> results = Lists.newArrayList();

        Collection<PsiMethod> methods = StubIndex.getElements(JavaStubIndexKeys.METHODS, methodName, project, GlobalSearchScope.allScope(project), PsiMethod.class);

        for (PsiMethod method : methods) {
            if (!isPsiMethodRobotKeyword(method)) {
                continue;
            }
            String normalizedMethod = RobotPsiUtil.normalizeJavaMethodForIndex(method.getName());
            if (normalizedMethod.equals(normalizedName)) {
                results.add(method);
            }
        }

        GlobalSearchScope javaFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.allScope(project), JavaFileType.INSTANCE);

        List<PsiElement> wordIndexResults = Lists.newArrayList();
        //Search the words index by the normalized name (since it is case insensitive, we might get results that we didn't get above.)
        RobotJavaMethodTextOccurrenceProcessor processor = new RobotJavaMethodTextOccurrenceProcessor(wordIndexResults, SearchType.FIND_ALL_EXACT_MATCHES, Optional.of(normalizedName), wrapPsiMethods);
        PsiSearchHelper.SERVICE.getInstance(project).processElementsWithWord(processor, javaFilesInProject, normalizedName, UsageSearchContext.IN_CODE, false);

        //If still no results are found, assume the Java method has the "underscore" style and search with words index again
        final String underscoreMethod = RobotPsiUtil.robotKeywordToUnderscoreStyleMethod(robotKeywordName);
        if (!underscoreMethod.equals(normalizedName)) {
            RobotJavaMethodTextOccurrenceProcessor underscoreProcessor = new RobotJavaMethodTextOccurrenceProcessor(wordIndexResults, SearchType.FIND_ALL_EXACT_MATCHES, Optional.of(underscoreMethod), wrapPsiMethods);
            PsiSearchHelper.SERVICE.getInstance(project).processElementsWithWord(underscoreProcessor, javaFilesInProject, underscoreMethod, UsageSearchContext.IN_CODE, false);
        }

        List<PsiMethod> methodResults = Lists.newArrayList();
        // Add the results from using the PsiStubIndex for Java methods to the final results set
        for (PsiElement result: results) {
            if (result instanceof PsiMethod) {
                methodResults.add((PsiMethod)result);
            }
        }
        // Add the results from the word index to the final results set
        for (PsiElement result: wordIndexResults) {
            if (!(result instanceof PsiMethod)) {
                continue;
            }
            if (!containsEquivalentPsiElement(result, methodResults)) {
                methodResults.add((PsiMethod) result);
            }
        }
        return methodResults;
    }

    @NotNull
    public static void findJavaKeywordsForRobotKeywordInScope(PsiElement sourceElement, List<PsiElement> results, boolean wrapPsiMethods) {
        // First find all Java keywords with names matching the given robot keyword name
        String keywordName = sourceElement.getText();
        List<PsiMethod> allExactMatches = findJavaKeywordsForRobotKeyword(sourceElement.getProject(), keywordName, wrapPsiMethods);

        // Filter by keywords in scope of sourceElement
        List<PsiMethod> javaRobotKeywordsInScope = filterJavaKeywordsByScope(sourceElement, allExactMatches);
        results.addAll(javaRobotKeywordsInScope);
    }


    public static PsiMethod wrap(PsiMethod method, boolean wrapPsiMethods) {
        if (wrapPsiMethods) {
            if (method instanceof ClsMethodImpl) {
                return new PsiMethodWithRobotName(((ClsMethodImpl) method).getStub(), method);
            }
            return new PsiMethodWithRobotName(method.getNode(), method);
        }
        return method;
    }

    private static <T extends PsiElement> boolean containsEquivalentPsiElement(PsiElement toAdd, Collection<T> els) {
        if (toAdd instanceof PsiMethodWithRobotName) {
            toAdd = ((PsiMethodWithRobotName)toAdd).unwrap();
        }
        if (toAdd == null || toAdd.getManager() == null) {
            return false;
        }
        final PsiManager manager = toAdd.getManager();
        for (T el: els) {
            PsiElement unwrapped;
            if (el instanceof PsiMethodWithRobotName) {
                unwrapped = ((PsiMethodWithRobotName)el).unwrap();
            } else {
                unwrapped = el;
            }
            if (manager.areElementsEquivalent(toAdd, unwrapped)) {
                return true;
            }
        }
        return false;
    }

}
