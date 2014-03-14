package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class RobotFindUsagesHandler extends FindUsagesHandler {

  protected RobotFindUsagesHandler(@NotNull PsiElement psiElement) {
    super(psiElement);
  }
}
