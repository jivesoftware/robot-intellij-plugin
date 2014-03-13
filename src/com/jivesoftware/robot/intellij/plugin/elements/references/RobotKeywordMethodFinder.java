package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.*;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefEl;

import java.util.Collection;
import java.util.List;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotKeywordMethodFinder implements ContentIterator {

  public static final String ROBOT_KEYWORD_ANNOTATION = "org.robotframework.javalib.annotation.RobotKeyword";

  private final VirtualFile file;
  private final Project project;
  private final Module module;
  private final String searchTerm;
  private final List<PsiElement> results;

  public RobotKeywordMethodFinder(VirtualFile file, Module module, String searchTerm) {
    this.file = file;
    this.module = module;
    this.project = module.getProject();
    this.searchTerm = searchTerm;
    results = Lists.newArrayList();
  }

  @Override
  public boolean processFile(VirtualFile virtualFile) {
    PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
    addResultsForJavaFile(psiFile, results);
    if (results.size() > 0) {
      return false;
    }
    return true;
  }

  public void process() {
    //Find Java methods for the keyword
    Collection<VirtualFile> files = FileTypeIndex.getFiles(JavaFileType.INSTANCE, GlobalSearchScope.moduleScope(module));
    for (VirtualFile file : files) {
      PsiFile psiFile = PsiManager.getInstance(project).findFile(file);
      boolean searchMore = addResultsForJavaFile(psiFile, results);
      if (!searchMore) {
        return;
      }
    }
    //Find Robot keyword definitions that match
    PsiFile startFile = PsiManager.getInstance(project).findFile(file);
    findKeywordDefInRobotFiles(startFile, results);
  }

  private boolean addResultsForJavaFile(PsiFile psiFile, List<PsiElement> resultsToAdd) {
    if (psiFile instanceof PsiJavaFile) {
      PsiClass[] classes = ((PsiClassOwner) psiFile).getClasses();
      for (PsiClass psiClass : classes) {
        for (PsiMethod psiMethod : psiClass.getMethods()) {
          if (searchTerm.equalsIgnoreCase(psiMethod.getName())) {
            PsiModifierList modifierList = psiMethod.getModifierList();
            if (modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null) {
              resultsToAdd.add(psiMethod);
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * Starting in startFile, search for the robot keyword definition in a robot file.
   * Recursively search UP the tree, since we generally only include robot files from a parent directory.
   * TODO: Can we filter by robot files without having to do so manually?
   * TODO: Follow which files are included in Resources? (Or maybe we want to be more inclusive, anyway)
   * @param startFile
   * @param resultsToAdd
   */
  public void findKeywordDefInRobotFiles(PsiFile startFile, List<PsiElement> resultsToAdd) {
    if (startFile == null) {
      return;
    }
    boolean searchMore = findKeywordDefInRobotFile(startFile, resultsToAdd);
    if (!searchMore) {
      return;
    }
    PsiDirectory directory = startFile.getContainingDirectory();
    if (directory == null) {
      return;
    }
    PsiFile[] files = directory.getFiles();
    for (PsiFile file: files) {
      if (file.equals(startFile)) {
        continue;
      }
      searchMore = findKeywordDefInRobotFile(file, resultsToAdd);
      if (!searchMore) {
        return;
      }
    }
    PsiDirectory parentDir = directory.getParent();
    if (parentDir == null) {
      return;
    }
    PsiFile[] parentFiles = parentDir.getFiles();
    if (parentFiles.length <= 0) {
      return;
    }
    findKeywordDefInRobotFiles(parentFiles[0], resultsToAdd);
  }

  /**
   * @return - true if search should continue, false if not
   */
  public boolean findKeywordDefInRobotFile(PsiFile file, List<PsiElement> resultsToAdd) {
    if (file instanceof RobotPsiFile) {
      PsiElement[] keywordDefs = ((RobotPsiFile) file).findChildrenByClass(RobotKeywordDefEl.class);
      for (PsiElement el: keywordDefs) {
          String keywordName = el.getText();
          String methodText = RobotPsiUtil.robotKeywordToMethodFast(keywordName);
          if (searchTerm.equalsIgnoreCase(methodText)) {
            resultsToAdd.add(el);
            return false;
          }
      }
    }
    return true;
  }

  public List<PsiElement> getResults() {
    return results;
  }
}
