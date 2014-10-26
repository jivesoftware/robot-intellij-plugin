package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
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
                if (robotTestcaseLine.getExecutionLine() == null || robotTestcaseLine.getExecutionLine().getKeywordInvocationTest() == null) {
                    continue;
                }
                RobotKeywordInvocationTest invocation = robotTestcaseLine.getExecutionLine().getKeywordInvocationTest();
                return invocation.getKeyword();
            }
        }
        return null;
    }

    public static RobotKeywordTitle createKeywordTitle(Project project, String keywordDefName) {
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
            return robotKeywordDefinition.getKeywordTitle();
        }
        return null;
    }

    public static RobotScalarVariable createScalarVariable(Project project, String scalarVarName) {
        String template = "*** Test Cases ***\n" +
                "My Test Case\n" +
                "  Log  ${%s}";
        RobotPsiFile file = createFile(project, format(template, scalarVarName));
        return PsiTreeUtil.findChildOfType(file, RobotScalarVariable.class);
    }

    public static RobotScalarAssignment createScalarAssignment(Project project, String scalarVarName) {
        String template = "*** Test Cases ***\n" +
                "My Test Case\n" +
                "  ${%s}=   Evaluate   'Abc'";
        RobotPsiFile file = createFile(project, format(template, scalarVarName));
        return PsiTreeUtil.findChildOfType(file, RobotScalarAssignment.class);
    }

    public static RobotScalarAssignmentLhs createScalarAssignmentLhs(Project project, String scalarVarName) {
        String template = "*** Test Cases ***\n" +
                "My Test Case\n" +
                "  ${%s}=   Evaluate   'Abc'";
        RobotPsiFile file = createFile(project, format(template, scalarVarName));
        return PsiTreeUtil.findChildOfType(file, RobotScalarAssignmentLhs.class);
    }

    public static RobotScalarDefaultArgValue createScalarDefaultArgValue(Project project, String scalarVarName) {
        String template = "*** Keywords ***\n" +
                "My Keyword\n" +
                "  [arguments]  ${%s}=abc\n" +
                "  Log  Foo\n";
        RobotPsiFile file = createFile(project, format(template, scalarVarName));
        return PsiTreeUtil.findChildOfType(file, RobotScalarDefaultArgValue.class);
    }

    public static RobotArgumentDef createArgumentDef(Project project, String scalarVarName) {
        String template = "*** Keywords ***\n" +
                "My Keyword\n" +
                "  [arguments]  ${%s}\n" +
                "  Log  Foo\n";
        RobotPsiFile file = createFile(project, format(template, scalarVarName));
        return PsiTreeUtil.findChildOfType(file, RobotArgumentDef.class);
    }

    public static RobotResourceFile createRobotResourceFile(Project project, String fileName) {
        String template = "*** Settings ***\n" +
                "Resource  %s\n";
        RobotPsiFile file = createFile(project, format(template, fileName));
        return PsiTreeUtil.findChildOfType(file, RobotResourceFile.class);
    }

    public static RobotPsiFile createFile(Project project, String text) {

        String name = "dummy.robot";
        return (RobotPsiFile) PsiFileFactory.getInstance(project)
                .createFileFromText(name, RobotFileType.INSTANCE, text);
    }
}
