package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.jivesoftware.robot.intellij.plugin.psi.RobotRobotKeywordEl;

public class RobotImplUtil {
  public static String getName(RobotRobotKeywordEl element) {
    return element.getText();
  }

  public static PsiElement setName(RobotRobotKeywordEl element, String newName) {
    RobotRobotKeywordEl replacement = RobotElementFactory.createKeyword(element.getProject(), newName);
    element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
    return replacement;
  }

  public static PsiElement getNameIdentifier(RobotRobotKeywordEl element) {
    return element;
  }

  public static PsiReference[] getReferences(RobotRobotKeywordEl element) {
    return ReferenceProvidersRegistry.getReferencesFromProviders(element);
  }

  public static PsiReference getReference(RobotRobotKeywordEl element) {
    PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
    if (refs.length <= 0) {
      return null;
    }
    return refs[0];
  }

}
