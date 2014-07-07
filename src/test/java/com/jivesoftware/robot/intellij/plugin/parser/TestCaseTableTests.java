package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.junit.Test;

/**
 * Created by charles on 7/6/14.
 */
public class TestCaseTableTests extends RobotParserTest {
    private static final String SIMPLE_TEST_CASE =
            "*** Test Cases ***\n" +
                    "My Simple Test Case\n" +
                    "  Log  Foo bar baz\n" +
                    "  ${foo}=  Do stuff  ${bar}\n";

    private static final String TEST_CASE_WITH_KEYWORD_ON_HEADER_LINE =
            "*** Test Cases ***\n" +
                    "My Simple Test Case  Log  ${fooo}\n";

    private static final String TEST_CASE_WITH_SETTING_ON_HEADER_LINE =
            "*** Test Cases ***\n" +
                    "My Simple Test Case  [tags]  abc  foo\n" +
                    "  Log  My simple test case\n";

    private static final String TEST_CASES_WITH_SETTINGS_FOR_NAMES =
            "*** Test Cases ***\n" +
                    "[tags]\n" +
                    "  Log  Foo Bar\n" +
                    "[Test Setup]\n" +
                    "  Log  ${baz}\n" +
                    "[Timeout]\n" +
                    "  ${bar}=  Evaluate  ${EMPTY}\n";

    @Test
    public void testSimpleTestCase() {
        RobotPsiFile file = doTestParseSucceeds(SIMPLE_TEST_CASE);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 2);
        assertFileHasPsiElements(file, RobotVariableAssignToKeyword.class, 1);
    }

    @Test
    public void testTestCaseWithKeywordOnHeadingLine() {
        RobotPsiFile file = doTestParseSucceeds(TEST_CASE_WITH_KEYWORD_ON_HEADER_LINE);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 1);
        assertFileHasPsiElements(file, RobotVariableAssignToKeyword.class, 0);
    }

    @Test
    public void testTestCaseWithSettingsOnHeadingLine() {
        RobotPsiFile file = doTestParseSucceeds(TEST_CASE_WITH_SETTING_ON_HEADER_LINE);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 1);
        assertFileHasPsiElements(file, RobotTestSetting.class, 1);
        assertFileHasPsiElements(file, RobotVariableAssignToKeyword.class, 0);
    }

    @Test
    public void testTestCasesWithSettingsForNames() {
        RobotPsiFile file = doTestParseSucceeds(TEST_CASES_WITH_SETTINGS_FOR_NAMES);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 3);
        assertFileHasPsiElements(file, RobotKeyword.class, 3);
        assertFileHasPsiElements(file, RobotVariableAssignToKeyword.class, 1);
    }

}
