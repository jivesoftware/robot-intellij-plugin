package com.jivesoftware.robot.intellij.plugin.elements;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefEl;

import java.util.Collection;
import java.util.List;

public class RobotPsiUtil {
  public static String robotKeywordToMethodFast(String keyword) {
    return keyword.replace(" ", "");
  }

  public static List<RobotKeywordDefEl> findRobotKeywordDefs(Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                           GlobalSearchScope.projectScope(project));
    List<RobotKeywordDefEl> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordDefsInFile(psiFile, results);
    }
    return results;
  }

  public static List<RobotKeywordDefEl> getKeywordDefsByName(String name, String pattern, Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                                         GlobalSearchScope.projectScope(project));
    List<RobotKeywordDefEl> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordDefsInFileByName(psiFile, name, results);
    }
    return results;
  }

  public static void findKeywordDefsInFile(PsiFile psiFile, List<RobotKeywordDefEl> keywordDefList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeywordDefEl[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeywordDefEl.class);
    for (RobotKeywordDefEl robotKeywordDefEl: results) {
      keywordDefList.add(robotKeywordDefEl);
    }
  }

  public static void findKeywordDefsInFileByName(PsiFile psiFile, String name, List<RobotKeywordDefEl> keywordDefList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeywordDefEl[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeywordDefEl.class);
    for (RobotKeywordDefEl robotKeywordDefEl: results) {
      String nameAsMethod = robotKeywordToMethodFast(name);
      String keywordAsMethod = robotKeywordToMethodFast(robotKeywordDefEl.getText());
      if (nameAsMethod.equalsIgnoreCase(keywordAsMethod)) {
        keywordDefList.add(robotKeywordDefEl);
      }
    }
  }
}
