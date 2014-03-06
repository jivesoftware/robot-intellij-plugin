package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiReferenceBase;
import com.jivesoftware.robot.intellij.plugin.elements.RobotKeywordElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RobotKeywordRef extends PsiReferenceBase<RobotKeywordElement> {

  public RobotKeywordRef(RobotKeywordElement element) {
    super(element);
  }

  public RobotKeywordRef(RobotKeywordElement element, boolean soft) {
    super(element, soft);
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    DataContext dataContext = DataManager.getInstance().getDataContextFromFocus().getResultSync();
    Project project = DataKeys.PROJECT.getData(dataContext);
    ProjectFileIndex projectFileIndex = ProjectRootManager.getInstance(project).getFileIndex();
    RobotKeywordMethodFinder robotKeywordMethodFinder = new RobotKeywordMethodFinder(project, getCanonicalText());
    projectFileIndex.iterateContent(robotKeywordMethodFinder);
    List<PsiMethod> results = robotKeywordMethodFinder.getResults();
    if (results.size() <= 0) {
      return null;
    }
    return results.get(0);
  }

  /**
   * Return the java method name corresponding to the Robot keyword.
   */
  @NotNull
  @Override
  public String getCanonicalText() {
    String keywordText = myElement.getText();
    String[] tokens = keywordText.split(" ");
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < tokens.length; i++) {
      if (i == 0) {
        sb.append(tokens[i].trim().toLowerCase());
      } else {
        sb.append(tokens[i].trim());
      }
    }
    return sb.toString();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }

}
