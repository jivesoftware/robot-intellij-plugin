package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.openapi.project.Project;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.jivesoftware.robot.intellij.plugin.elements.RobotElementFactory;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

/**
 * Created by charles on 6/28/14.
 */
public class ParserTests extends LightCodeInsightFixtureTestCase {
    final String FOR_LOOP_IN_RANGE =
            "*** Test Cases ***\n" +
            "Test For Loop\n" +
            "  :FOR  ${i}  IN RANGE  0  10\n" +
            "  \\  Do Something  ${foo}  ${bar}\n";

    final String FOR_LOOP_BAD_VARIABLE =
            "*** Test Cases ***\n" +
            "Test For Loop\n" +
            "  :FOR  @{i}  IN RANGE  0  10\n" +
            "  \\  Do Something  ${foo}  ${bar}\n";

    @Test
    public void testForLoopInRange() {
        doTestParseSucceeds(FOR_LOOP_IN_RANGE);
    }

    @Test
    public void testForLoopBadVariable() {
        doTestParseSucceeds(FOR_LOOP_BAD_VARIABLE);
    }

    private void doTestParseSucceeds(String code) {
        Project project = getProject();
        RobotPsiFile file = RobotElementFactory.createFile(project, FOR_LOOP_IN_RANGE);
        System.out.println("Pass?");
    }

    @Override
    @NotNull
    public LightProjectDescriptor getProjectDescriptor() {
        return super.getProjectDescriptor();
    }
}
