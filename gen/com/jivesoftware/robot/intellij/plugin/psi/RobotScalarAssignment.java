// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotNamedElement;
import com.intellij.psi.StubBasedPsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotScalarAssignmentStub;
import com.intellij.psi.PsiReference;

public interface RobotScalarAssignment extends RobotNamedElement, StubBasedPsiElement<RobotScalarAssignmentStub> {

  @Nullable
  PsiReference getReference();

  @NotNull
  PsiReference[] getReferences();

  @Nullable
  @NonNls
  String getName();

  PsiElement setName(String newName);

  @Nullable
  PsiElement getNameIdentifier();

  String toString();

}
