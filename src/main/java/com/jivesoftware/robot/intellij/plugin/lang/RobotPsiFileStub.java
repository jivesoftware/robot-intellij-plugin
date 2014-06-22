package com.jivesoftware.robot.intellij.plugin.lang;

import com.intellij.psi.stubs.PsiFileStub;
import com.intellij.psi.stubs.PsiFileStubImpl;

/**
 * Created by charles on 6/21/14.
 */
public class RobotPsiFileStub extends PsiFileStubImpl<RobotPsiFile> {
    public RobotPsiFileStub(RobotPsiFile file) {
        super(file);
    }
}
