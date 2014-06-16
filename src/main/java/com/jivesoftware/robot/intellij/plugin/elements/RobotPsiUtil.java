package com.jivesoftware.robot.intellij.plugin.elements;

import com.google.common.collect.Lists;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.util.indexing.FileBasedIndex;
import com.jivesoftware.robot.intellij.plugin.elements.references.FindRobotKeywordsUsagesByNameProcessor;
import com.jivesoftware.robot.intellij.plugin.elements.references.FindRobotRobotKeywordsByNameProcessor;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;

import java.util.Collection;
import java.util.List;

public class RobotPsiUtil {

  public static Project getCurrentProject() {
      DataContext dataContext = DataManager.getInstance().getDataContextFromFocus().getResultSync();
      Project project = DataKeys.PROJECT.getData(dataContext);
      return project;
  }

  public static boolean isJavaRobotKeyword(PsiElement element) {
    if (!(element instanceof PsiMethod)) {
      return false;
    }
    PsiModifierList psiModifierList = ((PsiMethod) element).getModifierList();
    return psiModifierList.findAnnotation(RobotKeywordDefinitionFinder.ROBOT_KEYWORD_ANNOTATION) != null;
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
    RobotRobotTable[] tables = ((RobotPsiFile) file).findChildrenByClass(RobotRobotTable.class);
    for (RobotRobotTable table : tables) {
      if (table.getTestCasesTable() != null) {
        addAllTestCasesInTable(table.getTestCasesTable(), results);
      }
    }
  }

  private static void findTestCasesInFileByName(PsiFile file, String name, List<RobotTestCase> results) {
    if (!(file instanceof RobotPsiFile)) {
      return;
    }
    RobotRobotTable[] tables = ((RobotPsiFile) file).findChildrenByClass(RobotRobotTable.class);
    for (RobotRobotTable table : tables) {
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

  public static List<RobotKeywordDef> findAllRobotKeywordDefs(Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
            GlobalSearchScope.projectScope(project));
    List<RobotKeywordDef> results = Lists.newArrayList();
    for (VirtualFile f : robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordDefsInFile(psiFile, results);
    }
    return results;
  }

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

  public static List<RobotKeywordDef> findKeywordDefsByName(String name, Project project) {
    GlobalSearchScope robotFileScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);

    FindRobotRobotKeywordsByNameProcessor processor = new FindRobotRobotKeywordsByNameProcessor(name);
    PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(name, robotFileScope, processor, false);

    return processor.getResults();
  }

  public static void findKeywordDefsInFile(PsiFile psiFile, List<RobotKeywordDef> keywordDefList) {
    if (!(psiFile instanceof RobotPsiFile)) {
      return;
    }
    RobotRobotTable[] tables = ((RobotPsiFile) psiFile).findChildrenByClass(RobotRobotTable.class);
    for (RobotRobotTable table : tables) {
      if (table.getKeywordsTable() != null) {
        addAllKeywordDefsInTable(table.getKeywordsTable(), keywordDefList);
      }
    }
  }

  public static void addAllKeywordDefsInTable(RobotKeywordsTable keywordsTable, List<RobotKeywordDef> keywordDefs) {
    for (RobotKeywordDefinition definition : keywordsTable.getKeywordDefinitionList()) {
      RobotKeywordDefinitionHeader header = definition.getKeywordDefinitionHeader();
      RobotKeywordDef def = header.getKeywordDef();
      keywordDefs.add(def);
    }
  }

  public static void findKeywordDefsInFileByName(PsiFile psiFile, String name, List<RobotKeywordDef> keywordDefList) {
    if (!(psiFile instanceof RobotPsiFile)) {
      return;
    }
    RobotRobotTable[] tables = ((RobotPsiFile) psiFile).findChildrenByClass(RobotRobotTable.class);
    for (RobotRobotTable table : tables) {
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
    RobotRobotTable[] tables = ((RobotPsiFile) psiFile).findChildrenByClass(RobotRobotTable.class);
    for (RobotRobotTable robotRobotTable : tables) {
      RobotTestCasesTable testCasesTable = robotRobotTable.getTestCasesTable();
      if (testCasesTable != null) {
        findKeywordUsagesInTestCasesTable(testCasesTable, name, keywordList);
      }
      RobotKeywordsTable robotKeywordsTable = robotRobotTable.getKeywordsTable();
      if (robotKeywordsTable != null) {
        findKeywordUsagesInKeywordsTable(robotKeywordsTable, name, keywordList);
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

}
