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

public class RobotArrayAssignableInVariablesTblImpl extends ASTWrapperPsiElement implements RobotArrayAssignableInVariablesTbl {

  public RobotArrayAssignableInVariablesTblImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitArrayAssignableInVariablesTbl(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RobotEllipses> getEllipsesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotEllipses.class);
  }

  @Override
  @NotNull
  public List<RobotEmptyLine> getEmptyLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotEmptyLine.class);
  }

  @Override
  @NotNull
  public List<RobotKeywordArgList> getKeywordArgListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotKeywordArgList.class);
  }

}
