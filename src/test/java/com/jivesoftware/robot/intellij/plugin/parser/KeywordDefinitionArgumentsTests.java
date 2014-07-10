package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotArgumentDef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotArgumentsSetting;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefinition;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarDefaultArgValue;
import org.junit.Test;

/**
 * Created by charles on 7/9/14.
 */
public class KeywordDefinitionArgumentsTests extends RobotParserTest {
    private static final String KEYWORD_WITH_SCALAR_ARGS =
            "*** Keywords ***\n" +
                    "Keyword with scalar args\n" +
                    "  [arguments]  ${foo}  ${bar}  ${baz}\n" +
                    "  Log  ${foo}\n" +
                    "  Log  ${bar}\n" +
                    "  Log  ${baz}\n";

    private static final String KEYWORD_WITH_ARRAY_ARGS =
            "*** Keywords ***\n" +
                    "Keyword with array args\n" +
                    "  [arguments]  @{foo}  @{bar}  @{baz}\n" +
                    "  Log  @{foo}\n" +
                    "  Log  @{bar}\n" +
                    "  Log  @{baz}\n";

    private static final String KEYWORD_WITH_MIXED_ARGS =
            "*** Keywords ***\n" +
                    "Keyword with mixed scalar and array args\n" +
                    "  [arguments]  @{foo}  ${bar}  @{baz}  ${fob}\n" +
                    "  Log  @{foo}\n" +
                    "  Log  ${bar}\n" +
                    "  Log  @{baz}\n" +
                    "  Log  ${fob}\n";

    private static final String KEYWORD_WITH_DEFAULT_SCALAR_VALUES =
            "*** Keywords ***\n" +
                    "Keyword with default scalar args\n" +
                    "  [arguments]  ${foo}=123  ${bar}= abc  ${baz}\n" +
                    "  Log  ${foo}\n" +
                    "  Log  ${bar}\n" +
                    "  Log  ${baz}\n";

    private static final String KEYWORD_WITH_INVALID_SPACE_IN_ARG_VALUE =
            "*** Keywords ***\n" +
                    "Keyword with default scalar args and invalid space\n" +
                    "  [arguments]  ${foo} =123  ${bar}= abc  ${baz}\n" +
                    "  Log  ${foo}\n" +
                    "  Log  ${bar}\n" +
                    "  Log  ${baz}\n";

    private static final String KEYWORD_WITH_INVALID_DEFAULT_ARRAY_VALUE =
            "*** Keywords ***\n" +
                    "Keyword with invalid default array arg\n" +
                    "  [arguments]  ${foo} =123  @{bar}= abc  ${baz}\n" +
                    "  Log  ${foo}\n" +
                    "  Log  @{bar}\n" +
                    "  Log  ${baz}\n";

    @Test
    public void testKeywordWithScalarArgs() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_SCALAR_ARGS);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotArgumentDef.class, 3);
    }

    @Test
    public void testKeywordWithArrayArgs() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_ARRAY_ARGS);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotArgumentDef.class, 3);
    }

    @Test
    public void testKeywordWithDefaultScalarValues() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_DEFAULT_SCALAR_VALUES);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotArgumentDef.class, 3);
        assertFileHasPsiElements(file, RobotScalarDefaultArgValue.class, 2);
    }

    @Test
    public void testKeywordWithMixedArgs() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_MIXED_ARGS);
        assertFileHasPsiElements(file, RobotKeywordDefinition.class, 1);
        assertFileHasPsiElements(file, RobotArgumentDef.class, 4);
    }

    @Test
    public void testKeywordWithInvalidSpaceInDefaultArg() {
        RobotPsiFile file = doTestParseFails(KEYWORD_WITH_INVALID_SPACE_IN_ARG_VALUE);
        assertFileHasPsiElements(file, RobotArgumentsSetting.class, 0);
    }

    @Test
    public void testKeywordWithInvalidDefaultArrayValue() {
        RobotPsiFile file = doTestParseFails(KEYWORD_WITH_INVALID_DEFAULT_ARRAY_VALUE);
        assertFileHasPsiElements(file, RobotArgumentsSetting.class, 0);
    }
}
