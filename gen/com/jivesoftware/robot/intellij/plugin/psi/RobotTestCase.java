// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotNamedElement;
import com.intellij.navigation.ItemPresentation;

public interface RobotTestCase extends RobotNamedElement {

  @NotNull
  List<RobotTestcaseLine> getTestcaseLineList();

  @NotNull
  RobotTestCaseHeader getTestCaseHeader();

  @NotNull
  RobotTestCaseSettings getTestCaseSettings();

  @Nullable
  @NonNls
  String getName();

  PsiElement setName(String newName);

  @Nullable
  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
