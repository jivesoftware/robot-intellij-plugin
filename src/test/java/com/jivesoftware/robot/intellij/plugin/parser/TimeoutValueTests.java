package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCaseTimeoutMeta;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCasesTable;
import org.junit.Test;

/**
 * Created by charlescapps on 12/6/14.
 */
public class TimeoutValueTests extends RobotParserTest {
    public static final String TIMEOUT_TEST_CASES =
            "*** Test Cases***\n" +
            "Timeout Test 1\n" +
            "    [Timeout]   1 min 30 secs\n" +
            "    Log         Foo1\n" +
            "\n" +
            "Timeout Test 2\n" +
            "    [Timeout]   1min30secs\n" +
            "    Log         Foo2\n" +
            "\n" +
            "Timeout Test 3\n" +
            "    [Timeout]   1 m 30 s\n" +
            "    Log         Foo3\n" +
            "\n" +
            "Timeout Test 4\n" +
            "    [Timeout]   1m30s\n" +
            "    Log         Foo4\n" +
            "\n" +
            "Timeout Test 5\n" +
            "    [Timeout]   -1m30s\n" +
            "    Log         Foo5\n" +
            "\n" +
            "Timeout Test 6\n" +
            "    [Timeout]   -1.23\n" +
            "    Log         Foo6\n" +
            "\n" +
            "Timeout Test 7\n" +
            "    [Timeout]   00\n" +
            "    Log         Foo6";

    private static final String LONG_UNITS_PLURAL =
            "*** Test Cases ***\n" +
            "Test All Units Plural\n" +
            "    [Timeout]  0.1 days 0.2 hours 0.3 minutes 0.4 seconds 0.5 milliseconds\n" +
            "    Log  FOO\n";

    private static final String LONG_UNITS_SINGULAR =
            "*** Test Cases ***\n" +
            "Test All Units Singular\n" +
            "    [Timeout]  0.1 day 0.2 hour 0.3 minute 0.4 second 0.5 millisecond\n" +
            "    Log  FOO\n";

    // TODO: We could test all the possible units

    @Test
    public void testManyTimeoutValues() {
        RobotPsiFile file = doTestParseSucceeds(TIMEOUT_TEST_CASES);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 7);
        assertFileHasPsiElements(file, RobotTestCaseTimeoutMeta.class, 7);
    }

    @Test
    public void testLongUnitsPlural() {
        RobotPsiFile file = doTestParseSucceeds(LONG_UNITS_PLURAL);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
        assertFileHasPsiElements(file, RobotTestCaseTimeoutMeta.class, 1);
    }

    @Test
    public void testLongUnitsSingular() {
        RobotPsiFile file = doTestParseSucceeds(LONG_UNITS_SINGULAR);
        assertFileHasPsiElements(file, RobotTestCasesTable.class, 1);
        assertFileHasPsiElements(file, RobotTestCase.class, 1);
        assertFileHasPsiElements(file, RobotTestCaseTimeoutMeta.class, 1);
    }
}
