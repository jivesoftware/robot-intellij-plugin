package com.jivesoftware.robot.intellij.plugin.elements.stubindex;

import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.ArrayFactory;
import com.intellij.util.io.StringRef;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class RobotKeywordDefStubImpl extends StubBase<RobotKeywordDef> implements RobotKeywordDefStub {
    private StringRef name;

    public RobotKeywordDefStubImpl(final StubElement parent, final IStubElementType elementType, StringRef name) {
        super(parent, elementType);
        this.name = name;
    }

    @Nullable
    @Override
    public String getName() {
        return name.getString();
    }
}
