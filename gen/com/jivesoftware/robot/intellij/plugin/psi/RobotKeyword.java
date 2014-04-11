// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotNamedElement;
import com.intellij.psi.PsiReference;

public interface RobotKeyword extends RobotNamedElement {

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  PsiReference getReference();

  PsiReference[] getReferences();

}
