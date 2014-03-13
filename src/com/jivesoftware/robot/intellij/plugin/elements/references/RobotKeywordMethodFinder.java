package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiClassOwner;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifierList;

import java.util.List;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotKeywordMethodFinder implements ContentIterator {

  public static final String ROBOT_KEYWORD_ANNOTATION = "org.robotframework.javalib.annotation.RobotKeyword";

  private final Project project;
  private final String searchTerm;
  private final List<PsiMethod> results;

  public RobotKeywordMethodFinder(Project project, String searchTerm) {
    this.project = project;
    this.searchTerm = searchTerm;
    results = Lists.newArrayList();
  }

  @Override
  public boolean processFile(VirtualFile virtualFile) {
    PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
    if (psiFile instanceof PsiJavaFile) {
      PsiClass[] classes = ((PsiClassOwner) psiFile).getClasses();
      for (PsiClass psiClass : classes) {

        for (PsiMethod psiMethod : psiClass.getMethods()) {
          if (searchTerm.equalsIgnoreCase(psiMethod.getName())) {
            PsiModifierList modifierList = psiMethod.getModifierList();
            if (modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null) {
              results.add(psiMethod);
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  public List<PsiMethod> getResults() {
    return results;
  }
}
