// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotForLoopInRange extends PsiElement {

  @Nullable
  RobotDoubleBoundForLoop getDoubleBoundForLoop();

  @Nullable
  RobotDoubleBoundForLoopWithStep getDoubleBoundForLoopWithStep();

  @NotNull
  List<RobotIndentedKeywordInvocationTest> getIndentedKeywordInvocationTestList();

  @NotNull
  List<RobotIndentedVariableAssignToKeyword> getIndentedVariableAssignToKeywordList();

  @Nullable
  RobotSingleBoundForLoop getSingleBoundForLoop();

}
