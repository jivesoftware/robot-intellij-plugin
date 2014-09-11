package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileSystemItem;
import com.intellij.psi.search.FilenameIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.util.containers.MultiMap;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiFileUtil;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotResourceFile;
import org.jetbrains.annotations.NotNull;

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
    public void prepareRenaming(final PsiElement element, final String newName,
                                final Map<PsiElement, String> allRenames) {
        if (!(element instanceof RobotPsiFile)) {
            return;
        }
        Collection<RobotResourceFile> resourceFiles = RobotPsiFileUtil.findAllReferencesToFileBeforeVariableSubstitution((RobotPsiFile) element);
        for (RobotResourceFile resourceFile: resourceFiles) {
            allRenames.put(resourceFile, newName);
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

    @Override
    public boolean forcesShowPreview() {
        return true;
    }
}
