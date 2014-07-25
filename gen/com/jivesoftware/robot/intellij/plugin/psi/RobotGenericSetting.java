// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotGenericSetting extends PsiElement {

  @NotNull
  List<RobotEllipses> getEllipsesList();

  @NotNull
  List<RobotEmptyLine> getEmptyLineList();

  @NotNull
  RobotKeyword getKeyword();

  @NotNull
  List<RobotSettingList> getSettingListList();

}
