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

public class RobotSettingImpl extends ASTWrapperPsiElement implements RobotSetting {

  public RobotSettingImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitSetting(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotDocumentationSetting getDocumentationSetting() {
    return findChildByClass(RobotDocumentationSetting.class);
  }

  @Override
  @Nullable
  public RobotForceTagsSetting getForceTagsSetting() {
    return findChildByClass(RobotForceTagsSetting.class);
  }

  @Override
  @Nullable
  public RobotGenericSetting getGenericSetting() {
    return findChildByClass(RobotGenericSetting.class);
  }

  @Override
  @Nullable
  public RobotLibrarySetting getLibrarySetting() {
    return findChildByClass(RobotLibrarySetting.class);
  }

  @Override
  @Nullable
  public RobotMetadataSetting getMetadataSetting() {
    return findChildByClass(RobotMetadataSetting.class);
  }

  @Override
  @Nullable
  public RobotResourceSetting getResourceSetting() {
    return findChildByClass(RobotResourceSetting.class);
  }

  @Override
  @Nullable
  public RobotTestSetupSetting getTestSetupSetting() {
    return findChildByClass(RobotTestSetupSetting.class);
  }

  @Override
  @Nullable
  public RobotTestTemplateSetting getTestTemplateSetting() {
    return findChildByClass(RobotTestTemplateSetting.class);
  }

  @Override
  @Nullable
  public RobotTestTimeoutSetting getTestTimeoutSetting() {
    return findChildByClass(RobotTestTimeoutSetting.class);
  }

  @Override
  @Nullable
  public RobotVariableSetting getVariableSetting() {
    return findChildByClass(RobotVariableSetting.class);
  }

}
