// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotToken;
import com.jivesoftware.robot.intellij.plugin.psi.impl.*;

public interface RobotTypes {

  IElementType ERROR_EL = new RobotElementType("ERROR_EL");
  IElementType KEYWORD_DEF_EL = new RobotElementType("KEYWORD_DEF_EL");
  IElementType KEYWORD_EL = new RobotElementType("KEYWORD_EL");
  IElementType OTHER_EL = new RobotElementType("OTHER_EL");
  IElementType TAG = new RobotElementType("TAG");

  IElementType ASSIGNMENT_TOKEN = new RobotToken("ASSIGNMENT_TOKEN");
  IElementType BAD_CHAR_TOKEN = new RobotToken("BAD_CHAR_TOKEN");
  IElementType COLUMN_SEP_TOKEN = new RobotToken("COLUMN_SEP_TOKEN");
  IElementType COMMENT_TOKEN = new RobotToken("COMMENT_TOKEN");
  IElementType DOCUMENTATION_TOKEN = new RobotToken("DOCUMENTATION_TOKEN");
  IElementType KEYWORDS_TABLE_HEADING_TOKEN = new RobotToken("KEYWORDS_TABLE_HEADING_TOKEN");
  IElementType META_INFO_TOKEN = new RobotToken("META_INFO_TOKEN");
  IElementType NEWLINE_TOKEN = new RobotToken("NEWLINE_TOKEN");
  IElementType NUMBER_LITERAL_TOKEN = new RobotToken("NUMBER_LITERAL_TOKEN");
  IElementType ROBOT_KEYWORD_ARG_TOKEN = new RobotToken("ROBOT_KEYWORD_ARG_TOKEN");
  IElementType ROBOT_KEYWORD_DEF_TOKEN = new RobotToken("ROBOT_KEYWORD_DEF_TOKEN");
  IElementType ROBOT_KEYWORD_TOKEN = new RobotToken("ROBOT_KEYWORD_TOKEN");
  IElementType SINGLE_SPACE_TOKEN = new RobotToken("SINGLE_SPACE_TOKEN");
  IElementType TABLE_HEADING_TOKEN = new RobotToken("TABLE_HEADING_TOKEN");
  IElementType TAG_TOKEN = new RobotToken("TAG_TOKEN");
  IElementType TEST_CASES_TABLE_HEADING_TOKEN = new RobotToken("TEST_CASES_TABLE_HEADING_TOKEN");
  IElementType TEST_CASE_HEADER_TOKEN = new RobotToken("TEST_CASE_HEADER_TOKEN");
  IElementType VARIABLE_TOKEN = new RobotToken("VARIABLE_TOKEN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ERROR_EL) {
        return new RobotErrorElImpl(node);
      }
      else if (type == KEYWORD_DEF_EL) {
        return new RobotKeywordDefElImpl(node);
      }
      else if (type == KEYWORD_EL) {
        return new RobotKeywordElImpl(node);
      }
      else if (type == OTHER_EL) {
        return new RobotOtherElImpl(node);
      }
      else if (type == TAG) {
        return new RobotTagImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
