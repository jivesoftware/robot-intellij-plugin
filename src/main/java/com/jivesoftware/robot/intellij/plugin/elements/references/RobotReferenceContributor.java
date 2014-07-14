package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotResourceFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarAssignment;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarVariable;
import org.jetbrains.annotations.NotNull;

public class RobotReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(RobotKeyword.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        if (element instanceof RobotKeyword) {
                            return new PsiReference[]{new RobotKeywordReference((RobotKeyword) element)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                },
                PsiReferenceRegistrar.HIGHER_PRIORITY);

        registrar.registerReferenceProvider(PlatformPatterns.psiElement(RobotResourceFile.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        if (element instanceof RobotResourceFile) {
                            return new PsiReference[]{new RobotFileReference((RobotResourceFile) element)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                },
                PsiReferenceRegistrar.HIGHER_PRIORITY);

        registrar.registerReferenceProvider(
                PlatformPatterns.or(
                        PlatformPatterns.psiElement(RobotScalarVariable.class),
                        PlatformPatterns.psiElement(RobotScalarAssignment.class)
                ),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        if (element instanceof RobotScalarVariable || element instanceof RobotScalarAssignment) {
                            return new PsiReference[]{new RobotVariableReference(element)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                },
                PsiReferenceRegistrar.HIGHER_PRIORITY);
    }
}
