package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotFileReference;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.*;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class RobotPsiUtil {

    public static String normalizeKeywordForIndex(String keywordOrMethod) {
        return keywordOrMethod.replace(" ", "")
                .replace("_", "")
                .toLowerCase();
    }

    public static String robotKeywordToMethodFast(String keyword) {
        String noSpaces = keyword.replace(" ", "");
        if (noSpaces.isEmpty()) {
            return noSpaces;
        }
        return noSpaces.substring(0, 1).toLowerCase() + noSpaces.substring(1);
    }

    public static String methodToRobotKeyword(String method) {
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        int current;
        for (int i = 1; i <= method.length(); i++) {
            Character c;
            if (i < method.length()) {
                c = method.charAt(i);
            } else {
                c = null;
            }
            if (i == method.length() || Character.isUpperCase(c)) {
                current = i;
                String sub = method.substring(prev, current);
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

    private static void findTestCasesInFileByName(PsiFile file, String name, List<RobotTestCase> results) {
        if (!(file instanceof RobotPsiFile)) {
            return;
        }
        RobotTable[] tables = ((RobotPsiFile) file).findChildrenByClass(RobotTable.class);
        for (RobotTable table : tables) {
            if (table.getTestCasesTable() != null) {
                addAllTestCasesInTableByName(table.getTestCasesTable(), name, results);
            }
        }
    }

    private static void addAllTestCasesInTable(RobotTestCasesTable table, List<RobotTestCase> results) {
        List<RobotTestCase> testCases = table.getTestCaseList();
        results.addAll(testCases);
    }

    private static void addAllTestCasesInTableByName(RobotTestCasesTable table, String name, List<RobotTestCase> results) {
        List<RobotTestCase> testCases = table.getTestCaseList();
        for (RobotTestCase testCase : testCases) {
            String squashedTestCase = robotKeywordToMethodFast(testCase.getName());
            String squashedName = robotKeywordToMethodFast(name);
            if (squashedName.equalsIgnoreCase(squashedTestCase)) {
                results.add(testCase);
            }
        }
    }

    public static List<RobotTestCase> findTestCasesByName(String name, Project project) {
        Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                GlobalSearchScope.projectScope(project));
        List<RobotTestCase> results = Lists.newArrayList();
        for (VirtualFile f : robotFiles) {
            PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
            findTestCasesInFileByName(psiFile, name, results);
        }
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
        final String normalizedStartsWith = RobotPsiUtil.normalizeKeywordForIndex(startsWith);
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
        final String normalizedName = normalizeKeywordForIndex(name);
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.EXACT_MATCH, name);
        STUB_INDEX.processElements(RobotKeywordTitleNormalizedNameIndex.KEY, normalizedName, project,
                GlobalSearchScope.allScope(project), RobotKeywordTitle.class, processor);
    }

    public static Optional<RobotKeywordTitle> findUniqueKeywordDefByName(String name, Project project) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedName = normalizeKeywordForIndex(name);
        List<PsiElement> results = Lists.newArrayList();
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.EXACT_MATCH, name);
        STUB_INDEX.processElements(RobotKeywordTitleNormalizedNameIndex.KEY, normalizedName, project,
                GlobalSearchScope.allScope(project), RobotKeywordTitle.class, processor);
        if (results.size() > 0) {
            return Optional.of((RobotKeywordTitle) results.get(0));
        }
        return Optional.absent();
    }

    //--------------Helpers to find Keyword usages------------
    public static List<RobotKeyword> findKeywordUsagesByName(String keywordName, Project project) {
        final String robotKeywordAsMethod = RobotPsiUtil.robotKeywordToMethodFast(keywordName);
        return findKeywordUsagesByJavaMethodName(robotKeywordAsMethod, project);
    }

    public static List<RobotKeyword> findKeywordUsagesByJavaMethodName(String javaMethodName, Project project) {
        Preconditions.checkArgument(!javaMethodName.contains(" "), "RobotPsiUtil: A Java method name can't contain space!");
        final String normalizedKeywordName = javaMethodName.toLowerCase();
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        GlobalSearchScope robotFileScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        RobotKeywordProcessor processor = new RobotKeywordProcessor(normalizedKeywordName, true);
        STUB_INDEX.processElements(RobotKeywordNormalizedNameIndex.KEY, normalizedKeywordName, project, robotFileScope,
                RobotKeyword.class, processor);

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
                    Collection<T> foundInResourceFile = findVariablesInVariablesTable(robotPsiFile, variableType);
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
