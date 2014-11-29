// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotKeywordSetting extends PsiElement {

  @Nullable
  RobotArgumentsSetting getArgumentsSetting();

  @Nullable
  RobotDocumentationMeta getDocumentationMeta();

  @Nullable
  RobotTestCaseTeardownMeta getTestCaseTeardownMeta();

  @Nullable
  RobotTestCaseTimeoutMeta getTestCaseTimeoutMeta();

}
