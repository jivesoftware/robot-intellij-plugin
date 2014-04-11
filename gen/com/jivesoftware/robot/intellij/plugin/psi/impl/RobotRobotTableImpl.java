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

public class RobotRobotTableImpl extends ASTWrapperPsiElement implements RobotRobotTable {

  public RobotRobotTableImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitRobotTable(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotKeywordsTable getKeywordsTable() {
    return findChildByClass(RobotKeywordsTable.class);
  }

  @Override
  @Nullable
  public RobotSettingsTable getSettingsTable() {
    return findChildByClass(RobotSettingsTable.class);
  }

  @Override
  @Nullable
  public RobotTestCasesTable getTestCasesTable() {
    return findChildByClass(RobotTestCasesTable.class);
  }

  @Override
  @Nullable
  public RobotVariablesTable getVariablesTable() {
    return findChildByClass(RobotVariablesTable.class);
  }

}
