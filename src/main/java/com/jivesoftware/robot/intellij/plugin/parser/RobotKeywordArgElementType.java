package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordArgStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordArgStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordArgNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.RobotKeywordNormalizedNameIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordArg;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotKeywordArgImpl;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotKeywordImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RobotKeywordArgElementType extends IStubElementType<RobotKeywordArgStub, RobotKeywordArg> {

  public RobotKeywordArgElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

    @Override
    public RobotKeywordArg createPsi(@NotNull RobotKeywordArgStub stub) {
        return new RobotKeywordArgImpl(stub, this);
    }

    @Override
    public RobotKeywordArgStub createStub(@NotNull RobotKeywordArg psi, StubElement parentStub) {
        return new RobotKeywordArgStubImpl(parentStub, this, StringRef.fromString(psi.getName()));
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "robot." + super.toString();
    }

    @Override
    public void serialize(@NotNull RobotKeywordArgStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public RobotKeywordArgStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef name = dataStream.readName();
        return new RobotKeywordArgStubImpl(parentStub, this, name);
    }

    @Override
    public void indexStub(@NotNull RobotKeywordArgStub stub, @NotNull IndexSink sink) {
        final String name = stub.getName();
        if (name != null) {
            final String normalizedName = RobotPsiUtil.normalizeRobotDefinedKeywordForIndex(name);
            sink.occurrence(RobotKeywordArgNormalizedNameIndex.KEY, normalizedName);
        }
    }
}
