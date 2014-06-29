package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.jivesoftware.robot.intellij.plugin.elements.RobotElementFactory;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by charles on 6/28/14.
 */
public class ForLoopInRangeParserTests extends RobotParserTest {
    private static final String FOR_LOOP_IN_RANGE =
            "*** Test Cases ***\n" +
            "Test For Loop\n" +
            "  :FOR  ${i}  IN RANGE  10\n" +
            "  \\  Do Something  ${foo}  ${bar}\n";

    private static final String FOR_LOOP_IN_RANGE_DOUBLE_BOUND =
            "*** Test Cases ***\n" +
            "Test For Loop\n" +
            "  :FOR  ${i}  IN RANGE  0  10\n" +
            "  \\  Do Something  ${foo}  ${bar}\n";

    private static final String FOR_LOOP_IN_RANGE_VAR_BOUNDS =
            "*** Test Cases ***\n" +
            "Test For Loop\n" +
            "  :FOR  ${i}  IN RANGE  ${lower}  ${upper}\n" +
            "  \\  Do Something  ${foo}  ${bar}\n";

    private static final String FOR_LOOP_IN_RANGE_WITH_STEP =
            "*** Test Cases ***\n" +
            "Test For Loop\n" +
            "  :FOR  ${i}  IN RANGE  ${lower}  ${upper}  3\n" +
            "  \\  Do Something  ${foo}  ${bar}\n";

    private static final String FOR_LOOP_ELLIPSES =
            "*** Test Cases ***\n" +
            "Test For Loop Ellipses In Bounds\n" +
            "  :FOR  ${i}  IN RANGE   0\n" +
            "  \\   ...  10\n" +
            "  \\  Log   Abc";

    private static final String FOR_LOOP_ELLIPSES_2 =
            "*** Test Cases ***\n" +
            "Test For Loop Ellipses In Bounds 2\n" +
            "  :FOR  ${i}  IN RANGE\n" +
            "  \\   ...  0\n" +
            "  \\   ...  10\n" +
            "  \\  Log   Abc";

    // Negative test cases

    private static final String FOR_LOOP_BAD_VARIABLE =
            "*** Test Cases ***\n" +
            "Test For Loop\n" +
            "  :FOR  @{i}  IN RANGE  0  10\n" +
            "  \\  Do Something  ${foo}  ${bar}\n";

    @Test
    public void testForLoopInRange() {
        doTestParseSucceeds(FOR_LOOP_IN_RANGE, RobotForLoopInRange.class);
    }

    @Test
    public void testForLoopInRangeDoubleBound() {
        doTestParseSucceeds(FOR_LOOP_IN_RANGE_DOUBLE_BOUND, RobotForLoopInRange.class);
    }

    @Test
    public void testForLoopInRangeVarBounds() {
        doTestParseSucceeds(FOR_LOOP_IN_RANGE_VAR_BOUNDS, RobotForLoopInRange.class);
    }

    @Test
    public void testForLoopInRangeWithStep() {
        doTestParseSucceeds(FOR_LOOP_IN_RANGE_WITH_STEP, RobotForLoopInRange.class);
    }

    @Test
    public void testForLoopInRangeEllipses() {
        doTestParseSucceeds(FOR_LOOP_ELLIPSES, RobotForLoopInRange.class);
    }

    @Test
    public void testForLoopInRangeEllipses2() {
        doTestParseSucceeds(FOR_LOOP_ELLIPSES_2, RobotForLoopInRange.class);
    }

    @Test
    public void testForLoopBadVariable() {
        doTestParseFails(FOR_LOOP_BAD_VARIABLE, RobotForLoopInRange.class);
    }


}
