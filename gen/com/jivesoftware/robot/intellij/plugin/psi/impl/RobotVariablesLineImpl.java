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

public class RobotVariablesLineImpl extends ASTWrapperPsiElement implements RobotVariablesLine {

  public RobotVariablesLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitVariablesLine(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotArrayAssignable getArrayAssignable() {
    return findChildByClass(RobotArrayAssignable.class);
  }

  @Override
  @Nullable
  public RobotAssignable getAssignable() {
    return findChildByClass(RobotAssignable.class);
  }

  @Override
  @Nullable
  public RobotEmptyLine getEmptyLine() {
    return findChildByClass(RobotEmptyLine.class);
  }

}
