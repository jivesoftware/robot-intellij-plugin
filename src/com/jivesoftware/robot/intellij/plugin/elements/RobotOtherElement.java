package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotOtherElement extends RobotElementLeaf {

  public RobotOtherElement(ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public PsiElement findElementAt(int offset) {
    return this;
  }

  @Override
  public PsiElement copy() {
    return new RobotOtherElement(node);
  }

  @Nullable
  @Override
  public PsiReference getReference() {
    return null;
  }

  @NotNull
  @Override
  public PsiReference[] getReferences() {
    return new PsiReference[0];
  }
}
