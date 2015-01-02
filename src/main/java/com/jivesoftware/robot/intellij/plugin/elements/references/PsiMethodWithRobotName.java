package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.impl.java.stubs.PsiMethodStub;
import com.intellij.psi.impl.source.PsiMethodImpl;
import com.intellij.psi.stubs.IStubElementType;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import org.jetbrains.annotations.NotNull;

public class PsiMethodWithRobotName extends PsiMethodImpl {

    private PsiMethod delegate;

    public PsiMethodWithRobotName(PsiMethodStub stub) {
        super(stub);
    }

    public PsiMethodWithRobotName(PsiMethodStub stub, PsiMethod delegate) {
        super(stub);
        this.delegate = delegate;
    }

    protected PsiMethodWithRobotName(PsiMethodStub stub, IStubElementType type) {
        super(stub, type);
    }

    public PsiMethodWithRobotName(ASTNode node) {
        super(node);
    }

    public PsiMethodWithRobotName(ASTNode node, PsiMethod delegate) {
        super(node);
        this.delegate = delegate;
    }

    @NotNull
    public PsiMethod unwrap() {
        return delegate == null ? this : delegate;
    }

    @NotNull
    @Override
    public String getName() {
        return RobotPsiUtil.methodToRobotKeyword(super.getName());
    }
}
