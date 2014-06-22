package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.StubBasedPsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordDefStub;

public interface IRobotKeywordDef extends PsiNameIdentifierOwner, StubBasedPsiElement<RobotKeywordDefStub> {
}
