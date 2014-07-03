package com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public class RobotKeywordTitleNormalizedNameIndex extends StringStubIndexExtension<RobotKeywordTitle> {
    public static final StubIndexKey<String, RobotKeywordTitle> KEY = StubIndexKey.createIndexKey("Robot.keywordDef.normalizedName");

    @NotNull
    @Override
    public StubIndexKey<String, RobotKeywordTitle> getKey() {
        return KEY;
    }
}
