package com.jivesoftware.robot.intellij.plugin.elements.stubindex;

import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.ArrayFactory;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class RobotKeywordDefStubImpl implements RobotKeywordDefStub {
    @Override
    public IStubElementType getStubType() {
        return null;
    }

    @Override
    public StubElement getParentStub() {
        return null;
    }

    @Override
    public List<StubElement> getChildrenStubs() {
        return null;
    }

    @Nullable
    @Override
    public <P extends PsiElement> StubElement<P> findChildStubByType(IStubElementType<?, P> elementType) {
        return null;
    }

    @Override
    public RobotKeywordDef getPsi() {
        return null;
    }

    @Override
    public <E extends PsiElement> E[] getChildrenByType(IElementType elementType, E[] array) {
        return null;
    }

    @Override
    public <E extends PsiElement> E[] getChildrenByType(TokenSet filter, E[] array) {
        return null;
    }

    @Override
    public <E extends PsiElement> E[] getChildrenByType(IElementType elementType, ArrayFactory<E> f) {
        return null;
    }

    @Override
    public <E extends PsiElement> E[] getChildrenByType(TokenSet filter, ArrayFactory<E> f) {
        return null;
    }

    @Nullable
    @Override
    public <E extends PsiElement> E getParentStubOfType(Class<E> parentClass) {
        return null;
    }
}
