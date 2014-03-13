package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class RobotNamedElementImpl extends ASTWrapperPsiElement implements RobotNamedElement {
  public RobotNamedElementImpl(@NotNull ASTNode node) {
    super(node);
  }
}
