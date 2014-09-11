package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotTestCaseStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotTestCaseStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotTestCaseNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotTestCaseImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RobotTestCaseElementType extends IStubElementType<RobotTestCaseStub, RobotTestCase> {

  public RobotTestCaseElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

    @Override
    public RobotTestCase createPsi(@NotNull RobotTestCaseStub stub) {
        return new RobotTestCaseImpl(stub, this);
    }

    @Override
    public RobotTestCaseStub createStub(@NotNull RobotTestCase psi, StubElement parentStub) {
        return new RobotTestCaseStubImpl(parentStub, this, StringRef.fromString(psi.getName()));
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "robot." + super.toString();
    }

    @Override
    public void serialize(@NotNull RobotTestCaseStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public RobotTestCaseStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef name = dataStream.readName();
        return new RobotTestCaseStubImpl(parentStub, this, name);
    }

    @Override
    public void indexStub(@NotNull RobotTestCaseStub stub, @NotNull IndexSink sink) {
        final String name = stub.getName();
        if (name != null) {
            final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(name);
            sink.occurrence(RobotTestCaseNormalizedNameIndex.KEY, normalizedName);
        }
    }
}
