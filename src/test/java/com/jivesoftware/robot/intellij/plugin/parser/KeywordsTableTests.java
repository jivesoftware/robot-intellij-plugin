package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefinition;
import com.jivesoftware.robot.intellij.plugin.psi.RobotReturnLine;
import org.junit.Test;

/**
 * Created by charles on 7/2/14.
 */
public class KeywordsTableTests extends RobotParserTest {
    private static final String KEYWORD_WITH_SINGLE_RETURN_VALUE =
            "*** Keywords ***\n" +
            "Single Return Val\n" +
            "  Foo Foo Keyword\n" +
            "  [Return]  Foo Bar Baz\n";

    private static final String KEYWORD_WITH_SINGLE_RETURN_VARIABLE =
            "*** Keywords ***\n" +
                    "Single Return Variable\n" +
                    "  Foo Foo Keyword\n" +
                    "  [Return]  ${foo Bar Baz}\n";

    private static final String KEYWORD_WITH_2_RETURN_VALUES =
            "*** Keywords ***\n" +
                    "Double Return Val\n" +
                    "  Foo Foo Keyword\n" +
                    "  [Return]  FOO    BAR\n";

    private static final String KEYWORD_WITH_2_RETURN_VARIABLES =
            "*** Keywords ***\n" +
                    "Double Return Variables\n" +
                    "  Foo Foo Keyword\n" +
                    "  [Return]  ${foo}    ${bar}\n";

    private static final String KEYWORD_WITH_MIXED_RETURN_VALUES_AND_VARIABLES =
            "*** Keywords ***\n" +
                    "Mixed Return Values and variables\n" +
                    "  Foo Foo Keyword\n" +
                    "  [Return]  ${foo}  FOO  ${bar}  BAR\n";

    private static final String KEYWORD_WITH_MULTIPLE_RETURN_STATEMENTS =
            "*** Keywords ***\n" +
                    "Double Return Statements\n" +
                    "  [Return]  ${BAZ}\n" +
                    "  Foo Foo Keyword\n" +
                    "  [Return]  ${foo}  FOO  ${bar}  BAR\n" +
                    "  Log  Foo\n";

    @Test
    public void testKeywordWithSingleReturnValue() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_SINGLE_RETURN_VALUE);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
        assertFileHasPsiElements(file, RobotReturnLine.class, 1);
    }

    @Test
    public void testKeywordWithSingleReturnVariable() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_SINGLE_RETURN_VARIABLE);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
        assertFileHasPsiElements(file, RobotReturnLine.class, 1);
    }

    @Test
    public void testKeywordWith2ReturnValues() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_2_RETURN_VALUES);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
        assertFileHasPsiElements(file, RobotReturnLine.class, 1);
    }

    @Test
    public void testKeywordWith2ReturnVariables() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_2_RETURN_VARIABLES);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
        assertFileHasPsiElements(file, RobotReturnLine.class, 1);
    }

    @Test
    public void testKeywordWithMixedReturnValuesAndVariables() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_MIXED_RETURN_VALUES_AND_VARIABLES);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
        assertFileHasPsiElements(file, RobotReturnLine.class, 1);
    }

    @Test
    public void testKeywordWithMultipleReturnStatements() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_MULTIPLE_RETURN_STATEMENTS);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
        assertFileHasPsiElements(file, RobotReturnLine.class, 2);
    }
}
