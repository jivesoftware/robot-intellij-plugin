package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.parser.RobotElementType;
import com.jivesoftware.robot.intellij.plugin.parser.RobotFileElementType;

import java.lang.reflect.Constructor;

public class PsiElementFactory {
  public static <T extends BaseRobotPsiElement> T create(ASTNode node) {
    IElementType elementType = node.getElementType();
    if (!(elementType instanceof RobotElementType) && !(elementType instanceof RobotFileElementType)) {
      System.err.println("Error: element of ASTNode is invalid. Type is: " + elementType.getClass().getSimpleName());
      return null;
    }
    Class elementClass = getClassByElementType((RobotElementType)elementType);
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

  private static Class<? extends BaseRobotPsiElement> getClassByElementType(RobotElementType elementType) {
    if (elementType.equals(RobotFileElementType.INSTANCE)) {
      return RobotRootElement.class;
    }
    if (elementType.equals(RobotElementType.ROBOT_KEYWORD_EL)) {
      return RobotKeywordElement.class;
    }
    if (elementType.equals(RobotElementType.ROBOT_OTHER_EL)) {
      return RobotOtherElement.class;
    }
    return null;
  }
}
