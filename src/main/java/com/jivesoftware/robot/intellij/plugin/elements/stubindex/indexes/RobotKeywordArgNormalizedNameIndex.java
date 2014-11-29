package com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordArg;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public class RobotKeywordArgNormalizedNameIndex extends StringStubIndexExtension<RobotKeywordArg> {
    public static final StubIndexKey<String, RobotKeywordArg> KEY = StubIndexKey.createIndexKey("Robot.keywordArg.normalizedName");

    @NotNull
    @Override
    public StubIndexKey<String, RobotKeywordArg> getKey() {
        return KEY;
    }
}
