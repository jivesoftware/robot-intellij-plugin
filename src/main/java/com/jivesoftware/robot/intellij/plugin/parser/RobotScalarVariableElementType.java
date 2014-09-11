package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotScalarVariableStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotScalarVariableStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotVariableNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarVariable;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotScalarVariableImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RobotScalarVariableElementType extends IStubElementType<RobotScalarVariableStub, RobotScalarVariable> {

  public RobotScalarVariableElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

    @Override
    public RobotScalarVariable createPsi(@NotNull RobotScalarVariableStub stub) {
        return new RobotScalarVariableImpl(stub, this);
    }

    @Override
    public RobotScalarVariableStub createStub(@NotNull RobotScalarVariable psi, StubElement parentStub) {
        return new RobotScalarVariableStubImpl(parentStub, this, StringRef.fromString(psi.getName()));
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "robot." + super.toString();
    }

    @Override
    public void serialize(@NotNull RobotScalarVariableStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public RobotScalarVariableStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef name = dataStream.readName();
        return new RobotScalarVariableStubImpl(parentStub, this, name);
    }

    @Override
    public void indexStub(@NotNull RobotScalarVariableStub stub, @NotNull IndexSink sink) {
        final String name = stub.getName();
        if (name != null) {
            final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(name);
            sink.occurrence(RobotVariableNormalizedNameIndex.KEY, normalizedName);
        }
    }
}
