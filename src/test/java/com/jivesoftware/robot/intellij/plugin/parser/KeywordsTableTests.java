package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
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

    private static final String KEYWORD_WITH_NUMBERS_FOR_NAME =
            "*** Keywords ***\n" +
                    "198923\n" +
                    "  Log  Foo bar baz\n";

    private static final String KEYWORD_WITH_DASHES_AND_UNDERSCORES_FOR_NAME =
            "*** Keywords ***\n" +
                    "----____\n" +
                    "  Log  Foo bar baz\n";

    private static final String KEYWORD_WITH_$_FOR_NAME =
            "*** Keywords ***\n" +
                    "$$$\n" +
                    "  Log  Foo bar baz\n";

    private static final String INVALID_KEYWORD_WITHOUT_A_TITLE_1 =
            "*** Keywords ***\n" +
                    "  Log  foobar\n";

    private static final String INVALID_KEYWORD_WITHOUT_A_TITLE_2 =
            "*** Keywords ***\n" +
                    "  [arguments]  ${foo}  ${bar}\n";

    private static final String KEYWORD_WITH_ARGUMENTS_ON_TITLE_LINE =
            "*** Keywords ***\n" +
                    "My Foo Keyword  [Arguments]  ${foo}  ${bar}\n" +
                    "  Log  ${foo} ${bar} abc  WARN\n";

    private static final String KEYWORD_WITH_ARGUMENTS_EMBEDDED_IN_NAME =
            "*** Keywords ***\n" +
                    "My Foo ${foo} Keyword ${bar}\n" +
                    "  Log  ${foo} ${bar} abc  WARN\n";

    private static final String KEYWORD_WITH_SPECIAL_CHARACTERS =
            "*** Keywords ***\n" +
                    "My \\${foo} \\#@%=|.*()[]-_\"'keyword\n" +
                    "  [Arguments]  ${x}  ${y}\n" +
                    "  Log  $did it!\n";

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

    @Test
    public void testKeywordWithNumbersForName() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_NUMBERS_FOR_NAME);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
    }

    @Test
    public void testKeywordWithDashesAndUnderscoresForName() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_DASHES_AND_UNDERSCORES_FOR_NAME);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
    }

    @Test
    public void testKeywordWith$$$ForName() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_$_FOR_NAME);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotKeywordTitle.class, 1);
    }

    @Test
    public void testInvalidKeywordWithoutATitle1() {
        RobotPsiFile file = doTestParseFails(INVALID_KEYWORD_WITHOUT_A_TITLE_1);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 0);
    }

    @Test
    public void testInvalidKeywordWithoutATitle2() {
        RobotPsiFile file = doTestParseFails(INVALID_KEYWORD_WITHOUT_A_TITLE_2);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 0);
    }

    @Test
    public void testKeywordWithArgumentsOnTitleLine() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_ARGUMENTS_ON_TITLE_LINE);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotArgumentDef.class, 2);
        assertFileHasPsiElements(file, RobotKeywordLine.class, 2);
    }

    @Test
    public void testKeywordWithArgumentsEmbeddedInName() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_ARGUMENTS_EMBEDDED_IN_NAME);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotArgumentDef.class, 0);
        assertFileHasPsiElements(file, RobotKeywordLine.class, 1);
    }

    @Test
    public void testKeywordWithSpecialCharacters() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_SPECIAL_CHARACTERS);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotArgumentDef.class, 2);
        assertFileHasPsiElements(file, RobotKeywordLine.class, 2);
    }
}
