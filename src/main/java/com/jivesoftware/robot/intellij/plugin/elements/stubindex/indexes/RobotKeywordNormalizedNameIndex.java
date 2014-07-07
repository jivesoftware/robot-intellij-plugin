package com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public class RobotKeywordNormalizedNameIndex extends StringStubIndexExtension<RobotKeyword> {
    public static final StubIndexKey<String, RobotKeyword> KEY = StubIndexKey.createIndexKey("Robot.keyword.normalizedName");

    @NotNull
    @Override
    public StubIndexKey<String, RobotKeyword> getKey() {
        return KEY;
    }
}
