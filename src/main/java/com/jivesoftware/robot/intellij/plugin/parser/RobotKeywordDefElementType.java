package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordDefStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordDefStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordDefNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotKeywordDefImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RobotKeywordDefElementType extends IStubElementType<RobotKeywordDefStub, RobotKeywordDef> {

  public RobotKeywordDefElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

    @Override
    public RobotKeywordDef createPsi(@NotNull RobotKeywordDefStub stub) {
        return new RobotKeywordDefImpl(stub, this);
    }

    @Override
    public RobotKeywordDefStub createStub(@NotNull RobotKeywordDef psi, StubElement parentStub) {
        return new RobotKeywordDefStubImpl(parentStub, this, StringRef.fromString(psi.getName()));
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "robot." + super.toString();
    }

    @Override
    public void serialize(@NotNull RobotKeywordDefStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public RobotKeywordDefStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef name = dataStream.readName();
        return new RobotKeywordDefStubImpl(parentStub, this, name);
    }

    @Override
    public void indexStub(@NotNull RobotKeywordDefStub stub, @NotNull IndexSink sink) {
        String name = stub.getName();
        if (name != null) {
            String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(name);
            sink.occurrence(RobotKeywordDefNormalizedNameIndex.KEY, normalizedName);
        }
    }
}
