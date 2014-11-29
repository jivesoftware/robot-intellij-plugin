// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotTypes.*;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordArgStub;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import com.jivesoftware.robot.intellij.plugin.elements.RobotImplUtil;
import com.intellij.psi.PsiReference;
import com.intellij.psi.stubs.IStubElementType;

public class RobotKeywordArgImpl extends StubBasedPsiElementBase<RobotKeywordArgStub> implements RobotKeywordArg {

  public RobotKeywordArgImpl(ASTNode node) {
    super(node);
  }

  public RobotKeywordArgImpl(RobotKeywordArgStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitKeywordArg(this);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RobotVariable getVariable() {
    return findChildByClass(RobotVariable.class);
  }

  @Nullable
  public PsiReference getReference() {
    return RobotImplUtil.getReference(this);
  }

  @NotNull
  public PsiReference[] getReferences() {
    return RobotImplUtil.getReferences(this);
  }

  @Nullable
  @NonNls
  public String getName() {
    return RobotImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return RobotImplUtil.setName(this, newName);
  }

  public PsiElement handleElementRename(String name) {
    return RobotImplUtil.handleElementRename(this, name);
  }

  @Nullable
  public PsiElement getNameIdentifier() {
    return RobotImplUtil.getNameIdentifier(this);
  }

}
