package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.junit.Test;

/**
 * Created by charles on 6/29/14.
 */
public class BasicTableTests extends RobotParserTest {
    private static final String SETTINGS_TABLE =
            "*** Settings ***\n" +
                    "Suite Setup     Foo Bar\n" +
                    "Suite Teardown  Bar Baz\n";

    private static final String KEYWORDS_TABLE =
                    "*** Keywords ***\n" +
                    "My User Keyword\n" +
                    "  [Arguments]  ${foo}  ${bar}\n" +
                    "  Log  ${foo}  INFO\n" +
                    "  ${bar}=   Evaluate  ${foo}\n";

    private static final String VARIABLES_TABLE =
            "*** Variables ***\n" +
                    "${fooVar}   12345\n" +
                    "${barVAR}=  Foo Keyword\n" +
                    "${fooBar}   ${fooVar}\n" +
                    "@{array}=   1   2   ${barVAR}\n";

    private static final String TEST_CASES_TABLE =
            "*** Test Cases ***\n" +
                    "My simple Test Case\n" +
                    "  Foo Keyword  123  456  ${var}\n" +
                    "  ${foo}=  Foo Keyword Abc  ${baz}\n";

    private static final String ALL_TABLES = SETTINGS_TABLE + KEYWORDS_TABLE + VARIABLES_TABLE + TEST_CASES_TABLE;

    @Test
    public void testSettingsTable() {
        RobotPsiFile file = doTestParseSucceeds(SETTINGS_TABLE);
        assertFileHasPsiElements(file, RobotSettingsTable.class, 1);
        assertFileHasPsiElements(file, RobotTestSetupSetting.class, 2);
    }

    @Test
    public void testKeywordsTable() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORDS_TABLE);
        assertFileHasPsiElements(file, RobotKeywordsTable.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 2);
    }

    @Test
    public void testVariablesTable() {
        RobotPsiFile file = doTestParseSucceeds(VARIABLES_TABLE);
        assertFileHasPsiElements(file, RobotVariablesTable.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 0);
        assertFileHasPsiElements(file, RobotVariablesLine.class, 4);
    }

    @Test
    public void testTestCasesTable() {
        RobotPsiFile file = doTestParseSucceeds(TEST_CASES_TABLE);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestcaseLine.class, 2);
        assertFileHasPsiElements(file, RobotKeyword.class, 2);
    }

    @Test
    public void testAllTables() {
        RobotPsiFile file = doTestParseSucceeds(ALL_TABLES);
        assertFileHasPsiElements(file, RobotSettingsTable.class, 1);
        assertFileHasPsiElements(file, RobotKeywordsTable.class, 1);
        assertFileHasPsiElements(file, RobotVariablesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
    }
}
