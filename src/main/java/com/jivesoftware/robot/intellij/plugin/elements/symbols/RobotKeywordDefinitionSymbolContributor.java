package com.jivesoftware.robot.intellij.plugin.elements.symbols;

import com.google.common.collect.Lists;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RobotKeywordDefinitionSymbolContributor implements ChooseByNameContributor {
  @NotNull
  @Override
  public String[] getNames(Project project, boolean includeNonProjectItems) {
    List<String> names = Lists.newArrayList();
    List<RobotKeywordDef> keywordDefs = RobotPsiUtil.findAllRobotKeywordDefsInRobotFiles(project);
    for (RobotKeywordDef keywordDef: keywordDefs) {
      names.add(keywordDef.getText());
    }

    List<RobotTestCase> testCases = RobotPsiUtil.findAllRobotTestCases(project);
    for (RobotTestCase testCase: testCases) {
        names.add(testCase.getName());
    }

    return names.toArray(new String[names.size()]);
  }

  @NotNull
  @Override
  public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
    List<RobotKeywordDef> keywordDefs = RobotPsiUtil.findKeywordDefsByName(name, project);
    List<RobotTestCase> testCases = RobotPsiUtil.findTestCasesByName(name, project);
    List<NavigationItem> items = Lists.newArrayList();
    for (RobotKeywordDef keywordDef: keywordDefs) {
        items.add((NavigationItem)keywordDef);
    }
    for (RobotTestCase testCase: testCases) {
        items.add((NavigationItem)testCase);
    }

    return items.toArray(new NavigationItem[items.size()]);
  }
}
