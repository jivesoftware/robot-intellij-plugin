package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class JavaRobotFindUsagesHandler extends FindUsagesHandler {

  protected JavaRobotFindUsagesHandler(@NotNull PsiElement psiElement) {
    super(psiElement);
  }

  //Highlighting is not working currently, not sure why. A weird selection of text is highlighted. Want to add this back when I figure it out.
/*  @Override
  public Collection<PsiReference> findReferencesToHighlight(@NotNull PsiElement target, @NotNull SearchScope searchScope) {
    Collection<PsiReference> defaultUsages = super.findReferencesToHighlight(target, searchScope);
    if (target instanceof PsiMethod) {
      PsiMethod method = (PsiMethod) target;
      String name = method.getName();
      List<RobotKeywordEl> robotKeywordEls = RobotPsiUtil.findKeywordUsagesByName(name, method.getProject());
      for (RobotKeywordEl keyword: robotKeywordEls) {
        defaultUsages.add(new RobotKeywordRef(keyword));
      }
    }
    return defaultUsages;
  }*/

}
