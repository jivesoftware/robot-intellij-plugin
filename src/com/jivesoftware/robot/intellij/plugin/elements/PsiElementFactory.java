package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.parser.RobotElementType;

import java.lang.reflect.Constructor;

public class PsiElementFactory {
  public static <T extends BaseRobotPsiElement> T create(ASTNode node) {
    IElementType elementType = node.getElementType();
    if (!(elementType instanceof RobotElementType)) {
      System.err.println("Error: element of ASTNode is invalid. Type is: " + elementType.getClass().getSimpleName());
      return null;
    }
    Class elementClass = getClassByElementType(elementType);
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

  private static Class<? extends BaseRobotPsiElement> getClassByElementType(IElementType elementType) {
    if (elementType.equals(RobotElementType.ROBOT_ROOT_EL)) {
      return RobotRootElement.class;
    }
    if (elementType.equals(RobotElementType.ROBOT_KEYWORD_EL)) {
      return RobotKeywordElement.class;
    }
    if (elementType.equals(RobotElementType.ROBOT_OTHER_EL)) {
      return RobotOtherElement.class;
    }
    //Can not reach this unless we didn't register all types, because we checked above that we have a RobotElementType
    throw new RuntimeException("Invalid elementType: " + elementType);
  }
}
