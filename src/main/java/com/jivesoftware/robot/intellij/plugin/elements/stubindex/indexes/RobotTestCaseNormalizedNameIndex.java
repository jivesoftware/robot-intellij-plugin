package com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public class RobotTestCaseNormalizedNameIndex extends StringStubIndexExtension<RobotTestCase> {
    public static final StubIndexKey<String, RobotTestCase> KEY = StubIndexKey.createIndexKey("Robot.keyword.normalizedTestCaseName");

    @NotNull
    @Override
    public StubIndexKey<String, RobotTestCase> getKey() {
        return KEY;
    }
}
