package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotKeywordImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RobotKeywordElementType extends IStubElementType<RobotKeywordStub, RobotKeyword> {

  public RobotKeywordElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

    @Override
    public RobotKeyword createPsi(@NotNull RobotKeywordStub stub) {
        return new RobotKeywordImpl(stub, this);
    }

    @Override
    public RobotKeywordStub createStub(@NotNull RobotKeyword psi, StubElement parentStub) {
        return new RobotKeywordStubImpl(parentStub, this, StringRef.fromString(psi.getName()));
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "robot." + super.toString();
    }

    @Override
    public void serialize(@NotNull RobotKeywordStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public RobotKeywordStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef name = dataStream.readName();
        return new RobotKeywordStubImpl(parentStub, this, name);
    }

    @Override
    public void indexStub(@NotNull RobotKeywordStub stub, @NotNull IndexSink sink) {
        final String name = stub.getName();
        if (name != null) {
            final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(name);
            sink.occurrence(RobotKeywordNormalizedNameIndex.KEY, normalizedName);
        }
    }
}
