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
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotTestCaseStub;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import com.jivesoftware.robot.intellij.plugin.elements.RobotImplUtil;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.stubs.IStubElementType;

public class RobotTestCaseImpl extends StubBasedPsiElementBase<RobotTestCaseStub> implements RobotTestCase {

  public RobotTestCaseImpl(ASTNode node) {
    super(node);
  }

  public RobotTestCaseImpl(RobotTestCaseStub stub, IStubElementType nodeType) {
    super(stub, nodeType);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RobotVisitor) ((RobotVisitor)visitor).visitTestCase(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RobotEmptyLine> getEmptyLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotEmptyLine.class);
  }

  @Override
  @NotNull
  public List<RobotTestcaseLine> getTestcaseLineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RobotTestcaseLine.class);
  }

  @Override
  @NotNull
  public RobotTestCaseHeader getTestCaseHeader() {
    return findNotNullChildByClass(RobotTestCaseHeader.class);
  }

  @Nullable
  @NonNls
  public String getName() {
    return RobotImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return RobotImplUtil.setName(this, newName);
  }

  @Nullable
  public PsiElement getNameIdentifier() {
    return RobotImplUtil.getNameIdentifier(this);
  }

  public ItemPresentation getPresentation() {
    return RobotImplUtil.getPresentation(this);
  }

}
