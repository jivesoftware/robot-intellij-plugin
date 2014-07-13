package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.jivesoftware.robot.intellij.plugin.elements.search.KeywordScope;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.SearchType;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RobotKeywordReference extends PsiReferenceBase<RobotKeyword> {

  public RobotKeywordReference(RobotKeyword element) {
    super(element);
  }

  @Nullable
  @Override
  public PsiElement resolve() {
    Project project = myElement.getProject();

    RobotKeywordDefinitionFinder robotKeywordDefinitionFinder =
            new RobotKeywordDefinitionFinder(project, getCanonicalText(), KeywordScope.ROBOT_AND_JAVA_KEYWORDS,
                    SearchType.EXACT_MATCH);
    robotKeywordDefinitionFinder.process();
    List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
    if (results.isEmpty()) {
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
    return myElement.getText();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0]; // code completion handled by RobotCompletionProvider
  }

  @Override
  public TextRange calculateDefaultRangeInElement() {
    return new TextRange(0, myElement.getText().length());
  }

  @Override
  public PsiElement handleElementRename(String name) {
      return myElement.setName(RobotPsiUtil.methodToRobotKeyword(name));
  }

}
