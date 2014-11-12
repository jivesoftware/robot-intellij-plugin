package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.jgoodies.common.base.Objects;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotFileReference;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.*;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotPsiUtil {

    /**
     * This method just removes spaces and underscores, and lowercases the string.
     *
     * This is useful for normalizing Java-defined Robot Keywords for indexing.
     * It's also used to normalize Robot Variables and Test Case Titles.
     *
     * @param keywordOrMethod
     * @return
     */
    public static String normalizeKeywordForIndex(String keywordOrMethod) {
        return keywordOrMethod.replace(" ", "")
                .replace("_", "")
                .toLowerCase();
    }

    /**
     * More advanced normalization for Robot-defined keywords
     * Handles special case of "embedded arguments"
     * See Robot Guide:
     * http://robotframework.org/robotframework/latest/RobotFrameworkUserGuide.html#arguments-embedded-to-keyword-names
     * @param keywordName
     * @return
     */
    public static String normalizeRobotDefinedKeywordForIndex(String keywordName) {
        final Matcher hasVariableMatcher = VariablePsiUtil.VARIABLE_PATTERN.matcher(keywordName);
        if (hasVariableMatcher.find()) {
            // Normalize a Keyword name for "embedded arguments" in keyword name.
            return hasVariableMatcher.replaceAll(Matcher.quoteReplacement("${arg}"))
                                     .toLowerCase();
        }

        // For Keywords not containing embedded arguments, ' ' and '_' are ignored
        return keywordName.replace(" ", "")
                .replace("_", "")
                .toLowerCase();

    }

    public static String normalizeEmbeddedArgKeyword(String keywordName) {
        final Matcher hasVariableMatcher = VariablePsiUtil.VARIABLE_PATTERN.matcher(keywordName);
        return hasVariableMatcher.replaceAll(Matcher.quoteReplacement("${arg}"))
                .toLowerCase();
    }

    public static String normalizeJavaMethodForIndex(String methodName) {
        Preconditions.checkArgument(!methodName.contains(" "), "A Java method can't contain a space!");
        return methodName.replace("_", "")
                .toLowerCase();
    }

    public static String robotKeywordToMethodFast(String keyword) {
        String noSpaces = keyword.replace(" ", "");
        if (noSpaces.isEmpty()) {
            return noSpaces;
        }
        return noSpaces.substring(0, 1).toLowerCase() + noSpaces.substring(1);
    }

    public static String robotKeywordToUnderscoreStyleMethod(String keyword) {
        String withUnderscores = keyword.replace(" ", "_");
        return withUnderscores.toLowerCase();
    }

    /**
     * Convert a Java method name into a Robot Keyword name.
     *
     * e.g. convert "fooBarMethod" to "Foo Bar Method".
     *
     * Throw out underscores as well, so convert "foo_bar_method" to "Foo Bar Method".
     *
     * @param method - valid name of a Java method
     * @return - standard Robot Keyword name for the input Java method
     */
    public static String methodToRobotKeyword(String method) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        int current;
        boolean capitalizeNext = false;
        for (int i = 1; i <= method.length(); i++) {
            Character c;
            if (i < method.length()) {
                c = method.charAt(i);
                if (capitalizeNext) {
                    c = Character.toUpperCase(c);
                    capitalizeNext = false;
                }
            } else {
                c = null;
            }
            if (Objects.equals(c, '_')) {
                capitalizeNext = true;
                continue;
            }
            if (i == method.length() || Character.isUpperCase(c)) {
                current = i;
                String sub = method.substring(prev, current)
                                    .replace("_", ""); // remove underscores.
                String cap = sub.substring(0, 1).toUpperCase() + sub.substring(1);
                if (!sb.toString().isEmpty()) { //Append the single space separator for robot keywords
                    char lastSoFar = sb.toString().charAt(sb.length() - 1);
                    if (!Character.isUpperCase(lastSoFar) || sub.length() > 1) {
                        if (!Character.isWhitespace(lastSoFar)) {
                            sb.append(" ");
                        }
                    }
                }
                sb.append(cap);
                prev = current;
            }
        }
        return sb.toString();
    }

    public static boolean areIdenticalTextualOccurrences(@NotNull PsiElement el1, @NotNull PsiElement el2) {
        if (el1.getContainingFile() == null || el2.getContainingFile() == null) {
            return false;
        }
        VirtualFile vf1 = el1.getContainingFile().getVirtualFile();
        VirtualFile vf2 = el2.getContainingFile().getVirtualFile();
        if (vf1 == null || vf2 == null) {
            return false;
        }
        return Objects.equals(vf1.getCanonicalPath(), vf2.getCanonicalPath()) &&
               el1.getTextRange().equals(el2.getTextRange());
    }

    public static List<RobotTestCase> findAllRobotTestCases(Project project) {
        Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                GlobalSearchScope.projectScope(project));
        List<RobotTestCase> results = Lists.newArrayList();
        for (VirtualFile f : robotFiles) {
            PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
            findTestCasesInFile(psiFile, results);
        }
        return results;
    }

    private static void findTestCasesInFile(PsiFile file, List<RobotTestCase> results) {
        if (!(file instanceof RobotPsiFile)) {
            return;
        }
        RobotTable[] tables = ((RobotPsiFile) file).findChildrenByClass(RobotTable.class);
        for (RobotTable table : tables) {
            if (table.getTestCasesTable() != null) {
                addAllTestCasesInTable(table.getTestCasesTable(), results);
            }
        }
    }

    private static void addAllTestCasesInTable(RobotTestCasesTable table, List<RobotTestCase> results) {
        List<RobotTestCase> testCases = table.getTestCaseList();
        results.addAll(testCases);
    }

    public static List<RobotTestCase> findTestCasesByName(String name, Project project) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedName = normalizeKeywordForIndex(name);
        List<RobotTestCase> results = Lists.newArrayList();
        RobotTestCaseProcessor processor = new RobotTestCaseProcessor(results, SearchType.FIND_ALL, name);
        STUB_INDEX.processElements(RobotTestCaseNormalizedNameIndex.KEY, normalizedName, project,
                GlobalSearchScope.allScope(project), RobotTestCase.class, processor);
        return results;
    }

    //-----------------Helpers for finding RobotKeywordDef's---------------
    public static void findAllRobotKeywordDefsInRobotFiles(Project project, List<PsiElement> results) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        Collection<String> keys = STUB_INDEX.getAllKeys(RobotKeywordTitleNormalizedNameIndex.KEY, project);
        for (String key : keys) {
            Collection<RobotKeywordTitle> defsForKey = StubIndex.getElements(RobotKeywordTitleNormalizedNameIndex.KEY, key,
                    project, GlobalSearchScope.allScope(project), RobotKeywordTitle.class);
            results.addAll(defsForKey);
        }
    }

    public static void findAllRobotKeywordDefsInRobotFilesStartingWith(Project project, List<PsiElement> results, String startsWith) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedStartsWith = RobotPsiUtil.normalizeRobotDefinedKeywordForIndex(startsWith);
        String keyValue;
        StubIndexKey<String, RobotKeywordTitle> indexKey;
        if (normalizedStartsWith.length() >= 3) {
            keyValue = normalizedStartsWith.substring(0, 3);
            indexKey = RobotKeywordDefFirstThreeCharsIndex.KEY;
        } else if (normalizedStartsWith.length() >= 2) {
            keyValue = normalizedStartsWith.substring(0, 2);
            indexKey = RobotKeywordTitleFirstTwoCharsIndex.KEY;
        } else if (normalizedStartsWith.length() >= 1) {
            keyValue = normalizedStartsWith.substring(0, 1);
            indexKey = RobotKeywordDefFirstCharIndex.KEY;
        } else {
            findAllRobotKeywordDefsInRobotFiles(project, results);
            return;
        }
        GlobalSearchScope robotFilesScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.STARTS_WITH, startsWith);
        STUB_INDEX.processElements(indexKey, keyValue, project, robotFilesScope, RobotKeywordTitle.class, processor);
    }

    public static void findKeywordDefsByName(String name, Project project, List<PsiElement> results) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedName = normalizeRobotDefinedKeywordForIndex(name);
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.EXACT_MATCH, name);
        STUB_INDEX.processElements(RobotKeywordTitleNormalizedNameIndex.KEY, normalizedName, project,
                GlobalSearchScope.allScope(project), RobotKeywordTitle.class, processor);
    }

    public static Optional<RobotKeywordTitle> findUniqueKeywordDefByName(String name, Project project, boolean isSearchTextFromRobotFile) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedName = normalizeRobotDefinedKeywordForIndex(name);
        List<PsiElement> results = Lists.newArrayList();
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.EXACT_MATCH, name);
        STUB_INDEX.processElements(RobotKeywordTitleNormalizedNameIndex.KEY, normalizedName, project,
                GlobalSearchScope.allScope(project), RobotKeywordTitle.class, processor);
        if (results.size() > 0) {
            return Optional.of((RobotKeywordTitle) results.get(0));
        }
        if (!isSearchTextFromRobotFile) {
            return Optional.absent();
        }
        return findFirstMatchInEmbeddedArgsIndex(name, project);
    }

    private static Optional<RobotKeywordTitle> findFirstMatchInEmbeddedArgsIndex(String name, Project project) {
        final String normalizedKeyword = normalizeEmbeddedArgKeyword(name);
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final Collection<String> KEYS = STUB_INDEX.getAllKeys(RobotKeywordTitleEmbeddedArgsIndex.KEY, project);
        for (String key: KEYS) {
            Collection<RobotKeywordTitle> keywordsWithEmbeddedArgs = StubIndex.getElements(RobotKeywordTitleEmbeddedArgsIndex.KEY, key, project, GlobalSearchScope.allScope(project), RobotKeywordTitle.class);
            for (RobotKeywordTitle keyword: keywordsWithEmbeddedArgs) {
                String regex = keyword.getRegex();
                Pattern pattern = Pattern.compile(regex);
                if (pattern.matcher(normalizedKeyword).matches()) {
                    return Optional.of(keyword);
                }
            }
        }
        return Optional.absent();
    }

    //--------------Helpers to find Keyword usages------------
    public static List<RobotKeyword> findRobotDefinedKeywordUsages(RobotKeywordTitle robotKeywordTitle) {
        final String keywordTitle = robotKeywordTitle.getText();
        if (VariablePsiUtil.VARIABLE_PATTERN.matcher(keywordTitle).find()) {
            return findKeywordUsagesOfKeywordWithEmbeddedArgs(robotKeywordTitle);
        }
        final String normalizedKeywordName = normalizeRobotDefinedKeywordForIndex(keywordTitle);
        return findKeywordUsagesByNormalizedName(normalizedKeywordName, robotKeywordTitle.getProject());
    }

    public static List<RobotKeyword> findJavaDefinedKeywordUsages(PsiMethod javaMethod) {
        final String normalizedName = normalizeJavaMethodForIndex(javaMethod.getName());
        return findKeywordUsagesByNormalizedName(normalizedName, javaMethod.getProject());
    }

    private static List<RobotKeyword> findKeywordUsagesByNormalizedName(String normalizedKeywordName, Project project) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        GlobalSearchScope robotFileScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        RobotKeywordProcessor processor = new RobotKeywordProcessor(normalizedKeywordName, true);
        STUB_INDEX.processElements(RobotKeywordNormalizedNameIndex.KEY, normalizedKeywordName, project, robotFileScope,
                RobotKeyword.class, processor);

        return processor.getResults();
    }

    public static List<RobotKeyword> findKeywordUsagesOfKeywordWithEmbeddedArgs(RobotKeywordTitle robotKeywordTitle) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final Project project = robotKeywordTitle.getProject();
        final Pattern REGEX = Pattern.compile(robotKeywordTitle.getRegex());

        final Collection<String> allKeywords = STUB_INDEX.getAllKeys(RobotKeywordNormalizedNameIndex.KEY, project);
        final GlobalSearchScope PROJECT_ROBOT_FILES = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        final RobotKeywordEmbeddedArgsProcessor processor = new RobotKeywordEmbeddedArgsProcessor(REGEX, true);

        for (String keyword: allKeywords) {
            STUB_INDEX.processElements(RobotKeywordNormalizedNameIndex.KEY,
                    keyword, project, PROJECT_ROBOT_FILES, RobotKeyword.class, processor);
        }
        return processor.getResults();
    }

    //-----------------Context-sensitive finders-------------------
    public static <T extends PsiElement> List<T> findVariablesInScope(PsiElement element, Class<T> variableType) {
        List<T> varsInScope = Lists.newArrayList();
        // Add scalar variables in a containing Test Case (if present)
        varsInScope.addAll(findPsiElementsOfTypeInParent(element, RobotTestCase.class, variableType));
        // Add scalar variables in a containing Keyword Definition (if present)
        varsInScope.addAll(findPsiElementsOfTypeInParent(element, RobotKeywordDefinition.class, variableType));

        RobotPsiFile file = PsiTreeUtil.getParentOfType(element, RobotPsiFile.class);
        if (file != null) {
            varsInScope.addAll(findVariablesInVariablesTableAndIncludedResourceFiles(file, variableType));
        }
        return varsInScope;
    }

    private static <T extends PsiElement> Collection<T> findPsiElementsOfTypeInParent(PsiElement element,
                                                                                      Class<? extends PsiElement> parentType,
                                                                                      Class<T> desiredType) {
        PsiElement parent = PsiTreeUtil.getParentOfType(element, parentType);
        if (parent != null) {
            return PsiTreeUtil.findChildrenOfType(parent, desiredType);
        }
        return Lists.newArrayList();
    }

    public static <T extends PsiElement> Collection<T> findVariablesInVariablesTableAndIncludedResourceFiles(@NotNull RobotPsiFile file, Class<T> variableType) {
        return findVariablesInVariablesTableAndIncludedResourceFiles(file, variableType, Sets.<String>newHashSet());
    }

    private static <T extends PsiElement> Collection<T> findVariablesInVariablesTableAndIncludedResourceFiles(@NotNull RobotPsiFile file, Class<T> variableType, Set<String> searchedFiles) {
        final VirtualFile currentVirtualFile = file.getVirtualFile();
        final String currentCanonicalPath = currentVirtualFile != null ? currentVirtualFile.getCanonicalPath() : null;
        // To avoid infinite loops if the Robot file includes itself, or there's a loop in Resource file inclusions
        if (currentCanonicalPath != null && searchedFiles.contains(currentCanonicalPath)) {
            return Lists.newArrayList();
        }
        searchedFiles.add(currentCanonicalPath);
        Collection<T> results = findVariablesInVariablesTable(file, variableType);

        RobotTable[] tables = file.findChildrenByClass(RobotTable.class);
        for (RobotTable table: tables) {
            if (table.getSettingsTable() == null) {
                continue;
            }
            RobotSettingsTable settingsTable = table.getSettingsTable();
            Collection<RobotResourceSetting> resourceSettings = PsiTreeUtil.findChildrenOfType(settingsTable, RobotResourceSetting.class);
            for (RobotResourceSetting resourceSetting: resourceSettings) {
                RobotResourceFile robotResourceFile = resourceSetting.getResourceFile();
                RobotFileReference robotFileReference = new RobotFileReference(robotResourceFile);
                PsiElement resourceFile = robotFileReference.resolve();
                if (resourceFile instanceof RobotPsiFile) {
                    RobotPsiFile robotPsiFile = (RobotPsiFile) resourceFile;
                    Collection<T> foundInResourceFile = findVariablesInVariablesTableAndIncludedResourceFiles(robotPsiFile, variableType, searchedFiles);
                    results.addAll(foundInResourceFile);
                }
            }
        }
        return results;
    }


    public static <T extends PsiElement> Collection<T> findVariablesInVariablesTable(@NotNull RobotPsiFile file, Class<T> variableType) {
        List<T> foundScalarVars = Lists.newArrayList();
        RobotTable[] tables = file.findChildrenByClass(RobotTable.class);
        for (RobotTable table : tables) {
            if (table.getVariablesTable() != null) {
                RobotVariablesTable robotVariablesTable = table.getVariablesTable();
                Collection<T> foundVars = PsiTreeUtil.findChildrenOfType(robotVariablesTable, variableType);
                foundScalarVars.addAll(foundVars);
            }
        }
        return foundScalarVars;
    }


}
