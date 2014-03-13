// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotNamedElement;

public class RobotVisitor extends PsiElementVisitor {

  public void visitRobotKeywordEl(@NotNull RobotRobotKeywordEl o) {
    visitNamedElement(o);
  }

  public void visitRobotOtherEl(@NotNull RobotRobotOtherEl o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull RobotNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
