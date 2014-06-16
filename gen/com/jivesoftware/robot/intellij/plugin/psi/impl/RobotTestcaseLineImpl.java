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

public class RobotTestcaseLineImpl extends ASTWrapperPsiElement implements RobotTestcaseLine {

  public RobotTestcaseLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitTestcaseLine(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotArgumentList getArgumentList() {
    return findChildByClass(RobotArgumentList.class);
  }

  @Override
  @Nullable
  public RobotEllipsesLineTest getEllipsesLineTest() {
    return findChildByClass(RobotEllipsesLineTest.class);
  }

  @Override
  @Nullable
  public RobotEmptyLine getEmptyLine() {
    return findChildByClass(RobotEmptyLine.class);
  }

  @Override
  @Nullable
  public RobotEndOfLine getEndOfLine() {
    return findChildByClass(RobotEndOfLine.class);
  }

  @Override
  @Nullable
  public RobotKeywordInvocationTest getKeywordInvocationTest() {
    return findChildByClass(RobotKeywordInvocationTest.class);
  }

  @Override
  @Nullable
  public RobotVariableAssignToKeyword getVariableAssignToKeyword() {
    return findChildByClass(RobotVariableAssignToKeyword.class);
  }

}
