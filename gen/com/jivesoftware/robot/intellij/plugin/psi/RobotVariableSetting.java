// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotVariableSetting extends PsiElement {

  @NotNull
  List<RobotEllipses> getEllipsesList();

  @NotNull
  List<RobotEmptyLine> getEmptyLineList();

  @Nullable
  RobotResourceFile getResourceFile();

}
