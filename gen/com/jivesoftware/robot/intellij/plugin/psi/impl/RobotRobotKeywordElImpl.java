// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotTypes.*;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotNamedElementImpl;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import com.jivesoftware.robot.intellij.plugin.elements.RobotImplUtil;
import com.intellij.psi.PsiReference;

public class RobotRobotKeywordElImpl extends RobotNamedElementImpl implements RobotRobotKeywordEl {

  public RobotRobotKeywordElImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitRobotKeywordEl(this);
    else super.accept(visitor);
  }

  public String getName() {
    return RobotImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return RobotImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return RobotImplUtil.getNameIdentifier(this);
  }

  public PsiReference getReference() {
    return RobotImplUtil.getReference(this);
  }

  public PsiReference[] getReferences() {
    return RobotImplUtil.getReferences(this);
  }

}
