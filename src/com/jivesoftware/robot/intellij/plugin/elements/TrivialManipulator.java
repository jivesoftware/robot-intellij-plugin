package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.intellij.psi.impl.PsiElementBase;
import com.intellij.util.IncorrectOperationException;

public class TrivialManipulator extends AbstractElementManipulator<PsiElementBase> {
  @Override
  public PsiElementBase handleContentChange(PsiElementBase element, TextRange range, String newContent) throws IncorrectOperationException {
    return element;
  }
}
