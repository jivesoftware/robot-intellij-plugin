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
    else if (root_ == ARRAY_ASSIGNABLE_IN_VARIABLES_TBL) {
      result_ = ARRAY_ASSIGNABLE_IN_VARIABLES_TBL(builder_, 0);
    }
    else if (root_ == ARRAY_ASSIGNMENT) {
      result_ = ARRAY_ASSIGNMENT(builder_, 0);
    }
    else if (root_ == ARRAY_ASSIGNMENT_LHS) {
      result_ = ARRAY_ASSIGNMENT_LHS(builder_, 0);
    }
    else if (root_ == ARRAY_ASSIGNMENT_NO_SPACE) {
      result_ = ARRAY_ASSIGNMENT_NO_SPACE(builder_, 0);
    }
    else if (root_ == ARRAY_VARIABLE) {
      result_ = ARRAY_VARIABLE(builder_, 0);
    }
    else if (root_ == ASSIGNABLE_IN_VARIABLES_TBL) {
      result_ = ASSIGNABLE_IN_VARIABLES_TBL(builder_, 0);
    }
    else if (root_ == ASSIGNMENT) {
      result_ = ASSIGNMENT(builder_, 0);
    }
    else if (root_ == ASSIGNMENT_NO_SPACE) {
      result_ = ASSIGNMENT_NO_SPACE(builder_, 0);
    }
    else if (root_ == DOCUMENTATION_SETTING) {
      result_ = DOCUMENTATION_SETTING(builder_, 0);
    }
    else if (root_ == DOUBLE_BOUND_FOR_LOOP) {
      result_ = DOUBLE_BOUND_FOR_LOOP(builder_, 0);
    }
    else if (root_ == DOUBLE_BOUND_FOR_LOOP_WITH_STEP) {
      result_ = DOUBLE_BOUND_FOR_LOOP_WITH_STEP(builder_, 0);
    }
    else if (root_ == ELLIPSES) {
      result_ = ELLIPSES(builder_, 0);
    }
    else if (root_ == ELLIPSES_FOR_SETTINGS_TABLE) {
      result_ = ELLIPSES_FOR_SETTINGS_TABLE(builder_, 0);
    }
    else if (root_ == ELLIPSES_FOR_TEST_TABLE) {
      result_ = ELLIPSES_FOR_TEST_TABLE(builder_, 0);
    }
    else if (root_ == ELLIPSES_LINE_SETTINGS) {
      result_ = ELLIPSES_LINE_SETTINGS(builder_, 0);
    }
    else if (root_ == ELLIPSES_LINE_TEST) {
      result_ = ELLIPSES_LINE_TEST(builder_, 0);
    }
    else if (root_ == EMPTY_LINE) {
      result_ = EMPTY_LINE(builder_, 0);
    }
    else if (root_ == END_OF_LINE) {
      result_ = END_OF_LINE(builder_, 0);
    }
    else if (root_ == ERROR) {
      result_ = ERROR(builder_, 0);
    }
    else if (root_ == FORCE_TAGS_SETTING) {
      result_ = FORCE_TAGS_SETTING(builder_, 0);
    }
    else if (root_ == FOR_LOOP_IN) {
      result_ = FOR_LOOP_IN(builder_, 0);
    }
    else if (root_ == FOR_LOOP_IN_RANGE) {
      result_ = FOR_LOOP_IN_RANGE(builder_, 0);
    }
    else if (root_ == FOR_LOOP_VALUE_LIST) {
      result_ = FOR_LOOP_VALUE_LIST(builder_, 0);
    }
    else if (root_ == FOR_VAR_IN) {
      result_ = FOR_VAR_IN(builder_, 0);
    }
    else if (root_ == FOR_VAR_IN_RANGE) {
      result_ = FOR_VAR_IN_RANGE(builder_, 0);
    }
    else if (root_ == GENERIC_SETTING) {
      result_ = GENERIC_SETTING(builder_, 0);
    }
    else if (root_ == INDENTED_ELLIPSES_FOR_TEST_TABLE) {
      result_ = INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, 0);
    }
    else if (root_ == INDENTED_ELLIPSES_LINE_TEST) {
      result_ = INDENTED_ELLIPSES_LINE_TEST(builder_, 0);
    }
    else if (root_ == INDENTED_KEYWORD_INVOCATION_TEST) {
      result_ = INDENTED_KEYWORD_INVOCATION_TEST(builder_, 0);
    }
    else if (root_ == INDENTED_KEYWORD_LINE) {
      result_ = INDENTED_KEYWORD_LINE(builder_, 0);
    }
    else if (root_ == INDENTED_VARIABLE_ASSIGN_TO_KEYWORD) {
      result_ = INDENTED_VARIABLE_ASSIGN_TO_KEYWORD(builder_, 0);
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
    else if (root_ == KEYWORD_ARG_LIST) {
      result_ = KEYWORD_ARG_LIST(builder_, 0);
    }
    else if (root_ == KEYWORD_DEFINITION) {
      result_ = KEYWORD_DEFINITION(builder_, 0);
    }
    else if (root_ == KEYWORD_DEFINITION_HEADER) {
      result_ = KEYWORD_DEFINITION_HEADER(builder_, 0);
    }
    else if (root_ == KEYWORD_INVOCATION_SETTINGS) {
      result_ = KEYWORD_INVOCATION_SETTINGS(builder_, 0);
    }
    else if (root_ == KEYWORD_INVOCATION_TEST) {
      result_ = KEYWORD_INVOCATION_TEST(builder_, 0);
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
    else if (root_ == KEYWORD_TITLE) {
      result_ = KEYWORD_TITLE(builder_, 0);
    }
    else if (root_ == MULTI_ASSIGNMENT_LHS) {
      result_ = MULTI_ASSIGNMENT_LHS(builder_, 0);
    }
    else if (root_ == RESOURCE_SETTING) {
      result_ = RESOURCE_SETTING(builder_, 0);
    }
    else if (root_ == RETURN_LINE) {
      result_ = RETURN_LINE(builder_, 0);
    }
    else if (root_ == RETURN_SETTING) {
      result_ = RETURN_SETTING(builder_, 0);
    }
    else if (root_ == SCALAR_ASSIGNMENT) {
      result_ = SCALAR_ASSIGNMENT(builder_, 0);
    }
    else if (root_ == SCALAR_ASSIGNMENT_LHS) {
      result_ = SCALAR_ASSIGNMENT_LHS(builder_, 0);
    }
    else if (root_ == SCALAR_ASSIGNMENT_NO_SPACE) {
      result_ = SCALAR_ASSIGNMENT_NO_SPACE(builder_, 0);
    }
    else if (root_ == SCALAR_DEFAULT_ARG_VALUE) {
      result_ = SCALAR_DEFAULT_ARG_VALUE(builder_, 0);
    }
    else if (root_ == SCALAR_VARIABLE) {
      result_ = SCALAR_VARIABLE(builder_, 0);
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
    else if (root_ == SETTING_LIST) {
      result_ = SETTING_LIST(builder_, 0);
    }
    else if (root_ == SETTING_LIST_OR_ELLIPSES) {
      result_ = SETTING_LIST_OR_ELLIPSES(builder_, 0);
    }
    else if (root_ == SINGLE_ASSIGNMENT_LHS) {
      result_ = SINGLE_ASSIGNMENT_LHS(builder_, 0);
    }
    else if (root_ == SINGLE_BOUND_FOR_LOOP) {
      result_ = SINGLE_BOUND_FOR_LOOP(builder_, 0);
    }
    else if (root_ == SINGLE_VARIABLE_LIST) {
      result_ = SINGLE_VARIABLE_LIST(builder_, 0);
    }
    else if (root_ == TABLE) {
      result_ = TABLE(builder_, 0);
    }
    else if (root_ == TAG) {
      result_ = TAG(builder_, 0);
    }
    else if (root_ == TAGS_SETTING) {
      result_ = TAGS_SETTING(builder_, 0);
    }
    else if (root_ == TAG_LIST) {
      result_ = TAG_LIST(builder_, 0);
    }
    else if (root_ == TAG_LIST_OR_ELLIPSES) {
      result_ = TAG_LIST_OR_ELLIPSES(builder_, 0);
    }
    else if (root_ == TAG_LIST_OR_ELLIPSES_NO_COL) {
      result_ = TAG_LIST_OR_ELLIPSES_NO_COL(builder_, 0);
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
    else if (root_ == TEST_CASE_SETUP_SETTING) {
      result_ = TEST_CASE_SETUP_SETTING(builder_, 0);
    }
    else if (root_ == TEST_CASE_TEARDOWN_SETTING) {
      result_ = TEST_CASE_TEARDOWN_SETTING(builder_, 0);
    }
    else if (root_ == TEST_CASE_TEMPLATE_SETTING) {
      result_ = TEST_CASE_TEMPLATE_SETTING(builder_, 0);
    }
    else if (root_ == TEST_CASE_TIMEOUT_SETTING) {
      result_ = TEST_CASE_TIMEOUT_SETTING(builder_, 0);
    }
    else if (root_ == TEST_SETTING) {
      result_ = TEST_SETTING(builder_, 0);
    }
    else if (root_ == TEST_SETTING_LINE) {
      result_ = TEST_SETTING_LINE(builder_, 0);
    }
    else if (root_ == TEST_SETUP_SETTING) {
      result_ = TEST_SETUP_SETTING(builder_, 0);
    }
    else if (root_ == TEST_SETUP_TOKEN) {
      result_ = TEST_SETUP_TOKEN(builder_, 0);
    }
    else if (root_ == VARIABLE) {
      result_ = VARIABLE(builder_, 0);
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
  // ARGUMENTS_SETTING_TOKEN (COLUMN_SEP_TOKEN ARGUMENT_DEF)*
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

  // (COLUMN_SEP_TOKEN ARGUMENT_DEF)*
  private static boolean ARGUMENTS_SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARGUMENTS_SETTING_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!ARGUMENTS_SETTING_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ARGUMENTS_SETTING_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN ARGUMENT_DEF
  private static boolean ARGUMENTS_SETTING_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARGUMENTS_SETTING_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && ARGUMENT_DEF(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // VARIABLE | SCALAR_DEFAULT_ARG_VALUE
  public static boolean ARGUMENT_DEF(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARGUMENT_DEF")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<argument def>");
    result_ = VARIABLE(builder_, level_ + 1);
    if (!result_) result_ = SCALAR_DEFAULT_ARG_VALUE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ARGUMENT_DEF, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ( KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE )*
  public static boolean ARRAY_ASSIGNABLE_IN_VARIABLES_TBL(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNABLE_IN_VARIABLES_TBL")) return false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<array assignable in variables tbl>");
    int pos_ = current_position_(builder_);
    while (true) {
      if (!ARRAY_ASSIGNABLE_IN_VARIABLES_TBL_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "ARRAY_ASSIGNABLE_IN_VARIABLES_TBL", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, ARRAY_ASSIGNABLE_IN_VARIABLES_TBL, true, false, null);
    return true;
  }

  // KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  private static boolean ARRAY_ASSIGNABLE_IN_VARIABLES_TBL_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNABLE_IN_VARIABLES_TBL_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG_LIST(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_FOR_SETTINGS_TABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ARRAY_ASSIGNMENT_TOKEN
  public static boolean ARRAY_ASSIGNMENT(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNMENT")) return false;
    if (!nextTokenIs(builder_, ARRAY_ASSIGNMENT_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ARRAY_ASSIGNMENT_TOKEN);
    exit_section_(builder_, marker_, ARRAY_ASSIGNMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // ARRAY_VARIABLE | ARRAY_ASSIGNMENT
  public static boolean ARRAY_ASSIGNMENT_LHS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNMENT_LHS")) return false;
    if (!nextTokenIs(builder_, "<array assignment lhs>", ARRAY_ASSIGNMENT_TOKEN, ARRAY_VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<array assignment lhs>");
    result_ = ARRAY_VARIABLE(builder_, level_ + 1);
    if (!result_) result_ = ARRAY_ASSIGNMENT(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ARRAY_ASSIGNMENT_LHS, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ARRAY_ASSIGNMENT_NO_SPACE_TOKEN
  public static boolean ARRAY_ASSIGNMENT_NO_SPACE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_ASSIGNMENT_NO_SPACE")) return false;
    if (!nextTokenIs(builder_, ARRAY_ASSIGNMENT_NO_SPACE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ARRAY_ASSIGNMENT_NO_SPACE_TOKEN);
    exit_section_(builder_, marker_, ARRAY_ASSIGNMENT_NO_SPACE, result_);
    return result_;
  }

  /* ********************************************************** */
  // ARRAY_VARIABLE_TOKEN
  public static boolean ARRAY_VARIABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ARRAY_VARIABLE")) return false;
    if (!nextTokenIs(builder_, ARRAY_VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ARRAY_VARIABLE_TOKEN);
    exit_section_(builder_, marker_, ARRAY_VARIABLE, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean ASSIGNABLE_IN_VARIABLES_TBL(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ASSIGNABLE_IN_VARIABLES_TBL")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, ASSIGNABLE_IN_VARIABLES_TBL, result_);
    return result_;
  }

  /* ********************************************************** */
  // SCALAR_ASSIGNMENT | ARRAY_ASSIGNMENT
  public static boolean ASSIGNMENT(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ASSIGNMENT")) return false;
    if (!nextTokenIs(builder_, "<assignment>", ARRAY_ASSIGNMENT_TOKEN, ASSIGNMENT_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<assignment>");
    result_ = SCALAR_ASSIGNMENT(builder_, level_ + 1);
    if (!result_) result_ = ARRAY_ASSIGNMENT(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ASSIGNMENT, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // SCALAR_ASSIGNMENT_NO_SPACE | ARRAY_ASSIGNMENT_NO_SPACE
  public static boolean ASSIGNMENT_NO_SPACE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ASSIGNMENT_NO_SPACE")) return false;
    if (!nextTokenIs(builder_, "<assignment no space>", ARRAY_ASSIGNMENT_NO_SPACE_TOKEN, ASSIGNMENT_NO_SPACE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<assignment no space>");
    result_ = SCALAR_ASSIGNMENT_NO_SPACE(builder_, level_ + 1);
    if (!result_) result_ = ARRAY_ASSIGNMENT_NO_SPACE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ASSIGNMENT_NO_SPACE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // DOCUMENTATION_SETTING_TOKEN  (ELLIPSES_FOR_TEST_TABLE? COLUMN_SEP_TOKEN  DOCUMENTATION_TOKEN)*
  public static boolean DOCUMENTATION_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOCUMENTATION_SETTING")) return false;
    if (!nextTokenIs(builder_, DOCUMENTATION_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, DOCUMENTATION_SETTING_TOKEN);
    result_ = result_ && DOCUMENTATION_SETTING_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, DOCUMENTATION_SETTING, result_);
    return result_;
  }

  // (ELLIPSES_FOR_TEST_TABLE? COLUMN_SEP_TOKEN  DOCUMENTATION_TOKEN)*
  private static boolean DOCUMENTATION_SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOCUMENTATION_SETTING_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!DOCUMENTATION_SETTING_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "DOCUMENTATION_SETTING_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // ELLIPSES_FOR_TEST_TABLE? COLUMN_SEP_TOKEN  DOCUMENTATION_TOKEN
  private static boolean DOCUMENTATION_SETTING_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOCUMENTATION_SETTING_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = DOCUMENTATION_SETTING_1_0_0(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, DOCUMENTATION_TOKEN);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ELLIPSES_FOR_TEST_TABLE?
  private static boolean DOCUMENTATION_SETTING_1_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOCUMENTATION_SETTING_1_0_0")) return false;
    ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1);
    return true;
  }

  /* ********************************************************** */
  // FOR_VAR_IN_RANGE INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  //                                            INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean DOUBLE_BOUND_FOR_LOOP(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOUBLE_BOUND_FOR_LOOP")) return false;
    if (!nextTokenIs(builder_, FOR_LOOP_START_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = FOR_VAR_IN_RANGE(builder_, level_ + 1);
    result_ = result_ && DOUBLE_BOUND_FOR_LOOP_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    result_ = result_ && DOUBLE_BOUND_FOR_LOOP_4(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, DOUBLE_BOUND_FOR_LOOP, result_);
    return result_;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOUBLE_BOUND_FOR_LOOP_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "DOUBLE_BOUND_FOR_LOOP_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOUBLE_BOUND_FOR_LOOP_4")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "DOUBLE_BOUND_FOR_LOOP_4", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // FOR_VAR_IN_RANGE INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  //                                                      INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  //                                                      INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP")) return false;
    if (!nextTokenIs(builder_, FOR_LOOP_START_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = FOR_VAR_IN_RANGE(builder_, level_ + 1);
    result_ = result_ && DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    result_ = result_ && DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    result_ = result_ && DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, DOUBLE_BOUND_FOR_LOOP_WITH_STEP, result_);
    return result_;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // ELLIPSES_TOKEN
  public static boolean ELLIPSES(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES")) return false;
    if (!nextTokenIs(builder_, ELLIPSES_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ELLIPSES_TOKEN);
    exit_section_(builder_, marker_, ELLIPSES, result_);
    return result_;
  }

  /* ********************************************************** */
  // END_OF_LINE NEWLINE_TOKEN WHITESPACE_TOKEN? COLUMN_SEP_TOKEN? ELLIPSES
  public static boolean ELLIPSES_FOR_SETTINGS_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_FOR_SETTINGS_TABLE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<ellipses for settings table>");
    result_ = END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    result_ = result_ && ELLIPSES_FOR_SETTINGS_TABLE_2(builder_, level_ + 1);
    result_ = result_ && ELLIPSES_FOR_SETTINGS_TABLE_3(builder_, level_ + 1);
    result_ = result_ && ELLIPSES(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ELLIPSES_FOR_SETTINGS_TABLE, result_, false, null);
    return result_;
  }

  // WHITESPACE_TOKEN?
  private static boolean ELLIPSES_FOR_SETTINGS_TABLE_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_FOR_SETTINGS_TABLE_2")) return false;
    consumeToken(builder_, WHITESPACE_TOKEN);
    return true;
  }

  // COLUMN_SEP_TOKEN?
  private static boolean ELLIPSES_FOR_SETTINGS_TABLE_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_FOR_SETTINGS_TABLE_3")) return false;
    consumeToken(builder_, COLUMN_SEP_TOKEN);
    return true;
  }

  /* ********************************************************** */
  // END_OF_LINE NEWLINE_TOKEN COLUMN_SEP_TOKEN ELLIPSES
  public static boolean ELLIPSES_FOR_TEST_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_FOR_TEST_TABLE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<ellipses for test table>");
    result_ = END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, NEWLINE_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && ELLIPSES(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ELLIPSES_FOR_TEST_TABLE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN? WHITESPACE_TOKEN? ELLIPSES END_OF_LINE
  public static boolean ELLIPSES_LINE_SETTINGS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_LINE_SETTINGS")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<ellipses line settings>");
    result_ = ELLIPSES_LINE_SETTINGS_0(builder_, level_ + 1);
    result_ = result_ && ELLIPSES_LINE_SETTINGS_1(builder_, level_ + 1);
    result_ = result_ && ELLIPSES(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, ELLIPSES_LINE_SETTINGS, result_, false, null);
    return result_;
  }

  // COLUMN_SEP_TOKEN?
  private static boolean ELLIPSES_LINE_SETTINGS_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_LINE_SETTINGS_0")) return false;
    consumeToken(builder_, COLUMN_SEP_TOKEN);
    return true;
  }

  // WHITESPACE_TOKEN?
  private static boolean ELLIPSES_LINE_SETTINGS_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_LINE_SETTINGS_1")) return false;
    consumeToken(builder_, WHITESPACE_TOKEN);
    return true;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  ELLIPSES  END_OF_LINE
  public static boolean ELLIPSES_LINE_TEST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "ELLIPSES_LINE_TEST")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && ELLIPSES(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    exit_section_(builder_, marker_, ELLIPSES_LINE_TEST, result_);
    return result_;
  }

  /* ********************************************************** */
  // !<<eof>> END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean EMPTY_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EMPTY_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<empty line>");
    result_ = EMPTY_LINE_0(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && EMPTY_LINE_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, EMPTY_LINE, result_, false, null);
    return result_;
  }

  // !<<eof>>
  private static boolean EMPTY_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EMPTY_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !eof(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean EMPTY_LINE_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "EMPTY_LINE_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // WHITESPACE_TOKEN? COLUMN_SEP_TOKEN? COMMENT_TOKEN?
  public static boolean END_OF_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "END_OF_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<end of line>");
    result_ = END_OF_LINE_0(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE_1(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE_2(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, END_OF_LINE, result_, false, null);
    return result_;
  }

  // WHITESPACE_TOKEN?
  private static boolean END_OF_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "END_OF_LINE_0")) return false;
    consumeToken(builder_, WHITESPACE_TOKEN);
    return true;
  }

  // COLUMN_SEP_TOKEN?
  private static boolean END_OF_LINE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "END_OF_LINE_1")) return false;
    consumeToken(builder_, COLUMN_SEP_TOKEN);
    return true;
  }

  // COMMENT_TOKEN?
  private static boolean END_OF_LINE_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "END_OF_LINE_2")) return false;
    consumeToken(builder_, COMMENT_TOKEN);
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
  // FORCE_TAGS_SETTING_KEYWORD_TOKEN TAG_LIST_OR_ELLIPSES_NO_COL+ | FORCE_TAGS_SETTING_KEYWORD_TOKEN
  public static boolean FORCE_TAGS_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FORCE_TAGS_SETTING")) return false;
    if (!nextTokenIs(builder_, FORCE_TAGS_SETTING_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = FORCE_TAGS_SETTING_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, FORCE_TAGS_SETTING_KEYWORD_TOKEN);
    exit_section_(builder_, marker_, FORCE_TAGS_SETTING, result_);
    return result_;
  }

  // FORCE_TAGS_SETTING_KEYWORD_TOKEN TAG_LIST_OR_ELLIPSES_NO_COL+
  private static boolean FORCE_TAGS_SETTING_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FORCE_TAGS_SETTING_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FORCE_TAGS_SETTING_KEYWORD_TOKEN);
    result_ = result_ && FORCE_TAGS_SETTING_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // TAG_LIST_OR_ELLIPSES_NO_COL+
  private static boolean FORCE_TAGS_SETTING_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FORCE_TAGS_SETTING_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TAG_LIST_OR_ELLIPSES_NO_COL(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!TAG_LIST_OR_ELLIPSES_NO_COL(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "FORCE_TAGS_SETTING_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  FOR_VAR_IN  FOR_LOOP_VALUE_LIST
  public static boolean FOR_LOOP_IN(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_LOOP_IN")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && FOR_VAR_IN(builder_, level_ + 1);
    result_ = result_ && FOR_LOOP_VALUE_LIST(builder_, level_ + 1);
    exit_section_(builder_, marker_, FOR_LOOP_IN, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN (DOUBLE_BOUND_FOR_LOOP_WITH_STEP | DOUBLE_BOUND_FOR_LOOP | SINGLE_BOUND_FOR_LOOP ) END_OF_LINE NEWLINE_TOKEN
  //                       INDENTED_KEYWORD_LINE+
  public static boolean FOR_LOOP_IN_RANGE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_LOOP_IN_RANGE")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && FOR_LOOP_IN_RANGE_1(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, NEWLINE_TOKEN);
    result_ = result_ && FOR_LOOP_IN_RANGE_4(builder_, level_ + 1);
    exit_section_(builder_, marker_, FOR_LOOP_IN_RANGE, result_);
    return result_;
  }

  // DOUBLE_BOUND_FOR_LOOP_WITH_STEP | DOUBLE_BOUND_FOR_LOOP | SINGLE_BOUND_FOR_LOOP
  private static boolean FOR_LOOP_IN_RANGE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_LOOP_IN_RANGE_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = DOUBLE_BOUND_FOR_LOOP_WITH_STEP(builder_, level_ + 1);
    if (!result_) result_ = DOUBLE_BOUND_FOR_LOOP(builder_, level_ + 1);
    if (!result_) result_ = SINGLE_BOUND_FOR_LOOP(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // INDENTED_KEYWORD_LINE+
  private static boolean FOR_LOOP_IN_RANGE_4(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_LOOP_IN_RANGE_4")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = INDENTED_KEYWORD_LINE(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!INDENTED_KEYWORD_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "FOR_LOOP_IN_RANGE_4", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE)+
  public static boolean FOR_LOOP_VALUE_LIST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_LOOP_VALUE_LIST")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<for loop value list>");
    result_ = FOR_LOOP_VALUE_LIST_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!FOR_LOOP_VALUE_LIST_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "FOR_LOOP_VALUE_LIST", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, level_, marker_, FOR_LOOP_VALUE_LIST, result_, false, null);
    return result_;
  }

  // KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE
  private static boolean FOR_LOOP_VALUE_LIST_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_LOOP_VALUE_LIST_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG_LIST(builder_, level_ + 1);
    if (!result_) result_ = INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // FOR_LOOP_START_TOKEN  INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN SINGLE_VARIABLE_LIST IN_TOKEN
  public static boolean FOR_VAR_IN(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_VAR_IN")) return false;
    if (!nextTokenIs(builder_, FOR_LOOP_START_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, FOR_LOOP_START_TOKEN);
    result_ = result_ && FOR_VAR_IN_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && SINGLE_VARIABLE_LIST(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, IN_TOKEN);
    exit_section_(builder_, marker_, FOR_VAR_IN, result_);
    return result_;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean FOR_VAR_IN_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_VAR_IN_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "FOR_VAR_IN_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // FOR_LOOP_START_TOKEN  COLUMN_SEP_TOKEN SCALAR_VARIABLE COLUMN_SEP_TOKEN IN_RANGE_TOKEN
  public static boolean FOR_VAR_IN_RANGE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "FOR_VAR_IN_RANGE")) return false;
    if (!nextTokenIs(builder_, FOR_LOOP_START_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, FOR_LOOP_START_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && SCALAR_VARIABLE(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, IN_RANGE_TOKEN);
    exit_section_(builder_, marker_, FOR_VAR_IN_RANGE, result_);
    return result_;
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_TOKEN SETTING_LIST_OR_ELLIPSES+ | ROBOT_KEYWORD_TOKEN
  public static boolean GENERIC_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "GENERIC_SETTING")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = GENERIC_SETTING_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, ROBOT_KEYWORD_TOKEN);
    exit_section_(builder_, marker_, GENERIC_SETTING, result_);
    return result_;
  }

  // ROBOT_KEYWORD_TOKEN SETTING_LIST_OR_ELLIPSES+
  private static boolean GENERIC_SETTING_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "GENERIC_SETTING_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ROBOT_KEYWORD_TOKEN);
    result_ = result_ && GENERIC_SETTING_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // SETTING_LIST_OR_ELLIPSES+
  private static boolean GENERIC_SETTING_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "GENERIC_SETTING_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = SETTING_LIST_OR_ELLIPSES(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!SETTING_LIST_OR_ELLIPSES(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "GENERIC_SETTING_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // END_OF_LINE NEWLINE_TOKEN COLUMN_SEP_TOKEN EMPTY_CELL_TOKEN COLUMN_SEP_TOKEN ELLIPSES
  public static boolean INDENTED_ELLIPSES_FOR_TEST_TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_ELLIPSES_FOR_TEST_TABLE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<indented ellipses for test table>");
    result_ = END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && consumeTokens(builder_, 0, NEWLINE_TOKEN, COLUMN_SEP_TOKEN, EMPTY_CELL_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && ELLIPSES(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, INDENTED_ELLIPSES_FOR_TEST_TABLE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN EMPTY_CELL_TOKEN COLUMN_SEP_TOKEN  ELLIPSES  END_OF_LINE
  public static boolean INDENTED_ELLIPSES_LINE_TEST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_ELLIPSES_LINE_TEST")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, EMPTY_CELL_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && ELLIPSES(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    exit_section_(builder_, marker_, INDENTED_ELLIPSES_LINE_TEST, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD (KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE)+ | KEYWORD
  public static boolean INDENTED_KEYWORD_INVOCATION_TEST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_INVOCATION_TEST")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = INDENTED_KEYWORD_INVOCATION_TEST_0(builder_, level_ + 1);
    if (!result_) result_ = KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, INDENTED_KEYWORD_INVOCATION_TEST, result_);
    return result_;
  }

  // KEYWORD (KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE)+
  private static boolean INDENTED_KEYWORD_INVOCATION_TEST_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_INVOCATION_TEST_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD(builder_, level_ + 1);
    result_ = result_ && INDENTED_KEYWORD_INVOCATION_TEST_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE)+
  private static boolean INDENTED_KEYWORD_INVOCATION_TEST_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_INVOCATION_TEST_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = INDENTED_KEYWORD_INVOCATION_TEST_0_1_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!INDENTED_KEYWORD_INVOCATION_TEST_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "INDENTED_KEYWORD_INVOCATION_TEST_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE
  private static boolean INDENTED_KEYWORD_INVOCATION_TEST_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_INVOCATION_TEST_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG_LIST(builder_, level_ + 1);
    if (!result_) result_ = INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  EMPTY_CELL_TOKEN COLUMN_SEP_TOKEN ( INDENTED_KEYWORD_INVOCATION_TEST | INDENTED_VARIABLE_ASSIGN_TO_KEYWORD ) END_OF_LINE (NEWLINE_TOKEN | <<eof>>)  |
  //                  EMPTY_LINE |
  //                  INDENTED_ELLIPSES_LINE_TEST
  public static boolean INDENTED_KEYWORD_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<indented keyword line>");
    result_ = INDENTED_KEYWORD_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    if (!result_) result_ = INDENTED_ELLIPSES_LINE_TEST(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, INDENTED_KEYWORD_LINE, result_, false, null);
    return result_;
  }

  // COLUMN_SEP_TOKEN  EMPTY_CELL_TOKEN COLUMN_SEP_TOKEN ( INDENTED_KEYWORD_INVOCATION_TEST | INDENTED_VARIABLE_ASSIGN_TO_KEYWORD ) END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  private static boolean INDENTED_KEYWORD_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, COLUMN_SEP_TOKEN, EMPTY_CELL_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && INDENTED_KEYWORD_LINE_0_3(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && INDENTED_KEYWORD_LINE_0_5(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // INDENTED_KEYWORD_INVOCATION_TEST | INDENTED_VARIABLE_ASSIGN_TO_KEYWORD
  private static boolean INDENTED_KEYWORD_LINE_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_LINE_0_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = INDENTED_KEYWORD_INVOCATION_TEST(builder_, level_ + 1);
    if (!result_) result_ = INDENTED_VARIABLE_ASSIGN_TO_KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean INDENTED_KEYWORD_LINE_0_5(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_KEYWORD_LINE_0_5")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ( MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS ) INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN  INDENTED_KEYWORD_INVOCATION_TEST
  public static boolean INDENTED_VARIABLE_ASSIGN_TO_KEYWORD(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<indented variable assign to keyword>");
    result_ = INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_0(builder_, level_ + 1);
    result_ = result_ && INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && INDENTED_KEYWORD_INVOCATION_TEST(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, INDENTED_VARIABLE_ASSIGN_TO_KEYWORD, result_, false, null);
    return result_;
  }

  // MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS
  private static boolean INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = MULTI_ASSIGNMENT_LHS(builder_, level_ + 1);
    if (!result_) result_ = SINGLE_ASSIGNMENT_LHS(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
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
  // KEYWORDS_TABLE_HEADING (EMPTY_LINE | KEYWORD_DEFINITION)*
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

  // (EMPTY_LINE | KEYWORD_DEFINITION)*
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

  // EMPTY_LINE | KEYWORD_DEFINITION
  private static boolean KEYWORDS_TABLE_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = EMPTY_LINE(builder_, level_ + 1);
    if (!result_) result_ = KEYWORD_DEFINITION(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORDS_TABLE_HEADING_TOKEN END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean KEYWORDS_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, KEYWORDS_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, KEYWORDS_TABLE_HEADING_TOKEN);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && KEYWORDS_TABLE_HEADING_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, KEYWORDS_TABLE_HEADING, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean KEYWORDS_TABLE_HEADING_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORDS_TABLE_HEADING_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // VARIABLE | ROBOT_KEYWORD_ARG_TOKEN | EMPTY_CELL_TOKEN | INTEGER_TOKEN
  public static boolean KEYWORD_ARG(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_ARG")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword arg>");
    result_ = VARIABLE(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, ROBOT_KEYWORD_ARG_TOKEN);
    if (!result_) result_ = consumeToken(builder_, EMPTY_CELL_TOKEN);
    if (!result_) result_ = consumeToken(builder_, INTEGER_TOKEN);
    exit_section_(builder_, level_, marker_, KEYWORD_ARG, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // (COLUMN_SEP_TOKEN KEYWORD_ARG)+
  public static boolean KEYWORD_ARG_LIST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_ARG_LIST")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG_LIST_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!KEYWORD_ARG_LIST_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORD_ARG_LIST", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, KEYWORD_ARG_LIST, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN KEYWORD_ARG
  private static boolean KEYWORD_ARG_LIST_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_ARG_LIST_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD_DEFINITION_HEADER KEYWORD_SETTINGS KEYWORD_LINE*
  public static boolean KEYWORD_DEFINITION(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEFINITION")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TITLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_DEFINITION_HEADER(builder_, level_ + 1);
    result_ = result_ && KEYWORD_SETTINGS(builder_, level_ + 1);
    result_ = result_ && KEYWORD_DEFINITION_2(builder_, level_ + 1);
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

  /* ********************************************************** */
  // KEYWORD_TITLE END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean KEYWORD_DEFINITION_HEADER(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEFINITION_HEADER")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TITLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_TITLE(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && KEYWORD_DEFINITION_HEADER_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, KEYWORD_DEFINITION_HEADER, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean KEYWORD_DEFINITION_HEADER_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_DEFINITION_HEADER_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD (KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE)+ | KEYWORD
  public static boolean KEYWORD_INVOCATION_SETTINGS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_SETTINGS")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_INVOCATION_SETTINGS_0(builder_, level_ + 1);
    if (!result_) result_ = KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, KEYWORD_INVOCATION_SETTINGS, result_);
    return result_;
  }

  // KEYWORD (KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE)+
  private static boolean KEYWORD_INVOCATION_SETTINGS_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_SETTINGS_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD(builder_, level_ + 1);
    result_ = result_ && KEYWORD_INVOCATION_SETTINGS_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE)+
  private static boolean KEYWORD_INVOCATION_SETTINGS_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_SETTINGS_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_INVOCATION_SETTINGS_0_1_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!KEYWORD_INVOCATION_SETTINGS_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORD_INVOCATION_SETTINGS_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  private static boolean KEYWORD_INVOCATION_SETTINGS_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_SETTINGS_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG_LIST(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_FOR_SETTINGS_TABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // KEYWORD (KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE)+ | KEYWORD
  public static boolean KEYWORD_INVOCATION_TEST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_TEST")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_INVOCATION_TEST_0(builder_, level_ + 1);
    if (!result_) result_ = KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, KEYWORD_INVOCATION_TEST, result_);
    return result_;
  }

  // KEYWORD (KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE)+
  private static boolean KEYWORD_INVOCATION_TEST_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_TEST_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD(builder_, level_ + 1);
    result_ = result_ && KEYWORD_INVOCATION_TEST_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE)+
  private static boolean KEYWORD_INVOCATION_TEST_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_TEST_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_INVOCATION_TEST_0_1_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!KEYWORD_INVOCATION_TEST_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "KEYWORD_INVOCATION_TEST_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE
  private static boolean KEYWORD_INVOCATION_TEST_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_INVOCATION_TEST_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG_LIST(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN ( KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD ) END_OF_LINE (NEWLINE_TOKEN | <<eof>>)  |
  //                  RETURN_LINE |
  //                  EMPTY_LINE |
  //                  ELLIPSES_LINE_TEST |
  //                  FOR_LOOP_IN_RANGE  |
  //                  FOR_LOOP_IN
  public static boolean KEYWORD_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword line>");
    result_ = KEYWORD_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = RETURN_LINE(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_LINE_TEST(builder_, level_ + 1);
    if (!result_) result_ = FOR_LOOP_IN_RANGE(builder_, level_ + 1);
    if (!result_) result_ = FOR_LOOP_IN(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, KEYWORD_LINE, result_, false, null);
    return result_;
  }

  // COLUMN_SEP_TOKEN ( KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD ) END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  private static boolean KEYWORD_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_LINE_0_1(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && KEYWORD_LINE_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD
  private static boolean KEYWORD_LINE_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_LINE_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_INVOCATION_TEST(builder_, level_ + 1);
    if (!result_) result_ = VARIABLE_ASSIGN_TO_KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean KEYWORD_LINE_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_LINE_0_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ARGUMENTS_SETTING | DOCUMENTATION_SETTING | TEST_CASE_TEARDOWN_SETTING | TEST_CASE_TIMEOUT_SETTING
  public static boolean KEYWORD_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTING")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword setting>");
    result_ = ARGUMENTS_SETTING(builder_, level_ + 1);
    if (!result_) result_ = DOCUMENTATION_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASE_TEARDOWN_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASE_TIMEOUT_SETTING(builder_, level_ + 1);
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
  // COLUMN_SEP_TOKEN KEYWORD_SETTING END_OF_LINE (NEWLINE_TOKEN | <<eof>>) | EMPTY_LINE
  public static boolean KEYWORD_SETTING_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTING_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<keyword setting line>");
    result_ = KEYWORD_SETTING_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, KEYWORD_SETTING_LINE, result_, false, null);
    return result_;
  }

  // COLUMN_SEP_TOKEN KEYWORD_SETTING END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  private static boolean KEYWORD_SETTING_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTING_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_SETTING(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && KEYWORD_SETTING_LINE_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean KEYWORD_SETTING_LINE_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_SETTING_LINE_0_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_TITLE_TOKEN
  public static boolean KEYWORD_TITLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "KEYWORD_TITLE")) return false;
    if (!nextTokenIs(builder_, ROBOT_KEYWORD_TITLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ROBOT_KEYWORD_TITLE_TOKEN);
    exit_section_(builder_, marker_, KEYWORD_TITLE, result_);
    return result_;
  }

  /* ********************************************************** */
  // VARIABLE (COLUMN_SEP_TOKEN VARIABLE)*  COLUMN_SEP_TOKEN ASSIGNMENT
  //                        |  VARIABLE (COLUMN_SEP_TOKEN  VARIABLE)+
  public static boolean MULTI_ASSIGNMENT_LHS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MULTI_ASSIGNMENT_LHS")) return false;
    if (!nextTokenIs(builder_, "<multi assignment lhs>", ARRAY_VARIABLE_TOKEN, VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<multi assignment lhs>");
    result_ = MULTI_ASSIGNMENT_LHS_0(builder_, level_ + 1);
    if (!result_) result_ = MULTI_ASSIGNMENT_LHS_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, MULTI_ASSIGNMENT_LHS, result_, false, null);
    return result_;
  }

  // VARIABLE (COLUMN_SEP_TOKEN VARIABLE)*  COLUMN_SEP_TOKEN ASSIGNMENT
  private static boolean MULTI_ASSIGNMENT_LHS_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MULTI_ASSIGNMENT_LHS_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = VARIABLE(builder_, level_ + 1);
    result_ = result_ && MULTI_ASSIGNMENT_LHS_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && ASSIGNMENT(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN VARIABLE)*
  private static boolean MULTI_ASSIGNMENT_LHS_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MULTI_ASSIGNMENT_LHS_0_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!MULTI_ASSIGNMENT_LHS_0_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "MULTI_ASSIGNMENT_LHS_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN VARIABLE
  private static boolean MULTI_ASSIGNMENT_LHS_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MULTI_ASSIGNMENT_LHS_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && VARIABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // VARIABLE (COLUMN_SEP_TOKEN  VARIABLE)+
  private static boolean MULTI_ASSIGNMENT_LHS_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MULTI_ASSIGNMENT_LHS_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = VARIABLE(builder_, level_ + 1);
    result_ = result_ && MULTI_ASSIGNMENT_LHS_1_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (COLUMN_SEP_TOKEN  VARIABLE)+
  private static boolean MULTI_ASSIGNMENT_LHS_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MULTI_ASSIGNMENT_LHS_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = MULTI_ASSIGNMENT_LHS_1_1_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!MULTI_ASSIGNMENT_LHS_1_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "MULTI_ASSIGNMENT_LHS_1_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN  VARIABLE
  private static boolean MULTI_ASSIGNMENT_LHS_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "MULTI_ASSIGNMENT_LHS_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && VARIABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // RESOURCE_SETTING_TOKEN  COLUMN_SEP_TOKEN  KEYWORD_ARG
  public static boolean RESOURCE_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RESOURCE_SETTING")) return false;
    if (!nextTokenIs(builder_, RESOURCE_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, RESOURCE_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, RESOURCE_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN RETURN_SETTING END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean RETURN_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RETURN_LINE")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && RETURN_SETTING(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && RETURN_LINE_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, RETURN_LINE, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean RETURN_LINE_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RETURN_LINE_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // RETURN_SETTING_TOKEN (COLUMN_SEP_TOKEN KEYWORD_ARG)+
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

  // (COLUMN_SEP_TOKEN KEYWORD_ARG)+
  private static boolean RETURN_SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RETURN_SETTING_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = RETURN_SETTING_1_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!RETURN_SETTING_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "RETURN_SETTING_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN KEYWORD_ARG
  private static boolean RETURN_SETTING_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "RETURN_SETTING_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ASSIGNMENT_TOKEN
  public static boolean SCALAR_ASSIGNMENT(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SCALAR_ASSIGNMENT")) return false;
    if (!nextTokenIs(builder_, ASSIGNMENT_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ASSIGNMENT_TOKEN);
    exit_section_(builder_, marker_, SCALAR_ASSIGNMENT, result_);
    return result_;
  }

  /* ********************************************************** */
  // SCALAR_VARIABLE | SCALAR_ASSIGNMENT
  public static boolean SCALAR_ASSIGNMENT_LHS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SCALAR_ASSIGNMENT_LHS")) return false;
    if (!nextTokenIs(builder_, "<scalar assignment lhs>", ASSIGNMENT_TOKEN, VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<scalar assignment lhs>");
    result_ = SCALAR_VARIABLE(builder_, level_ + 1);
    if (!result_) result_ = SCALAR_ASSIGNMENT(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SCALAR_ASSIGNMENT_LHS, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // ASSIGNMENT_NO_SPACE_TOKEN
  public static boolean SCALAR_ASSIGNMENT_NO_SPACE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SCALAR_ASSIGNMENT_NO_SPACE")) return false;
    if (!nextTokenIs(builder_, ASSIGNMENT_NO_SPACE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, ASSIGNMENT_NO_SPACE_TOKEN);
    exit_section_(builder_, marker_, SCALAR_ASSIGNMENT_NO_SPACE, result_);
    return result_;
  }

  /* ********************************************************** */
  // SCALAR_DEFAULT_ARG_VALUE_TOKEN
  public static boolean SCALAR_DEFAULT_ARG_VALUE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SCALAR_DEFAULT_ARG_VALUE")) return false;
    if (!nextTokenIs(builder_, SCALAR_DEFAULT_ARG_VALUE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SCALAR_DEFAULT_ARG_VALUE_TOKEN);
    exit_section_(builder_, marker_, SCALAR_DEFAULT_ARG_VALUE, result_);
    return result_;
  }

  /* ********************************************************** */
  // VARIABLE_TOKEN
  public static boolean SCALAR_VARIABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SCALAR_VARIABLE")) return false;
    if (!nextTokenIs(builder_, VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VARIABLE_TOKEN);
    exit_section_(builder_, marker_, SCALAR_VARIABLE, result_);
    return result_;
  }

  /* ********************************************************** */
  // FORCE_TAGS_SETTING | RESOURCE_SETTING | TEST_SETUP_SETTING | GENERIC_SETTING
  public static boolean SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<setting>");
    result_ = FORCE_TAGS_SETTING(builder_, level_ + 1);
    if (!result_) result_ = RESOURCE_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEST_SETUP_SETTING(builder_, level_ + 1);
    if (!result_) result_ = GENERIC_SETTING(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SETTING, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // WHITESPACE_TOKEN? SETTING END_OF_LINE (NEWLINE_TOKEN | <<eof>>) |
  //                   EMPTY_LINE |
  //                   ELLIPSES_LINE_SETTINGS
  public static boolean SETTINGS_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<settings line>");
    result_ = SETTINGS_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_LINE_SETTINGS(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SETTINGS_LINE, result_, false, null);
    return result_;
  }

  // WHITESPACE_TOKEN? SETTING END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  private static boolean SETTINGS_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = SETTINGS_LINE_0_0(builder_, level_ + 1);
    result_ = result_ && SETTING(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && SETTINGS_LINE_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // WHITESPACE_TOKEN?
  private static boolean SETTINGS_LINE_0_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_LINE_0_0")) return false;
    consumeToken(builder_, WHITESPACE_TOKEN);
    return true;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean SETTINGS_LINE_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_LINE_0_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
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
  // SETTINGS_TABLE_HEADING_TOKEN END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean SETTINGS_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, SETTINGS_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, SETTINGS_TABLE_HEADING_TOKEN);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && SETTINGS_TABLE_HEADING_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, SETTINGS_TABLE_HEADING, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean SETTINGS_TABLE_HEADING_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTINGS_TABLE_HEADING_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (COLUMN_SEP_TOKEN  KEYWORD_ARG)+
  public static boolean SETTING_LIST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_LIST")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = SETTING_LIST_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!SETTING_LIST_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SETTING_LIST", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, SETTING_LIST, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN  KEYWORD_ARG
  private static boolean SETTING_LIST_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_LIST_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SETTING_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  public static boolean SETTING_LIST_OR_ELLIPSES(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SETTING_LIST_OR_ELLIPSES")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<setting list or ellipses>");
    result_ = SETTING_LIST(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_FOR_SETTINGS_TABLE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SETTING_LIST_OR_ELLIPSES, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // SCALAR_ASSIGNMENT_LHS | ARRAY_ASSIGNMENT_LHS
  public static boolean SINGLE_ASSIGNMENT_LHS(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SINGLE_ASSIGNMENT_LHS")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<single assignment lhs>");
    result_ = SCALAR_ASSIGNMENT_LHS(builder_, level_ + 1);
    if (!result_) result_ = ARRAY_ASSIGNMENT_LHS(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, SINGLE_ASSIGNMENT_LHS, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // FOR_VAR_IN_RANGE INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean SINGLE_BOUND_FOR_LOOP(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SINGLE_BOUND_FOR_LOOP")) return false;
    if (!nextTokenIs(builder_, FOR_LOOP_START_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = FOR_VAR_IN_RANGE(builder_, level_ + 1);
    result_ = result_ && SINGLE_BOUND_FOR_LOOP_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_ARG(builder_, level_ + 1);
    exit_section_(builder_, marker_, SINGLE_BOUND_FOR_LOOP, result_);
    return result_;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean SINGLE_BOUND_FOR_LOOP_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SINGLE_BOUND_FOR_LOOP_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SINGLE_BOUND_FOR_LOOP_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // SCALAR_VARIABLE (INDENTED_ELLIPSES_FOR_TEST_TABLE | (COLUMN_SEP_TOKEN SCALAR_VARIABLE))*
  public static boolean SINGLE_VARIABLE_LIST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SINGLE_VARIABLE_LIST")) return false;
    if (!nextTokenIs(builder_, VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = SCALAR_VARIABLE(builder_, level_ + 1);
    result_ = result_ && SINGLE_VARIABLE_LIST_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, SINGLE_VARIABLE_LIST, result_);
    return result_;
  }

  // (INDENTED_ELLIPSES_FOR_TEST_TABLE | (COLUMN_SEP_TOKEN SCALAR_VARIABLE))*
  private static boolean SINGLE_VARIABLE_LIST_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SINGLE_VARIABLE_LIST_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!SINGLE_VARIABLE_LIST_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "SINGLE_VARIABLE_LIST_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE | (COLUMN_SEP_TOKEN SCALAR_VARIABLE)
  private static boolean SINGLE_VARIABLE_LIST_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SINGLE_VARIABLE_LIST_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = INDENTED_ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1);
    if (!result_) result_ = SINGLE_VARIABLE_LIST_1_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN SCALAR_VARIABLE
  private static boolean SINGLE_VARIABLE_LIST_1_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "SINGLE_VARIABLE_LIST_1_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && SCALAR_VARIABLE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // SETTINGS_TABLE|VARIABLES_TABLE|TEST_CASES_TABLE|KEYWORDS_TABLE
  public static boolean TABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TABLE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<table>");
    result_ = SETTINGS_TABLE(builder_, level_ + 1);
    if (!result_) result_ = VARIABLES_TABLE(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASES_TABLE(builder_, level_ + 1);
    if (!result_) result_ = KEYWORDS_TABLE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TABLE, result_, false, null);
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
  // TAGS_SETTING_TOKEN TAG_LIST_OR_ELLIPSES+ | TAGS_SETTING_TOKEN
  public static boolean TAGS_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAGS_SETTING")) return false;
    if (!nextTokenIs(builder_, TAGS_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TAGS_SETTING_0(builder_, level_ + 1);
    if (!result_) result_ = consumeToken(builder_, TAGS_SETTING_TOKEN);
    exit_section_(builder_, marker_, TAGS_SETTING, result_);
    return result_;
  }

  // TAGS_SETTING_TOKEN TAG_LIST_OR_ELLIPSES+
  private static boolean TAGS_SETTING_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAGS_SETTING_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TAGS_SETTING_TOKEN);
    result_ = result_ && TAGS_SETTING_0_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // TAG_LIST_OR_ELLIPSES+
  private static boolean TAGS_SETTING_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAGS_SETTING_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TAG_LIST_OR_ELLIPSES(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!TAG_LIST_OR_ELLIPSES(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TAGS_SETTING_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // (COLUMN_SEP_TOKEN TAG)+
  public static boolean TAG_LIST(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAG_LIST")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TAG_LIST_0(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!TAG_LIST_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TAG_LIST", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, TAG_LIST, result_);
    return result_;
  }

  // COLUMN_SEP_TOKEN TAG
  private static boolean TAG_LIST_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAG_LIST_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && TAG(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TAG_LIST | ELLIPSES_FOR_TEST_TABLE
  public static boolean TAG_LIST_OR_ELLIPSES(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAG_LIST_OR_ELLIPSES")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<tag list or ellipses>");
    result_ = TAG_LIST(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TAG_LIST_OR_ELLIPSES, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // TAG_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  public static boolean TAG_LIST_OR_ELLIPSES_NO_COL(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TAG_LIST_OR_ELLIPSES_NO_COL")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<tag list or ellipses no col>");
    result_ = TAG_LIST(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_FOR_SETTINGS_TABLE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TAG_LIST_OR_ELLIPSES_NO_COL, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // TEST_SETTING_LINE |
  //                   COLUMN_SEP_TOKEN (KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD) END_OF_LINE (NEWLINE_TOKEN | <<eof>>) |
  //                   KEYWORD_ARG_LIST END_OF_LINE (NEWLINE_TOKEN | <<eof>>) |
  //                   EMPTY_LINE |
  //                   ELLIPSES_LINE_TEST |
  //                   FOR_LOOP_IN_RANGE  |
  //                   FOR_LOOP_IN
  public static boolean TESTCASE_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<testcase line>");
    result_ = TEST_SETTING_LINE(builder_, level_ + 1);
    if (!result_) result_ = TESTCASE_LINE_1(builder_, level_ + 1);
    if (!result_) result_ = TESTCASE_LINE_2(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_LINE_TEST(builder_, level_ + 1);
    if (!result_) result_ = FOR_LOOP_IN_RANGE(builder_, level_ + 1);
    if (!result_) result_ = FOR_LOOP_IN(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TESTCASE_LINE, result_, false, null);
    return result_;
  }

  // COLUMN_SEP_TOKEN (KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD) END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  private static boolean TESTCASE_LINE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && TESTCASE_LINE_1_1(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && TESTCASE_LINE_1_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD
  private static boolean TESTCASE_LINE_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_1_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_INVOCATION_TEST(builder_, level_ + 1);
    if (!result_) result_ = VARIABLE_ASSIGN_TO_KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean TESTCASE_LINE_1_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_1_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // KEYWORD_ARG_LIST END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  private static boolean TESTCASE_LINE_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = KEYWORD_ARG_LIST(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && TESTCASE_LINE_2_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean TESTCASE_LINE_2_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TESTCASE_LINE_2_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_CASE_HEADER TESTCASE_LINE+
  public static boolean TEST_CASE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE")) return false;
    if (!nextTokenIs(builder_, TEST_CASE_HEADER_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TEST_CASE_HEADER(builder_, level_ + 1);
    result_ = result_ && TEST_CASE_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_CASE, result_);
    return result_;
  }

  // TESTCASE_LINE+
  private static boolean TEST_CASE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TESTCASE_LINE(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!TESTCASE_LINE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TEST_CASE_1", pos_)) break;
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
  // TEST_CASES_TABLE_HEADING_TOKEN END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean TEST_CASES_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASES_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, TEST_CASES_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TEST_CASES_TABLE_HEADING_TOKEN);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && TEST_CASES_TABLE_HEADING_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_CASES_TABLE_HEADING, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean TEST_CASES_TABLE_HEADING_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASES_TABLE_HEADING_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_CASE_HEADER_TOKEN
  public static boolean TEST_CASE_HEADER(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_HEADER")) return false;
    if (!nextTokenIs(builder_, TEST_CASE_HEADER_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, TEST_CASE_HEADER_TOKEN);
    exit_section_(builder_, marker_, TEST_CASE_HEADER, result_);
    return result_;
  }

  /* ********************************************************** */
  // SETUP_SETTING_TOKEN  COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  public static boolean TEST_CASE_SETUP_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_SETUP_SETTING")) return false;
    if (!nextTokenIs(builder_, SETUP_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, SETUP_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION_SETTINGS(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_CASE_SETUP_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEARDOWN_SETTING_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  public static boolean TEST_CASE_TEARDOWN_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_TEARDOWN_SETTING")) return false;
    if (!nextTokenIs(builder_, TEARDOWN_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TEARDOWN_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION_SETTINGS(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_CASE_TEARDOWN_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEMPLATE_SETTING_TOKEN COLUMN_SEP_TOKEN KEYWORD
  public static boolean TEST_CASE_TEMPLATE_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_TEMPLATE_SETTING")) return false;
    if (!nextTokenIs(builder_, TEMPLATE_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TEMPLATE_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_CASE_TEMPLATE_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // TIMEOUT_SETTING_TOKEN COLUMN_SEP_TOKEN TIMEOUT_VALUE_TOKEN
  public static boolean TEST_CASE_TIMEOUT_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_CASE_TIMEOUT_SETTING")) return false;
    if (!nextTokenIs(builder_, TIMEOUT_SETTING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeTokens(builder_, 0, TIMEOUT_SETTING_TOKEN, COLUMN_SEP_TOKEN, TIMEOUT_VALUE_TOKEN);
    exit_section_(builder_, marker_, TEST_CASE_TIMEOUT_SETTING, result_);
    return result_;
  }

  /* ********************************************************** */
  // DOCUMENTATION_SETTING|TAGS_SETTING|TEST_CASE_SETUP_SETTING|TEST_CASE_TEARDOWN_SETTING|TEST_CASE_TEMPLATE_SETTING|TEST_CASE_TIMEOUT_SETTING
  public static boolean TEST_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETTING")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<test setting>");
    result_ = DOCUMENTATION_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TAGS_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASE_SETUP_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASE_TEARDOWN_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASE_TEMPLATE_SETTING(builder_, level_ + 1);
    if (!result_) result_ = TEST_CASE_TIMEOUT_SETTING(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TEST_SETTING, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  TEST_SETTING END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean TEST_SETTING_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETTING_LINE")) return false;
    if (!nextTokenIs(builder_, COLUMN_SEP_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && TEST_SETTING(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && TEST_SETTING_LINE_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, TEST_SETTING_LINE, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean TEST_SETTING_LINE_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETTING_LINE_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_SETUP_TOKEN ELLIPSES_FOR_SETTINGS_TABLE+ COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS |
  //                        TEST_SETUP_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  public static boolean TEST_SETUP_SETTING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETUP_SETTING")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<test setup setting>");
    result_ = TEST_SETUP_SETTING_0(builder_, level_ + 1);
    if (!result_) result_ = TEST_SETUP_SETTING_1(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, TEST_SETUP_SETTING, result_, false, null);
    return result_;
  }

  // TEST_SETUP_TOKEN ELLIPSES_FOR_SETTINGS_TABLE+ COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  private static boolean TEST_SETUP_SETTING_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETUP_SETTING_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TEST_SETUP_TOKEN(builder_, level_ + 1);
    result_ = result_ && TEST_SETUP_SETTING_0_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION_SETTINGS(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ELLIPSES_FOR_SETTINGS_TABLE+
  private static boolean TEST_SETUP_SETTING_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETUP_SETTING_0_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ELLIPSES_FOR_SETTINGS_TABLE(builder_, level_ + 1);
    int pos_ = current_position_(builder_);
    while (result_) {
      if (!ELLIPSES_FOR_SETTINGS_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "TEST_SETUP_SETTING_0_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // TEST_SETUP_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  private static boolean TEST_SETUP_SETTING_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETUP_SETTING_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TEST_SETUP_TOKEN(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION_SETTINGS(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // TEST_SETUP_SETTING_TOKEN | TEST_TEARDOWN_SETTING_TOKEN | SUITE_SETUP_SETTING_TOKEN | SUITE_TEARDOWN_SETTING_TOKEN
  public static boolean TEST_SETUP_TOKEN(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "TEST_SETUP_TOKEN")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<test setup token>");
    result_ = consumeToken(builder_, TEST_SETUP_SETTING_TOKEN);
    if (!result_) result_ = consumeToken(builder_, TEST_TEARDOWN_SETTING_TOKEN);
    if (!result_) result_ = consumeToken(builder_, SUITE_SETUP_SETTING_TOKEN);
    if (!result_) result_ = consumeToken(builder_, SUITE_TEARDOWN_SETTING_TOKEN);
    exit_section_(builder_, level_, marker_, TEST_SETUP_TOKEN, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // SCALAR_VARIABLE | ARRAY_VARIABLE
  public static boolean VARIABLE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLE")) return false;
    if (!nextTokenIs(builder_, "<variable>", ARRAY_VARIABLE_TOKEN, VARIABLE_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<variable>");
    result_ = SCALAR_VARIABLE(builder_, level_ + 1);
    if (!result_) result_ = ARRAY_VARIABLE(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, VARIABLE, result_, false, null);
    return result_;
  }

  /* ********************************************************** */
  // SCALAR_ASSIGNMENT_LHS (ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE (NEWLINE_TOKEN | <<eof>>) |
  //                    ARRAY_ASSIGNMENT_LHS  (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE  (NEWLINE_TOKEN | <<eof>>) |
  //                    EMPTY_LINE  |
  //                    ELLIPSES_LINE_SETTINGS
  public static boolean VARIABLES_LINE(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<variables line>");
    result_ = VARIABLES_LINE_0(builder_, level_ + 1);
    if (!result_) result_ = VARIABLES_LINE_1(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    if (!result_) result_ = ELLIPSES_LINE_SETTINGS(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, VARIABLES_LINE, result_, false, null);
    return result_;
  }

  // SCALAR_ASSIGNMENT_LHS (ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  private static boolean VARIABLES_LINE_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = SCALAR_ASSIGNMENT_LHS(builder_, level_ + 1);
    result_ = result_ && VARIABLES_LINE_0_1(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && VARIABLES_LINE_0_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (ASSIGNABLE_IN_VARIABLES_TBL)?
  private static boolean VARIABLES_LINE_0_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0_1")) return false;
    VARIABLES_LINE_0_1_0(builder_, level_ + 1);
    return true;
  }

  // (ASSIGNABLE_IN_VARIABLES_TBL)
  private static boolean VARIABLES_LINE_0_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ASSIGNABLE_IN_VARIABLES_TBL(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean VARIABLES_LINE_0_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_0_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ARRAY_ASSIGNMENT_LHS  (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE  (NEWLINE_TOKEN | <<eof>>)
  private static boolean VARIABLES_LINE_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ARRAY_ASSIGNMENT_LHS(builder_, level_ + 1);
    result_ = result_ && VARIABLES_LINE_1_1(builder_, level_ + 1);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && VARIABLES_LINE_1_3(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)?
  private static boolean VARIABLES_LINE_1_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1_1")) return false;
    VARIABLES_LINE_1_1_0(builder_, level_ + 1);
    return true;
  }

  // (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)
  private static boolean VARIABLES_LINE_1_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = ARRAY_ASSIGNABLE_IN_VARIABLES_TBL(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean VARIABLES_LINE_1_3(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_LINE_1_3")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
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
  // VARIABLES_TABLE_HEADING_TOKEN END_OF_LINE (NEWLINE_TOKEN | <<eof>>)
  public static boolean VARIABLES_TABLE_HEADING(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_TABLE_HEADING")) return false;
    if (!nextTokenIs(builder_, VARIABLES_TABLE_HEADING_TOKEN)) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, VARIABLES_TABLE_HEADING_TOKEN);
    result_ = result_ && END_OF_LINE(builder_, level_ + 1);
    result_ = result_ && VARIABLES_TABLE_HEADING_2(builder_, level_ + 1);
    exit_section_(builder_, marker_, VARIABLES_TABLE_HEADING, result_);
    return result_;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean VARIABLES_TABLE_HEADING_2(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLES_TABLE_HEADING_2")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = consumeToken(builder_, NEWLINE_TOKEN);
    if (!result_) result_ = eof(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  /* ********************************************************** */
  // ( MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS ) ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN  KEYWORD_INVOCATION_TEST
  public static boolean VARIABLE_ASSIGN_TO_KEYWORD(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLE_ASSIGN_TO_KEYWORD")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NONE_, "<variable assign to keyword>");
    result_ = VARIABLE_ASSIGN_TO_KEYWORD_0(builder_, level_ + 1);
    result_ = result_ && VARIABLE_ASSIGN_TO_KEYWORD_1(builder_, level_ + 1);
    result_ = result_ && consumeToken(builder_, COLUMN_SEP_TOKEN);
    result_ = result_ && KEYWORD_INVOCATION_TEST(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, VARIABLE_ASSIGN_TO_KEYWORD, result_, false, null);
    return result_;
  }

  // MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS
  private static boolean VARIABLE_ASSIGN_TO_KEYWORD_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLE_ASSIGN_TO_KEYWORD_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = MULTI_ASSIGNMENT_LHS(builder_, level_ + 1);
    if (!result_) result_ = SINGLE_ASSIGNMENT_LHS(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // ELLIPSES_FOR_TEST_TABLE*
  private static boolean VARIABLE_ASSIGN_TO_KEYWORD_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "VARIABLE_ASSIGN_TO_KEYWORD_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!ELLIPSES_FOR_TEST_TABLE(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "VARIABLE_ASSIGN_TO_KEYWORD_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> (TABLE|EMPTY_LINE)*
  static boolean robotFile(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "robotFile")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = robotFile_0(builder_, level_ + 1);
    result_ = result_ && robotFile_1(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

  // !<<eof>>
  private static boolean robotFile_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "robotFile_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_, level_, _NOT_, null);
    result_ = !eof(builder_, level_ + 1);
    exit_section_(builder_, level_, marker_, null, result_, false, null);
    return result_;
  }

  // (TABLE|EMPTY_LINE)*
  private static boolean robotFile_1(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "robotFile_1")) return false;
    int pos_ = current_position_(builder_);
    while (true) {
      if (!robotFile_1_0(builder_, level_ + 1)) break;
      if (!empty_element_parsed_guard_(builder_, "robotFile_1", pos_)) break;
      pos_ = current_position_(builder_);
    }
    return true;
  }

  // TABLE|EMPTY_LINE
  private static boolean robotFile_1_0(PsiBuilder builder_, int level_) {
    if (!recursion_guard_(builder_, level_, "robotFile_1_0")) return false;
    boolean result_ = false;
    Marker marker_ = enter_section_(builder_);
    result_ = TABLE(builder_, level_ + 1);
    if (!result_) result_ = EMPTY_LINE(builder_, level_ + 1);
    exit_section_(builder_, marker_, null, result_);
    return result_;
  }

}
