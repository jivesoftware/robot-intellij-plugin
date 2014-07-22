package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotEllipses;
import com.jivesoftware.robot.intellij.plugin.psi.RobotForLoopIn;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.junit.Test;

/**
 * Created by charles.capps on 7/22/14.
 */
public class ForLoopInTests extends RobotParserTest {
    private static final String FOR_LOOP_IN_SINGLE_VARIABLE_VALUE =
            "*** Test Cases ***\n" +
                    "My Test Case\n" +
                    "  :FOR  ${foo}  IN  ${abc}\n" +
                    "  \\  Log  ${foo}\n";

    private static final String FOR_LOOP_IN_MULTIPLE_VALUES =
            "*** Test Cases ***\n" +
                    "My Test Case\n" +
                    "  :FOR  ${foo}  IN  ${abc}  ${bcd}\n" +
                    "  \\  Log  ${foo}\n";

    private static final String FOR_LOOP_IN_ARRAY =
            "*** Test Cases ***\n" +
                    "My Test Case\n" +
                    "  :FOR  ${foo}  IN  @{array}\n" +
                    "  \\  Log  ${foo}\n";

    private static final String FOR_LOOP_IN_MULTIPLE_ARGUMENTS =
            "*** Test Cases ***\n" +
                    "My Test Case\n" +
                    "  :FOR  ${foo1}  ${foo2}  IN\n" +
                    "  ...   Dog       Cat\n" +
                    "  ...   Horse     Bear\n" +
                    "  \\     Log      ${foo1}\n" +
                    "  \\     Log      ${foo2}\n";

    @Test
    public void testBasicForLoopInSingleVariableValue() {
        RobotPsiFile file = doTestParseSucceeds(FOR_LOOP_IN_SINGLE_VARIABLE_VALUE);
        assertFileHasPsiElements(file, RobotForLoopIn.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
    }

    @Test
    public void testBasicForLoopInMultipleVariableValues() {
        RobotPsiFile file = doTestParseSucceeds(FOR_LOOP_IN_MULTIPLE_VALUES);
        assertFileHasPsiElements(file, RobotForLoopIn.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
    }

    @Test
    public void testBasicForLoopInArray() {
        RobotPsiFile file = doTestParseSucceeds(FOR_LOOP_IN_ARRAY);
        assertFileHasPsiElements(file, RobotForLoopIn.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
    }

    @Test
    public void testForLoopMultipleArguments() {
        RobotPsiFile file = doTestParseSucceeds(FOR_LOOP_IN_MULTIPLE_ARGUMENTS);
        assertFileHasPsiElements(file, RobotForLoopIn.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
        assertFileHasPsiElements(file, RobotEllipses.class, 2);
    }
}
