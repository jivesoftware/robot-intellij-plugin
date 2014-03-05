package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.extapi.psi.PsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.util.IncorrectOperationException;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseRobotPsiElement extends PsiElementBase {

  protected ASTNode node;
  protected PsiElement parent;
  protected PsiElement nextSibling;
  protected PsiElement prevSibling;

  public BaseRobotPsiElement(ASTNode node) {
    this.node = node;
  }

  @NotNull
  @Override
  public Language getLanguage() {
    return RobotLanguage.INSTANCE;
  }

  @NotNull
  @Override
  public abstract PsiElement[] getChildren();

  @Override
  public PsiElement getParent() {
    return parent;
  }

  public void setParent(PsiElement parent) {
    this.parent = parent;
  }

  @Override
  public abstract PsiElement getFirstChild();

  @Override
  public abstract PsiElement getLastChild();

  @Override
  public PsiElement getNextSibling() {
   return nextSibling;
  }

  public void setNextSibling(PsiElement nextSibling) {
    this.nextSibling = nextSibling;
  }

  @Override
  public PsiElement getPrevSibling() {
    return prevSibling;
  }

  public void setPrevSibling(PsiElement prevSibling) {
    this.prevSibling = prevSibling;
  }

  @Override
  public TextRange getTextRange() {
    return node.getTextRange();
  }

  @Override
  public int getStartOffsetInParent() {
    return getTextOffset() - parent.getTextLength();
  }

  @Override
  public int getTextLength() {
    return node.getText().length();
  }

  @Nullable
  @Override
  public abstract PsiElement findElementAt(int offset);

  @Nullable
  @Override
  public abstract PsiReference findReferenceAt(int offset);

  @Override
  public int getTextOffset() {
    return node.getStartOffset();
  }

  @Override
  public String getText() {
    return node.getText();
  }

  @NotNull
  @Override
  public char[] textToCharArray() {
    return getText().toCharArray();
  }

  @Override
  public boolean textContains(char c) {
    return getText().contains(String.valueOf(c));
  }

  @Override
  public abstract PsiElement copy();

  @Override
  public abstract PsiElement add(@NotNull PsiElement element) throws IncorrectOperationException;

  @Override
  public abstract PsiElement addBefore(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException;

  @Override
  public abstract PsiElement addAfter(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException;

  @Override
  public abstract void checkAdd(@NotNull PsiElement element) throws IncorrectOperationException;

  @Override
  public abstract PsiElement addRange(PsiElement first, PsiElement last) throws IncorrectOperationException;

  @Override
  public abstract PsiElement addRangeBefore(@NotNull PsiElement first, @NotNull PsiElement last, PsiElement anchor) throws IncorrectOperationException;

  @Override
  public abstract PsiElement addRangeAfter(PsiElement first, PsiElement last, PsiElement anchor) throws IncorrectOperationException;

  @Override
  public abstract void delete() throws IncorrectOperationException;

  @Override
  public abstract void checkDelete() throws IncorrectOperationException;

  @Override
  public abstract void deleteChildRange(PsiElement first, PsiElement last) throws IncorrectOperationException;

  @Override
  public abstract PsiElement replace(@NotNull PsiElement newElement) throws IncorrectOperationException;

  @Nullable
  @Override
  public abstract PsiReference getReference();

  @NotNull
  @Override
  public abstract PsiReference[] getReferences();

  @Override
  public ASTNode getNode() {
    return node;
  }


}
