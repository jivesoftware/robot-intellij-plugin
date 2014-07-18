package com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarVariable;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public class RobotVariableNormalizedNameIndex extends StringStubIndexExtension<RobotScalarVariable> {
    public static final StubIndexKey<String, RobotScalarVariable> KEY = StubIndexKey.createIndexKey("Robot.scalarVariable.normalizedName");

    @NotNull
    @Override
    public StubIndexKey<String, RobotScalarVariable> getKey() {
        return KEY;
    }
}
