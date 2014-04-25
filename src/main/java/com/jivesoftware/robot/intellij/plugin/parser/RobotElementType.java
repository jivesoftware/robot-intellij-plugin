package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;

public class RobotElementType extends IElementType {

  public RobotElementType(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

}
