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
import com.intellij.navigation.ItemPresentation;

public class RobotKeywordsTableImpl extends ASTWrapperPsiElement implements RobotKeywordsTable {

  public RobotKeywordsTableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitKeywordsTable(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RobotEmptyLine> getEmptyLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotEmptyLine.class);
  }

  @Override
  @NotNull
  public RobotKeywordsTableHeading getKeywordsTableHeading() {
    return findNotNullChildByClass(RobotKeywordsTableHeading.class);
  }

  @Override
  @NotNull
  public List<RobotKeywordDefinition> getKeywordDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotKeywordDefinition.class);
  }

  @Nullable
  public PsiElement getNameIdentifier() {
    return RobotImplUtil.getNameIdentifier(this);
  }

  public ItemPresentation getPresentation() {
    return RobotImplUtil.getPresentation(this);
  }

}
