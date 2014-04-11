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

public class RobotKeywordDefinitionImpl extends ASTWrapperPsiElement implements RobotKeywordDefinition {

  public RobotKeywordDefinitionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitKeywordDefinition(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RobotKeywordDefinitionHeader getKeywordDefinitionHeader() {
    return findNotNullChildByClass(RobotKeywordDefinitionHeader.class);
  }

  @Override
  @NotNull
  public List<RobotKeywordLine> getKeywordLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotKeywordLine.class);
  }

  @Override
  @NotNull
  public RobotKeywordSettings getKeywordSettings() {
    return findNotNullChildByClass(RobotKeywordSettings.class);
  }

  @Override
  @Nullable
  public RobotReturnLine getReturnLine() {
    return findChildByClass(RobotReturnLine.class);
  }

}
