package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.impl.java.stubs.index.JavaStubIndexKeys;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords AND robot keywords defined in Robot files.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotKeywordDefinitionFinder implements Processor<PsiFile> {

  public static final String ROBOT_KEYWORD_ANNOTATION = "org.robotframework.javalib.annotation.RobotKeyword";

  public static enum KEYWORD_SCOPE {ROBOT_KEYWORDS, JAVA_KEYWORDS, ROBOT_AND_JAVA_KEYWORDS}

  private final Project project;
  private final String searchTerm;
  private final String methodText;
  private final KEYWORD_SCOPE scope;
  private final List<PsiElement> results;
  private final KeywordPredicate keywordPredicate;
  private final boolean findAll;
  private final boolean wrapPsiMethods;

  public RobotKeywordDefinitionFinder(Project project, String searchTerm, KEYWORD_SCOPE scope) {
    this(project, searchTerm, scope, false);
  }

  public RobotKeywordDefinitionFinder(Project project, String searchTerm, KEYWORD_SCOPE scope, boolean findAll) {
    this(project, searchTerm, scope, findAll, false);
  }

  public RobotKeywordDefinitionFinder(Project project, String searchTerm, KEYWORD_SCOPE scope, boolean findAll, boolean wrapPsiMethods) {
    this.project = project;
    this.searchTerm = searchTerm;
    this.methodText = RobotPsiUtil.robotKeywordToMethodFast(searchTerm);
    this.scope = scope;
    this.findAll = findAll;
    this.keywordPredicate = findAll ? ALL_PREDICATE : EXACT_NAME_PREDICATE;
    this.wrapPsiMethods = wrapPsiMethods;
    results = Lists.newArrayList();
  }

  @Override
  public boolean process(PsiFile file) {
    return addResultsForJavaFile(file, results);
  }

  public void process() {
    //Find Java methods for the keyword
    if (scope == KEYWORD_SCOPE.ROBOT_AND_JAVA_KEYWORDS || scope == KEYWORD_SCOPE.JAVA_KEYWORDS) {
      if (findAll) {
        addJavaMethodsContainingText();
      } else {
        addJavaMethodsWithExactName(results);
      }
    }

    if (!findAll && results.size() > 0) {
      return;
    }

    //Find Robot keyword definitions from robot files
    if (scope == KEYWORD_SCOPE.ROBOT_AND_JAVA_KEYWORDS || scope == KEYWORD_SCOPE.ROBOT_KEYWORDS) {
      List<RobotKeywordDef> robotKeywordDefs;
      if (StringUtils.isEmpty(searchTerm)) {
        robotKeywordDefs = RobotPsiUtil.findAllRobotKeywordDefs(project);
      } else {
        robotKeywordDefs = RobotPsiUtil.findKeywordDefsByName(searchTerm, project);
      }
      results.addAll(robotKeywordDefs);
    }
  }

  private void addJavaMethodsWithExactName(List<PsiElement> resultsToAdd) {
    Collection<PsiMethod> methods = StubIndex.getElements(JavaStubIndexKeys.METHODS, methodText, project, GlobalSearchScope.projectScope(project), PsiMethod.class);
    for (PsiMethod method : methods) {
      if (!RobotPsiUtil.isJavaRobotKeyword(method)) {
        continue;
      }
      if (keywordPredicate.includeJavaMethod(methodText, method)) {
        if (wrapPsiMethods) {
          resultsToAdd.add(new PsiMethodWithRobotName(method.getNode()));
        } else {
          resultsToAdd.add(method);
        }
        if (!findAll) {
          return;
        }
      }
    }
    if (resultsToAdd.isEmpty()) {
      addJavaMethodsContainingText();
    }
  }

  private void addJavaMethodsContainingText() {
    String searchWord;
    if (StringUtils.isEmpty(methodText)) {
      searchWord = "RobotKeyword";
    } else {
      searchWord = methodText;
    }
    GlobalSearchScope javaFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), JavaFileType.INSTANCE);
    PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(searchWord, javaFilesInProject, this, false);
  }

  private boolean addResultsForJavaFile(PsiFile psiFile, List<PsiElement> resultsToAdd) {
    if (psiFile instanceof PsiJavaFile) {
      PsiClass[] classes = ((PsiClassOwner) psiFile).getClasses();
      for (PsiClass psiClass : classes) {
        for (PsiMethod psiMethod : psiClass.getMethods()) {
          if (keywordPredicate.includeJavaMethod(methodText, psiMethod)) {
            if (wrapPsiMethods) {
              resultsToAdd.add(new PsiMethodWithRobotName(psiMethod.getNode()));
            } else {
              resultsToAdd.add(psiMethod);
            }
            if (!findAll) {
              return false;
            }
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
    public boolean includeJavaMethod(String searchTextAsMethod, PsiMethod el);

    public boolean includeRobotKeywordDefinition(String searchText, RobotKeywordDef el);
  }

  public static final KeywordPredicate EXACT_NAME_PREDICATE = new KeywordPredicate() {
    @Override
    public boolean includeJavaMethod(String searchTextAsMethod, PsiMethod el) {
      String methodText = el.getName();
      if (!methodText.equalsIgnoreCase(searchTextAsMethod)) {
        return false;
      }
      PsiModifierList modifierList = el.getModifierList();
      return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
    }

    @Override
    public boolean includeRobotKeywordDefinition(String searchTextAsMethod, RobotKeywordDef el) {
      String methodText = RobotPsiUtil.robotKeywordToMethodFast(el.getText());
      return methodText.equalsIgnoreCase(searchTextAsMethod);
    }
  };

  public static final KeywordPredicate ALL_PREDICATE = new KeywordPredicate() {
    @Override
    public boolean includeJavaMethod(String searchTextAsMethod, PsiMethod el) {
      PsiModifierList modifierList = el.getModifierList();
      return modifierList.findAnnotation(ROBOT_KEYWORD_ANNOTATION) != null;
    }

    @Override
    public boolean includeRobotKeywordDefinition(String searchText, RobotKeywordDef el) {
      return true;
    }
  };
}
