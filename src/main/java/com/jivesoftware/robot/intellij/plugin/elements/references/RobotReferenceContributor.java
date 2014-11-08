package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FilePathReferenceProvider;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;

public class RobotReferenceContributor extends PsiReferenceContributor {
    final FilePathReferenceProvider filePathReferenceProvider = new FilePathReferenceProvider(false);

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

        registrar.registerReferenceProvider(
            PlatformPatterns.psiElement(RobotKeywordArg.class),
            new PsiReferenceProvider() {

                @NotNull
                @Override
                public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement, @NotNull ProcessingContext processingContext) {
                    // Find references to files from resource folders
                    if (psiElement instanceof RobotKeywordArg) {
                        PsiFile psiFile = psiElement.getContainingFile();
                        Module[] modules;
                        // Find the Module containing the Robot file, if possible
                        if (psiFile != null) {
                            Module module = ModuleUtilCore.findModuleForFile(psiFile.getVirtualFile(), psiElement.getProject());
                            modules = new Module[] { module };
                        } else {
                            modules = Module.EMPTY_ARRAY;
                        }
                        // Use the FilePathReferenceProvider to do all the hard work for us!
                        return filePathReferenceProvider.getReferencesByElement(psiElement, psiElement.getText(), 0, true, modules);
                    }
                    return PsiReference.EMPTY_ARRAY;
                }
            },
            PsiReferenceRegistrar.HIGHER_PRIORITY
        );
    }
}
