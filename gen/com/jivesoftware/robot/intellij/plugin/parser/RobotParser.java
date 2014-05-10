// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.openapi.diagnostic.Logger;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotTypes.*;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotParserUtil.*;
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
    if (root_ == ARGUMENTS_SETTING) {
      result_ = ARGUMENTS_SETTING(builder_, 0);
    }
    else if (root_ == ARGUMENT_DEF) {
      result_ = ARGUMENT_DEF(builder_, 0);
    }
    else if (root_ == ARRAY_ASSIGNABLE) {
      result_ = ARRAY_ASSIGNABLE(builder_, 0);
    }
    else if (root_ == ASSIGNABLE) {
      result_ = ASSIGNABLE(builder_, 0);
    }
    else if (root_ == COMMENT) {
      result_ = COMMENT(builder_, 0);
    }
    else if (root_ == DOCUMENTATION_SETTING) {
      result_ = DOCUMENTATION_SETTING(builder_, 0);
    }
    else if (root_ == EMPTY_LINE) {
      result_ = EMPTY_LINE(builder_, 0);
    }
    else if (root_ == ERROR) {
      result_ = ERROR(builder_, 0);
    }
    else if (root_ == KEYWORD) {
      result_ = KEYWORD(builder_, 0);
    }
    else if (root_ == KEYWORDS_TABLE) {
      result_ = KEYWORDS_TABLE(builder_, 0);
    }
    else if (root_ == KEYWORDS_TABLE_HEADING) {
      result_ = KEYWORDS_TABLE_HEADING(builder_, 0);
    }
    else if (root_ == KEYWORD_ARG) {
      result_ = KEYWORD_ARG(builder_, 0);
    }
    else if (root_ == KEYWORD_DEF) {
      result_ = KEYWORD_DEF(builder_, 0);
    }
    else if (root_ == KEYWORD_DEFINITION) {
      result_ = KEYWORD_DEFINITION(builder_, 0);
    }
    else if (root_ == KEYWORD_DEFINITION_HEADER) {
      result_ = KEYWORD_DEFINITION_HEADER(builder_, 0);
    }
    else if (root_ == KEYWORD_INVOCATION) {
      result_ = KEYWORD_INVOCATION(builder_, 0);
    }
    else if (root_ == KEYWORD_LINE) {
      result_ = KEYWORD_LINE(builder_, 0);
    }
    else if (root_ == KEYWORD_SETTING) {
      result_ = KEYWORD_SETTING(builder_, 0);
    }
    else if (root_ == KEYWORD_SETTINGS) {
      result_ = KEYWORD_SETTINGS(builder_, 0);
    }
    else if (root_ == KEYWORD_SETTING_LINE) {
      result_ = KEYWORD_SETTING_LINE(builder_, 0);
    }
    else if (root_ == OTHER) {
      result_ = OTHER(builder_, 0);
    }
    else if (root_ == RETURN_LINE) {
      result_ = RETURN_LINE(builder_, 0);
    }
    else if (root_ == RETURN_SETTING) {
      result_ = RETURN_SETTING(builder_, 0);
    }
    else if (root_ == ROBOT_TABLE) {
      result_ = ROBOT_TABLE(builder_, 0);
    }
    else if (root_ == SETTING) {
      result_ = SETTING(builder_, 0);
    }
    else if (root_ == SETTINGS_LINE) {
      result_ = SETTINGS_LINE(builder_, 0);
    }
    else if (root_ == SETTINGS_TABLE) {
      result_ = SETTINGS_TABLE(builder_, 0);
    }
    else if (root_ == SETTINGS_TABLE_HEADING) {
      result_ = SETTINGS_TABLE_HEADING(builder_, 0);
    }
    else if (root_ == SETUP_SETTING) {
      result_ = SETUP_SETTING(builder_, 0);
    }
    else if (root_ == TAG) {
      result_ = TAG(builder_, 0);
    }
    else if (root_ == TAGS_SETTING) {
      result_ = TAGS_SETTING(builder_, 0);
    }
    else if (root_ == TEARDOWN_SETTING) {
      result_ = TEARDOWN_SETTING(builder_, 0);
    }
    else if (root_ == TEMPLATE_SETTING) {
      result_ = TEMPLATE_SETTING(builder_, 0);
    }
    else if (root_ == TESTCASE_LINE) {
      result_ = TESTCASE_LINE(builder_, 0);
    }
    else if (root_ == TEST_CASE) {
      result_ = TEST_CASE(builder_, 0);
    }
    else if (root_ == TEST_CASES_TABLE) {
      result_ = TEST_CASES_TABLE(builder_, 0);
    }
    else if (root_ == TEST_CASES_TABLE_HEADING) {
      result_ = TEST_CASES_TABLE_HEADING(builder_, 0);
    }
    else if (root_ == TEST_CASE_HEADER) {
      result_ = TEST_CASE_HEADER(builder_, 0);
    }
    else if (root_ == TEST_CASE_SETTINGS) {
      result_ = TEST_CASE_SETTINGS(builder_, 0);
    }
    else if (root_ == TEST_SETTING) {
      result_ = TEST_SETTING(builder_, 0);
    }
    else if (root_ == TEST_SETTING_LINE) {
      result_ = TEST_SETTING_LINE(builder_, 0);
    }
    else if (root_ == TIMEOUT_SETTING) {
      result_ = TIMEOUT_SETTING(builder_, 0);
    }
    else if (root_ == VARIABLES_LINE) {
      result_ = VARIABLES_LINE(builder_, 0);
    }
    else if (root_ == VARIABLES_TABLE) {
      result_ = VARIABLES_TABLE(builder_, 0);
    }
    else if (root_ == VARIABLES_TABLE_HEADING) {
      result_ = VARIABLES_TABLE_HEADING(builder_, 0);
    }
    else if (root_ == VARIABLE_ASSIGN_TO_KEYWORD) {
      result_ = VARIABLE_ASSIGN_TO_KEYWORD(builder_, 0);
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
  // ARGUMENTS_SETTING_TOKEN ARGUMENT_DEF*
  public static boolean ARGUMENTS_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARGUMENTS_SETTING")) return false;
    if (!nextTokenIs(builder_, ARGUMENTS_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ARGUMENTS_SETTING_TOKEN);
    result_ = result_ && ARGUMENTS_SETTING_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, ARGUMENTS_SETTING, result_);
    return result_;
  }

  // ARGUMENT_DEF*
  private static boolean ARGUMENTS_SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARGUMENTS_SETTING_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!ARGUMENT_DEF(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ARGUMENTS_SETTING_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLE_TOKEN | ASSIGNMENT_TOKEN KEYWORD_ARG
  public static boolean ARGUMENT_DEF(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARGUMENT_DEF")) return false;
    if (!nextTokenIs(builder_, "<argument def>", ASSIGNMENT_TOKEN, VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<argument def>");
    result_ = consumeToken(builder_, VARIABLE_TOKEN);
    if (!result_) result_ = ARGUMENT_DEF_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ARGUMENT_DEF, result_, false, null);
    return result_;
  }

  // ASSIGNMENT_TOKEN KEYWORD_ARG
  private static boolean ARGUMENT_DEF_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARGUMENT_DEF_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ASSIGNMENT_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD_INVOCATION | KEYWORD_ARG (COLUMN_SEP_TOKEN KEYWORD_ARG)*
  public static boolean ARRAY_ASSIGNABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNABLE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<array assignable>");
    result_ = KEYWORD_INVOCATION(builder_, level_ + 1);
    if (!result_) result_ = ARRAY_ASSIGNABLE_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ARRAY_ASSIGNABLE, result_, false, null);
    return result_;
  }

  // KEYWORD_ARG (COLUMN_SEP_TOKEN KEYWORD_ARG)*
  private static boolean ARRAY_ASSIGNABLE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNABLE_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG(builder_, level_ + 1);
    result_ = result_ && ARRAY_ASSIGNABLE_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN KEYWORD_ARG)*
  private static boolean ARRAY_ASSIGNABLE_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNABLE_1_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!ARRAY_ASSIGNABLE_1_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ARRAY_ASSIGNABLE_1_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN KEYWORD_ARG
  private static boolean ARRAY_ASSIGNABLE_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNABLE_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD_INVOCATION | KEYWORD_ARG
  public static boolean ASSIGNABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ASSIGNABLE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<assignable>");
    result_ = KEYWORD_INVOCATION(builder_, level_ + 1);
    if (!result_) result_ = KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ASSIGNABLE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // COMMENT_TOKEN
  public static boolean COMMENT(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "COMMENT")) return false;
    if (!nextTokenIs(builder_, COMMENT_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COMMENT_TOKEN);
    exit_section_(builder_, marker_, COMMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // DOCUMENTATION_SETTING_TOKEN   COLUMN_SEP_TOKEN  DOCUMENTATION_TOKEN
  public static boolean DOCUMENTATION_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOCUMENTATION_SETTING")) return false;
    if (!nextTokenIs(builder_, DOCUMENTATION_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, DOCUMENTATION_SETTING_TOKEN, COLUMN_SEP_TOKEN, DOCUMENTATION_TOKEN);
    exit_section_(builder_, marker_, DOCUMENTATION_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // (WHITESPACE_TOKEN* | COMMENT_TOKEN)* NEWLINE_TOKEN
  public static boolean EMPTY_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EMPTY_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<empty line>");
    result_ = EMPTY_LINE_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, level_, marker_, EMPTY_LINE, result_, false, null);
    return result_;
  }

  // (WHITESPACE_TOKEN* | COMMENT_TOKEN)*
  private static boolean EMPTY_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EMPTY_LINE_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!EMPTY_LINE_0_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "EMPTY_LINE_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // WHITESPACE_TOKEN* | COMMENT_TOKEN
  private static boolean EMPTY_LINE_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EMPTY_LINE_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = EMPTY_LINE_0_0_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, COMMENT_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // WHITESPACE_TOKEN*
  private static boolean EMPTY_LINE_0_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EMPTY_LINE_0_0_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!consumeToken(builder_, WHITESPACE_TOKEN)) break;
      if (!empty_element_parsed_guard_(builder_, "EMPTY_LINE_0_0_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // BAD_SYNTAX_TOKEN
  public static boolean ERROR(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ERROR")) return false;
    if (!nextTokenIs(builder_, BAD_SYNTAX_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, BAD_SYNTAX_TOKEN);
    exit_section_(builder_, marker_, ERROR, result_);
    return result_;
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_TOKEN
  public static boolean KEYWORD(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ROBOT_KEYWORD_TOKEN);
    exit_section_(builder_, marker_, KEYWORD, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORDS_TABLE_HEADING (EMPTY_LINE* KEYWORD_DEFINITION)*
  public static boolean KEYWORDS_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE")) return false;
    if (!nextTokenIs(builder_, KEYWORDS_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORDS_TABLE_HEADING(builder_, level_ + 1);
    result_ = result_ && KEYWORDS_TABLE_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, KEYWORDS_TABLE, result_);
    return result_;
  }

  // (EMPTY_LINE* KEYWORD_DEFINITION)*
  private static boolean KEYWORDS_TABLE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!KEYWORDS_TABLE_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORDS_TABLE_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // EMPTY_LINE* KEYWORD_DEFINITION
  private static boolean KEYWORDS_TABLE_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORDS_TABLE_1_0_0(builder_, level_ + 1);
    result_ = result_ && KEYWORD_DEFINITION(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // EMPTY_LINE*
  private static boolean KEYWORDS_TABLE_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE_1_0_0")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!EMPTY_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORDS_TABLE_1_0_0", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // KEYWORDS_TABLE_HEADING_TOKEN  NEWLINE_TOKEN
  public static boolean KEYWORDS_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, KEYWORDS_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, KEYWORDS_TABLE_HEADING_TOKEN, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, KEYWORDS_TABLE_HEADING, result_);
    return result_;
  }

  /* ********************************************************** */
  // VARIABLE_TOKEN | NUMBER_LITERAL_TOKEN | ROBOT_KEYWORD_ARG_TOKEN
  public static boolean KEYWORD_ARG(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_ARG")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword arg>");
    result_ = consumeToken(builder_, VARIABLE_TOKEN);
    if (!result_) result_ = consumeToken(builder_, NUMBER_LITERAL_TOKEN);
    if (!result_) result_ = consumeToken(builder_, ROBOT_KEYWORD_ARG_TOKEN);
    exit_section_(builder_, level_, marker_, KEYWORD_ARG, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_DEF_TOKEN
  public static boolean KEYWORD_DEF(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEF")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_DEF_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ROBOT_KEYWORD_DEF_TOKEN);
    exit_section_(builder_, marker_, KEYWORD_DEF, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD_DEFINITION_HEADER KEYWORD_SETTINGS KEYWORD_LINE* RETURN_LINE?
  public static boolean KEYWORD_DEFINITION(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEFINITION")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_DEF_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_DEFINITION_HEADER(builder_, level_ + 1);
    result_ = result_ && KEYWORD_SETTINGS(builder_, level_ + 1);
    result_ = result_ && KEYWORD_DEFINITION_2(builder_, level_ + 1);
    result_ = result_ && KEYWORD_DEFINITION_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, KEYWORD_DEFINITION, result_);
    return result_;
  }

  // KEYWORD_LINE*
  private static boolean KEYWORD_DEFINITION_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEFINITION_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!KEYWORD_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORD_DEFINITION_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // RETURN_LINE?
  private static boolean KEYWORD_DEFINITION_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEFINITION_3")) return false;
    RETURN_LINE(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // KEYWORD_DEF NEWLINE_TOKEN
  public static boolean KEYWORD_DEFINITION_HEADER(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEFINITION_HEADER")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_DEF_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_DEF(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, KEYWORD_DEFINITION_HEADER, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD (COLUMN_SEP_TOKEN KEYWORD_ARG)*
  public static boolean KEYWORD_INVOCATION(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD(builder_, level_ + 1);
    result_ = result_ && KEYWORD_INVOCATION_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, KEYWORD_INVOCATION, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN KEYWORD_ARG)*
  private static boolean KEYWORD_INVOCATION_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!KEYWORD_INVOCATION_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORD_INVOCATION_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN KEYWORD_ARG
  private static boolean KEYWORD_INVOCATION_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ( KEYWORD_INVOCATION | VARIABLE_ASSIGN_TO_KEYWORD ) NEWLINE_TOKEN  | EMPTY_LINE
  public static boolean KEYWORD_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword line>");
    result_ = KEYWORD_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, KEYWORD_LINE, result_, false, null);
    return result_;
  }

  // ( KEYWORD_INVOCATION | VARIABLE_ASSIGN_TO_KEYWORD ) NEWLINE_TOKEN
  private static boolean KEYWORD_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_LINE_0_0(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // KEYWORD_INVOCATION | VARIABLE_ASSIGN_TO_KEYWORD
  private static boolean KEYWORD_LINE_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_LINE_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_INVOCATION(builder_, level_ + 1);
    if (!result_) result_ = VARIABLE_ASSIGN_TO_KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ARGUMENTS_SETTING | DOCUMENTATION_SETTING | TEARDOWN_SETTING | TIMEOUT_SETTING
  public static boolean KEYWORD_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTING")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword setting>");
    result_ = ARGUMENTS_SETTING(builder_, level_ + 1);
    if (!result_) result_ = DOCUMENTATION_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEARDOWN_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TIMEOUT_SETTING(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, KEYWORD_SETTING, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD_SETTING_LINE*
  public static boolean KEYWORD_SETTINGS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTINGS")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword settings>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!KEYWORD_SETTING_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORD_SETTINGS", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, KEYWORD_SETTINGS, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // KEYWORD_SETTING NEWLINE_TOKEN | EMPTY_LINE
  public static boolean KEYWORD_SETTING_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTING_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword setting line>");
    result_ = KEYWORD_SETTING_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, KEYWORD_SETTING_LINE, result_, false, null);
    return result_;
  }

  // KEYWORD_SETTING NEWLINE_TOKEN
  private static boolean KEYWORD_SETTING_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTING_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_SETTING(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // WHITESPACE_TOKEN | COLUMN_SEP_TOKEN | SINGLE_SPACE_TOKEN
  public static boolean OTHER(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "OTHER")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<other>");
    result_ = consumeToken(builder_, WHITESPACE_TOKEN);
    if (!result_) result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    if (!result_) result_ = consumeToken(builder_, SINGLE_SPACE_TOKEN);
    exit_section_(builder_, level_, marker_, OTHER, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // RETURN_SETTING NEWLINE_TOKEN
  public static boolean RETURN_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RETURN_LINE")) return false;
    if (!nextTokenIs(builder_, RETURN_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = RETURN_SETTING(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, RETURN_LINE, result_);
    return result_;
  }

  /* ********************************************************** */
  // RETURN_SETTING_TOKEN  ROBOT_KEYWORD_ARG_TOKEN+
  public static boolean RETURN_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RETURN_SETTING")) return false;
    if (!nextTokenIs(builder_, RETURN_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, RETURN_SETTING_TOKEN);
    result_ = result_ && RETURN_SETTING_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, RETURN_SETTING, result_);
    return result_;
  }

  // ROBOT_KEYWORD_ARG_TOKEN+
  private static boolean RETURN_SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RETURN_SETTING_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ROBOT_KEYWORD_ARG_TOKEN);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!consumeToken(builder_, ROBOT_KEYWORD_ARG_TOKEN)) break;
      if (!empty_element_parsed_guard_(builder_, "RETURN_SETTING_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SETTINGS_TABLE|VARIABLES_TABLE|TEST_CASES_TABLE|KEYWORDS_TABLE
  public static boolean ROBOT_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ROBOT_TABLE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<robot table>");
    result_ = SETTINGS_TABLE(builder_, level_ + 1);
    if (!result_) result_ = VARIABLES_TABLE(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASES_TABLE(builder_, level_ + 1);
    if (!result_) result_ = KEYWORDS_TABLE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ROBOT_TABLE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // FORCE_TAGS_SETTING_KEYWORD_TOKEN (COLUMN_SEP_TOKEN TAG_TOKEN)* |
  //             ROBOT_KEYWORD_TOKEN (COLUMN_SEP_TOKEN ROBOT_KEYWORD_ARG_TOKEN)*
  public static boolean SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING")) return false;
    if (!nextTokenIs(builder_, "<setting>", FORCE_TAGS_SETTING_KEYWORD_TOKEN, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<setting>");
    result_ = SETTING_0(builder_, level_ + 1);
    if (!result_) result_ = SETTING_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SETTING, result_, false, null);
    return result_;
  }

  // FORCE_TAGS_SETTING_KEYWORD_TOKEN (COLUMN_SEP_TOKEN TAG_TOKEN)*
  private static boolean SETTING_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FORCE_TAGS_SETTING_KEYWORD_TOKEN);
    result_ = result_ && SETTING_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN TAG_TOKEN)*
  private static boolean SETTING_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_0_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!SETTING_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SETTING_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN TAG_TOKEN
  private static boolean SETTING_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, TAG_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ROBOT_KEYWORD_TOKEN (COLUMN_SEP_TOKEN ROBOT_KEYWORD_ARG_TOKEN)*
  private static boolean SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ROBOT_KEYWORD_TOKEN);
    result_ = result_ && SETTING_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN ROBOT_KEYWORD_ARG_TOKEN)*
  private static boolean SETTING_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_1_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!SETTING_1_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SETTING_1_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN ROBOT_KEYWORD_ARG_TOKEN
  private static boolean SETTING_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, ROBOT_KEYWORD_ARG_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SETTING NEWLINE_TOKEN | EMPTY_LINE
  public static boolean SETTINGS_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<settings line>");
    result_ = SETTINGS_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SETTINGS_LINE, result_, false, null);
    return result_;
  }

  // SETTING NEWLINE_TOKEN
  private static boolean SETTINGS_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = SETTING(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SETTINGS_TABLE_HEADING SETTINGS_LINE*
  public static boolean SETTINGS_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_TABLE")) return false;
    if (!nextTokenIs(builder_, SETTINGS_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = SETTINGS_TABLE_HEADING(builder_, level_ + 1);
    result_ = result_ && SETTINGS_TABLE_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, SETTINGS_TABLE, result_);
    return result_;
  }

  // SETTINGS_LINE*
  private static boolean SETTINGS_TABLE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_TABLE_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!SETTINGS_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SETTINGS_TABLE_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // SETTINGS_TABLE_HEADING_TOKEN NEWLINE_TOKEN
  public static boolean SETTINGS_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, SETTINGS_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, SETTINGS_TABLE_HEADING_TOKEN, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, SETTINGS_TABLE_HEADING, result_);
    return result_;
  }

  /* ********************************************************** */
  // SETUP_SETTING_TOKEN  COLUMN_SEP_TOKEN KEYWORD_INVOCATION
  public static boolean SETUP_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETUP_SETTING")) return false;
    if (!nextTokenIs(builder_, SETUP_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, SETUP_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION(builder_, level_ + 1);
    exit_section_(builder_, marker_, SETUP_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // TAG_TOKEN
  public static boolean TAG(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAG")) return false;
    if (!nextTokenIs(builder_, TAG_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TAG_TOKEN);
    exit_section_(builder_, marker_, TAG, result_);
    return result_;
  }

  /* ********************************************************** */
  // TAGS_SETTING_TOKEN  (COLUMN_SEP_TOKEN TAG)*
  public static boolean TAGS_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAGS_SETTING")) return false;
    if (!nextTokenIs(builder_, TAGS_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TAGS_SETTING_TOKEN);
    result_ = result_ && TAGS_SETTING_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, TAGS_SETTING, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN TAG)*
  private static boolean TAGS_SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAGS_SETTING_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!TAGS_SETTING_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TAGS_SETTING_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN TAG
  private static boolean TAGS_SETTING_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAGS_SETTING_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && TAG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEARDOWN_SETTING_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION
  public static boolean TEARDOWN_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEARDOWN_SETTING")) return false;
    if (!nextTokenIs(builder_, TEARDOWN_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TEARDOWN_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEARDOWN_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEMPLATE_SETTING_TOKEN COLUMN_SEP_TOKEN ROBOT_KEYWORD_TOKEN
  public static boolean TEMPLATE_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEMPLATE_SETTING")) return false;
    if (!nextTokenIs(builder_, TEMPLATE_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TEMPLATE_SETTING_TOKEN, COLUMN_SEP_TOKEN, ROBOT_KEYWORD_TOKEN);
    exit_section_(builder_, marker_, TEMPLATE_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN KEYWORD_INVOCATION NEWLINE_TOKEN |
  //                   COLUMN_SEP_TOKEN ASSIGNMENT_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION NEWLINE_TOKEN |
  //                   COLUMN_SEP_TOKEN ARRAY_ASSIGNMENT_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION NEWLINE_TOKEN |
  //                   EMPTY_LINE
  public static boolean TESTCASE_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<testcase line>");
    result_ = TESTCASE_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = TESTCASE_LINE_1(builder_, level_ + 1);
    if (!result_) result_ = TESTCASE_LINE_2(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TESTCASE_LINE, result_, false, null);
    return result_;
  }

  // COLUMN_SEP_TOKEN KEYWORD_INVOCATION NEWLINE_TOKEN
  private static boolean TESTCASE_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN ASSIGNMENT_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION NEWLINE_TOKEN
  private static boolean TESTCASE_LINE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, ASSIGNMENT_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN ARRAY_ASSIGNMENT_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION NEWLINE_TOKEN
  private static boolean TESTCASE_LINE_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, ARRAY_ASSIGNMENT_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_CASE_HEADER TEST_CASE_SETTINGS TESTCASE_LINE+
  public static boolean TEST_CASE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE")) return false;
    if (!nextTokenIs(builder_, TEST_CASE_HEADER_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TEST_CASE_HEADER(builder_, level_ + 1);
    result_ = result_ && TEST_CASE_SETTINGS(builder_, level_ + 1);
    result_ = result_ && TEST_CASE_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_CASE, result_);
    return result_;
  }

  // TESTCASE_LINE+
  private static boolean TEST_CASE_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TESTCASE_LINE(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!TESTCASE_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TEST_CASE_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_CASES_TABLE_HEADING EMPTY_LINE* TEST_CASE*
  public static boolean TEST_CASES_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASES_TABLE")) return false;
    if (!nextTokenIs(builder_, TEST_CASES_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TEST_CASES_TABLE_HEADING(builder_, level_ + 1);
    result_ = result_ && TEST_CASES_TABLE_1(builder_, level_ + 1);
    result_ = result_ && TEST_CASES_TABLE_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_CASES_TABLE, result_);
    return result_;
  }

  // EMPTY_LINE*
  private static boolean TEST_CASES_TABLE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASES_TABLE_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!EMPTY_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TEST_CASES_TABLE_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // TEST_CASE*
  private static boolean TEST_CASES_TABLE_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASES_TABLE_2")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!TEST_CASE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TEST_CASES_TABLE_2", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // TEST_CASES_TABLE_HEADING_TOKEN NEWLINE_TOKEN
  public static boolean TEST_CASES_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASES_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, TEST_CASES_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TEST_CASES_TABLE_HEADING_TOKEN, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, TEST_CASES_TABLE_HEADING, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_CASE_HEADER_TOKEN  NEWLINE_TOKEN
  public static boolean TEST_CASE_HEADER(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_HEADER")) return false;
    if (!nextTokenIs(builder_, TEST_CASE_HEADER_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TEST_CASE_HEADER_TOKEN, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, TEST_CASE_HEADER, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_SETTING_LINE*
  public static boolean TEST_CASE_SETTINGS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_SETTINGS")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<test case settings>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!TEST_SETTING_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TEST_CASE_SETTINGS", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, TEST_CASE_SETTINGS, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // DOCUMENTATION_SETTING|TAGS_SETTING|SETUP_SETTING|TEARDOWN_SETTING|TEMPLATE_SETTING|TIMEOUT_SETTING
  public static boolean TEST_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETTING")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<test setting>");
    result_ = DOCUMENTATION_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TAGS_SETTING(builder_, level_ + 1);
    if (!result_) result_ = SETUP_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEARDOWN_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEMPLATE_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TIMEOUT_SETTING(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TEST_SETTING, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  TEST_SETTING  NEWLINE_TOKEN | EMPTY_LINE
  public static boolean TEST_SETTING_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETTING_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<test setting line>");
    result_ = TEST_SETTING_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TEST_SETTING_LINE, result_, false, null);
    return result_;
  }

  // COLUMN_SEP_TOKEN  TEST_SETTING  NEWLINE_TOKEN
  private static boolean TEST_SETTING_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETTING_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && TEST_SETTING(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TIMEOUT_SETTING_TOKEN COLUMN_SEP_TOKEN TIMEOUT_VALUE_TOKEN
  public static boolean TIMEOUT_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TIMEOUT_SETTING")) return false;
    if (!nextTokenIs(builder_, TIMEOUT_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TIMEOUT_SETTING_TOKEN, COLUMN_SEP_TOKEN, TIMEOUT_VALUE_TOKEN);
    exit_section_(builder_, marker_, TIMEOUT_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // (ASSIGNMENT_TOKEN | VARIABLE_TOKEN)  (COLUMN_SEP_TOKEN   ASSIGNABLE)?   NEWLINE_TOKEN |
  //                    (ARRAY_ASSIGNMENT_TOKEN | ARRAY_VARIABLE_TOKEN)  (COLUMN_SEP_TOKEN   ARRAY_ASSIGNABLE)?   NEWLINE_TOKEN |
  //                    EMPTY_LINE
  public static boolean VARIABLES_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<variables line>");
    result_ = VARIABLES_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = VARIABLES_LINE_1(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, VARIABLES_LINE, result_, false, null);
    return result_;
  }

  // (ASSIGNMENT_TOKEN | VARIABLE_TOKEN)  (COLUMN_SEP_TOKEN   ASSIGNABLE)?   NEWLINE_TOKEN
  private static boolean VARIABLES_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = VARIABLES_LINE_0_0(builder_, level_ + 1);
    result_ = result_ && VARIABLES_LINE_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ASSIGNMENT_TOKEN | VARIABLE_TOKEN
  private static boolean VARIABLES_LINE_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ASSIGNMENT_TOKEN);
    if (!result_) result_ = consumeToken(builder_, VARIABLE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN   ASSIGNABLE)?
  private static boolean VARIABLES_LINE_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0_1")) return false;
    VARIABLES_LINE_0_1_0(builder_, level_ + 1);
    return true;
  }

  // COLUMN_SEP_TOKEN   ASSIGNABLE
  private static boolean VARIABLES_LINE_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && ASSIGNABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (ARRAY_ASSIGNMENT_TOKEN | ARRAY_VARIABLE_TOKEN)  (COLUMN_SEP_TOKEN   ARRAY_ASSIGNABLE)?   NEWLINE_TOKEN
  private static boolean VARIABLES_LINE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = VARIABLES_LINE_1_0(builder_, level_ + 1);
    result_ = result_ && VARIABLES_LINE_1_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ARRAY_ASSIGNMENT_TOKEN | ARRAY_VARIABLE_TOKEN
  private static boolean VARIABLES_LINE_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ARRAY_ASSIGNMENT_TOKEN);
    if (!result_) result_ = consumeToken(builder_, ARRAY_VARIABLE_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN   ARRAY_ASSIGNABLE)?
  private static boolean VARIABLES_LINE_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1_1")) return false;
    VARIABLES_LINE_1_1_0(builder_, level_ + 1);
    return true;
  }

  // COLUMN_SEP_TOKEN   ARRAY_ASSIGNABLE
  private static boolean VARIABLES_LINE_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && ARRAY_ASSIGNABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // VARIABLES_TABLE_HEADING VARIABLES_LINE*
  public static boolean VARIABLES_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_TABLE")) return false;
    if (!nextTokenIs(builder_, VARIABLES_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = VARIABLES_TABLE_HEADING(builder_, level_ + 1);
    result_ = result_ && VARIABLES_TABLE_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, VARIABLES_TABLE, result_);
    return result_;
  }

  // VARIABLES_LINE*
  private static boolean VARIABLES_TABLE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_TABLE_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!VARIABLES_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "VARIABLES_TABLE_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLES_TABLE_HEADING_TOKEN NEWLINE_TOKEN
  public static boolean VARIABLES_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, VARIABLES_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, VARIABLES_TABLE_HEADING_TOKEN, NEWLINE_TOKEN);
    exit_section_(builder_, marker_, VARIABLES_TABLE_HEADING, result_);
    return result_;
  }

  /* ********************************************************** */
  // ASSIGNMENT_TOKEN  KEYWORD_INVOCATION
  public static boolean VARIABLE_ASSIGN_TO_KEYWORD(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLE_ASSIGN_TO_KEYWORD")) return false;
    if (!nextTokenIs(builder_, ASSIGNMENT_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ASSIGNMENT_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION(builder_, level_ + 1);
    exit_section_(builder_, marker_, VARIABLE_ASSIGN_TO_KEYWORD, result_);
    return result_;
  }

  /* ********************************************************** */
  // (ROBOT_TABLE|EMPTY_LINE)*
  static boolean robotFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "robotFile")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!robotFile_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "robotFile", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ROBOT_TABLE|EMPTY_LINE
  private static boolean robotFile_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "robotFile_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ROBOT_TABLE(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

}
