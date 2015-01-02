package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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
import com.jivesoftware.robot.intellij.plugin.psi.*;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by charles.capps on 7/25/14.
 */
public class RobotResourceFileUtil {
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

    public static List<RobotLibrarySetting> findAllLibraryImportsInScope(PsiElement sourceElement) {
        PsiFile containingFile = sourceElement.getContainingFile();
        if (!(containingFile instanceof RobotPsiFile)) {
            return Lists.newArrayList();
        }

        List<RobotLibrarySetting> results = Lists.newArrayList();
        Set<String> searchedFiles = Sets.newHashSet(); // to handle loops in resource file imports

        findLibraryImportsRecursive((RobotPsiFile)containingFile, results, searchedFiles);
        return results;
    }

    public static List<RobotKeywordTitle> findAllRobotKeywordDefinitionsInScope(PsiElement sourceElement, boolean matchName) {
        PsiFile containingFile = sourceElement.getContainingFile();
        if (!(containingFile instanceof RobotPsiFile)) {
            return Lists.newArrayList();
        }

        List<RobotKeywordTitle> results = Lists.newArrayList();
        Set<String> searchedFiles = Sets.newHashSet(); // to handle loops in resource file imports

        Optional<String> normalizedSearchTerm = matchName ?
                Optional.of(RobotPsiUtil.normalizeRobotDefinedKeywordForIndex(sourceElement.getText())) :
                Optional.<String>absent();

        findKeywordTitlesRecursive((RobotPsiFile) containingFile, results, searchedFiles, normalizedSearchTerm);
        return results;
    }

    // ----------------------- Private -------------------------

    private static void findLibraryImportsRecursive(RobotPsiFile currentFile, List<RobotLibrarySetting> results, Set<String> searchedFiles) {
        // This shouldn't happen for ordinary files. Return to avoid infinite loops.
        if (currentFile == null || currentFile.getVirtualFile() == null) {
            return;
        }
        // If we've already searched this file OR there's no valid file associated with this virtual file
        final String file = currentFile.getVirtualFile().getCanonicalPath();
        if (file == null || searchedFiles.contains(file)) {
            return;
        }
        searchedFiles.add(file);

        // Now do the actual work to find the Library settings

        // First find the RobotSettingsTable's in the current file.
        RobotTable[] tables = currentFile.findChildrenByClass(RobotTable.class);
        List<RobotResourceFile> followResources = Lists.newArrayList();

        for (RobotTable table: tables) {
            if (table.getSettingsTable() != null) {
                RobotSettingsTable settingsTable = table.getSettingsTable();
                extractLibrarySettingsAndResourceFiles(settingsTable, results, followResources);
            }
        }

        // Recursively search Robot files included as Resources
        for (RobotResourceFile resourceFile: followResources) {
            RobotFileReference fileReference = new RobotFileReference(resourceFile);
            PsiElement resolvesTo = fileReference.resolve();
            if (resolvesTo instanceof RobotPsiFile) {
                findLibraryImportsRecursive((RobotPsiFile)resolvesTo, results, searchedFiles);
            }
        }
    }

    private static void extractLibrarySettingsAndResourceFiles(RobotSettingsTable settingsTable, List<RobotLibrarySetting> results, List<RobotResourceFile> resourceFiles) {
        for (RobotSettingsLine settingsLine: settingsTable.getSettingsLineList()) {
            RobotSetting setting = settingsLine.getSetting();
            if (setting == null) {
                continue;
            }
            // Add the RobotLibrarySetting to the results if present
            RobotLibrarySetting librarySetting = setting.getLibrarySetting();
            if (librarySetting != null) {
                results.add(librarySetting);
                continue;
            }

            // Add the RobotResourceFile if present so we can recursively search other robot files.
            RobotResourceSetting resourceSetting = setting.getResourceSetting();
            if (resourceSetting != null) {
                RobotResourceFile resourceFile = resourceSetting.getResourceFile();
                if (resourceFile != null) {
                    resourceFiles.add(resourceFile);
                }
            }
        }
    }

    private static void extractResourceFiles(RobotSettingsTable settingsTable, List<RobotResourceFile> resourceFiles) {
        for (RobotSettingsLine settingsLine: settingsTable.getSettingsLineList()) {
            RobotSetting setting = settingsLine.getSetting();
            if (setting == null) {
                continue;
            }

            // Add the RobotResourceFile if present so we can recursively search other robot files.
            RobotResourceSetting resourceSetting = setting.getResourceSetting();
            if (resourceSetting != null) {
                RobotResourceFile resourceFile = resourceSetting.getResourceFile();
                if (resourceFile != null) {
                    resourceFiles.add(resourceFile);
                }
            }
        }
    }

    private static void extractKeywordTitles(RobotKeywordsTable keywordsTable, List<RobotKeywordTitle> robotKeywordTitles, Optional<String> normalizedSearchTerm) {
        for (RobotKeywordDefinition keywordDef: keywordsTable.getKeywordDefinitionList()) {
            RobotKeywordTitle title = keywordDef.getKeywordTitle();
            if (normalizedSearchTerm.isPresent()) {
                String normalizedTitle = RobotPsiUtil.normalizeRobotDefinedKeywordForIndex(title.getName());
                if (normalizedTitle.equals(normalizedSearchTerm.get())) {
                    robotKeywordTitles.add(title);
                }
            } else {
                robotKeywordTitles.add(title);
            }
        }
    }

    private static void findKeywordTitlesRecursive(RobotPsiFile currentFile, List<RobotKeywordTitle> results, Set<String> searchedFiles, Optional<String> normalizedKeywordName) {
        // This shouldn't happen for ordinary files. Return to avoid infinite loops.
        if (currentFile == null || currentFile.getVirtualFile() == null) {
            return;
        }
        // If we've already searched this file OR there's no valid file associated with this virtual file
        final String file = currentFile.getVirtualFile().getCanonicalPath();
        if (file == null || searchedFiles.contains(file)) {
            return;
        }
        searchedFiles.add(file);

        // Now do the actual work to find the Library settings

        // First find the RobotSettingsTable's in the current file.
        RobotTable[] tables = currentFile.findChildrenByClass(RobotTable.class);
        List<RobotResourceFile> followResources = Lists.newArrayList();

        for (RobotTable table: tables) {
            if (table.getSettingsTable() != null) {
                RobotSettingsTable settingsTable = table.getSettingsTable();
                extractResourceFiles(settingsTable, followResources);
            }
            if (table.getKeywordsTable() != null) {
                extractKeywordTitles(table.getKeywordsTable(), results, normalizedKeywordName);
            }
        }

        // Recursively search Robot files included as Resources
        for (RobotResourceFile resourceFile: followResources) {
            RobotFileReference fileReference = new RobotFileReference(resourceFile);
            PsiElement resolvesTo = fileReference.resolve();
            if (resolvesTo instanceof RobotPsiFile) {
                findKeywordTitlesRecursive((RobotPsiFile) resolvesTo, results, searchedFiles, normalizedKeywordName);
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
