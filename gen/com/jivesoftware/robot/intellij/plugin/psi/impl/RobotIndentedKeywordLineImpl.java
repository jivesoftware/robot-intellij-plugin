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

public class RobotIndentedKeywordLineImpl extends ASTWrapperPsiElement implements RobotIndentedKeywordLine {

  public RobotIndentedKeywordLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitIndentedKeywordLine(this);
    else super.accept(visitor);
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
  public RobotIndentedEllipsesLineTest getIndentedEllipsesLineTest() {
    return findChildByClass(RobotIndentedEllipsesLineTest.class);
  }

  @Override
  @Nullable
  public RobotIndentedKeywordInvocationTest getIndentedKeywordInvocationTest() {
    return findChildByClass(RobotIndentedKeywordInvocationTest.class);
  }

  @Override
  @Nullable
  public RobotIndentedVariableAssignToKeyword getIndentedVariableAssignToKeyword() {
    return findChildByClass(RobotIndentedVariableAssignToKeyword.class);
  }

}
