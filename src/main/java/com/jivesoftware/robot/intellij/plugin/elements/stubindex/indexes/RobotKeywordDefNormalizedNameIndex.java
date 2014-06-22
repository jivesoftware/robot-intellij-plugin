package com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public class RobotKeywordDefNormalizedNameIndex extends StringStubIndexExtension<RobotKeywordDef> {
    public static final StubIndexKey<String, RobotKeywordDef> KEY = StubIndexKey.createIndexKey("Robot.keywordDef.normalizedName");

    @NotNull
    @Override
    public StubIndexKey<String, RobotKeywordDef> getKey() {
        return KEY;
    }
}
