package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.google.common.collect.Lists;
import com.intellij.find.findUsages.CustomUsageSearcher;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiReference;
import com.intellij.usageView.UsageInfo;
import com.intellij.usages.Usage;
import com.intellij.usages.UsageInfo2UsageAdapter;
import com.intellij.util.CollectionQuery;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordRef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RobotCustomUsagesSearcher extends CustomUsageSearcher {
  @Override
  public void processElementUsages(@NotNull PsiElement element, @NotNull Processor<Usage> processor, @NotNull FindUsagesOptions options) {
    if (!(element instanceof PsiMethod)) {
      return;
    }
    PsiMethod method = (PsiMethod) element;
    Application app = ApplicationManager.getApplication();
    FindUsagesRunnable findUsagesRunnable = new FindUsagesRunnable(method);
    app.runReadAction(findUsagesRunnable);
    List<Usage> usages = findUsagesRunnable.getUsages();
    new CollectionQuery<Usage>(usages).forEach(processor);
  }

  private static class FindUsagesRunnable implements Runnable {

    private List<Usage> usages;
    private final PsiMethod methodToFindUsages;

    public FindUsagesRunnable(PsiMethod psiMethod) {
      this.methodToFindUsages = psiMethod;
    }


    @Override
    public void run() {
      usages = Lists.newArrayList();
      if (!RobotPsiUtil.isJavaRobotKeyword(methodToFindUsages)) {
        return;
      }
      String name = methodToFindUsages.getName();
      List<RobotKeyword> robotKeywords = RobotPsiUtil.findKeywordUsagesByName(name, methodToFindUsages.getProject());
      for (RobotKeyword keyword: robotKeywords) {
        PsiReference ref = new RobotKeywordRef(keyword);
        TextRange rangeInElement = ref.getRangeInElement();
        UsageInfo usageInfo = new UsageInfo(keyword, rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
        usages.add(new UsageInfo2UsageAdapter(usageInfo));
      }
    }

    public List<Usage> getUsages() {
      return usages;
    }
  }
}
