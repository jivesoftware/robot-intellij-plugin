package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.tree.IFileElementType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;

public class RobotFileElementType extends IFileElementType {

  public static final RobotFileElementType INSTANCE = new RobotFileElementType();

  private RobotFileElementType() {
    super("Robot File Element Type", RobotLanguage.INSTANCE);
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof RobotFileElementType;
  }
}
