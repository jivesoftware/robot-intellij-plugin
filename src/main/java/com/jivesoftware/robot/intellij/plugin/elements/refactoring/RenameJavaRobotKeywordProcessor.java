package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.google.common.collect.Lists;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.util.containers.MultiMap;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Created by charles.capps on 6/5/14.
 *
 * Enable renaming Java-defined Robot Keywords, and having this propagate to all usages in Robot files.
 */
public class RenameJavaRobotKeywordProcessor extends RenamePsiElementProcessor {
  @Override
  public boolean canProcessElement(@NotNull PsiElement psiElement) {
    return RobotPsiUtil.isJavaRobotKeyword(psiElement);
  }

  public void prepareRenaming(final PsiElement element, final String newName,
                              final Map<PsiElement, String> allRenames) {
    if (!canProcessElement(element)) {
      return;
    }
    PsiMethod psiMethod = (PsiMethod) element;
    String name = psiMethod.getName();
    List<RobotKeyword> robotKeywords = RobotPsiUtil.findKeywordUsagesByName(name, psiMethod.getProject());
    final String robotName = RobotPsiUtil.methodToRobotKeyword(newName);
    for (RobotKeyword robotKeyword: robotKeywords) {
      allRenames.put(robotKeyword, robotName);
    }
  }

  @Override
  public void findExistingNameConflicts(PsiElement element, String newName, MultiMap<PsiElement, String> conflicts) {
     List<RobotKeywordDef> defs = RobotPsiUtil.findKeywordDefsByName(newName, element.getProject());
     for (RobotKeywordDef def: defs) {
         conflicts.put(def, Lists.newArrayList(newName));
     }
  }
}
