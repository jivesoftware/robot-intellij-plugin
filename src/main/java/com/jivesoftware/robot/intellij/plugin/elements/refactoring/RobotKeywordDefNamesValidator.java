package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.google.common.collect.Sets;
import com.intellij.lang.refactoring.NamesValidator;
import com.intellij.openapi.project.Project;
import com.jivesoftware.robot.intellij.plugin.elements.RobotElementFactory;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Created by charles.capps on 6/5/14.
 */
public class RobotKeywordDefNamesValidator implements NamesValidator {
  //TODO: find a good way to get the build-in Robot keywords within Java
  private final static Set<String> buildInKeywords = Sets.newHashSet("callmethod", "catenate", "comment", "continueforloop");
  @Override
  public boolean isKeyword(@NotNull String s, Project project) {
    return !buildInKeywords.contains(RobotPsiUtil.robotKeywordToMethodFast(s).toLowerCase());
  }

  @Override
  public boolean isIdentifier(@NotNull String s, Project project) {
    return RobotElementFactory.createKeyword(project, s) != null;
  }
}
