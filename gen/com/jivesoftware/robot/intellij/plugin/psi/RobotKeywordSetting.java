// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotKeywordSetting extends PsiElement {

  @Nullable
  RobotArgumentsSetting getArgumentsSetting();

  @Nullable
  RobotDocumentationSetting getDocumentationSetting();

  @Nullable
  RobotTestCaseTeardownSetting getTestCaseTeardownSetting();

  @Nullable
  RobotTestCaseTimeoutSetting getTestCaseTimeoutSetting();

}
