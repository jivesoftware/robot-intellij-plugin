package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.psi.impl.source.resolve.reference.impl.providers.FilePathReferenceProvider;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotVariableUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordArg;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by charlescapps on 11/10/14.
 */
public class RobotKeywordArgReferenceProvider extends PsiReferenceProvider {
    private static final FilePathReferenceProvider filePathReferenceProvider = new FilePathReferenceProvider(false);

    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        if (!(element instanceof RobotKeywordArg)) {
            return PsiReference.EMPTY_ARRAY;
        }
        RobotKeywordReference keywordReference = new RobotKeywordReference(element);
        PsiReference[] fileReferences = getReferencesToResourceFiles(element);
        PsiReference[] varReferences = getReferencesToVariables(element);
        List<PsiReference> allRefs = Lists.newArrayList();
        allRefs.add(keywordReference);
        allRefs.addAll(Lists.newArrayList(fileReferences));
        allRefs.addAll(Lists.newArrayList(varReferences));
        return allRefs.toArray(new PsiReference[allRefs.size()]);
    }

    private PsiReference[] getReferencesToResourceFiles(PsiElement psiElement) {
        // Find references to files in resource folders
        PsiFile psiFile = psiElement.getContainingFile();
        Module[] modules;
        // Find the Module containing the Robot file, if possible
        if (psiFile != null && psiFile.getVirtualFile() != null) {
            Module module = ModuleUtilCore.findModuleForFile(psiFile.getVirtualFile(), psiElement.getProject());
            modules = new Module[] { module };
        } else {
            modules = Module.EMPTY_ARRAY;
        }
        // Use the FilePathReferenceProvider to do all the hard work for us!
        return filePathReferenceProvider.getReferencesByElement(psiElement, psiElement.getText(), 0, true, modules);
    }

    private PsiReference[] getReferencesToVariables(PsiElement psiElement) {
        List<TextRange> ranges = RobotVariableUtil.getOccurrencesOfVariablesInElement(psiElement);
        List<PsiReference> references = Lists.newArrayList();
        for (TextRange range: ranges) {
            PsiReference reference = new RobotVariableReference(psiElement, range);
            references.add(reference);
        }
        return references.toArray(new PsiReference[references.size()]);
    }
}
