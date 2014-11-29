package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.psi.*;
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

        // Register Robot Keyword Arguments so they can point to files in resource folders, and have embedded variables.
        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(RobotKeywordArg.class),
            new RobotKeywordArgReferenceProvider(),
            PsiReferenceRegistrar.HIGHER_PRIORITY
        );

        registrar.registerReferenceProvider(
                PlatformPatterns.psiElement(RobotJavaClassReference.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        if (!(element instanceof RobotJavaClassReference)) {
                            return PsiReference.EMPTY_ARRAY;
                        }
                        return new PsiReference[] { new RobotJavaClassInTextReference((RobotJavaClassReference)element) };
                    }
                },
                PsiReferenceRegistrar.HIGHER_PRIORITY);
    }
}
