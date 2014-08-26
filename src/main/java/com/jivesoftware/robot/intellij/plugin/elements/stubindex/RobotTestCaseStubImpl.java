package com.jivesoftware.robot.intellij.plugin.elements.stubindex;

import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.jetbrains.annotations.Nullable;

/**
 * Created by charles on 6/9/14.
 */
public class RobotTestCaseStubImpl extends StubBase<RobotTestCase> implements RobotTestCaseStub {
    private StringRef name;

    public RobotTestCaseStubImpl(final StubElement parent, final IStubElementType elementType, StringRef name) {
        super(parent, elementType);
        this.name = name;
    }

    @Nullable
    @Override
    public String getName() {
        return name.getString();
    }
}
