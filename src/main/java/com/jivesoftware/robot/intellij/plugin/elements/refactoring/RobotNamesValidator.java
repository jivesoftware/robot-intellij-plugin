package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.google.common.collect.Sets;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;
import com.jgoodies.common.base.Objects;
import com.jivesoftware.robot.intellij.plugin.elements.RobotBuiltInKeywords;
import com.jivesoftware.robot.intellij.plugin.elements.RobotElementFactory;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by charles.capps on 6/5/14.
 */
public class RobotNamesValidator implements NamesValidator {
  //TODO: find a good way to get the build-in Robot keywords within Java
  private final static Set<String> buildInKeywords = Sets.newHashSet("callmethod", "catenate", "comment", "continueforloop");
  @Override
  public boolean isKeyword(@NotNull String s, Project project) {
      String normalName = RobotPsiUtil.normalizeKeywordForIndex(s);
      return RobotBuiltInKeywords.isBuiltInKeyword(normalName);
  }

  @Override
  public boolean isIdentifier(@NotNull String s, Project project) {
      // It's bad practice to have $, {, or } in Robot keywords, even if it's technically allowed.
      if (s.contains("$") || s.contains("{") || s.contains("}")) {
          return false;
      }
      RobotKeyword keyword = RobotElementFactory.createKeyword(project, s);
      return keyword != null && Objects.equals(s, keyword.getText());
  }
}
