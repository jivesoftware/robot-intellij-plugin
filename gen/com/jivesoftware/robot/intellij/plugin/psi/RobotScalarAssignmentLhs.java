// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotNamedElement;
import com.intellij.psi.PsiReference;

public interface RobotScalarAssignmentLhs extends RobotNamedElement {

  @Nullable
  RobotScalarAssignment getScalarAssignment();

  @Nullable
  RobotScalarVariable getScalarVariable();

  @Nullable
  @NonNls
  String getName();

  PsiElement setName(String newName);

  @Nullable
  PsiReference getReference();

  @NotNull
  PsiReference[] getReferences();

  @Nullable
  PsiElement getNameIdentifier();

  PsiElement handleElementRename(String name);

  String toString();

}
