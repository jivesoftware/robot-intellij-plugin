package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IStubElementType;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordDefStub;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/21/14.
 */
public abstract class RobotKeywordDefBase extends StubBasedPsiElementBase<RobotKeywordDefStub> {
    public RobotKeywordDefBase(@NotNull RobotKeywordDefStub stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public RobotKeywordDefBase(@NotNull ASTNode node) {
        super(node);
    }
}
