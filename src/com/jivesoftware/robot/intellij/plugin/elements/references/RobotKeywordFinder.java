package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.jivesoftware.robot.intellij.plugin.elements.GeneralUtil;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotRobotKeywordEl;

import java.util.List;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotKeywordFinder implements ContentIterator {

  private final Project project;
  private final String searchTerm;
  private final List<RobotRobotKeywordEl> results;

  public RobotKeywordFinder(Project project, String searchTerm) {
    this.project = project;
    this.searchTerm = searchTerm;
    results = Lists.newArrayList();
  }

  @Override
  public boolean processFile(VirtualFile virtualFile) {
    PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
    if (psiFile instanceof RobotPsiFile) {
      RobotPsiFile robotPsiFile = (RobotPsiFile) psiFile;
      for (PsiElement el: robotPsiFile.findChildrenByClass(RobotRobotKeywordEl.class)) {
        String methodName = GeneralUtil.robotKeywordToMethod(el.getText());
        if (methodName.equalsIgnoreCase(searchTerm)) {
            results.add((RobotRobotKeywordEl)el);
          }
      }
    }
    return true;
  }

  public List<RobotRobotKeywordEl> getResults() {
    return results;
  }
}
