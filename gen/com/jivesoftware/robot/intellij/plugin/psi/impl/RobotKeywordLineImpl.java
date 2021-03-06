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

public class RobotKeywordLineImpl extends ASTWrapperPsiElement implements RobotKeywordLine {

  public RobotKeywordLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitKeywordLine(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotEllipsesLineTest getEllipsesLineTest() {
    return findChildByClass(RobotEllipsesLineTest.class);
  }

  @Override
  @Nullable
  public RobotExecutionLine getExecutionLine() {
    return findChildByClass(RobotExecutionLine.class);
  }

  @Override
  @Nullable
  public RobotForLoopIn getForLoopIn() {
    return findChildByClass(RobotForLoopIn.class);
  }

  @Override
  @Nullable
  public RobotForLoopInRange getForLoopInRange() {
    return findChildByClass(RobotForLoopInRange.class);
  }

  @Override
  @Nullable
  public RobotKeywordSettingLine getKeywordSettingLine() {
    return findChildByClass(RobotKeywordSettingLine.class);
  }

  @Override
  @Nullable
  public RobotReturnLine getReturnLine() {
    return findChildByClass(RobotReturnLine.class);
  }

}
