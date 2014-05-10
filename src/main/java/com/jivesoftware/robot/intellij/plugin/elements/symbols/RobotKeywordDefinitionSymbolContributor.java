package com.jivesoftware.robot.intellij.plugin.elements.symbols;

import com.google.common.collect.Lists;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RobotKeywordDefinitionSymbolContributor implements ChooseByNameContributor {
  @NotNull
  @Override
  public String[] getNames(Project project, boolean includeNonProjectItems) {
    List<String> names = Lists.newArrayList();
    List<RobotKeywordDef> keywordDefs = RobotPsiUtil.findRobotKeywordDefs(project);
    for (RobotKeywordDef keywordDef: keywordDefs) {
      names.add(keywordDef.getText());
    }
    return names.toArray(new String[names.size()]);
  }

  @NotNull
  @Override
  public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
    List<RobotKeywordDef> keywordDefs = RobotPsiUtil.findKeywordDefsByName(name, project);
    return keywordDefs.toArray(new NavigationItem[keywordDefs.size()]);
  }
}
