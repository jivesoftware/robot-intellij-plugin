// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotVariablesLine extends PsiElement {

  @Nullable
  RobotArrayAssignableInVariablesTbl getArrayAssignableInVariablesTbl();

  @Nullable
  RobotArrayAssignmentLhs getArrayAssignmentLhs();

  @Nullable
  RobotAssignableInVariablesTbl getAssignableInVariablesTbl();

  @Nullable
  RobotBadVariablesLine getBadVariablesLine();

  @Nullable
  RobotEllipsesLineSettings getEllipsesLineSettings();

  @Nullable
  RobotEmptyLine getEmptyLine();

  @Nullable
  RobotScalarAssignmentLhs getScalarAssignmentLhs();

}
