// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotTestCasesTable extends PsiElement {

  @NotNull
  List<RobotEmptyLine> getEmptyLineList();

  @NotNull
  List<RobotTestCase> getTestCaseList();

  @NotNull
  RobotTestCasesTableHeading getTestCasesTableHeading();

}