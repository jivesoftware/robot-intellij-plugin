package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;

public class RobotElementType extends IElementType {

  public static enum EL_TYPE { ROBOT_KEYWORD, ROBOT_OTHER, ROBOT_ROOT };

  public static final RobotElementType ROBOT_ROOT_EL = create(EL_TYPE.ROBOT_ROOT);
  public static final RobotElementType ROBOT_KEYWORD_EL = create(EL_TYPE.ROBOT_KEYWORD);
  public static final RobotElementType ROBOT_OTHER_EL = create(EL_TYPE.ROBOT_OTHER);

  private final EL_TYPE elType;

  private static RobotElementType create(EL_TYPE elType) {
    return new RobotElementType(elType);
  }

  private RobotElementType(EL_TYPE elType) {
    super(elType.toString(), RobotLanguage.INSTANCE);
    this.elType = elType;
  }

  public EL_TYPE getElType() {
    return elType;
  }

  public boolean equals(Object o) {
    if (!(o instanceof RobotElementType)) {
      return false;
    }
    RobotElementType robotElementType = (RobotElementType) o;
    return robotElementType.elType == elType;
  }
}
