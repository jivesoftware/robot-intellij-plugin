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
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordReference;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotJavaPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RobotCustomUsagesSearcher extends CustomUsageSearcher {
  @Override
  public void processElementUsages(@NotNull PsiElement element, @NotNull Processor<Usage> processor, @NotNull FindUsagesOptions options) {
    if (!(element instanceof PsiMethod) && (!(element instanceof RobotKeywordTitle))) {
      return;
    }
    if (element instanceof PsiMethod) {
      processJavaUsages((PsiMethod)element, processor);
    } else {
      processKeywordUsages((RobotKeywordTitle)element, processor);
    }
  }

  private void processJavaUsages(PsiMethod method, Processor<Usage> processor) {
    Application app = ApplicationManager.getApplication();
    FindJavaUsagesRunnable findJavaUsagesRunnable = new FindJavaUsagesRunnable(method);
    app.runReadAction(findJavaUsagesRunnable);
    List<Usage> usages = findJavaUsagesRunnable.getUsages();
    new CollectionQuery<Usage>(usages).forEach(processor);
  }

  private void processKeywordUsages(RobotKeywordTitle keywordTitle, Processor<Usage> processor) {
    Application app = ApplicationManager.getApplication();
    FindRobotUsagesRunnable findRobotUsagesRunnable = new FindRobotUsagesRunnable(keywordTitle);
    app.runReadAction(findRobotUsagesRunnable);
    List<Usage> usages = findRobotUsagesRunnable.getUsages();
    new CollectionQuery<Usage>(usages).forEach(processor);
  }

  private static class FindJavaUsagesRunnable implements Runnable {

    private List<Usage> usages;
    private final PsiMethod methodToFindUsages;

    public FindJavaUsagesRunnable(PsiMethod psiMethod) {
      this.methodToFindUsages = psiMethod;
    }

    @Override
    public void run() {
      usages = Lists.newArrayList();
      if (!RobotJavaPsiUtil.isPsiMethodRobotKeyword(methodToFindUsages)) {
        return;
      }
      String name = methodToFindUsages.getName();
      List<RobotKeyword> robotKeywords = RobotPsiUtil.findKeywordUsagesByJavaMethodName(name, methodToFindUsages.getProject());
      for (RobotKeyword keyword: robotKeywords) {
        UsageInfo usageInfo = new UsageInfo(keyword, false);
        usages.add(new UsageInfo2UsageAdapter(usageInfo));
      }
    }

    public List<Usage> getUsages() {
      return usages;
    }
  }

  private static class FindRobotUsagesRunnable implements Runnable {

    private List<Usage> usages;
    private final RobotKeywordTitle keywordToFindUsages;

    public FindRobotUsagesRunnable(RobotKeywordTitle robotKeywordTitle) {
      this.keywordToFindUsages = robotKeywordTitle;
    }

    @Override
    public void run() {
      usages = Lists.newArrayList();
      String name = keywordToFindUsages.getName();
      List<RobotKeyword> robotKeywords = RobotPsiUtil.findKeywordUsagesByName(name, keywordToFindUsages.getProject());
      for (RobotKeyword keyword: robotKeywords) {
        PsiReference ref = new RobotKeywordReference(keyword);
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
