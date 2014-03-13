package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefEl;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordEl;

public class RobotElementFactory {

  public static RobotKeywordEl createKeyword(Project project, String text) {
    String start = "*** Settings ***\n";
    RobotPsiFile file = createFile(project, start + text);
    PsiElement[] children = file.getChildren();
    for (PsiElement el: children) {
      if (el instanceof RobotKeywordEl) {
        return (RobotKeywordEl) el;
      }
    }
    return null;
  }

  public static RobotKeywordDefEl createKeywordDef(Project project, String text) {
    String start = "*** Keywords ***\n";
    RobotPsiFile file = createFile(project, start + text);
    PsiElement[] children = file.getChildren();
    for (PsiElement el: children) {
      if (el instanceof RobotKeywordDefEl) {
        return (RobotKeywordDefEl) el;
      }
    }
    return null;
  }

  public static RobotPsiFile createFile(Project project, String text) {
    String name = "dummy.robot";
    return (RobotPsiFile) PsiFileFactory.getInstance(project)
        .createFileFromText(name, RobotFileType.INSTANCE, text);
  }
}
