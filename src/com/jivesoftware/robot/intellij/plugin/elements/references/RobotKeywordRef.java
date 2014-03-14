package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectFileIndex;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RobotKeywordRef extends PsiReferenceBase<PsiElement> {

  public RobotKeywordRef(PsiElement element) {
    super(element);
  }


  @Nullable
  @Override
  public PsiElement resolve() {
    Project project = myElement.getProject();
    VirtualFile file = myElement.getContainingFile().getVirtualFile();
    Module module = ProjectFileIndex.SERVICE.getInstance(project).getModuleForFile(file);

    RobotKeywordMethodFinder robotKeywordMethodFinder = new RobotKeywordMethodFinder(file, module, getCanonicalText());
    robotKeywordMethodFinder.process();
    List<PsiElement> results = robotKeywordMethodFinder.getResults();
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
      String token = tokens[i].trim();
      if (token.length() <= 0) {
        continue;
      }
      if (i == 0) {
        sb.append(token.substring(0, 1).toLowerCase() + token.substring(1));
      } else {
        sb.append(token.substring(0, 1).toUpperCase() + token.substring(1));
      }
    }
    return sb.toString();
  }

  @NotNull
  @Override
  public Object[] getVariants() {
    return new Object[0];
  }

  @Override
  public TextRange calculateDefaultRangeInElement() {
    return new TextRange(0, myElement.getText().length());
  }

  @Override
  public boolean isReferenceTo(PsiElement element) {
    return super.isReferenceTo(element);
  }

}
