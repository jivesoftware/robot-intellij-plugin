// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotTestSetting extends PsiElement {

  @Nullable
  RobotDocumentationSetting getDocumentationSetting();

  @Nullable
  RobotTagsSetting getTagsSetting();

  @Nullable
  RobotTestCaseSetupSetting getTestCaseSetupSetting();

  @Nullable
  RobotTestCaseTeardownSetting getTestCaseTeardownSetting();

  @Nullable
  RobotTestCaseTemplateSetting getTestCaseTemplateSetting();

  @Nullable
  RobotTestCaseTimeoutSetting getTestCaseTimeoutSetting();

}
