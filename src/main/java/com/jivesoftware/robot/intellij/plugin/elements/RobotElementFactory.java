package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;

public class RobotElementFactory {

  public static RobotKeyword createKeyword(Project project, String text) {
    String start = "*** Settings ***\n";
    RobotPsiFile file = createFile(project, start + text);
    PsiElement[] children = file.getChildren();
    for (PsiElement el: children) {
      if (el instanceof RobotKeyword) {
        return (RobotKeyword) el;
      }
    }
    return null;
  }

  public static RobotKeywordDef createKeywordDef(Project project, String text) {
    String start = "*** Keywords ***\n";
    RobotPsiFile file = createFile(project, start + text);
    PsiElement child = file.getLastChild();
      if (child instanceof RobotKeywordDef) {
        return (RobotKeywordDef) child;
    }
    return null;
  }

  public static RobotPsiFile createFile(Project project, String text) {
    String name = "dummy.robot";
    return (RobotPsiFile) PsiFileFactory.getInstance(project)
        .createFileFromText(name, RobotFileType.INSTANCE, text);
  }
}
