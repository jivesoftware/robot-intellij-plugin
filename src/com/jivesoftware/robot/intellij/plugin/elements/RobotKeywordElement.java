package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotKeywordElement extends RobotElementLeaf {

  public RobotKeywordElement(ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public PsiElement findElementAt(int offset) {
    return this;
  }

  @Override
  public PsiElement copy() {
    return new RobotKeywordElement(node);
  }

  @Nullable
  @Override
  public PsiReference getReference() {
    return new RobotKeywordRef(this);
  }

  @NotNull
  @Override
  public PsiReference[] getReferences() {
    PsiReference[] refs = new PsiReference[1];
    refs[0] = new RobotKeywordRef(this);
    return refs;
  }
}
