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

public class RobotTestSettingImpl extends ASTWrapperPsiElement implements RobotTestSetting {

  public RobotTestSettingImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitTestSetting(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotDocumentationSetting getDocumentationSetting() {
    return findChildByClass(RobotDocumentationSetting.class);
  }

  @Override
  @Nullable
  public RobotSetupSetting getSetupSetting() {
    return findChildByClass(RobotSetupSetting.class);
  }

  @Override
  @Nullable
  public RobotTagsSetting getTagsSetting() {
    return findChildByClass(RobotTagsSetting.class);
  }

  @Override
  @Nullable
  public RobotTeardownSetting getTeardownSetting() {
    return findChildByClass(RobotTeardownSetting.class);
  }

  @Override
  @Nullable
  public RobotTemplateSetting getTemplateSetting() {
    return findChildByClass(RobotTemplateSetting.class);
  }

  @Override
  @Nullable
  public RobotTimeoutSetting getTimeoutSetting() {
    return findChildByClass(RobotTimeoutSetting.class);
  }

}
