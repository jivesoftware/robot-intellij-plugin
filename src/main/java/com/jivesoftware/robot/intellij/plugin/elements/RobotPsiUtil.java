package com.jivesoftware.robot.intellij.plugin.elements;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifierList;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;

import java.util.Collection;
import java.util.List;

public class RobotPsiUtil {

  public static boolean isJavaRobotKeyword(PsiElement element) {
    if (!(element instanceof PsiMethod)) {
      return false;
    }
    PsiModifierList psiModifierList = ((PsiMethod)element).getModifierList();
    return psiModifierList.findAnnotation(RobotKeywordDefinitionFinder.ROBOT_KEYWORD_ANNOTATION) != null;
  }

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
    for (int i = 1; i <= method.length(); i++) {
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

  public static List<RobotKeywordDef> findRobotKeywordDefs(Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                           GlobalSearchScope.projectScope(project));
    List<RobotKeywordDef> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordDefsInFile(psiFile, results);
    }
    return results;
  }

  public static List<RobotKeyword> findKeywordUsagesByName(String name, Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                                         GlobalSearchScope.projectScope(project));
    List<RobotKeyword> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordUsagesInFileByName(psiFile, name, results);
    }
    return results;
  }

  public static List<RobotKeywordDef> findKeywordDefsByName(String name, Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                                         GlobalSearchScope.projectScope(project));
    List<RobotKeywordDef> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordDefsInFileByName(psiFile, name, results);
    }
    return results;
  }

  public static void findKeywordDefsInFile(PsiFile psiFile, List<RobotKeywordDef> keywordDefList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeywordDef[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeywordDef.class);
    for (RobotKeywordDef RobotKeywordDef: results) {
      keywordDefList.add(RobotKeywordDef);
    }
  }

  public static void findKeywordDefsInFileByName(PsiFile psiFile, String name, List<RobotKeywordDef> keywordDefList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeywordDef[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeywordDef.class);
    for (RobotKeywordDef RobotKeywordDef: results) {
      String nameAsMethod = robotKeywordToMethodFast(name);
      String keywordAsMethod = robotKeywordToMethodFast(RobotKeywordDef.getText());
      if (nameAsMethod.equalsIgnoreCase(keywordAsMethod)) {
        keywordDefList.add(RobotKeywordDef);
      }
    }
  }

  public static List<RobotKeywordDef> getKeywordDefsInRobotFilesStartingWith(String startText, Project project) {
    Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                                                                                         GlobalSearchScope.projectScope(project));
    List<RobotKeywordDef> results = Lists.newArrayList();
    for (VirtualFile f: robotFiles) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(f);
      findKeywordDefsInFileByName(psiFile, startText, results);
    }
    return results;
  }

  public static void findKeywordDefsInFileStartingWith(PsiFile psiFile, String startText, List<RobotKeywordDef> keywordDefList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeywordDef[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeywordDef.class);
    for (RobotKeywordDef RobotKeywordDef: results) {
      String startTextNoSpaces = robotKeywordToMethodFast(startText);
      String keywordAsMethod = robotKeywordToMethodFast(RobotKeywordDef.getText());
      if (keywordAsMethod.toLowerCase().startsWith(startTextNoSpaces.toLowerCase())) {
        keywordDefList.add(RobotKeywordDef);
      }
    }
  }

  public static void findKeywordUsagesInFileByName(PsiFile psiFile, String name, List<RobotKeyword> keywordList) {
    if (! (psiFile instanceof RobotPsiFile) ) {
      return;
    }
    RobotKeyword[] results = ((RobotPsiFile) psiFile).findChildrenByClass(RobotKeyword.class);
    for (RobotKeyword RobotKeyword: results) {
      String nameAsMethod = robotKeywordToMethodFast(name);
      String keywordAsMethod = robotKeywordToMethodFast(RobotKeyword.getText());
      if (nameAsMethod.equalsIgnoreCase(keywordAsMethod)) {
        keywordList.add(RobotKeyword);
      }
    }
  }
}
