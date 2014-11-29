package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.junit.Test;

/**
 * Created by charles on 6/29/14.
 */
public class EllipsesTests extends RobotParserTest {
    private static final String DOCUMENTATION_ELLIPSES =
            "*** Test Cases ***\n" +
            "Test 1\n" +
            "  [Documentation]\n" +
            "  ...                My documentation\n" +
            "  Log  Some message";

    private static final String KEYWORD_WITH_ELLIPSES_SIMPLE =
            "*** Test Cases ***\n" +
            "Test a keyword with ellipses\n" +
            "  Log   Some Message\n" +
            "  ...   WARN";


    private static final String KEYWORD_WITH_ELLIPSES_BEFORE_ARG =
            "*** Test Cases ***\n" +
            "Test ellipses\n" +
            "  [Documentation]  My documentation\n" +
            "  Log\n" +
            "  ...\n" +
            "  ...   Some Message\n" +
            "  ...   INFO";

    private static final String ELLIPSES_IN_VARAIBLE_ASSIGNMENT =
            "*** Test Cases***\n" +
                    "Test Ellipses inside variable assignment.\n" +
                    "  ${var}=    Evaluate\n" +
                    "  ...        \"${EMPTY} Abc Def\"\n" +
                    "  Log    ${var}";

    @Test
    public void testDocumentationWithEllipses() {
        RobotPsiFile file = doTestParseSucceeds(DOCUMENTATION_ELLIPSES);
        assertFileHasPsiElements(file, RobotDocumentationMeta.class, 1);
    }

    @Test
    public void testKeywordWithEllipsesSimple() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_ELLIPSES_SIMPLE);
        assertFileHasPsiElements(file, RobotEllipses.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 1);
    }

    @Test
    public void testKeywordWithEllipsesBeforeArg() {
        RobotPsiFile file = doTestParseSucceeds(KEYWORD_WITH_ELLIPSES_BEFORE_ARG);
        assertFileHasPsiElements(file, RobotEllipses.class, 3);
        assertFileHasPsiElements(file, RobotKeyword.class, 1);
    }

    @Test
    public void testEllipsesInVariableAssignment() {
        RobotPsiFile file = doTestParseSucceeds(ELLIPSES_IN_VARAIBLE_ASSIGNMENT);
        assertFileHasPsiElements(file, RobotVariableAssignToKeyword.class, 1);
        assertFileHasPsiElements(file, RobotEllipses.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 2);
    }
}
