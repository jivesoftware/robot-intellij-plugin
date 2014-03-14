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
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordEl;

import java.util.Collection;
import java.util.List;

public class RobotPsiUtil {
  public static String robotKeywordToMethodFast(String keyword) {
    String noSpaces = keyword.replace(" ", "");
    if (noSpaces.isEmpty()) {
      return noSpaces;
    }
    return noSpaces.substring(0, 1).toLowerCase() + noSpaces.substring(1);
  }

  public static String methodToRobotKeyword(String method) {
    StringBuilder sb = new StringBuilder();
    int prev = 0;
    int current;
    for (int i = 0; i <= method.length(); i++) {
      Character c;
      if (i < method.length()) {
        c = method.charAt(i);
      } else {
        c = null;
      }
      if (i == method.length() || Character.isUpperCase(c)) {
        current = i;
        String sub = method.substring(prev, current);
        String cap = sub.substring(0, 1).toUpperCase() + sub.substring(1);
        if (!sb.toString().isEmpty()) { //Append the single space separator for robot keywords
          char lastSoFar = sb.toString().charAt(sb.length() - 1);
          if (!Character.isUpperCase(lastSoFar)) {
            sb.append(" ");
          }
        }
        sb.append(cap);
        prev = current;
      }
    }
    return sb.toString();
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

  public static List<RobotKeywordEl> getKeywordUsagesByName(String name, Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                                         GlobalSearchScope.projectScope(project));
    List<RobotKeywordEl> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordUsagesInFileByName(psiFile, name, results);
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

  public static List<RobotKeywordDefEl> getKeywordDefsInRobotFilesStartingWith(String startText, Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                                         GlobalSearchScope.projectScope(project));
    List<RobotKeywordDefEl> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordDefsInFileByName(psiFile, startText, results);
    }
    return results;
  }

  public static void findKeywordDefsInFileStartingWith(PsiFile psiFile, String startText, List<RobotKeywordDefEl> keywordDefList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeywordDefEl[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeywordDefEl.class);
    for (RobotKeywordDefEl robotKeywordDefEl: results) {
      String startTextNoSpaces = robotKeywordToMethodFast(startText);
      String keywordAsMethod = robotKeywordToMethodFast(robotKeywordDefEl.getText());
      if (keywordAsMethod.toLowerCase().startsWith(startTextNoSpaces.toLowerCase())) {
        keywordDefList.add(robotKeywordDefEl);
      }
    }
  }

  public static void findKeywordUsagesInFileByName(PsiFile psiFile, String name, List<RobotKeywordEl> keywordList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeywordEl[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeywordEl.class);
    for (RobotKeywordEl robotKeywordEl: results) {
      String nameAsMethod = robotKeywordToMethodFast(name);
      String keywordAsMethod = robotKeywordToMethodFast(robotKeywordEl.getText());
      if (nameAsMethod.equalsIgnoreCase(keywordAsMethod)) {
        keywordList.add(robotKeywordEl);
      }
    }
  }
}
