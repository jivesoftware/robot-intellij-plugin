package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;

public class RobotKeywordReferenceContributor extends PsiReferenceContributor {
  @Override
  public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
    registrar.registerReferenceProvider(PlatformPatterns.psiElement(RobotKeyword.class),
                                        new PsiReferenceProvider() {
                                          @NotNull
                                          @Override
                                          public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                                            return new PsiReference[] {new RobotKeywordRef(element)};
                                          }
                                        },
                                        PsiReferenceRegistrar.HIGHER_PRIORITY);
  }
}
