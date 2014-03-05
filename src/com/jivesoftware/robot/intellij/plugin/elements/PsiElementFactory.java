package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.parser.RobotElement;

import java.lang.reflect.Constructor;

public class PsiElementFactory {
  public static <T extends BaseRobotPsiElement> T create(ASTNode node) {
    IElementType elementType = node.getElementType();
    if (!(elementType instanceof RobotElement)) {
      return null;
    }
    Class elementClass = getClassByElementType((RobotElement)elementType);
    if (elementClass == null) {
      return null;
    }
    Constructor constructor;
    try {
      constructor = elementClass.getConstructor(ASTNode.class);
      return (T) constructor.newInstance(node);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static Class<? extends BaseRobotPsiElement> getClassByElementType(RobotElement elementType) {
    if (elementType.equals(RobotElement.ROBOT_KEYWORD_EL)) {
      return RobotKeywordElement.class;
    }
    if (elementType.equals(RobotElement.ROBOT_ROOT_EL)) {
      return RobotRootElement.class;
    }
    if (elementType.equals(RobotElement.ROBOT_OTHER_EL)) {
      return RobotOtherElement.class;
    }
    return null;
  }
}
