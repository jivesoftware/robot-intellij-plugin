package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefEl;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords AND robot keywords defined in Robot files.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotKeywordDefinitionFinder implements Processor<PsiFile> {

  public static final String ROBOT_KEYWORD_ANNOTATION = "org.robotframework.javalib.annotation.RobotKeyword";

  public static enum SCOPE {ROBOT_FILES, JAVA_FILES, ALL}

  ;

  private final PsiFile startPsiFile;
  private final Project project;
  private final String searchTerm;
  private final SCOPE scope;
  private final List<PsiElement> results;
  private final KeywordPredicate keywordPredicate;
  private boolean findAll;

  public RobotKeywordDefinitionFinder(PsiFile startPsiFile, Project project, String searchTerm, SCOPE scope) {
    this(startPsiFile, project, searchTerm, scope, false);
  }

  public RobotKeywordDefinitionFinder(PsiFile startPsiFile, Project project, String searchTerm, SCOPE scope, boolean findAll) {
    this(startPsiFile, project, searchTerm, scope, findAll, DEFAULT_PREDICATE);
  }

  public RobotKeywordDefinitionFinder(PsiFile startPsiFile, Project project, String searchTerm, SCOPE scope, boolean findAll, KeywordPredicate keywordPredicate) {
    this.startPsiFile = startPsiFile;
    this.project = project;
    this.searchTerm = searchTerm;
    this.scope = scope;
    this.findAll = findAll;
    this.keywordPredicate = keywordPredicate;
    results = Lists.newArrayList();
  }

  @Override
  public boolean process(PsiFile file) {
    return addResultsForJavaFile(file, results);
  }

  public void process() {
    //Find Java methods for the keyword
    if (scope == SCOPE.ALL || scope == SCOPE.JAVA_FILES) {
      String methodText = RobotPsiUtil.robotKeywordToMethodFast(searchTerm);
      String searchWord;
      if (StringUtils.isEmpty(methodText)) {
        searchWord = "RobotKeyword";
      } else {
        searchWord = methodText;
      }
      GlobalSearchScope javaFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), JavaFileType.INSTANCE);
      PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(searchWord, javaFilesInProject,
                                                                           this,
                                                                           false);
    }

    //Find Robot keyword definitions from robot files
    if (scope == SCOPE.ALL || scope == SCOPE.ROBOT_FILES) {
      findKeywordDefInRobotFiles(startPsiFile, results);
    }
  }

  private boolean addResultsForJavaFile(PsiFile psiFile, List<PsiElement> resultsToAdd) {
    if (psiFile instanceof PsiJavaFile) {
      PsiClass[] classes = ((PsiClassOwner) psiFile).getClasses();
      for (PsiClass psiClass : classes) {
        for (PsiMethod psiMethod : psiClass.getMethods()) {
          if (keywordPredicate.includeJavaMethod(searchTerm, psiMethod)) {
            resultsToAdd.add(psiMethod);
            if (!findAll) {
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
    for (PsiFile file : files) {
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
      RobotKeywordDefEl[] keywordDefs = ((RobotPsiFile) file).findChildrenByClass(RobotKeywordDefEl.class);
      for (RobotKeywordDefEl el : keywordDefs) {
        if (keywordPredicate.includeRobotKeywordDefinition(searchTerm, el)) {
          resultsToAdd.add(el);
          if (!findAll) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public List<PsiElement> getResults() {
    return results;
  }

  public static interface KeywordPredicate {
    public boolean includeJavaMethod(String searchText, PsiMethod el);

    public boolean includeRobotKeywordDefinition(String searchText, RobotKeywordDefEl el);
  }

  public static final KeywordPredicate DEFAULT_PREDICATE = new KeywordPredicate() {
    @Override
    public boolean includeJavaMethod(String searchText, PsiMethod el) {
      String methodText = el.getName();
      String searchTextAsMethod = RobotPsiUtil.robotKeywordToMethodFast(searchText);
      if (!methodText.equalsIgnoreCase(searchTextAsMethod)) {
        return false;
      }
      PsiModifierList modifierList = el.getModifierList();
      return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
    }

    @Override
    public boolean includeRobotKeywordDefinition(String searchText, RobotKeywordDefEl el) {
      String methodText = RobotPsiUtil.robotKeywordToMethodFast(el.getText());
      String searchTextAsMethod = RobotPsiUtil.robotKeywordToMethodFast(searchText);
      return methodText.equalsIgnoreCase(searchTextAsMethod);
    }
  };

  public static final KeywordPredicate STARTS_WITH_PREDICATE = new KeywordPredicate() {
    @Override
    public boolean includeJavaMethod(String searchText, PsiMethod el) {
      String methodText = el.getName();
      String searchTextAsMethod = RobotPsiUtil.robotKeywordToMethodFast(searchText);
      if (!methodText.toLowerCase().startsWith(searchTextAsMethod.toLowerCase())) {
        return false;
      }
      PsiModifierList modifierList = el.getModifierList();
      return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
    }

    @Override
    public boolean includeRobotKeywordDefinition(String searchText, RobotKeywordDefEl el) {
      String methodText = RobotPsiUtil.robotKeywordToMethodFast(el.getText());
      String searchTextAsMethod = RobotPsiUtil.robotKeywordToMethodFast(searchText);
      return methodText.toLowerCase().startsWith(searchTextAsMethod.toLowerCase());
    }
  };

  public static final KeywordPredicate ALL_PREDICATE = new KeywordPredicate() {
    @Override
    public boolean includeJavaMethod(String searchText, PsiMethod el) {
      PsiModifierList modifierList = el.getModifierList();
      return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
    }

    @Override
    public boolean includeRobotKeywordDefinition(String searchText, RobotKeywordDefEl el) {
      return true;
    }
  };
}
