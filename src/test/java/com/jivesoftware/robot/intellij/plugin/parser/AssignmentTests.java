package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotMultiAssignmentLhs;
import org.junit.Test;

/**
 * Created by charles on 7/2/14.
 */
public class AssignmentTests extends RobotParserTest {
    private static final String MULTI_ASSIGN =
            "*** Test Cases ***\n" +
            "Test Multi Assign\n" +
            "  ${var1}  ${var2}  ${var3}  Foo Bar Keyword\n";

    private static final String MULTI_ASSIGN_WITH_EQUALS =
            "*** Test Cases ***\n" +
                    "Test Multi Assign\n" +
                    "  ${var1}  ${var2}  ${var3}=  Foo Bar Keyword\n";

    private static final String MULTI_ASSIGN_INVALID_1 =
            "*** Test Cases ***\n" +
                    "Test Multi Assign Invalid\n" +
                    "  ${var1}  ${var2}=  ${var3}  Foo Bar Keyword\n";

    private static final String MULTI_ASSIGN_INVALID_2 =
            "*** Test Cases ***\n" +
                    "Test Multi Assign Invalid 2\n" +
                    "  ${var1}=  ${var2}=  Foo Bar Keyword\n";

    @Test
    public void testMultiAssign() {
        RobotPsiFile file = doTestParseSucceeds(MULTI_ASSIGN);
        assertFileHasPsiElements(file, RobotMultiAssignmentLhs.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 1);
    }

    @Test
    public void testMultiAssignWithEquals() {
        RobotPsiFile file = doTestParseSucceeds(MULTI_ASSIGN_WITH_EQUALS);
        assertFileHasPsiElements(file, RobotMultiAssignmentLhs.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 1);
    }

    @Test
    public void testMultiAssignInvalid1() {
        RobotPsiFile file = doTestParseFails(MULTI_ASSIGN_INVALID_1);
        assertFileHasPsiElements(file, RobotMultiAssignmentLhs.class, 0);
    }

    @Test
    public void testMultiAssignInvalid2() {
        RobotPsiFile file = doTestParseFails(MULTI_ASSIGN_INVALID_2);
        assertFileHasPsiElements(file, RobotMultiAssignmentLhs.class, 0);
    }
}
