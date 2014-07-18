package com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes;

import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarAssignment;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public class RobotAssignmentNormalizedNameIndex extends StringStubIndexExtension<RobotScalarAssignment> {
    public static final StubIndexKey<String, RobotScalarAssignment> KEY = StubIndexKey.createIndexKey("Robot.scalarAssignment.normalizedName");

    @NotNull
    @Override
    public StubIndexKey<String, RobotScalarAssignment> getKey() {
        return KEY;
    }
}
