package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.PsiComment;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordInvocationTest;
import com.jivesoftware.robot.intellij.plugin.psi.RobotSettingsLine;
import com.jivesoftware.robot.intellij.plugin.psi.RobotVariableAssignToKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotVariablesLine;
import org.junit.Test;

/**
 * Created by charles on 7/24/14.
 */
public class CommentTests extends RobotParserTest {

    private static final String COMMENT_AFTER_VARIABLE_LINE =
            "*** Variables ***\n" +
                    "${foo}=   bar\n" +
                    "${baz}=   rad      # comment foo foo foo";

    private static final String COMMENT_AFTER_TEST_CASE_LINE =
            "*** Test Cases ***\n" +
                    "My Foo Test Case\n" +
                    "   ${foo}=   Bar Keyword\n" +
                    "   ${baz}=   Rad Keyword      # comment foo foo foo";

    private static final String COMMENT_AFTER_KEYWORD_DEFINITION_LINE =
            "*** KEYWORDS ***\n" +
                    "My Foo Keyword\n" +
                    "   ${foo}=   Bar Keyword\n" +
                    "   Baz Keyword      # comment foo foo foo";

    private static final String COMMENT_AFTER_SETTINGS_LINE =
            "*** Settings ***\n" +
                    "My Foo Setting  Bar Value\n" +
                    "Force Tags      abc  def    # Bar baz comment   stuff";

    @Test
    public void testCommentAfterVariableLine() {
        RobotPsiFile file = doTestParseSucceeds(COMMENT_AFTER_VARIABLE_LINE);
        assertFileHasPsiElements(file, PsiComment.class, 1);
        assertFileHasPsiElements(file, RobotVariablesLine.class, 2);
    }

    @Test
    public void testCommentAfterTestCaseLine() {
        RobotPsiFile file = doTestParseSucceeds(COMMENT_AFTER_TEST_CASE_LINE);
        assertFileHasPsiElements(file, PsiComment.class, 1);
        assertFileHasPsiElements(file, RobotVariableAssignToKeyword.class, 2);
    }

    @Test
    public void testCommentAfterKeywordDefinitionLine() {
        RobotPsiFile file = doTestParseSucceeds(COMMENT_AFTER_KEYWORD_DEFINITION_LINE);
        assertFileHasPsiElements(file, PsiComment.class, 1);
        assertFileHasPsiElements(file, RobotVariableAssignToKeyword.class, 1);
        assertFileHasPsiElements(file, RobotKeywordInvocationTest.class, 2);
    }

    @Test
    public void testCommentAfterSettingsLine() {
        RobotPsiFile file = doTestParseSucceeds(COMMENT_AFTER_SETTINGS_LINE);
        assertFileHasPsiElements(file, PsiComment.class, 1);
        assertFileHasPsiElements(file, RobotSettingsLine.class, 2);
    }
}
