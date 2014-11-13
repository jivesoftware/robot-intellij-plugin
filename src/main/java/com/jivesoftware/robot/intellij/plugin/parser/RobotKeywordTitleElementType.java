package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotVariableUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordTitleStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordTitleStubImpl;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.indexes.*;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotKeywordTitleImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RobotKeywordTitleElementType extends IStubElementType<RobotKeywordTitleStub, RobotKeywordTitle> {

  public RobotKeywordTitleElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

    @Override
    public RobotKeywordTitle createPsi(@NotNull RobotKeywordTitleStub stub) {
        return new RobotKeywordTitleImpl(stub, this);
    }

    @Override
    public RobotKeywordTitleStub createStub(@NotNull RobotKeywordTitle psi, StubElement parentStub) {
        return new RobotKeywordTitleStubImpl(parentStub, this, StringRef.fromString(psi.getName()));
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "robot." + super.toString();
    }

    @Override
    public void serialize(@NotNull RobotKeywordTitleStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public RobotKeywordTitleStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef name = dataStream.readName();
        return new RobotKeywordTitleStubImpl(parentStub, this, name);
    }

    @Override
    public void indexStub(@NotNull RobotKeywordTitleStub stub, @NotNull IndexSink sink) {
        final String name = stub.getName();
        if (name != null) {
            final String normalizedName = RobotPsiUtil.normalizeRobotDefinedKeywordForIndex(name);
            sink.occurrence(RobotKeywordTitleNormalizedNameIndex.KEY, normalizedName);

            if (normalizedName.length() >= 1) {
                String firstCharacter = normalizedName.substring(0, 1);
                sink.occurrence(RobotKeywordDefFirstCharIndex.KEY, firstCharacter);
            }
            if (normalizedName.length() >= 2) {
                String firstTwoCharacters = normalizedName.substring(0, 2);
                sink.occurrence(RobotKeywordTitleFirstTwoCharsIndex.KEY, firstTwoCharacters);
            }
            if (normalizedName.length() >= 3) {
                String firstThreeCharacters = normalizedName.substring(0, 3);
                sink.occurrence(RobotKeywordDefFirstThreeCharsIndex.KEY, firstThreeCharacters);
            }

            if (RobotVariableUtil.VARIABLE_PATTERN.matcher(name).find()) {
                sink.occurrence(RobotKeywordTitleEmbeddedArgsIndex.KEY, normalizedName);
            }
        }
    }
}
