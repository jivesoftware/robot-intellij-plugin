package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;

public class RobotElement extends IElementType {

  public static enum EL_TYPE { ROBOT_ROOT, ROBOT_KEYWORD, ROBOT_OTHER };

  public static final RobotElement ROBOT_ROOT_EL = create(EL_TYPE.ROBOT_ROOT);
  public static final RobotElement ROBOT_KEYWORD_EL = create(EL_TYPE.ROBOT_KEYWORD);
  public static final RobotElement ROBOT_OTHER_EL = create(EL_TYPE.ROBOT_OTHER);

  private final EL_TYPE elType;

  private static RobotElement create(EL_TYPE elType) {
    return new RobotElement(elType);
  }

  private RobotElement(EL_TYPE elType) {
    super(elType.toString(), RobotLanguage.INSTANCE);
    this.elType = elType;
  }

  public EL_TYPE getElType() {
    return elType;
  }
}
