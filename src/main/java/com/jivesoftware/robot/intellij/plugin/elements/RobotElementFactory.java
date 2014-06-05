package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;

public class RobotElementFactory {

  public static RobotKeyword createKeyword(Project project, String text) {
    String start = "*** Test Cases ***\nSome Test\n  ";
    RobotPsiFile file = createFile(project, start + text);
    PsiElement[] children = file.getChildren();
    for (PsiElement el: children) {
      if (el instanceof RobotRobotTable) {
        RobotRobotTable table = (RobotRobotTable)el;
        if (table.getTestCasesTable() == null) {
          return null;
        }
        RobotTestCasesTable testCasesTable = table.getTestCasesTable();
        for (RobotTestCase robotTestCase: testCasesTable.getTestCaseList()) {
          for (RobotTestcaseLine robotTestcaseLine: robotTestCase.getTestcaseLineList()) {
            if (robotTestcaseLine.getKeywordInvocation() == null) {
              return null;
            }
            RobotKeywordInvocation invocation = robotTestcaseLine.getKeywordInvocation();
            return invocation.getKeyword();
          }
        }
        return null;
      }
    }
    return null;
  }

  public static RobotKeywordDef createKeywordDef(Project project, String keywordDefName) {
    String template = "*** Keywords ***\n" +
                      "%s\n" +
                      "  Log  abc  INFO";
    RobotPsiFile file = createFile(project, String.format(template, keywordDefName));
    for (PsiElement el: file.getChildren()) {
      if (el instanceof RobotRobotTable) {
        RobotRobotTable table = (RobotRobotTable) el;
        if (table.getKeywordsTable() == null) {
          return null;
        }
        RobotKeywordsTable keywordsTable = table.getKeywordsTable();
        for (RobotKeywordDefinition robotKeywordDefinition: keywordsTable.getKeywordDefinitionList()) {
          RobotKeywordDefinitionHeader header = robotKeywordDefinition.getKeywordDefinitionHeader();
          return header.getKeywordDef();
        }
      }
    }
    return null;
  }

  public static RobotPsiFile createFile(Project project, String text) {

    String name = "dummy.robot";
    return (RobotPsiFile) PsiFileFactory.getInstance(project)
        .createFileFromText(name, RobotFileType.INSTANCE, text);
  }
}
