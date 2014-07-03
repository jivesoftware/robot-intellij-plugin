package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.jivesoftware.robot.intellij.plugin.elements.RobotElementFactory;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTable;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCasesTable;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestcaseLine;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;

import java.util.Collection;
import java.util.List;

/**
 * Created by charles on 6/29/14.
 */
public abstract class RobotParserTest extends LightCodeInsightFixtureTestCase {

    protected <T extends PsiElement> T doTestParseSucceeds(String code, Class<T> psiElementClass) {
        RobotPsiFile file = doTestParseSucceeds(code);
        T expected = PsiTreeUtil.findChildOfType(file, psiElementClass);
        Assert.assertNotNull(String.format("Expected code to parse with a PsiElement of type %s successfully!", psiElementClass.getSimpleName()),
                expected);
        return expected;
    }

    protected <T extends PsiElement> void doTestParseFails(String code, Class<T> psiElementClass) {
        RobotPsiFile file = doTestParseFails(code);
        T expected = PsiTreeUtil.findChildOfType(file, psiElementClass);
        Assert.assertNull(String.format("Expected code to fail to parse with a PsiElement of type %s!", psiElementClass.getSimpleName()),
                expected);
    }

    protected RobotPsiFile doTestParseSucceeds(String code) {
        Project project = getProject();
        RobotPsiFile file = RobotElementFactory.createFile(project, code);
        PsiErrorElement err = findFirstError(file);
        Assert.assertNull("Expected no PsiErrorElement to exist in the AST!", err);
        return file;
    }

    protected RobotPsiFile doTestParseFails(String code) {
        Project project = getProject();
        RobotPsiFile file = RobotElementFactory.createFile(project, code);
        PsiErrorElement err = findFirstError(file);
        Assert.assertNotNull("Expected to find an error element!", err);
        return file;
    }

    protected static RobotTestCasesTable extractTestCasesTable(RobotPsiFile file) {
        RobotTable[] tables = file.findChildrenByClass(RobotTable.class);
        Assert.assertTrue("Expected PsiFile to contain a Robot Table", tables.length > 0);
        for (RobotTable table : tables) {
            if (table.getTestCasesTable() != null) {
                return table.getTestCasesTable();
            }
        }
        Assert.fail("Expected one of the Robot Tables to be a Test Cases table.");
        return null;
    }

    protected static RobotTestcaseLine extractFirstTestCaseLine(RobotPsiFile file) {
        RobotTestCasesTable table = extractTestCasesTable(file);
        for (RobotTestCase testCase : table.getTestCaseList()) {
            List<RobotTestcaseLine> lines = testCase.getTestcaseLineList();
            Assert.assertTrue("Expected there to be at least 1 test case line", lines.size() > 0);
            return lines.get(0);
        }
        Assert.fail("Expected there to be one test case line!");
        return null;
    }

    /**
     * Trivial recursive method to search for a PsiErrorElement in the tree.
     * I don't see any better method supplied by jetbrains for doing this.
     *
     * @param parent
     * @return
     */
    protected static PsiErrorElement findFirstError(PsiElement parent) {
        return PsiTreeUtil.findChildOfType(parent, PsiErrorElement.class);
    }

    protected static <T extends PsiElement> Collection<T> assertFileHasPsiElements(RobotPsiFile file, Class<T> psiClass, int numExpected) {
       Collection<T> children = PsiTreeUtil.findChildrenOfType(file, psiClass);
       Assert.assertEquals(
               String.format("Expected the Robot file to contain %d elements of type %s", numExpected, psiClass.getSimpleName()),
               numExpected, children.size());
        return children;
    }

}
