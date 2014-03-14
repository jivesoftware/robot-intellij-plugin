package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifierList;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefEl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotFindUsagesHandlerFactory extends FindUsagesHandlerFactory {
  @Override
  public boolean canFindUsages(@NotNull PsiElement element) {
    if (element instanceof RobotKeywordDefEl) {
      return true;
    }
    if (!(element instanceof PsiMethod)) {
      return false;
    }
    PsiModifierList psiModifierList = ((PsiMethod) element).getModifierList();
    return psiModifierList.findAnnotation(RobotKeywordDefinitionFinder.ROBOT_KEYWORD_ANNOTATION) != null;
  }

  @Nullable
  @Override
  public FindUsagesHandler createFindUsagesHandler(@NotNull PsiElement element, boolean forHighlightUsages) {
    if (element instanceof PsiMethod) {
      return new JavaRobotFindUsagesHandler(element);
    } else if (element instanceof RobotKeywordDefEl) {
      return new RobotFindUsagesHandler(element);
    }
    return null;
  }
}
