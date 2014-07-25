package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.PsiSearchHelper;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.lang.RobotFileType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Searches the given IntelliJ project for Java method implementation of Robot Keywords AND robot keywords defined in Robot files.
 * They must be annotated with @RobotKeyword and the containing class must be annotated with @RobotKeywords.
 */
public class RobotTagFinder implements Processor<PsiFile> {
    public static final String TAGS_SETTING = "[tags]";
    public static final String FORCE_TAGS_SETTING = "Force tags";
    public static final String FORCE_TAGS_SETTING2 = "Force Tags";

    private final Project project;
    private final Set<String> results;

    public RobotTagFinder(Project project) {
        this.project = project;
        results = Sets.newHashSet();
    }

    @Override
    public boolean process(PsiFile file) {
        return addResultsForRobotFile(file, results);
    }

    public void process() {

        GlobalSearchScope robotFilesInProject = GlobalSearchScope.getScopeRestrictedByFileTypes(GlobalSearchScope.projectScope(project), RobotFileType.INSTANCE);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWordInLiterals(TAGS_SETTING, robotFilesInProject, this);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWordInLiterals(FORCE_TAGS_SETTING, robotFilesInProject, this);
        PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWordInLiterals(FORCE_TAGS_SETTING2, robotFilesInProject, this);
    }

    private boolean addResultsForRobotFile(PsiFile psiFile, Set<String> resultsToAdd) {
        if (psiFile instanceof RobotPsiFile) {
            RobotTable[] tables = ((RobotPsiFile) psiFile).findChildrenByClass(RobotTable.class);
            for (RobotTable table : tables) {
                if (table.getTestCasesTable() != null) {
                    addResultsForTestCaseTable(table.getTestCasesTable(), resultsToAdd);
                }
                if (table.getSettingsTable() != null) {
                    addResultsForSettingsTable(table.getSettingsTable(), resultsToAdd);
                }
            }
            RobotTag[] tags = ((RobotPsiFile) psiFile).findChildrenByClass(RobotTag.class);
            for (RobotTag tag : tags) {
                resultsToAdd.add(tag.getText());
            }
        }
        return true;
    }

    private void addResultsForSettingsTable(RobotSettingsTable settingsTable, Set<String> resultsToAdd) {
        List<RobotSettingsLine> lines = settingsTable.getSettingsLineList();
        for (RobotSettingsLine line : lines) {
            RobotSetting setting = line.getSetting();
            if (setting == null) {
                continue;
            }
            RobotForceTagsSetting tagsSetting = setting.getForceTagsSetting();
            if (tagsSetting == null) {
                continue;
            }
            List<RobotTag> tags = tagsSetting.getTagList();
            for (RobotTag tag : tags) {
                resultsToAdd.add(tag.getText());
            }
        }
    }

    private void addResultsForTestCaseTable(RobotTestCasesTable testCasesTable, Set<String> resultsToAdd) {
        for (RobotTestCase testCase : testCasesTable.getTestCaseList()) {
            addResultsForTestCase(testCase, resultsToAdd);
        }
    }

    private void addResultsForTestCase(RobotTestCase testCase, Set<String> resultsToAdd) {
        List<RobotTestcaseLine> lines = testCase.getTestcaseLineList();
        for (RobotTestcaseLine line : lines) {
            if (line.getTestSettingLine() == null) {
                continue;
            }
            RobotTestSetting setting = line.getTestSettingLine().getTestSetting();
            RobotTagsSetting tagsSetting = setting.getTagsSetting();
            if (tagsSetting == null) {
                continue;
            }
            List<RobotTag> tags = tagsSetting.getTagList();
            for (RobotTag tag : tags) {
                String tagString = tag.getText();
                resultsToAdd.add(tagString);
            }
        }
    }


    public List<String> getResults() {
        List<String> orderedResults = Lists.newArrayList(results);
        Collections.sort(orderedResults);
        return orderedResults;
    }

}
