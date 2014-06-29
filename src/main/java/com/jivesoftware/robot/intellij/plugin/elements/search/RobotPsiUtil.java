package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.util.indexing.FileBasedIndex;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordDefFirstCharIndex;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordDefFirstThreeCharsIndex;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordDefFirstTwoCharsIndex;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordDefNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;

import java.util.Collection;
import java.util.List;

public class RobotPsiUtil {

    public static String normalizeKeywordForIndex(String keywordOrMethod) {
        return keywordOrMethod.replace(" ", "").toLowerCase();
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
        Collection<String> keys = STUB_INDEX.getAllKeys(RobotKeywordDefNormalizedNameIndex.KEY, project);
        List<RobotKeywordDef> defs = Lists.newArrayList();
        for (String key : keys) {
            Collection<RobotKeywordDef> defsForKey = StubIndex.getElements(RobotKeywordDefNormalizedNameIndex.KEY, key,
                    project, GlobalSearchScope.allScope(project), RobotKeywordDef.class);
            results.addAll(defsForKey);
        }
    }

    public static void findAllRobotKeywordDefsInRobotFilesStartingWith(Project project, List<PsiElement> results, String startsWith) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedStartsWith = RobotPsiUtil.normalizeKeywordForIndex(startsWith);
        String keyValue;
        StubIndexKey<String, RobotKeywordDef> indexKey;
        if (normalizedStartsWith.length() >= 3) {
            keyValue = normalizedStartsWith.substring(0, 3);
            indexKey = RobotKeywordDefFirstThreeCharsIndex.KEY;
        } else if (normalizedStartsWith.length() >= 2) {
            keyValue = normalizedStartsWith.substring(0, 2);
            indexKey = RobotKeywordDefFirstTwoCharsIndex.KEY;
        } else if (normalizedStartsWith.length() >= 1) {
            keyValue = normalizedStartsWith.substring(0, 1);
            indexKey = RobotKeywordDefFirstCharIndex.KEY;
        } else {
            findAllRobotKeywordDefsInRobotFiles(project, results);
            return;
        }
        GlobalSearchScope robotFilesScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.STARTS_WITH, startsWith);
        STUB_INDEX.processElements(indexKey, keyValue, project, robotFilesScope, RobotKeywordDef.class, processor);
    }

    public static void findKeywordDefsByName(String name, Project project, List<PsiElement> results) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedName = normalizeKeywordForIndex(name);
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.EXACT_MATCH, name);
        STUB_INDEX.processElements(RobotKeywordDefNormalizedNameIndex.KEY, normalizedName, project,
                GlobalSearchScope.allScope(project), RobotKeywordDef.class, processor);
    }

    public static Optional<RobotKeywordDef> findUniqueKeywordDefByName(String name, Project project) {
        final StubIndex STUB_INDEX = StubIndex.getInstance();
        final String normalizedName = normalizeKeywordForIndex(name);
        List<PsiElement> results = Lists.newArrayList();
        RobotKeywordDefProcessor processor = new RobotKeywordDefProcessor(results, SearchType.EXACT_MATCH, name);
        STUB_INDEX.processElements(RobotKeywordDefNormalizedNameIndex.KEY, normalizedName, project,
                GlobalSearchScope.allScope(project), RobotKeywordDef.class, processor);
        if (results.size() > 0) {
            return Optional.of((RobotKeywordDef) results.get(0));
        }
        return Optional.absent();
    }

    //--------------Helpers to find Keyword usages------------
    public static List<RobotKeyword> findKeywordUsagesByName(String name, Project project) {
        GlobalSearchScope robotFileScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        FindRobotKeywordsUsagesByNameProcessor processor = new FindRobotKeywordsUsagesByNameProcessor(name, true);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(name, robotFileScope, processor, false);

        return processor.getResults();
    }

    public static List<RobotKeyword> findKeywordUsagesByJavaMethodName(String javaMethodName, Project project) {
        GlobalSearchScope robotFileScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        final String robotName = methodToRobotKeyword(javaMethodName);
        FindRobotKeywordsUsagesByNameProcessor processor = new FindRobotKeywordsUsagesByNameProcessor(robotName, true);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(robotName, robotFileScope, processor, false);

        return processor.getResults();
    }

    public static void findKeywordDefsInFileByName(PsiFile psiFile, String name, List<RobotKeywordDef> keywordDefList) {
        if (!(psiFile instanceof RobotPsiFile)) {
            return;
        }
        RobotTable[] tables = ((RobotPsiFile) psiFile).findChildrenByClass(RobotTable.class);
        for (RobotTable table : tables) {
            if (table.getKeywordsTable() != null) {
                findKeywordDefsInKeywordsTable(table.getKeywordsTable(), name, keywordDefList);
            }
        }
    }

    public static void findKeywordDefsInKeywordsTable(RobotKeywordsTable table, String name, List<RobotKeywordDef> keywordDefs) {
        List<RobotKeywordDefinition> definitions = table.getKeywordDefinitionList();
        for (RobotKeywordDefinition definition : definitions) {
            RobotKeywordDefinitionHeader header = definition.getKeywordDefinitionHeader();
            RobotKeywordDef keywordDef = header.getKeywordDef();
            addKeywordDefIfMatching(keywordDef, name, keywordDefs);
        }
    }

    public static void addKeywordDefIfMatching(RobotKeywordDef def, String name, List<RobotKeywordDef> keywordDefs) {
        String nameAsMethod = robotKeywordToMethodFast(name);
        String keywordAsMethod = robotKeywordToMethodFast(def.getName());
        if (nameAsMethod.equalsIgnoreCase(keywordAsMethod)) {
            keywordDefs.add(def);
        }
    }

    public static void findKeywordUsagesInFileByName(PsiFile psiFile, String name, List<RobotKeyword> keywordList) {
        if (!(psiFile instanceof RobotPsiFile)) {
            return;
        }
        RobotTable[] tables = ((RobotPsiFile) psiFile).findChildrenByClass(RobotTable.class);
        for (RobotTable RobotTable : tables) {
            RobotTestCasesTable testCasesTable = RobotTable.getTestCasesTable();
            if (testCasesTable != null) {
                findKeywordUsagesInTestCasesTable(testCasesTable, name, keywordList);
            }
            RobotKeywordsTable robotKeywordsTable = RobotTable.getKeywordsTable();
            if (robotKeywordsTable != null) {
                findKeywordUsagesInKeywordsTable(robotKeywordsTable, name, keywordList);
            }
            RobotSettingsTable robotSettingsTable = RobotTable.getSettingsTable();
            if (robotSettingsTable != null) {
                findKeywordUsagesInSettingsTable(robotSettingsTable, name, keywordList);
            }
        }
    }

    public static void findKeywordUsagesInKeywordsTable(RobotKeywordsTable keywordsTable, String name, List<RobotKeyword> keywordList) {
        List<RobotKeywordDefinition> robotKeywordDefinitionList = keywordsTable.getKeywordDefinitionList();
        for (RobotKeywordDefinition robotKeywordDefinition : robotKeywordDefinitionList) {
            List<RobotKeywordLine> lines = robotKeywordDefinition.getKeywordLineList();
            for (RobotKeywordLine line : lines) {
                RobotKeywordInvocationTest invocation = line.getKeywordInvocationTest();
                RobotVariableAssignToKeyword assignToKeyword = line.getVariableAssignToKeyword();
                if (invocation != null) {
                    RobotKeyword keyword = invocation.getKeyword();
                    addKeywordIfMatch(name, keyword, keywordList);
                } else if (assignToKeyword != null) {
                    RobotKeyword keyword = assignToKeyword.getKeywordInvocationTest().getKeyword();
                    addKeywordIfMatch(name, keyword, keywordList);
                }
            }
        }
    }

    public static void findKeywordUsagesInSettingsTable(RobotSettingsTable settingsTable, String name, List<RobotKeyword> keywordList) {
        List<RobotSettingsLine> lines = settingsTable.getSettingsLineList();
        for (RobotSettingsLine line : lines) {
            if (line.getSetting() != null) {
                RobotSetting setting = line.getSetting();
                if (setting.getTestSetupSetting() != null) {
                    RobotTestSetupSetting setupSetting = setting.getTestSetupSetting();
                    RobotKeyword keyword = setupSetting.getKeywordInvocationSettings().getKeyword();
                    addKeywordIfMatch(name, keyword, keywordList);
                }
            }
        }
    }

    public static void findKeywordUsagesInTestCasesTable(RobotTestCasesTable testCasesTable, String name, List<RobotKeyword> keywordList) {
        List<RobotTestCase> testCases = testCasesTable.getTestCaseList();
        for (RobotTestCase testCase : testCases) {
            findKeywordUsagesInTestCase(testCase, name, keywordList);
        }
    }

    public static void findKeywordUsagesInTestCase(RobotTestCase testCase, String name, List<RobotKeyword> keywordList) {
        for (RobotTestcaseLine line : testCase.getTestcaseLineList()) {
            RobotKeywordInvocationTest invocation = line.getKeywordInvocationTest();
            RobotVariableAssignToKeyword assignToKeyword = line.getVariableAssignToKeyword();
            if (invocation != null) {
                RobotKeyword keyword = invocation.getKeyword();
                addKeywordIfMatch(name, keyword, keywordList);
            } else if (assignToKeyword != null) {
                RobotKeywordInvocationTest assignInvocation = assignToKeyword.getKeywordInvocationTest();
                RobotKeyword keyword = assignInvocation.getKeyword();
                addKeywordIfMatch(name, keyword, keywordList);
            }
        }
    }

    private static void addKeywordIfMatch(String name, RobotKeyword keyword, List<RobotKeyword> keywordList) {
        String nameAsMethod = robotKeywordToMethodFast(name);
        String keywordAsMethod = robotKeywordToMethodFast(keyword.getName());
        if (nameAsMethod.equalsIgnoreCase(keywordAsMethod)) {
            keywordList.add(keyword);
        }
    }

    //-----------------Context-sensitive finders-------------------
    //TODO: Methods to find variables in scope


}