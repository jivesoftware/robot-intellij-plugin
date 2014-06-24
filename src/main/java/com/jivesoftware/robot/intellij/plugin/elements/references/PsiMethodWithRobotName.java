package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.lang.ASTNode;
import com.intellij.psi.impl.java.stubs.PsiMethodStub;
import com.intellij.psi.impl.source.PsiMethodImpl;
import com.intellij.psi.stubs.IStubElementType;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;

public class PsiMethodWithRobotName extends PsiMethodImpl {

  public PsiMethodWithRobotName(PsiMethodStub stub) {
    super(stub);
  }

  protected PsiMethodWithRobotName(PsiMethodStub stub, IStubElementType type) {
    super(stub, type);
  }

  public PsiMethodWithRobotName(ASTNode node) {
    super(node);
  }

  @Override
  public String getName() {
    return RobotPsiUtil.methodToRobotKeyword(super.getName());
  }
}
