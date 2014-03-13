// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RobotParser implements PsiParser {

  public static final Logger LOG_ = Logger.getInstance("com.jivesoftware.robot.intellij.plugin.parser.RobotParser");

  public ASTNode parse(IElementType root_, PsiBuilder builder_) {
    boolean result_;
    builder_ = adapt_builder_(root_, builder_, this, null);
    Marker marker_ = enter_section_(builder_, 0, _COLLAPSE_, null);
    if (root_ == ROBOT_KEYWORD_EL) {
      result_ = ROBOT_KEYWORD_EL(builder_, 0);
    }
    else if (root_ == ROBOT_OTHER_EL) {
      result_ = ROBOT_OTHER_EL(builder_, 0);
    }
    else {
      result_ = parse_root_(root_, builder_, 0);
    }
    exit_section_(builder_, 0, marker_, root_, result_, true, TRUE_CONDITION);
    return builder_.getTreeBuilt();
  }

  protected boolean parse_root_(final IElementType root_, final PsiBuilder builder_, final int level_) {
    return robotFile(builder_, level_ + 1);
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_TOKEN
  public static boolean ROBOT_KEYWORD_EL(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ROBOT_KEYWORD_EL")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ROBOT_KEYWORD_TOKEN);
    exit_section_(builder_, marker_, ROBOT_KEYWORD_EL, result_);
    return result_;
  }

  /* ********************************************************** */
  // TABLE_HEADING_TOKEN|TEST_CASES_TABLE_HEADING_TOKEN|TEST_CASE_HEADER_TOKEN|ROBOT_KEYWORD_ARG_TOKEN|COMMENT_TOKEN|VARIABLE_TOKEN
  //                         |ASSIGNMENT_TOKEN|META_INFO_TOKEN|NUMBER_LITERAL_TOKEN|COLUMN_SEP_TOKEN|SINGLE_SPACE_TOKEN|NEWLINE_TOKEN|BAD_CHAR_TOKEN|TAG_TOKEN|DOCUMENTATION_TOKEN
  public static boolean ROBOT_OTHER_EL(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ROBOT_OTHER_EL")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<robot other el>");
    result_ = consumeToken(builder_, TABLE_HEADING_TOKEN);
    if (!result_) result_ = consumeToken(builder_, TEST_CASES_TABLE_HEADING_TOKEN);
    if (!result_) result_ = consumeToken(builder_, TEST_CASE_HEADER_TOKEN);
    if (!result_) result_ = consumeToken(builder_, ROBOT_KEYWORD_ARG_TOKEN);
    if (!result_) result_ = consumeToken(builder_, COMMENT_TOKEN);
    if (!result_) result_ = consumeToken(builder_, VARIABLE_TOKEN);
    if (!result_) result_ = consumeToken(builder_, ASSIGNMENT_TOKEN);
    if (!result_) result_ = consumeToken(builder_, META_INFO_TOKEN);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL_TOKEN);
    if (!result_) result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    if (!result_) result_ = consumeToken(builder_, SINGLE_SPACE_TOKEN);
    if (!result_) result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = consumeToken(builder_, BAD_CHAR_TOKEN);
    if (!result_) result_ = consumeToken(builder_, TAG_TOKEN);
    if (!result_) result_ = consumeToken(builder_, DOCUMENTATION_TOKEN);
    exit_section_(builder_, level_, marker_, ROBOT_OTHER_EL, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_EL|ROBOT_OTHER_EL
  static boolean item(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "item")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ROBOT_KEYWORD_EL(builder_, level_ + 1);
    if (!result_) result_ = ROBOT_OTHER_EL(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // item*
  static boolean robotFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "robotFile")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!item(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "robotFile", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

}
