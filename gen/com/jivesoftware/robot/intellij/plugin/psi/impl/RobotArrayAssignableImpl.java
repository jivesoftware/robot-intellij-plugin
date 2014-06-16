// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import com.jivesoftware.robot.intellij.plugin.elements.RobotImplUtil;

public class RobotArrayAssignableImpl extends ASTWrapperPsiElement implements RobotArrayAssignable {

  public RobotArrayAssignableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitArrayAssignable(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RobotContinueNoCol> getContinueNoColList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotContinueNoCol.class);
  }

  @Override
  @NotNull
  public List<RobotKeywordArg> getKeywordArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotKeywordArg.class);
  }

  @Override
  @Nullable
  public RobotKeywordInvocationSettings getKeywordInvocationSettings() {
    return findChildByClass(RobotKeywordInvocationSettings.class);
  }

}
