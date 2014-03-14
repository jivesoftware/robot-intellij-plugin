package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.usageView.UsageInfo;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;

public class JavaRobotFindUsagesHandler extends FindUsagesHandler {

  protected JavaRobotFindUsagesHandler(@NotNull PsiElement psiElement) {
    super(psiElement);
  }

  @Override
  public boolean processElementUsages(@NotNull final PsiElement element,
                                      @NotNull final Processor<UsageInfo> processor,
                                      @NotNull final FindUsagesOptions options) {
    options.searchScope = GlobalSearchScope.projectScope(element.getProject());
    return super.processElementUsages(element, processor, options);
  }


}
