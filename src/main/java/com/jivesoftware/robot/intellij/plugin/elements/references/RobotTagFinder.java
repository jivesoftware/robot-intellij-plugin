package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.PsiElementBase;
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
  public static final String searchTerm = "tags";

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
    PsiSearchHelper.SERVICE.getInstance(project).processAllFilesWithWord(searchTerm, robotFilesInProject,
                                                                         this,
                                                                         false);
  }

  private boolean addResultsForRobotFile(PsiFile psiFile, Set<String> resultsToAdd) {
    if (psiFile instanceof RobotPsiFile) {
      RobotRobotTable[] tables = ((RobotPsiFile) psiFile).findChildrenByClass(RobotRobotTable.class);
      for (RobotRobotTable table: tables) {
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
        for (RobotSettingsLine line: lines) {
            RobotSetting setting = line.getSetting();
            if (setting == null) {
                continue;
            }
            RobotForceTagsSetting tagsSetting = setting.getForceTagsSetting();
            if (tagsSetting == null) {
                continue;
            }
            List<RobotTagSettingLine> tagsSettingLines = tagsSetting.getTagSettingLineList();
            for (RobotTagSettingLine tagSettingLine: tagsSettingLines) {
                if (tagSettingLine.getTagList() == null) {
                    continue;
                }
                for (RobotTag tag: tagSettingLine.getTagList().getTagList()) {
                    resultsToAdd.add(tag.getText());
                }
            }
        }
    }

    private void addResultsForTestCaseTable(RobotTestCasesTable testCasesTable, Set<String> resultsToAdd) {
        for (RobotTestCase testCase: testCasesTable.getTestCaseList()) {
            addResultsForTestCase(testCase, resultsToAdd);
        }
    }

    private void addResultsForTestCase(RobotTestCase testCase, Set<String> resultsToAdd) {
        RobotTestCaseSettings robotTestCaseSettings = testCase.getTestCaseSettings();
        List<RobotTestSettingLine> lines = robotTestCaseSettings.getTestSettingLineList();
        for (RobotTestSettingLine line: lines) {
            RobotTestSetting setting = line.getTestSetting();
            if (setting == null) {
                continue;
            }
            RobotTagsSetting tagsSetting = setting.getTagsSetting();
            if (tagsSetting == null) {
                continue;
            }
            List<RobotTagLine> tagLines = tagsSetting.getTagLineList();
            for (RobotTagLine tagLine: tagLines) {
                if (tagLine.getTagList() == null) {
                    continue;
                }
                for (RobotTag tag: tagLine.getTagList().getTagList()) {
                    String tagString = tag.getText();
                    resultsToAdd.add(tagString);
                }
            }
        }
    }



  public List<String> getResults() {
    List<String> orderedResults = Lists.newArrayList(results);
    Collections.sort(orderedResults);
    return orderedResults;
  }

}
