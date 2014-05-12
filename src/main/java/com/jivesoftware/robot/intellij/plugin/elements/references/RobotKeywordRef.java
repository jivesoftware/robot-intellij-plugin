package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordDefinitionFinder.SCOPE;

public class RobotKeywordRef extends PsiReferenceBase<PsiElement> {

  public RobotKeywordRef(PsiElement element) {
    super(element);
  }


  @Nullable
  @Override
  public PsiElement resolve() {
    Project project = myElement.getProject();
    PsiFile psiFile = myElement.getContainingFile();

    RobotKeywordDefinitionFinder robotKeywordDefinitionFinder = new RobotKeywordDefinitionFinder(psiFile, project, getCanonicalText(), SCOPE.ALL);
    robotKeywordDefinitionFinder.process();
    List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
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
    return RobotPsiUtil.robotKeywordToMethodFast(keywordText);
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    Project project = myElement.getProject();
    PsiFile psiFile = myElement.getContainingFile();
    if (psiFile == null) {
      return new Object[0];
    }
    RobotKeywordDefinitionFinder robotKeywordDefinitionFinder = new RobotKeywordDefinitionFinder(psiFile, project, "", SCOPE.ALL, true, true,
                                                                                                 RobotKeywordDefinitionFinder.ALL_PREDICATE);
    robotKeywordDefinitionFinder.process();
    List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
    return results.toArray();
  }

  @Override
  public TextRange calculateDefaultRangeInElement() {
    return new TextRange(0, myElement.getText().length());
  }

}
