// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RobotKeywordsTable extends PsiElement {

  @NotNull
  List<RobotEmptyLine> getEmptyLineList();

  @NotNull
  RobotKeywordsTableHeading getKeywordsTableHeading();

  @NotNull
  List<RobotKeywordDefinition> getKeywordDefinitionList();

}
