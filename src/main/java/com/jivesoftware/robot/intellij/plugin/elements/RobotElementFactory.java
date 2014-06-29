package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;

import static java.lang.String.format;

public class RobotElementFactory {

    public static RobotKeyword createKeyword(Project project, String text) {
        String template = "*** Test Cases ***\nSome Test Case\n    %s\n";
        RobotPsiFile file = createFile(project, format(template, text));
        RobotTable table = file.findChildByClass(RobotTable.class);
        if (table == null || table.getTestCasesTable() == null) {
            return null;
        }
        RobotTestCasesTable testCasesTable = table.getTestCasesTable();
        for (RobotTestCase robotTestCase : testCasesTable.getTestCaseList()) {
            for (RobotTestcaseLine robotTestcaseLine : robotTestCase.getTestcaseLineList()) {
                if (robotTestcaseLine.getKeywordInvocationTest() == null) {
                    continue;
                }
                RobotKeywordInvocationTest invocation = robotTestcaseLine.getKeywordInvocationTest();
                return invocation.getKeyword();
            }
        }
        return null;
    }

    public static RobotKeywordDef createKeywordDef(Project project, String keywordDefName) {
        String template = "*** Keywords ***\n" +
                "%s\n" +
                "  Log  abc  INFO";
        RobotPsiFile file = createFile(project, format(template, keywordDefName));
        RobotTable table = file.findChildByClass(RobotTable.class);
        if (table == null || table.getKeywordsTable() == null) {
            return null;
        }
        RobotKeywordsTable keywordsTable = table.getKeywordsTable();
        for (RobotKeywordDefinition robotKeywordDefinition : keywordsTable.getKeywordDefinitionList()) {
            RobotKeywordDefinitionHeader header = robotKeywordDefinition.getKeywordDefinitionHeader();
            return header.getKeywordDef();
        }
        return null;
    }

    public static RobotPsiFile createFile(Project project, String text) {

        String name = "dummy.robot";
        return (RobotPsiFile) PsiFileFactory.getInstance(project)
                .createFileFromText(name, RobotFileType.INSTANCE, text);
    }
}
