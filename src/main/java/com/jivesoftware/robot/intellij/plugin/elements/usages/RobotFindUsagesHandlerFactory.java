package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotFindUsagesHandlerFactory extends FindUsagesHandlerFactory {
  @Override
  public boolean canFindUsages(@NotNull PsiElement element) {
    if (element instanceof RobotKeywordDef) {
      return true;
    }
    return RobotPsiUtil.isJavaRobotKeyword(element);
  }

  @Nullable
  @Override
  public FindUsagesHandler createFindUsagesHandler(@NotNull PsiElement element, boolean forHighlightUsages) {
    if (element instanceof PsiMethod) {
      return new JavaRobotFindUsagesHandler(element);
    } else if (element instanceof RobotKeywordDef) {
      return new RobotFindUsagesHandler(element);
    }
    return null;
  }

}
