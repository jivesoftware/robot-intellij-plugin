package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.google.common.collect.Lists;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.PsiReference;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.refactoring.rename.RenameDialog;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.util.containers.MultiMap;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotResourceFile;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Collection;
import java.util.Map;

/**
 * Created by charles.capps on 6/5/14.
 * <p/>
 * Enable renaming Java-defined Robot Keywords, and having this propagate to all usages in Robot files.
 */
public class RenameRobotPsiFileProcessor extends RenamePsiElementProcessor {
    @Override
    public boolean canProcessElement(@NotNull PsiElement psiElement) {
        return psiElement instanceof RobotPsiFile;
    }

    @Override
    public RenameDialog createRenameDialog(Project project, PsiElement element, PsiElement nameSuggestionContext, Editor editor) {
        return new RenameDialog(project, element, nameSuggestionContext, editor);
    }

    @Override
    public void prepareRenaming(final PsiElement element, final String newName,
                                final Map<PsiElement, String> allRenames) {
        Collection<PsiReference> refs = findReferences(element, true);
        for (PsiReference ref: refs) {
            PsiElement referringElement = ref.getElement();
            if (referringElement instanceof RobotResourceFile) {
                String text = ((RobotResourceFile) referringElement).getText();
                int indexOfLastSlash = text.lastIndexOf(File.separator);
                String replaced = text.substring(0, indexOfLastSlash + 1) + newName;
                allRenames.put(referringElement, replaced);
            }
        }
    }

    @Override
    public void findExistingNameConflicts(PsiElement element, String newName, MultiMap<PsiElement, String> conflicts) {
        final Project project = element.getProject();
        GlobalSearchScope robotFileScope = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.allScope(project), RobotFileType.INSTANCE);
        PsiFileSystemItem[] files = FilenameIndex.getFilesByName(project, newName, robotFileScope, false);
        for (PsiFileSystemItem file: files) {
            if (file.getName().equalsIgnoreCase(newName)) {
                conflicts.put(file, Lists.newArrayList(newName));
            }
        }
    }
}
