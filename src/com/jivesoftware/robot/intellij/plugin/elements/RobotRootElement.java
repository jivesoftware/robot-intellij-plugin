package com.jivesoftware.robot.intellij.plugin.elements;

import com.google.common.collect.Lists;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.IncorrectOperationException;
import com.jivesoftware.robot.intellij.plugin.parser.RobotElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RobotRootElement extends BaseRobotPsiElement {

  public RobotRootElement(ASTNode node) {
    super(node);
    this.robotKeywords = Lists.newArrayList();
    for (ASTNode child: node.getChildren(TokenSet.create(RobotElementType.ROBOT_KEYWORD_EL))) {
      RobotKeywordElement keyword = PsiElementFactory.create(child);
      add(keyword);
    }
  }

  private List<RobotKeywordElement> robotKeywords;

  @NotNull
  @Override
  public PsiElement[] getChildren() {
    return robotKeywords.toArray(new RobotKeywordElement[0]);
  }

  @Override
  public PsiElement getFirstChild() {
    if (robotKeywords.size() <= 0) {
      return null;
    }
    return robotKeywords.get(0);
  }

  @Override
  public PsiElement getLastChild() {
    if (robotKeywords.size() <= 0) {
      return null;
    }
    return robotKeywords.get(robotKeywords.size() - 1);
  }

  @Nullable
  @Override
  public PsiElement findElementAt(int offset) {
    for (RobotKeywordElement keyword: robotKeywords) {
      if (keyword.getTextRange().contains(offset)) {
        return keyword;
      }
    }
    return null;
  }

  @Nullable
  @Override
  public PsiReference findReferenceAt(int offset) {
    for (RobotKeywordElement keyword: robotKeywords) {
      if (keyword.getTextRange().contains(offset)) {
        return keyword.getReference();
      }
    }
    return null;
  }

  @Override
  public PsiElement copy() {
    return new RobotRootElement(node);
  }

  @Override
  public PsiElement add(@NotNull PsiElement element) throws IncorrectOperationException {
    if (!(element instanceof RobotKeywordElement)) {
      throw new IncorrectOperationException("Can only add Robot Keywords to a RobotRootElement! Type was: " + element.getClass().getSimpleName());
    }
    RobotKeywordElement keyword = (RobotKeywordElement) element;
    keyword.setParent(this);
    robotKeywords.add(keyword);
    if (robotKeywords.size() > 1) {
      RobotKeywordElement prev = robotKeywords.get(robotKeywords.size() - 2);
      keyword.setPrevSibling(prev);
      prev.setNextSibling(keyword);
    }
    return keyword;
  }

  @Override
  public PsiElement addBefore(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
    if (!(element instanceof RobotKeywordElement)) {
      throw new IncorrectOperationException("Can only add Robot Keywords to Robot Root Element. Type was: " + element.getClass().getSimpleName());
    }
    RobotKeywordElement keyword = (RobotKeywordElement) element;
    for (int i = 0; i < robotKeywords.size(); i++) {
      if (robotKeywords.get(i) == anchor) {
        robotKeywords.add(i, keyword);
        return keyword;
      }
    }
    return null;
  }

  @Override
  public PsiElement addAfter(@NotNull PsiElement element, @Nullable PsiElement anchor) throws IncorrectOperationException {
    if (!(element instanceof RobotKeywordElement)) {
      throw new IncorrectOperationException("Can only add Robot Keywords to Robot Root Element. Type was: " + element.getClass().getSimpleName());
    }
    RobotKeywordElement keyword = (RobotKeywordElement) element;
    for (int i = 0; i < robotKeywords.size(); i++) {
      if (robotKeywords.get(i) == anchor) {
        robotKeywords.add(i + 1, keyword);
        return keyword;
      }
    }
    return null;
  }

  @Override
  public void checkAdd(@NotNull PsiElement element) throws IncorrectOperationException {

  }

  @Override
  public PsiElement addRange(PsiElement first, PsiElement last) throws IncorrectOperationException {
    return null;
  }

  @Override
  public PsiElement addRangeBefore(@NotNull PsiElement first, @NotNull PsiElement last, PsiElement anchor) throws IncorrectOperationException {
    return null;
  }

  @Override
  public PsiElement addRangeAfter(PsiElement first, PsiElement last, PsiElement anchor) throws IncorrectOperationException {
    return null;
  }

  @Override
  public void delete() throws IncorrectOperationException {

  }

  @Override
  public void checkDelete() throws IncorrectOperationException {

  }

  @Override
  public void deleteChildRange(PsiElement first, PsiElement last) throws IncorrectOperationException {

  }

  @Override
  public PsiElement replace(@NotNull PsiElement newElement) throws IncorrectOperationException {
    return null;
  }

  @Override
  public boolean isValid() {
    return false;
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

  //Private
  //Set siblings
  private void setSiblingsAndParent() {
    for (int i = 0; i < robotKeywords.size(); i++) {
      robotKeywords.get(i).setParent(this);
      if (i > 0) {
        robotKeywords.get(i).setPrevSibling(robotKeywords.get(i - 1));
      }
      if (i < robotKeywords.size() - 1) {
        robotKeywords.get(i).setNextSibling(robotKeywords.get(i + 1));
      }
    }
  }
}
