package com.jivesoftware.robot.intellij.plugin.parser;

import com.jivesoftware.robot.intellij.plugin.psi.RobotDocumentationSetting;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
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

    @Test
    public void testDocumentationWithEllipses() {
        doTestParseSucceeds(DOCUMENTATION_ELLIPSES, RobotDocumentationSetting.class);
    }

    @Test
    public void testKeywordWithEllipsesSimple() {
        doTestParseSucceeds(KEYWORD_WITH_ELLIPSES_SIMPLE, RobotKeyword.class);
    }

    @Test
    public void testKeywordWithEllipsesBeforeArg() {
        doTestParseSucceeds(KEYWORD_WITH_ELLIPSES_BEFORE_ARG, RobotKeyword.class);
    }
}
