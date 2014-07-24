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

public class RobotSettingsLineImpl extends ASTWrapperPsiElement implements RobotSettingsLine {

  public RobotSettingsLineImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitSettingsLine(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotBadSettingsLine getBadSettingsLine() {
    return findChildByClass(RobotBadSettingsLine.class);
  }

  @Override
  @Nullable
  public RobotEllipsesLineSettings getEllipsesLineSettings() {
    return findChildByClass(RobotEllipsesLineSettings.class);
  }

  @Override
  @Nullable
  public RobotEmptyLine getEmptyLine() {
    return findChildByClass(RobotEmptyLine.class);
  }

  @Override
  @Nullable
  public RobotSetting getSetting() {
    return findChildByClass(RobotSetting.class);
  }

}
