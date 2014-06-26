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

public class RobotForLoopInRangeImpl extends ASTWrapperPsiElement implements RobotForLoopInRange {

  public RobotForLoopInRangeImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitForLoopInRange(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotDoubleBoundForLoop getDoubleBoundForLoop() {
    return findChildByClass(RobotDoubleBoundForLoop.class);
  }

  @Override
  @Nullable
  public RobotDoubleBoundForLoopWithStep getDoubleBoundForLoopWithStep() {
    return findChildByClass(RobotDoubleBoundForLoopWithStep.class);
  }

  @Override
  @NotNull
  public RobotEndOfLine getEndOfLine() {
    return findNotNullChildByClass(RobotEndOfLine.class);
  }

  @Override
  @NotNull
  public List<RobotIndentedKeywordLine> getIndentedKeywordLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotIndentedKeywordLine.class);
  }

  @Override
  @Nullable
  public RobotSingleBoundForLoop getSingleBoundForLoop() {
    return findChildByClass(RobotSingleBoundForLoop.class);
  }

}
