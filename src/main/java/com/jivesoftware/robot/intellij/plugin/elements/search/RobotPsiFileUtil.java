package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotFileReference;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotResourceFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotSettingsTable;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTable;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * Created by charles.capps on 7/25/14.
 */
public class RobotPsiFileUtil {
    /**
     * Find all the ResourceFile imports that refer to this RobotPsiFile.
     * However, don't take into account variable substitution, because we don't want to change
     * the value of variables when we rename refactor a Robot File.
     *
     * @param file
     * @return
     */
    public static List<RobotResourceFile> findAllReferencesToFileBeforeVariableSubstitution(RobotPsiFile file) {
        final Project project = file.getProject();
        final List<RobotResourceFile> results = Lists.newArrayList();
        if (file.getVirtualFile() == null) {
            return results;
        }
        Collection<VirtualFile> robotFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, RobotFileType.INSTANCE,
                GlobalSearchScope.projectScope(project));
        for (VirtualFile vf: robotFiles) {
            PsiFile psiFile = PsiManager.getInstance(project).findFile(vf);
            if (!(psiFile instanceof RobotPsiFile)) {
                continue;
            }
            getReferencesToRobotFileInResourceSettings(file, (RobotPsiFile)psiFile, results);
        }
        return results;
    }

    public static void getReferencesToRobotFileInResourceSettings(RobotPsiFile source, RobotPsiFile searchFile, List<RobotResourceFile> results) {
        RobotTable[] tables = searchFile.findChildrenByClass(RobotTable.class);
        for (RobotTable table: tables) {
            RobotSettingsTable settingsTable = table.getSettingsTable();
            if (settingsTable == null) {
                continue;
            }
            Collection<RobotResourceFile> resourceFiles = PsiTreeUtil.findChildrenOfType(settingsTable, RobotResourceFile.class);
            for (RobotResourceFile resourceFile: resourceFiles) {
                if (isReferenceToFileWithoutVariableSubs(source, resourceFile)) {
                    results.add(resourceFile);
                }
            }
        }
    }

    private static boolean isReferenceToFileWithoutVariableSubs(RobotPsiFile file, RobotResourceFile resourceFile) {
        final String fileName = file.getName();
        final String resourcePath = resourceFile.getText();
        final int indexOfLastSlash = resourcePath.lastIndexOf(File.separatorChar);
        final String resourceFileName = resourcePath.substring(indexOfLastSlash + 1);
        if (!fileName.equals(resourceFileName)) {
            return false;
        }
        RobotFileReference ref = new RobotFileReference(resourceFile);
        PsiElement resolvesTo = ref.resolve();
        if (!(resolvesTo instanceof RobotPsiFile)) {
            return false;
        }
        RobotPsiFile resourceRobotFile = (RobotPsiFile) resolvesTo;
        final VirtualFile resourceVF = resourceRobotFile.getVirtualFile();
        if (resourceVF == null || resourceVF.getCanonicalPath() == null) {
            return false;
        }
        return resourceVF.getCanonicalPath().equals(file.getVirtualFile().getCanonicalPath());
    }

}
