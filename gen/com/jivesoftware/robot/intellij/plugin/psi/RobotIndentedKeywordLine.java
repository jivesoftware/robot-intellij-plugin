// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotIndentedKeywordLine extends PsiElement {

  @Nullable
  RobotEmptyLine getEmptyLine();

  @Nullable
  RobotEndOfLine getEndOfLine();

  @Nullable
  RobotIndentedEllipsesLineTest getIndentedEllipsesLineTest();

  @Nullable
  RobotIndentedKeywordInvocationTest getIndentedKeywordInvocationTest();

  @Nullable
  RobotIndentedVariableAssignToKeyword getIndentedVariableAssignToKeyword();

}
