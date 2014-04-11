package com.jivesoftware.robot.intellij.plugin.lexer;


import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;

public final class RobotToken extends IElementType {

  public RobotToken(String name) {
    super(name, RobotLanguage.INSTANCE);
  }

}
