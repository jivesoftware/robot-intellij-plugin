package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefEl;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordEl;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RobotImplUtil {

  public static String getName(RobotKeywordEl element) {
    return element.getText();
  }

  public static PsiElement setName(RobotKeywordEl element, String newName) {
    RobotKeywordEl replacement = RobotElementFactory.createKeyword(element.getProject(), newName);
    element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
    return replacement;
  }

  public static PsiElement getNameIdentifier(RobotKeywordEl element) {
    return element;
  }

  public static PsiReference[] getReferences(RobotKeywordEl element) {
    return ReferenceProvidersRegistry.getReferencesFromProviders(element);
  }

  public static PsiReference getReference(RobotKeywordEl element) {
    PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
    if (refs.length <= 0) {
      return null;
    }
    return refs[0];
  }

  // Robot Keyword Definition methods
  public static ItemPresentation getPresentation(final RobotKeywordDefEl element) {
    return new ItemPresentation() {
      @Nullable
      @Override
      public String getPresentableText() {
        return String.format("Robot Keyword: %s", element.getText());
      }

      @Nullable
      @Override
      public String getLocationString() {
        return element.getContainingFile().getName();
      }

      @Nullable
      @Override
      public Icon getIcon(boolean unused) {
        return RobotIcons.FILE;
      }
    };
  }

  public static String getName(RobotKeywordDefEl element) {
    return element.getText();
  }

  public static PsiElement setName(RobotKeywordDefEl element, String newName) {
    RobotKeywordDefEl replacement = RobotElementFactory.createKeywordDef(element.getProject(), newName);
    element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
    return replacement;
  }

  public static PsiElement getNameIdentifier(RobotKeywordDefEl element) {
    return element;
  }

}
