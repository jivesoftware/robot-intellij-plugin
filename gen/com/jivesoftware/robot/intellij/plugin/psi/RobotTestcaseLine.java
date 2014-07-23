// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotTestcaseLine extends PsiElement {

  @Nullable
  RobotBadTestCaseLine getBadTestCaseLine();

  @Nullable
  RobotEllipsesLineTest getEllipsesLineTest();

  @Nullable
  RobotEmptyLine getEmptyLine();

  @Nullable
  RobotEndOfLine getEndOfLine();

  @Nullable
  RobotExecutionLine getExecutionLine();

  @Nullable
  RobotForLoopIn getForLoopIn();

  @Nullable
  RobotForLoopInRange getForLoopInRange();

  @Nullable
  RobotKeywordArgList getKeywordArgList();

  @Nullable
  RobotTestSettingLine getTestSettingLine();

}
