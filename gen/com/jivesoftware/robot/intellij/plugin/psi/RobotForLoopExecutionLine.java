// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotForLoopExecutionLine extends PsiElement {

  @NotNull
  List<RobotEmptyForLoopLine> getEmptyForLoopLineList();

  @NotNull
  RobotNonEmptyForLoopLine getNonEmptyForLoopLine();

}
