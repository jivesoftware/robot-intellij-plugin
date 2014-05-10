// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotTestCase extends PsiElement {

  @NotNull
  List<RobotTestcaseLine> getTestcaseLineList();

  @NotNull
  RobotTestCaseHeader getTestCaseHeader();

  @NotNull
  RobotTestCaseSettings getTestCaseSettings();

}
