package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.junit.Test;

/**
 * Created by charles on 6/29/14.
 */
public class VariableTableTests extends RobotParserTest {
    private static final String VALID_VARIABLE_NAMES =
            "*** Variables ***\n" +
            "${camelCaseVar}=   Variable surrounded by spaces\n" +
            "${ ABC }=   Variable surrounded by spaces\n" +
            "${___}=     Underscore variable\n" +
            "${123}=     Number variable\n" +
            "${ A Variable Name }=  Variable name with spaces\n" +
            "@{ARRAY}=   Array variable\n" +
            "*** Test Cases ***\n" +
            "My Test Case With Many Variables\n" +
            "  Foo Keyword  ${camelCaseVar}  ${ ABC }  ${___}  ${123}  ${ A Variable Name }\n" +
            "  Bar Keyword  @{ARRAY}\n";

    private static final String ASSIGN_SCALAR_VARIABLE_TO_NOTHING =
            "*** Variables ***\n" +
                    "${fooBar}=\n";

    private static final String ASSIGN_ARRAY_VARIABLE_TO_NOTHING =
            "*** Variables ***\n" +
                    "@{fooBar}=\n";

    private static final String ASSIGN_VARIABLE_NO_ENDLINE =
            "*** Variables ***\n" +
                    "${foo}=  123";

    @Test
    public void testValidVariableNames() {
        RobotPsiFile file = doTestParseSucceeds(VALID_VARIABLE_NAMES);
        assertFileHasPsiElements(file, RobotVariablesLine.class, 6);
        assertFileHasPsiElements(file, RobotKeyword.class, 2);
    }

    @Test
    public void testAssignScalarToNothing() {
        RobotPsiFile file = doTestParseSucceeds(ASSIGN_SCALAR_VARIABLE_TO_NOTHING);
        assertFileHasPsiElements(file, RobotVariablesLine.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 0);
        assertFileHasPsiElements(file, RobotScalarAssignment.class, 1);
    }

    @Test
    public void testAssignArrayToNothing() {
        RobotPsiFile file = doTestParseSucceeds(ASSIGN_ARRAY_VARIABLE_TO_NOTHING);
        assertFileHasPsiElements(file, RobotVariablesLine.class, 1);
        assertFileHasPsiElements(file, RobotKeyword.class, 0);
        assertFileHasPsiElements(file, RobotArrayAssignmentLhs.class, 1);
    }

    @Test
    public void testAssignVariableNoEndline() {
        RobotPsiFile file = doTestParseSucceeds(ASSIGN_VARIABLE_NO_ENDLINE);
        assertFileHasPsiElements(file, RobotVariablesLine.class, 1);
        assertFileHasPsiElements(file, RobotScalarAssignmentLhs.class, 1);
    }
}
