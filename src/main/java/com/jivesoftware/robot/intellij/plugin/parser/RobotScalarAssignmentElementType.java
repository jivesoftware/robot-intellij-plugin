package com.jivesoftware.robot.intellij.plugin.parser;

import com.google.common.base.Optional;
import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariablePsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotScalarAssignmentStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotScalarAssignmentStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotAssignmentNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarAssignment;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotScalarAssignmentImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RobotScalarAssignmentElementType extends IStubElementType<RobotScalarAssignmentStub, RobotScalarAssignment> {

  public RobotScalarAssignmentElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

    @Override
    public RobotScalarAssignment createPsi(@NotNull RobotScalarAssignmentStub stub) {
        return new RobotScalarAssignmentImpl(stub, this);
    }

    @Override
    public RobotScalarAssignmentStub createStub(@NotNull RobotScalarAssignment psi, StubElement parentStub) {
        return new RobotScalarAssignmentStubImpl(parentStub, this, StringRef.fromString(psi.getName()));
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "robot." + super.toString();
    }

    @Override
    public void serialize(@NotNull RobotScalarAssignmentStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public RobotScalarAssignmentStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef name = dataStream.readName();
        return new RobotScalarAssignmentStubImpl(parentStub, this, name);
    }

    @Override
    public void indexStub(@NotNull RobotScalarAssignmentStub stub, @NotNull IndexSink sink) {
        final String name = stub.getName();
        if (name != null) {
            Optional<String> optVariableName = VariablePsiUtil.getVariableName(name);
            if (!optVariableName.isPresent()) {
                return;
            }
            final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(optVariableName.get());
            sink.occurrence(RobotAssignmentNormalizedNameIndex.KEY, normalizedName);
        }
    }
}
