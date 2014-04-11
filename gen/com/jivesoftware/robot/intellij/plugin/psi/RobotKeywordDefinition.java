// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotKeywordDefinition extends PsiElement {

  @NotNull
  RobotKeywordDefinitionHeader getKeywordDefinitionHeader();

  @NotNull
  List<RobotKeywordLine> getKeywordLineList();

  @NotNull
  RobotKeywordSettings getKeywordSettings();

  @Nullable
  RobotReturnLine getReturnLine();

}
