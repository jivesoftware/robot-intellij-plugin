// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotTypes.*;
import static com.jivesoftware.robot.intellij.plugin.parser.RobotParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RobotParser implements PsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARGUMENTS_SETTING) {
      r = ARGUMENTS_SETTING(b, 0);
    }
    else if (t == ARGUMENT_DEF) {
      r = ARGUMENT_DEF(b, 0);
    }
    else if (t == ARRAY_ASSIGNABLE_IN_VARIABLES_TBL) {
      r = ARRAY_ASSIGNABLE_IN_VARIABLES_TBL(b, 0);
    }
    else if (t == ARRAY_ASSIGNMENT) {
      r = ARRAY_ASSIGNMENT(b, 0);
    }
    else if (t == ARRAY_ASSIGNMENT_LHS) {
      r = ARRAY_ASSIGNMENT_LHS(b, 0);
    }
    else if (t == ARRAY_VARIABLE) {
      r = ARRAY_VARIABLE(b, 0);
    }
    else if (t == ASSIGNABLE_IN_VARIABLES_TBL) {
      r = ASSIGNABLE_IN_VARIABLES_TBL(b, 0);
    }
    else if (t == ASSIGNMENT) {
      r = ASSIGNMENT(b, 0);
    }
    else if (t == DOCUMENTATION_META) {
      r = DOCUMENTATION_META(b, 0);
    }
    else if (t == DOCUMENTATION_SETTING) {
      r = DOCUMENTATION_SETTING(b, 0);
    }
    else if (t == DOUBLE_BOUND_FOR_LOOP) {
      r = DOUBLE_BOUND_FOR_LOOP(b, 0);
    }
    else if (t == DOUBLE_BOUND_FOR_LOOP_WITH_STEP) {
      r = DOUBLE_BOUND_FOR_LOOP_WITH_STEP(b, 0);
    }
    else if (t == ELLIPSES) {
      r = ELLIPSES(b, 0);
    }
    else if (t == ELLIPSES_LINE_TEST) {
      r = ELLIPSES_LINE_TEST(b, 0);
    }
    else if (t == EMPTY_LINE) {
      r = EMPTY_LINE(b, 0);
    }
    else if (t == ERROR) {
      r = ERROR(b, 0);
    }
    else if (t == EXECUTION_LINE) {
      r = EXECUTION_LINE(b, 0);
    }
    else if (t == FORCE_TAGS_SETTING) {
      r = FORCE_TAGS_SETTING(b, 0);
    }
    else if (t == FOR_LOOP_IN) {
      r = FOR_LOOP_IN(b, 0);
    }
    else if (t == FOR_LOOP_IN_RANGE) {
      r = FOR_LOOP_IN_RANGE(b, 0);
    }
    else if (t == FOR_LOOP_VALUE_LIST) {
      r = FOR_LOOP_VALUE_LIST(b, 0);
    }
    else if (t == FOR_VAR_IN) {
      r = FOR_VAR_IN(b, 0);
    }
    else if (t == FOR_VAR_IN_RANGE) {
      r = FOR_VAR_IN_RANGE(b, 0);
    }
    else if (t == GENERIC_SETTING) {
      r = GENERIC_SETTING(b, 0);
    }
    else if (t == GENERIC_SETTING_NAME) {
      r = GENERIC_SETTING_NAME(b, 0);
    }
    else if (t == INDENTED_KEYWORD_INVOCATION_TEST) {
      r = INDENTED_KEYWORD_INVOCATION_TEST(b, 0);
    }
    else if (t == INDENTED_VARIABLE_ASSIGN_TO_KEYWORD) {
      r = INDENTED_VARIABLE_ASSIGN_TO_KEYWORD(b, 0);
    }
    else if (t == JAVA_CLASS_REFERENCE) {
      r = JAVA_CLASS_REFERENCE(b, 0);
    }
    else if (t == KEYWORD) {
      r = KEYWORD(b, 0);
    }
    else if (t == KEYWORDS_TABLE) {
      r = KEYWORDS_TABLE(b, 0);
    }
    else if (t == KEYWORDS_TABLE_HEADING) {
      r = KEYWORDS_TABLE_HEADING(b, 0);
    }
    else if (t == KEYWORD_ARG) {
      r = KEYWORD_ARG(b, 0);
    }
    else if (t == KEYWORD_ARG_LIST) {
      r = KEYWORD_ARG_LIST(b, 0);
    }
    else if (t == KEYWORD_DEFINITION) {
      r = KEYWORD_DEFINITION(b, 0);
    }
    else if (t == KEYWORD_INVOCATION_SETTINGS) {
      r = KEYWORD_INVOCATION_SETTINGS(b, 0);
    }
    else if (t == KEYWORD_INVOCATION_TEST) {
      r = KEYWORD_INVOCATION_TEST(b, 0);
    }
    else if (t == KEYWORD_LINE) {
      r = KEYWORD_LINE(b, 0);
    }
    else if (t == KEYWORD_SETTING) {
      r = KEYWORD_SETTING(b, 0);
    }
    else if (t == KEYWORD_SETTING_LINE) {
      r = KEYWORD_SETTING_LINE(b, 0);
    }
    else if (t == KEYWORD_TITLE) {
      r = KEYWORD_TITLE(b, 0);
    }
    else if (t == LIBRARY_SETTING) {
      r = LIBRARY_SETTING(b, 0);
    }
    else if (t == METADATA_SETTING) {
      r = METADATA_SETTING(b, 0);
    }
    else if (t == MULTI_ASSIGNMENT_LHS) {
      r = MULTI_ASSIGNMENT_LHS(b, 0);
    }
    else if (t == RESOURCE_FILE) {
      r = RESOURCE_FILE(b, 0);
    }
    else if (t == RESOURCE_SETTING) {
      r = RESOURCE_SETTING(b, 0);
    }
    else if (t == RETURN_LINE) {
      r = RETURN_LINE(b, 0);
    }
    else if (t == RETURN_SETTING) {
      r = RETURN_SETTING(b, 0);
    }
    else if (t == SCALAR_ASSIGNMENT) {
      r = SCALAR_ASSIGNMENT(b, 0);
    }
    else if (t == SCALAR_ASSIGNMENT_LHS) {
      r = SCALAR_ASSIGNMENT_LHS(b, 0);
    }
    else if (t == SCALAR_DEFAULT_ARG_VALUE) {
      r = SCALAR_DEFAULT_ARG_VALUE(b, 0);
    }
    else if (t == SCALAR_VARIABLE) {
      r = SCALAR_VARIABLE(b, 0);
    }
    else if (t == SETTING) {
      r = SETTING(b, 0);
    }
    else if (t == SETTINGS_LINE) {
      r = SETTINGS_LINE(b, 0);
    }
    else if (t == SETTINGS_TABLE) {
      r = SETTINGS_TABLE(b, 0);
    }
    else if (t == SETTINGS_TABLE_HEADING) {
      r = SETTINGS_TABLE_HEADING(b, 0);
    }
    else if (t == SETTING_LIST) {
      r = SETTING_LIST(b, 0);
    }
    else if (t == SINGLE_ASSIGNMENT_LHS) {
      r = SINGLE_ASSIGNMENT_LHS(b, 0);
    }
    else if (t == SINGLE_BOUND_FOR_LOOP) {
      r = SINGLE_BOUND_FOR_LOOP(b, 0);
    }
    else if (t == SINGLE_VARIABLE_LIST) {
      r = SINGLE_VARIABLE_LIST(b, 0);
    }
    else if (t == TABLE) {
      r = TABLE(b, 0);
    }
    else if (t == TAG) {
      r = TAG(b, 0);
    }
    else if (t == TAGS_META) {
      r = TAGS_META(b, 0);
    }
    else if (t == TESTCASE_LINE) {
      r = TESTCASE_LINE(b, 0);
    }
    else if (t == TEST_CASE) {
      r = TEST_CASE(b, 0);
    }
    else if (t == TEST_CASES_TABLE) {
      r = TEST_CASES_TABLE(b, 0);
    }
    else if (t == TEST_CASES_TABLE_HEADING) {
      r = TEST_CASES_TABLE_HEADING(b, 0);
    }
    else if (t == TEST_CASE_HEADER) {
      r = TEST_CASE_HEADER(b, 0);
    }
    else if (t == TEST_CASE_SETUP_META) {
      r = TEST_CASE_SETUP_META(b, 0);
    }
    else if (t == TEST_CASE_TEARDOWN_META) {
      r = TEST_CASE_TEARDOWN_META(b, 0);
    }
    else if (t == TEST_CASE_TEMPLATE_META) {
      r = TEST_CASE_TEMPLATE_META(b, 0);
    }
    else if (t == TEST_CASE_TIMEOUT_META) {
      r = TEST_CASE_TIMEOUT_META(b, 0);
    }
    else if (t == TEST_SETTING) {
      r = TEST_SETTING(b, 0);
    }
    else if (t == TEST_SETTING_LINE) {
      r = TEST_SETTING_LINE(b, 0);
    }
    else if (t == TEST_SETUP_SETTING) {
      r = TEST_SETUP_SETTING(b, 0);
    }
    else if (t == TEST_SETUP_TOKEN) {
      r = TEST_SETUP_TOKEN(b, 0);
    }
    else if (t == TEST_TEMPLATE_SETTING) {
      r = TEST_TEMPLATE_SETTING(b, 0);
    }
    else if (t == TEST_TIMEOUT_SETTING) {
      r = TEST_TIMEOUT_SETTING(b, 0);
    }
    else if (t == VARIABLE) {
      r = VARIABLE(b, 0);
    }
    else if (t == VARIABLES_LINE) {
      r = VARIABLES_LINE(b, 0);
    }
    else if (t == VARIABLES_TABLE) {
      r = VARIABLES_TABLE(b, 0);
    }
    else if (t == VARIABLES_TABLE_HEADING) {
      r = VARIABLES_TABLE_HEADING(b, 0);
    }
    else if (t == VARIABLE_ASSIGN_TO_KEYWORD) {
      r = VARIABLE_ASSIGN_TO_KEYWORD(b, 0);
    }
    else if (t == VARIABLE_SETTING) {
      r = VARIABLE_SETTING(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return robotFile(b, l + 1);
  }

  /* ********************************************************** */
  // ARGUMENTS_SETTING_TOKEN (COLUMN_SEP_TOKEN ARGUMENT_DEF)*
  public static boolean ARGUMENTS_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARGUMENTS_SETTING")) return false;
    if (!nextTokenIs(b, ARGUMENTS_SETTING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARGUMENTS_SETTING_TOKEN);
    r = r && ARGUMENTS_SETTING_1(b, l + 1);
    exit_section_(b, m, ARGUMENTS_SETTING, r);
    return r;
  }

  // (COLUMN_SEP_TOKEN ARGUMENT_DEF)*
  private static boolean ARGUMENTS_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARGUMENTS_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ARGUMENTS_SETTING_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ARGUMENTS_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN ARGUMENT_DEF
  private static boolean ARGUMENTS_SETTING_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARGUMENTS_SETTING_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && ARGUMENT_DEF(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE | SCALAR_DEFAULT_ARG_VALUE
  public static boolean ARGUMENT_DEF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARGUMENT_DEF")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<argument def>");
    r = VARIABLE(b, l + 1);
    if (!r) r = SCALAR_DEFAULT_ARG_VALUE(b, l + 1);
    exit_section_(b, l, m, ARGUMENT_DEF, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE )*
  public static boolean ARRAY_ASSIGNABLE_IN_VARIABLES_TBL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARRAY_ASSIGNABLE_IN_VARIABLES_TBL")) return false;
    Marker m = enter_section_(b, l, _NONE_, "<array assignable in variables tbl>");
    int c = current_position_(b);
    while (true) {
      if (!ARRAY_ASSIGNABLE_IN_VARIABLES_TBL_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ARRAY_ASSIGNABLE_IN_VARIABLES_TBL", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, ARRAY_ASSIGNABLE_IN_VARIABLES_TBL, true, false, null);
    return true;
  }

  // KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  private static boolean ARRAY_ASSIGNABLE_IN_VARIABLES_TBL_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARRAY_ASSIGNABLE_IN_VARIABLES_TBL_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_ARG_LIST(b, l + 1);
    if (!r) r = ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ARRAY_ASSIGNMENT_TOKEN
  public static boolean ARRAY_ASSIGNMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARRAY_ASSIGNMENT")) return false;
    if (!nextTokenIs(b, ARRAY_ASSIGNMENT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARRAY_ASSIGNMENT_TOKEN);
    exit_section_(b, m, ARRAY_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ARRAY_VARIABLE | ARRAY_ASSIGNMENT
  public static boolean ARRAY_ASSIGNMENT_LHS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARRAY_ASSIGNMENT_LHS")) return false;
    if (!nextTokenIs(b, "<array assignment lhs>", ARRAY_ASSIGNMENT_TOKEN, ARRAY_VARIABLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<array assignment lhs>");
    r = ARRAY_VARIABLE(b, l + 1);
    if (!r) r = ARRAY_ASSIGNMENT(b, l + 1);
    exit_section_(b, l, m, ARRAY_ASSIGNMENT_LHS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ARRAY_VARIABLE_TOKEN
  public static boolean ARRAY_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ARRAY_VARIABLE")) return false;
    if (!nextTokenIs(b, ARRAY_VARIABLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARRAY_VARIABLE_TOKEN);
    exit_section_(b, m, ARRAY_VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean ASSIGNABLE_IN_VARIABLES_TBL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ASSIGNABLE_IN_VARIABLES_TBL")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    exit_section_(b, m, ASSIGNABLE_IN_VARIABLES_TBL, r);
    return r;
  }

  /* ********************************************************** */
  // SCALAR_ASSIGNMENT | ARRAY_ASSIGNMENT
  public static boolean ASSIGNMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ASSIGNMENT")) return false;
    if (!nextTokenIs(b, "<assignment>", ARRAY_ASSIGNMENT_TOKEN, ASSIGNMENT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<assignment>");
    r = SCALAR_ASSIGNMENT(b, l + 1);
    if (!r) r = ARRAY_ASSIGNMENT(b, l + 1);
    exit_section_(b, l, m, ASSIGNMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOCUMENTATION_META_TOKEN  (ELLIPSES_FOR_TEST_TABLE? COLUMN_SEP_TOKEN  DOCUMENTATION_TOKEN)*
  public static boolean DOCUMENTATION_META(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_META")) return false;
    if (!nextTokenIs(b, DOCUMENTATION_META_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, DOCUMENTATION_META_TOKEN);
    p = r; // pin = 1
    r = r && DOCUMENTATION_META_1(b, l + 1);
    exit_section_(b, l, m, DOCUMENTATION_META, r, p, null);
    return r || p;
  }

  // (ELLIPSES_FOR_TEST_TABLE? COLUMN_SEP_TOKEN  DOCUMENTATION_TOKEN)*
  private static boolean DOCUMENTATION_META_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_META_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!DOCUMENTATION_META_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOCUMENTATION_META_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ELLIPSES_FOR_TEST_TABLE? COLUMN_SEP_TOKEN  DOCUMENTATION_TOKEN
  private static boolean DOCUMENTATION_META_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_META_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DOCUMENTATION_META_1_0_0(b, l + 1);
    r = r && consumeTokens(b, 0, COLUMN_SEP_TOKEN, DOCUMENTATION_TOKEN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELLIPSES_FOR_TEST_TABLE?
  private static boolean DOCUMENTATION_META_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_META_1_0_0")) return false;
    ELLIPSES_FOR_TEST_TABLE(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (COLUMN_SEP_TOKEN DOCUMENTATION_TOKEN) | ELLIPSES_FOR_SETTINGS_TABLE
  static boolean DOCUMENTATION_OR_ELLIPSES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_OR_ELLIPSES")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DOCUMENTATION_OR_ELLIPSES_0(b, l + 1);
    if (!r) r = ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLUMN_SEP_TOKEN DOCUMENTATION_TOKEN
  private static boolean DOCUMENTATION_OR_ELLIPSES_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_OR_ELLIPSES_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLUMN_SEP_TOKEN, DOCUMENTATION_TOKEN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOCUMENTATION_SETTING_TOKEN  DOCUMENTATION_OR_ELLIPSES*
  public static boolean DOCUMENTATION_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_SETTING")) return false;
    if (!nextTokenIs(b, DOCUMENTATION_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, DOCUMENTATION_SETTING_TOKEN);
    p = r; // pin = 1
    r = r && DOCUMENTATION_SETTING_1(b, l + 1);
    exit_section_(b, l, m, DOCUMENTATION_SETTING, r, p, null);
    return r || p;
  }

  // DOCUMENTATION_OR_ELLIPSES*
  private static boolean DOCUMENTATION_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOCUMENTATION_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!DOCUMENTATION_OR_ELLIPSES(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOCUMENTATION_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // FOR_VAR_IN_RANGE INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  //                                            INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean DOUBLE_BOUND_FOR_LOOP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_BOUND_FOR_LOOP")) return false;
    if (!nextTokenIs(b, FOR_LOOP_START_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_VAR_IN_RANGE(b, l + 1);
    r = r && DOUBLE_BOUND_FOR_LOOP_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    r = r && DOUBLE_BOUND_FOR_LOOP_4(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    exit_section_(b, m, DOUBLE_BOUND_FOR_LOOP, r);
    return r;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_BOUND_FOR_LOOP_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOUBLE_BOUND_FOR_LOOP_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_BOUND_FOR_LOOP_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOUBLE_BOUND_FOR_LOOP_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // FOR_VAR_IN_RANGE INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  //                                                      INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  //                                                      INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP")) return false;
    if (!nextTokenIs(b, FOR_LOOP_START_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_VAR_IN_RANGE(b, l + 1);
    r = r && DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    r = r && DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    r = r && DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    exit_section_(b, m, DOUBLE_BOUND_FOR_LOOP_WITH_STEP, r);
    return r;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DOUBLE_BOUND_FOR_LOOP_WITH_STEP_7", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ELLIPSES_TOKEN
  public static boolean ELLIPSES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES")) return false;
    if (!nextTokenIs(b, ELLIPSES_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELLIPSES_TOKEN);
    exit_section_(b, m, ELLIPSES, r);
    return r;
  }

  /* ********************************************************** */
  // EMPTY_LINE WHITESPACE_TOKEN? COLUMN_SEP_TOKEN? ELLIPSES
  static boolean ELLIPSES_FOR_SETTINGS_TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_FOR_SETTINGS_TABLE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EMPTY_LINE(b, l + 1);
    r = r && ELLIPSES_FOR_SETTINGS_TABLE_1(b, l + 1);
    r = r && ELLIPSES_FOR_SETTINGS_TABLE_2(b, l + 1);
    r = r && ELLIPSES(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITESPACE_TOKEN?
  private static boolean ELLIPSES_FOR_SETTINGS_TABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_FOR_SETTINGS_TABLE_1")) return false;
    consumeToken(b, WHITESPACE_TOKEN);
    return true;
  }

  // COLUMN_SEP_TOKEN?
  private static boolean ELLIPSES_FOR_SETTINGS_TABLE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_FOR_SETTINGS_TABLE_2")) return false;
    consumeToken(b, COLUMN_SEP_TOKEN);
    return true;
  }

  /* ********************************************************** */
  // EMPTY_LINE COLUMN_SEP_TOKEN ELLIPSES
  static boolean ELLIPSES_FOR_TEST_TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_FOR_TEST_TABLE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EMPTY_LINE(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && ELLIPSES(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN? WHITESPACE_TOKEN? ELLIPSES
  static boolean ELLIPSES_LINE_SETTINGS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_LINE_SETTINGS")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ELLIPSES_LINE_SETTINGS_0(b, l + 1);
    r = r && ELLIPSES_LINE_SETTINGS_1(b, l + 1);
    r = r && ELLIPSES(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLUMN_SEP_TOKEN?
  private static boolean ELLIPSES_LINE_SETTINGS_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_LINE_SETTINGS_0")) return false;
    consumeToken(b, COLUMN_SEP_TOKEN);
    return true;
  }

  // WHITESPACE_TOKEN?
  private static boolean ELLIPSES_LINE_SETTINGS_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_LINE_SETTINGS_1")) return false;
    consumeToken(b, WHITESPACE_TOKEN);
    return true;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  ELLIPSES
  public static boolean ELLIPSES_LINE_TEST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ELLIPSES_LINE_TEST")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && ELLIPSES(b, l + 1);
    exit_section_(b, m, ELLIPSES_LINE_TEST, r);
    return r;
  }

  /* ********************************************************** */
  // NEWLINE_TOKEN END_OF_LINE* & NEWLINE_TOKEN
  static boolean EMPTY_FOR_LOOP_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EMPTY_FOR_LOOP_LINE")) return false;
    if (!nextTokenIs(b, NEWLINE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE_TOKEN);
    r = r && EMPTY_FOR_LOOP_LINE_1(b, l + 1);
    r = r && EMPTY_FOR_LOOP_LINE_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean EMPTY_FOR_LOOP_LINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EMPTY_FOR_LOOP_LINE_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EMPTY_FOR_LOOP_LINE_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // & NEWLINE_TOKEN
  private static boolean EMPTY_FOR_LOOP_LINE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EMPTY_FOR_LOOP_LINE_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_, null);
    r = consumeToken(b, NEWLINE_TOKEN);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // END_OF_LINE* NEWLINE_TOKEN
  public static boolean EMPTY_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EMPTY_LINE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<empty line>");
    r = EMPTY_LINE_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE_TOKEN);
    exit_section_(b, l, m, EMPTY_LINE, r, false, null);
    return r;
  }

  // END_OF_LINE*
  private static boolean EMPTY_LINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EMPTY_LINE_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EMPTY_LINE_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN | WHITESPACE_TOKEN | COMMENT_TOKEN
  static boolean END_OF_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "END_OF_LINE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    if (!r) r = consumeToken(b, WHITESPACE_TOKEN);
    if (!r) r = consumeToken(b, COMMENT_TOKEN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BAD_SYNTAX_TOKEN
  public static boolean ERROR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ERROR")) return false;
    if (!nextTokenIs(b, BAD_SYNTAX_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAD_SYNTAX_TOKEN);
    exit_section_(b, m, ERROR, r);
    return r;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN ( KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD )
  public static boolean EXECUTION_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EXECUTION_LINE")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && EXECUTION_LINE_1(b, l + 1);
    exit_section_(b, m, EXECUTION_LINE, r);
    return r;
  }

  // KEYWORD_INVOCATION_TEST | VARIABLE_ASSIGN_TO_KEYWORD
  private static boolean EXECUTION_LINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EXECUTION_LINE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_INVOCATION_TEST(b, l + 1);
    if (!r) r = VARIABLE_ASSIGN_TO_KEYWORD(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FORCE_TAGS_SETTING_KEYWORD_TOKEN TAG_LIST_OR_ELLIPSES_NO_COL*
  public static boolean FORCE_TAGS_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FORCE_TAGS_SETTING")) return false;
    if (!nextTokenIs(b, FORCE_TAGS_SETTING_KEYWORD_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, FORCE_TAGS_SETTING_KEYWORD_TOKEN);
    p = r; // pin = 1
    r = r && FORCE_TAGS_SETTING_1(b, l + 1);
    exit_section_(b, l, m, FORCE_TAGS_SETTING, r, p, null);
    return r || p;
  }

  // TAG_LIST_OR_ELLIPSES_NO_COL*
  private static boolean FORCE_TAGS_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FORCE_TAGS_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TAG_LIST_OR_ELLIPSES_NO_COL(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FORCE_TAGS_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // EMPTY_FOR_LOOP_LINE* NON_EMPTY_FOR_LOOP_LINE
  static boolean FOR_LOOP_EXECUTION_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_EXECUTION_LINE")) return false;
    if (!nextTokenIs(b, NEWLINE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_LOOP_EXECUTION_LINE_0(b, l + 1);
    r = r && NON_EMPTY_FOR_LOOP_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EMPTY_FOR_LOOP_LINE*
  private static boolean FOR_LOOP_EXECUTION_LINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_EXECUTION_LINE_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!EMPTY_FOR_LOOP_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FOR_LOOP_EXECUTION_LINE_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  FOR_VAR_IN  FOR_LOOP_VALUE_LIST END_OF_LINE* FOR_LOOP_EXECUTION_LINE+
  public static boolean FOR_LOOP_IN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_IN")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && FOR_VAR_IN(b, l + 1);
    r = r && FOR_LOOP_VALUE_LIST(b, l + 1);
    r = r && FOR_LOOP_IN_3(b, l + 1);
    p = r; // pin = 4
    r = r && FOR_LOOP_IN_4(b, l + 1);
    exit_section_(b, l, m, FOR_LOOP_IN, r, p, null);
    return r || p;
  }

  // END_OF_LINE*
  private static boolean FOR_LOOP_IN_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_IN_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FOR_LOOP_IN_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // FOR_LOOP_EXECUTION_LINE+
  private static boolean FOR_LOOP_IN_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_IN_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_LOOP_EXECUTION_LINE(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!FOR_LOOP_EXECUTION_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FOR_LOOP_IN_4", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN (DOUBLE_BOUND_FOR_LOOP_WITH_STEP | DOUBLE_BOUND_FOR_LOOP | SINGLE_BOUND_FOR_LOOP )
  //                       END_OF_LINE* FOR_LOOP_EXECUTION_LINE+
  public static boolean FOR_LOOP_IN_RANGE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_IN_RANGE")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && FOR_LOOP_IN_RANGE_1(b, l + 1);
    r = r && FOR_LOOP_IN_RANGE_2(b, l + 1);
    p = r; // pin = 3
    r = r && FOR_LOOP_IN_RANGE_3(b, l + 1);
    exit_section_(b, l, m, FOR_LOOP_IN_RANGE, r, p, null);
    return r || p;
  }

  // DOUBLE_BOUND_FOR_LOOP_WITH_STEP | DOUBLE_BOUND_FOR_LOOP | SINGLE_BOUND_FOR_LOOP
  private static boolean FOR_LOOP_IN_RANGE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_IN_RANGE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DOUBLE_BOUND_FOR_LOOP_WITH_STEP(b, l + 1);
    if (!r) r = DOUBLE_BOUND_FOR_LOOP(b, l + 1);
    if (!r) r = SINGLE_BOUND_FOR_LOOP(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean FOR_LOOP_IN_RANGE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_IN_RANGE_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FOR_LOOP_IN_RANGE_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // FOR_LOOP_EXECUTION_LINE+
  private static boolean FOR_LOOP_IN_RANGE_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_IN_RANGE_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_LOOP_EXECUTION_LINE(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!FOR_LOOP_EXECUTION_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FOR_LOOP_IN_RANGE_3", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE)+
  public static boolean FOR_LOOP_VALUE_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_VALUE_LIST")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<for loop value list>");
    r = FOR_LOOP_VALUE_LIST_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!FOR_LOOP_VALUE_LIST_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FOR_LOOP_VALUE_LIST", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, FOR_LOOP_VALUE_LIST, r, false, null);
    return r;
  }

  // KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE
  private static boolean FOR_LOOP_VALUE_LIST_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_LOOP_VALUE_LIST_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_ARG_LIST(b, l + 1);
    if (!r) r = ELLIPSES_FOR_TEST_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOR_LOOP_START_TOKEN  INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN SINGLE_VARIABLE_LIST  COLUMN_SEP_TOKEN  IN_TOKEN
  public static boolean FOR_VAR_IN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_VAR_IN")) return false;
    if (!nextTokenIs(b, FOR_LOOP_START_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_LOOP_START_TOKEN);
    r = r && FOR_VAR_IN_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && SINGLE_VARIABLE_LIST(b, l + 1);
    r = r && consumeTokens(b, 0, COLUMN_SEP_TOKEN, IN_TOKEN);
    exit_section_(b, m, FOR_VAR_IN, r);
    return r;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean FOR_VAR_IN_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_VAR_IN_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FOR_VAR_IN_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // FOR_LOOP_START_TOKEN  COLUMN_SEP_TOKEN SCALAR_VARIABLE COLUMN_SEP_TOKEN IN_RANGE_TOKEN
  public static boolean FOR_VAR_IN_RANGE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FOR_VAR_IN_RANGE")) return false;
    if (!nextTokenIs(b, FOR_LOOP_START_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR_LOOP_START_TOKEN, COLUMN_SEP_TOKEN);
    r = r && SCALAR_VARIABLE(b, l + 1);
    r = r && consumeTokens(b, 0, COLUMN_SEP_TOKEN, IN_RANGE_TOKEN);
    exit_section_(b, m, FOR_VAR_IN_RANGE, r);
    return r;
  }

  /* ********************************************************** */
  // GENERIC_SETTING_NAME SETTING_LIST_OR_ELLIPSES*
  public static boolean GENERIC_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GENERIC_SETTING")) return false;
    if (!nextTokenIs(b, GENERIC_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = GENERIC_SETTING_NAME(b, l + 1);
    p = r; // pin = 1
    r = r && GENERIC_SETTING_1(b, l + 1);
    exit_section_(b, l, m, GENERIC_SETTING, r, p, null);
    return r || p;
  }

  // SETTING_LIST_OR_ELLIPSES*
  private static boolean GENERIC_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GENERIC_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SETTING_LIST_OR_ELLIPSES(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GENERIC_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // GENERIC_SETTING_TOKEN
  public static boolean GENERIC_SETTING_NAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GENERIC_SETTING_NAME")) return false;
    if (!nextTokenIs(b, GENERIC_SETTING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GENERIC_SETTING_TOKEN);
    exit_section_(b, m, GENERIC_SETTING_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // END_OF_LINE* NEWLINE_TOKEN COLUMN_SEP_TOKEN EMPTY_CELL_TOKEN COLUMN_SEP_TOKEN ELLIPSES
  static boolean INDENTED_ELLIPSES_FOR_TEST_TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_ELLIPSES_FOR_TEST_TABLE")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INDENTED_ELLIPSES_FOR_TEST_TABLE_0(b, l + 1);
    r = r && consumeTokens(b, 0, NEWLINE_TOKEN, COLUMN_SEP_TOKEN, EMPTY_CELL_TOKEN, COLUMN_SEP_TOKEN);
    r = r && ELLIPSES(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean INDENTED_ELLIPSES_FOR_TEST_TABLE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_ELLIPSES_FOR_TEST_TABLE_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "INDENTED_ELLIPSES_FOR_TEST_TABLE_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // KEYWORD (KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE)+ | KEYWORD
  public static boolean INDENTED_KEYWORD_INVOCATION_TEST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_KEYWORD_INVOCATION_TEST")) return false;
    if (!nextTokenIs(b, ROBOT_KEYWORD_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INDENTED_KEYWORD_INVOCATION_TEST_0(b, l + 1);
    if (!r) r = KEYWORD(b, l + 1);
    exit_section_(b, m, INDENTED_KEYWORD_INVOCATION_TEST, r);
    return r;
  }

  // KEYWORD (KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE)+
  private static boolean INDENTED_KEYWORD_INVOCATION_TEST_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_KEYWORD_INVOCATION_TEST_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD(b, l + 1);
    r = r && INDENTED_KEYWORD_INVOCATION_TEST_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE)+
  private static boolean INDENTED_KEYWORD_INVOCATION_TEST_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_KEYWORD_INVOCATION_TEST_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INDENTED_KEYWORD_INVOCATION_TEST_0_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!INDENTED_KEYWORD_INVOCATION_TEST_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "INDENTED_KEYWORD_INVOCATION_TEST_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // KEYWORD_ARG_LIST | INDENTED_ELLIPSES_FOR_TEST_TABLE
  private static boolean INDENTED_KEYWORD_INVOCATION_TEST_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_KEYWORD_INVOCATION_TEST_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_ARG_LIST(b, l + 1);
    if (!r) r = INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS ) INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN  INDENTED_KEYWORD_INVOCATION_TEST
  public static boolean INDENTED_VARIABLE_ASSIGN_TO_KEYWORD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<indented variable assign to keyword>");
    r = INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_0(b, l + 1);
    r = r && INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && INDENTED_KEYWORD_INVOCATION_TEST(b, l + 1);
    exit_section_(b, l, m, INDENTED_VARIABLE_ASSIGN_TO_KEYWORD, r, false, null);
    return r;
  }

  // MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS
  private static boolean INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MULTI_ASSIGNMENT_LHS(b, l + 1);
    if (!r) r = SINGLE_ASSIGNMENT_LHS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "INDENTED_VARIABLE_ASSIGN_TO_KEYWORD_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // JAVA_CLASS_TOKEN
  public static boolean JAVA_CLASS_REFERENCE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JAVA_CLASS_REFERENCE")) return false;
    if (!nextTokenIs(b, JAVA_CLASS_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, JAVA_CLASS_TOKEN);
    exit_section_(b, m, JAVA_CLASS_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_TOKEN
  public static boolean KEYWORD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD")) return false;
    if (!nextTokenIs(b, ROBOT_KEYWORD_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROBOT_KEYWORD_TOKEN);
    exit_section_(b, m, KEYWORD, r);
    return r;
  }

  /* ********************************************************** */
  // KEYWORDS_TABLE_HEADING (EMPTY_LINE | KEYWORD_DEFINITION)*
  public static boolean KEYWORDS_TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORDS_TABLE")) return false;
    if (!nextTokenIs(b, KEYWORDS_TABLE_HEADING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = KEYWORDS_TABLE_HEADING(b, l + 1);
    p = r; // pin = 1
    r = r && KEYWORDS_TABLE_1(b, l + 1);
    exit_section_(b, l, m, KEYWORDS_TABLE, r, p, null);
    return r || p;
  }

  // (EMPTY_LINE | KEYWORD_DEFINITION)*
  private static boolean KEYWORDS_TABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORDS_TABLE_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!KEYWORDS_TABLE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORDS_TABLE_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // EMPTY_LINE | KEYWORD_DEFINITION
  private static boolean KEYWORDS_TABLE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORDS_TABLE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EMPTY_LINE(b, l + 1);
    if (!r) r = KEYWORD_DEFINITION(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KEYWORDS_TABLE_HEADING_TOKEN END_OF_LINE* NEWLINE_TOKEN
  public static boolean KEYWORDS_TABLE_HEADING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORDS_TABLE_HEADING")) return false;
    if (!nextTokenIs(b, KEYWORDS_TABLE_HEADING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KEYWORDS_TABLE_HEADING_TOKEN);
    r = r && KEYWORDS_TABLE_HEADING_1(b, l + 1);
    r = r && consumeToken(b, NEWLINE_TOKEN);
    exit_section_(b, m, KEYWORDS_TABLE_HEADING, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORDS_TABLE_HEADING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORDS_TABLE_HEADING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORDS_TABLE_HEADING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLE | ROBOT_KEYWORD_ARG_TOKEN | EMPTY_CELL_TOKEN | INTEGER_TOKEN | ARRAY_VARIABLE_ACCESS_TOKEN | ROBOT_KEYWORD_TOKEN
  public static boolean KEYWORD_ARG(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_ARG")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<keyword arg>");
    r = VARIABLE(b, l + 1);
    if (!r) r = consumeToken(b, ROBOT_KEYWORD_ARG_TOKEN);
    if (!r) r = consumeToken(b, EMPTY_CELL_TOKEN);
    if (!r) r = consumeToken(b, INTEGER_TOKEN);
    if (!r) r = consumeToken(b, ARRAY_VARIABLE_ACCESS_TOKEN);
    if (!r) r = consumeToken(b, ROBOT_KEYWORD_TOKEN);
    exit_section_(b, l, m, KEYWORD_ARG, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (COLUMN_SEP_TOKEN KEYWORD_ARG)+
  public static boolean KEYWORD_ARG_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_ARG_LIST")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_ARG_LIST_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!KEYWORD_ARG_LIST_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_ARG_LIST", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, KEYWORD_ARG_LIST, r);
    return r;
  }

  // COLUMN_SEP_TOKEN KEYWORD_ARG
  private static boolean KEYWORD_ARG_LIST_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_ARG_LIST_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KEYWORD_TITLE  (KEYWORD_LINE EMPTY_LINE | EMPTY_LINE )* (KEYWORD_LINE END_OF_LINE* <<eof>>)?
  public static boolean KEYWORD_DEFINITION(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_DEFINITION")) return false;
    if (!nextTokenIs(b, ROBOT_KEYWORD_TITLE_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = KEYWORD_TITLE(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, KEYWORD_DEFINITION_1(b, l + 1));
    r = p && KEYWORD_DEFINITION_2(b, l + 1) && r;
    exit_section_(b, l, m, KEYWORD_DEFINITION, r, p, null);
    return r || p;
  }

  // (KEYWORD_LINE EMPTY_LINE | EMPTY_LINE )*
  private static boolean KEYWORD_DEFINITION_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_DEFINITION_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!KEYWORD_DEFINITION_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_DEFINITION_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // KEYWORD_LINE EMPTY_LINE | EMPTY_LINE
  private static boolean KEYWORD_DEFINITION_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_DEFINITION_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_DEFINITION_1_0_0(b, l + 1);
    if (!r) r = EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KEYWORD_LINE EMPTY_LINE
  private static boolean KEYWORD_DEFINITION_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_DEFINITION_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_LINE(b, l + 1);
    r = r && EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KEYWORD_LINE END_OF_LINE* <<eof>>)?
  private static boolean KEYWORD_DEFINITION_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_DEFINITION_2")) return false;
    KEYWORD_DEFINITION_2_0(b, l + 1);
    return true;
  }

  // KEYWORD_LINE END_OF_LINE* <<eof>>
  private static boolean KEYWORD_DEFINITION_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_DEFINITION_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_LINE(b, l + 1);
    r = r && KEYWORD_DEFINITION_2_0_1(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORD_DEFINITION_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_DEFINITION_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_DEFINITION_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // KEYWORD (KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE)+ | KEYWORD
  public static boolean KEYWORD_INVOCATION_SETTINGS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_INVOCATION_SETTINGS")) return false;
    if (!nextTokenIs(b, ROBOT_KEYWORD_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_INVOCATION_SETTINGS_0(b, l + 1);
    if (!r) r = KEYWORD(b, l + 1);
    exit_section_(b, m, KEYWORD_INVOCATION_SETTINGS, r);
    return r;
  }

  // KEYWORD (KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE)+
  private static boolean KEYWORD_INVOCATION_SETTINGS_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_INVOCATION_SETTINGS_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD(b, l + 1);
    r = r && KEYWORD_INVOCATION_SETTINGS_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE)+
  private static boolean KEYWORD_INVOCATION_SETTINGS_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_INVOCATION_SETTINGS_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_INVOCATION_SETTINGS_0_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!KEYWORD_INVOCATION_SETTINGS_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_INVOCATION_SETTINGS_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // KEYWORD_ARG_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  private static boolean KEYWORD_INVOCATION_SETTINGS_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_INVOCATION_SETTINGS_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_ARG_LIST(b, l + 1);
    if (!r) r = ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KEYWORD (KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE)*
  public static boolean KEYWORD_INVOCATION_TEST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_INVOCATION_TEST")) return false;
    if (!nextTokenIs(b, ROBOT_KEYWORD_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD(b, l + 1);
    r = r && KEYWORD_INVOCATION_TEST_1(b, l + 1);
    exit_section_(b, m, KEYWORD_INVOCATION_TEST, r);
    return r;
  }

  // (KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE)*
  private static boolean KEYWORD_INVOCATION_TEST_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_INVOCATION_TEST_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!KEYWORD_INVOCATION_TEST_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_INVOCATION_TEST_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // KEYWORD_ARG_LIST | ELLIPSES_FOR_TEST_TABLE
  private static boolean KEYWORD_INVOCATION_TEST_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_INVOCATION_TEST_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_ARG_LIST(b, l + 1);
    if (!r) r = ELLIPSES_FOR_TEST_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // EXECUTION_LINE        END_OF_LINE* |
  //                  KEYWORD_SETTING_LINE  END_OF_LINE* |
  //                  RETURN_LINE           END_OF_LINE* |
  //                  ELLIPSES_LINE_TEST    END_OF_LINE* |
  //                  FOR_LOOP_IN_RANGE     END_OF_LINE* |
  //                  FOR_LOOP_IN           END_OF_LINE* |
  //                  COLUMN_SEP_TOKEN
  public static boolean KEYWORD_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<keyword line>");
    r = KEYWORD_LINE_0(b, l + 1);
    if (!r) r = KEYWORD_LINE_1(b, l + 1);
    if (!r) r = KEYWORD_LINE_2(b, l + 1);
    if (!r) r = KEYWORD_LINE_3(b, l + 1);
    if (!r) r = KEYWORD_LINE_4(b, l + 1);
    if (!r) r = KEYWORD_LINE_5(b, l + 1);
    if (!r) r = consumeToken(b, COLUMN_SEP_TOKEN);
    exit_section_(b, l, m, KEYWORD_LINE, r, false, not_a_newline_token_parser_);
    return r;
  }

  // EXECUTION_LINE        END_OF_LINE*
  private static boolean KEYWORD_LINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EXECUTION_LINE(b, l + 1);
    r = r && KEYWORD_LINE_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORD_LINE_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_LINE_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // KEYWORD_SETTING_LINE  END_OF_LINE*
  private static boolean KEYWORD_LINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_SETTING_LINE(b, l + 1);
    r = r && KEYWORD_LINE_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORD_LINE_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_LINE_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // RETURN_LINE           END_OF_LINE*
  private static boolean KEYWORD_LINE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RETURN_LINE(b, l + 1);
    r = r && KEYWORD_LINE_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORD_LINE_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_2_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_LINE_2_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ELLIPSES_LINE_TEST    END_OF_LINE*
  private static boolean KEYWORD_LINE_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ELLIPSES_LINE_TEST(b, l + 1);
    r = r && KEYWORD_LINE_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORD_LINE_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_3_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_LINE_3_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // FOR_LOOP_IN_RANGE     END_OF_LINE*
  private static boolean KEYWORD_LINE_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_LOOP_IN_RANGE(b, l + 1);
    r = r && KEYWORD_LINE_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORD_LINE_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_4_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_LINE_4_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // FOR_LOOP_IN           END_OF_LINE*
  private static boolean KEYWORD_LINE_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_LOOP_IN(b, l + 1);
    r = r && KEYWORD_LINE_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean KEYWORD_LINE_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_LINE_5_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "KEYWORD_LINE_5_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ARGUMENTS_SETTING | DOCUMENTATION_META | TEST_CASE_TEARDOWN_META | TEST_CASE_TIMEOUT_META
  public static boolean KEYWORD_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_SETTING")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<keyword setting>");
    r = ARGUMENTS_SETTING(b, l + 1);
    if (!r) r = DOCUMENTATION_META(b, l + 1);
    if (!r) r = TEST_CASE_TEARDOWN_META(b, l + 1);
    if (!r) r = TEST_CASE_TIMEOUT_META(b, l + 1);
    exit_section_(b, l, m, KEYWORD_SETTING, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN KEYWORD_SETTING
  public static boolean KEYWORD_SETTING_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_SETTING_LINE")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_SETTING(b, l + 1);
    exit_section_(b, m, KEYWORD_SETTING_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // ROBOT_KEYWORD_TITLE_TOKEN
  public static boolean KEYWORD_TITLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KEYWORD_TITLE")) return false;
    if (!nextTokenIs(b, ROBOT_KEYWORD_TITLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROBOT_KEYWORD_TITLE_TOKEN);
    exit_section_(b, m, KEYWORD_TITLE, r);
    return r;
  }

  /* ********************************************************** */
  // LIBRARY_SETTING_TOKEN  COLUMN_SEP_TOKEN  JAVA_CLASS_REFERENCE   SETTING_LIST_OR_ELLIPSES*
  public static boolean LIBRARY_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LIBRARY_SETTING")) return false;
    if (!nextTokenIs(b, LIBRARY_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 0, LIBRARY_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    r = r && JAVA_CLASS_REFERENCE(b, l + 1);
    p = r; // pin = 3
    r = r && LIBRARY_SETTING_3(b, l + 1);
    exit_section_(b, l, m, LIBRARY_SETTING, r, p, null);
    return r || p;
  }

  // SETTING_LIST_OR_ELLIPSES*
  private static boolean LIBRARY_SETTING_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LIBRARY_SETTING_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SETTING_LIST_OR_ELLIPSES(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LIBRARY_SETTING_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // METADATA_SETTING_TOKEN  SETTING_LIST_OR_ELLIPSES*
  public static boolean METADATA_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "METADATA_SETTING")) return false;
    if (!nextTokenIs(b, METADATA_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, METADATA_SETTING_TOKEN);
    p = r; // pin = 1
    r = r && METADATA_SETTING_1(b, l + 1);
    exit_section_(b, l, m, METADATA_SETTING, r, p, null);
    return r || p;
  }

  // SETTING_LIST_OR_ELLIPSES*
  private static boolean METADATA_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "METADATA_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SETTING_LIST_OR_ELLIPSES(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "METADATA_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLE (COLUMN_SEP_TOKEN VARIABLE)*  COLUMN_SEP_TOKEN ASSIGNMENT
  //                        |  VARIABLE (COLUMN_SEP_TOKEN  VARIABLE)+
  public static boolean MULTI_ASSIGNMENT_LHS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTI_ASSIGNMENT_LHS")) return false;
    if (!nextTokenIs(b, "<multi assignment lhs>", ARRAY_VARIABLE_TOKEN, VARIABLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<multi assignment lhs>");
    r = MULTI_ASSIGNMENT_LHS_0(b, l + 1);
    if (!r) r = MULTI_ASSIGNMENT_LHS_1(b, l + 1);
    exit_section_(b, l, m, MULTI_ASSIGNMENT_LHS, r, false, null);
    return r;
  }

  // VARIABLE (COLUMN_SEP_TOKEN VARIABLE)*  COLUMN_SEP_TOKEN ASSIGNMENT
  private static boolean MULTI_ASSIGNMENT_LHS_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTI_ASSIGNMENT_LHS_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VARIABLE(b, l + 1);
    r = r && MULTI_ASSIGNMENT_LHS_0_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && ASSIGNMENT(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLUMN_SEP_TOKEN VARIABLE)*
  private static boolean MULTI_ASSIGNMENT_LHS_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTI_ASSIGNMENT_LHS_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!MULTI_ASSIGNMENT_LHS_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MULTI_ASSIGNMENT_LHS_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COLUMN_SEP_TOKEN VARIABLE
  private static boolean MULTI_ASSIGNMENT_LHS_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTI_ASSIGNMENT_LHS_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && VARIABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VARIABLE (COLUMN_SEP_TOKEN  VARIABLE)+
  private static boolean MULTI_ASSIGNMENT_LHS_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTI_ASSIGNMENT_LHS_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VARIABLE(b, l + 1);
    r = r && MULTI_ASSIGNMENT_LHS_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLUMN_SEP_TOKEN  VARIABLE)+
  private static boolean MULTI_ASSIGNMENT_LHS_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTI_ASSIGNMENT_LHS_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MULTI_ASSIGNMENT_LHS_1_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!MULTI_ASSIGNMENT_LHS_1_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MULTI_ASSIGNMENT_LHS_1_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // COLUMN_SEP_TOKEN  VARIABLE
  private static boolean MULTI_ASSIGNMENT_LHS_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MULTI_ASSIGNMENT_LHS_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && VARIABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NEWLINE_TOKEN COLUMN_SEP_TOKEN  EMPTY_CELL_TOKEN COLUMN_SEP_TOKEN ( INDENTED_KEYWORD_INVOCATION_TEST | INDENTED_VARIABLE_ASSIGN_TO_KEYWORD ) END_OF_LINE*
  static boolean NON_EMPTY_FOR_LOOP_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NON_EMPTY_FOR_LOOP_LINE")) return false;
    if (!nextTokenIs(b, NEWLINE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NEWLINE_TOKEN, COLUMN_SEP_TOKEN, EMPTY_CELL_TOKEN, COLUMN_SEP_TOKEN);
    r = r && NON_EMPTY_FOR_LOOP_LINE_4(b, l + 1);
    r = r && NON_EMPTY_FOR_LOOP_LINE_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // INDENTED_KEYWORD_INVOCATION_TEST | INDENTED_VARIABLE_ASSIGN_TO_KEYWORD
  private static boolean NON_EMPTY_FOR_LOOP_LINE_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NON_EMPTY_FOR_LOOP_LINE_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = INDENTED_KEYWORD_INVOCATION_TEST(b, l + 1);
    if (!r) r = INDENTED_VARIABLE_ASSIGN_TO_KEYWORD(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean NON_EMPTY_FOR_LOOP_LINE_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NON_EMPTY_FOR_LOOP_LINE_5")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "NON_EMPTY_FOR_LOOP_LINE_5", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ROBOT_FILE_TOKEN
  public static boolean RESOURCE_FILE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RESOURCE_FILE")) return false;
    if (!nextTokenIs(b, ROBOT_FILE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROBOT_FILE_TOKEN);
    exit_section_(b, m, RESOURCE_FILE, r);
    return r;
  }

  /* ********************************************************** */
  // RESOURCE_SETTING_TOKEN  ELLIPSES_FOR_SETTINGS_TABLE* COLUMN_SEP_TOKEN  RESOURCE_FILE
  public static boolean RESOURCE_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RESOURCE_SETTING")) return false;
    if (!nextTokenIs(b, RESOURCE_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, RESOURCE_SETTING_TOKEN);
    p = r; // pin = 1
    r = r && report_error_(b, RESOURCE_SETTING_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLUMN_SEP_TOKEN)) && r;
    r = p && RESOURCE_FILE(b, l + 1) && r;
    exit_section_(b, l, m, RESOURCE_SETTING, r, p, null);
    return r || p;
  }

  // ELLIPSES_FOR_SETTINGS_TABLE*
  private static boolean RESOURCE_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RESOURCE_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RESOURCE_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN RETURN_SETTING
  public static boolean RETURN_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RETURN_LINE")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && RETURN_SETTING(b, l + 1);
    exit_section_(b, m, RETURN_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN_SETTING_TOKEN (COLUMN_SEP_TOKEN KEYWORD_ARG)+
  public static boolean RETURN_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RETURN_SETTING")) return false;
    if (!nextTokenIs(b, RETURN_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, RETURN_SETTING_TOKEN);
    p = r; // pin = 1
    r = r && RETURN_SETTING_1(b, l + 1);
    exit_section_(b, l, m, RETURN_SETTING, r, p, null);
    return r || p;
  }

  // (COLUMN_SEP_TOKEN KEYWORD_ARG)+
  private static boolean RETURN_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RETURN_SETTING_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RETURN_SETTING_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!RETURN_SETTING_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "RETURN_SETTING_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // COLUMN_SEP_TOKEN KEYWORD_ARG
  private static boolean RETURN_SETTING_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RETURN_SETTING_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASSIGNMENT_TOKEN
  public static boolean SCALAR_ASSIGNMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCALAR_ASSIGNMENT")) return false;
    if (!nextTokenIs(b, ASSIGNMENT_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT_TOKEN);
    exit_section_(b, m, SCALAR_ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // SCALAR_VARIABLE | SCALAR_ASSIGNMENT
  public static boolean SCALAR_ASSIGNMENT_LHS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCALAR_ASSIGNMENT_LHS")) return false;
    if (!nextTokenIs(b, "<scalar assignment lhs>", ASSIGNMENT_TOKEN, VARIABLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<scalar assignment lhs>");
    r = SCALAR_VARIABLE(b, l + 1);
    if (!r) r = SCALAR_ASSIGNMENT(b, l + 1);
    exit_section_(b, l, m, SCALAR_ASSIGNMENT_LHS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SCALAR_DEFAULT_ARG_VALUE_TOKEN
  public static boolean SCALAR_DEFAULT_ARG_VALUE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCALAR_DEFAULT_ARG_VALUE")) return false;
    if (!nextTokenIs(b, SCALAR_DEFAULT_ARG_VALUE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCALAR_DEFAULT_ARG_VALUE_TOKEN);
    exit_section_(b, m, SCALAR_DEFAULT_ARG_VALUE, r);
    return r;
  }

  /* ********************************************************** */
  // VARIABLE_TOKEN
  public static boolean SCALAR_VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SCALAR_VARIABLE")) return false;
    if (!nextTokenIs(b, VARIABLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLE_TOKEN);
    exit_section_(b, m, SCALAR_VARIABLE, r);
    return r;
  }

  /* ********************************************************** */
  // FORCE_TAGS_SETTING |
  //             RESOURCE_SETTING |
  //             VARIABLE_SETTING |
  //             TEST_SETUP_SETTING |
  //             LIBRARY_SETTING |
  //             TEST_TIMEOUT_SETTING |
  //             DOCUMENTATION_SETTING |
  //             METADATA_SETTING |
  //             TEST_TEMPLATE_SETTING |
  //             GENERIC_SETTING
  public static boolean SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTING")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<setting>");
    r = FORCE_TAGS_SETTING(b, l + 1);
    if (!r) r = RESOURCE_SETTING(b, l + 1);
    if (!r) r = VARIABLE_SETTING(b, l + 1);
    if (!r) r = TEST_SETUP_SETTING(b, l + 1);
    if (!r) r = LIBRARY_SETTING(b, l + 1);
    if (!r) r = TEST_TIMEOUT_SETTING(b, l + 1);
    if (!r) r = DOCUMENTATION_SETTING(b, l + 1);
    if (!r) r = METADATA_SETTING(b, l + 1);
    if (!r) r = TEST_TEMPLATE_SETTING(b, l + 1);
    if (!r) r = GENERIC_SETTING(b, l + 1);
    exit_section_(b, l, m, SETTING, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WHITESPACE_TOKEN? SETTING END_OF_LINE* |
  //                   ELLIPSES_LINE_SETTINGS    END_OF_LINE*
  public static boolean SETTINGS_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_LINE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<settings line>");
    r = SETTINGS_LINE_0(b, l + 1);
    if (!r) r = SETTINGS_LINE_1(b, l + 1);
    exit_section_(b, l, m, SETTINGS_LINE, r, false, not_a_newline_token_parser_);
    return r;
  }

  // WHITESPACE_TOKEN? SETTING END_OF_LINE*
  private static boolean SETTINGS_LINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_LINE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SETTINGS_LINE_0_0(b, l + 1);
    r = r && SETTING(b, l + 1);
    r = r && SETTINGS_LINE_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHITESPACE_TOKEN?
  private static boolean SETTINGS_LINE_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_LINE_0_0")) return false;
    consumeToken(b, WHITESPACE_TOKEN);
    return true;
  }

  // END_OF_LINE*
  private static boolean SETTINGS_LINE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_LINE_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SETTINGS_LINE_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ELLIPSES_LINE_SETTINGS    END_OF_LINE*
  private static boolean SETTINGS_LINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_LINE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ELLIPSES_LINE_SETTINGS(b, l + 1);
    r = r && SETTINGS_LINE_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean SETTINGS_LINE_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_LINE_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SETTINGS_LINE_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // SETTINGS_TABLE_HEADING (SETTINGS_LINE EMPTY_LINE | EMPTY_LINE)* (SETTINGS_LINE END_OF_LINE* <<eof>>)?
  public static boolean SETTINGS_TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE")) return false;
    if (!nextTokenIs(b, SETTINGS_TABLE_HEADING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = SETTINGS_TABLE_HEADING(b, l + 1);
    r = r && SETTINGS_TABLE_1(b, l + 1);
    p = r; // pin = 2
    r = r && SETTINGS_TABLE_2(b, l + 1);
    exit_section_(b, l, m, SETTINGS_TABLE, r, p, null);
    return r || p;
  }

  // (SETTINGS_LINE EMPTY_LINE | EMPTY_LINE)*
  private static boolean SETTINGS_TABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!SETTINGS_TABLE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SETTINGS_TABLE_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // SETTINGS_LINE EMPTY_LINE | EMPTY_LINE
  private static boolean SETTINGS_TABLE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SETTINGS_TABLE_1_0_0(b, l + 1);
    if (!r) r = EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SETTINGS_LINE EMPTY_LINE
  private static boolean SETTINGS_TABLE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SETTINGS_LINE(b, l + 1);
    r = r && EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SETTINGS_LINE END_OF_LINE* <<eof>>)?
  private static boolean SETTINGS_TABLE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE_2")) return false;
    SETTINGS_TABLE_2_0(b, l + 1);
    return true;
  }

  // SETTINGS_LINE END_OF_LINE* <<eof>>
  private static boolean SETTINGS_TABLE_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SETTINGS_LINE(b, l + 1);
    r = r && SETTINGS_TABLE_2_0_1(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean SETTINGS_TABLE_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SETTINGS_TABLE_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // SETTINGS_TABLE_HEADING_TOKEN EMPTY_LINE
  public static boolean SETTINGS_TABLE_HEADING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTINGS_TABLE_HEADING")) return false;
    if (!nextTokenIs(b, SETTINGS_TABLE_HEADING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SETTINGS_TABLE_HEADING_TOKEN);
    r = r && EMPTY_LINE(b, l + 1);
    exit_section_(b, m, SETTINGS_TABLE_HEADING, r);
    return r;
  }

  /* ********************************************************** */
  // (COLUMN_SEP_TOKEN  KEYWORD_ARG)+
  public static boolean SETTING_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTING_LIST")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SETTING_LIST_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!SETTING_LIST_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SETTING_LIST", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, SETTING_LIST, r);
    return r;
  }

  // COLUMN_SEP_TOKEN  KEYWORD_ARG
  private static boolean SETTING_LIST_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTING_LIST_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SETTING_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  static boolean SETTING_LIST_OR_ELLIPSES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SETTING_LIST_OR_ELLIPSES")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SETTING_LIST(b, l + 1);
    if (!r) r = ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SCALAR_ASSIGNMENT_LHS | ARRAY_ASSIGNMENT_LHS
  public static boolean SINGLE_ASSIGNMENT_LHS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_ASSIGNMENT_LHS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<single assignment lhs>");
    r = SCALAR_ASSIGNMENT_LHS(b, l + 1);
    if (!r) r = ARRAY_ASSIGNMENT_LHS(b, l + 1);
    exit_section_(b, l, m, SINGLE_ASSIGNMENT_LHS, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR_VAR_IN_RANGE INDENTED_ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN KEYWORD_ARG
  public static boolean SINGLE_BOUND_FOR_LOOP(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_BOUND_FOR_LOOP")) return false;
    if (!nextTokenIs(b, FOR_LOOP_START_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_VAR_IN_RANGE(b, l + 1);
    r = r && SINGLE_BOUND_FOR_LOOP_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_ARG(b, l + 1);
    exit_section_(b, m, SINGLE_BOUND_FOR_LOOP, r);
    return r;
  }

  // INDENTED_ELLIPSES_FOR_TEST_TABLE*
  private static boolean SINGLE_BOUND_FOR_LOOP_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_BOUND_FOR_LOOP_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SINGLE_BOUND_FOR_LOOP_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // SCALAR_VARIABLE ((COLUMN_SEP_TOKEN SCALAR_VARIABLE) | INDENTED_ELLIPSES_FOR_TEST_TABLE)+ | SCALAR_VARIABLE
  public static boolean SINGLE_VARIABLE_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_VARIABLE_LIST")) return false;
    if (!nextTokenIs(b, VARIABLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SINGLE_VARIABLE_LIST_0(b, l + 1);
    if (!r) r = SCALAR_VARIABLE(b, l + 1);
    exit_section_(b, m, SINGLE_VARIABLE_LIST, r);
    return r;
  }

  // SCALAR_VARIABLE ((COLUMN_SEP_TOKEN SCALAR_VARIABLE) | INDENTED_ELLIPSES_FOR_TEST_TABLE)+
  private static boolean SINGLE_VARIABLE_LIST_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_VARIABLE_LIST_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCALAR_VARIABLE(b, l + 1);
    r = r && SINGLE_VARIABLE_LIST_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ((COLUMN_SEP_TOKEN SCALAR_VARIABLE) | INDENTED_ELLIPSES_FOR_TEST_TABLE)+
  private static boolean SINGLE_VARIABLE_LIST_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_VARIABLE_LIST_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SINGLE_VARIABLE_LIST_0_1_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!SINGLE_VARIABLE_LIST_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SINGLE_VARIABLE_LIST_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLUMN_SEP_TOKEN SCALAR_VARIABLE) | INDENTED_ELLIPSES_FOR_TEST_TABLE
  private static boolean SINGLE_VARIABLE_LIST_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_VARIABLE_LIST_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SINGLE_VARIABLE_LIST_0_1_0_0(b, l + 1);
    if (!r) r = INDENTED_ELLIPSES_FOR_TEST_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLUMN_SEP_TOKEN SCALAR_VARIABLE
  private static boolean SINGLE_VARIABLE_LIST_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SINGLE_VARIABLE_LIST_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && SCALAR_VARIABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SETTINGS_TABLE|VARIABLES_TABLE|TEST_CASES_TABLE|KEYWORDS_TABLE
  public static boolean TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TABLE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<table>");
    r = SETTINGS_TABLE(b, l + 1);
    if (!r) r = VARIABLES_TABLE(b, l + 1);
    if (!r) r = TEST_CASES_TABLE(b, l + 1);
    if (!r) r = KEYWORDS_TABLE(b, l + 1);
    exit_section_(b, l, m, TABLE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TAG_TOKEN
  public static boolean TAG(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG")) return false;
    if (!nextTokenIs(b, TAG_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TAG_TOKEN);
    exit_section_(b, m, TAG, r);
    return r;
  }

  /* ********************************************************** */
  // TAGS_META_TOKEN TAG_LIST_OR_ELLIPSES*
  public static boolean TAGS_META(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAGS_META")) return false;
    if (!nextTokenIs(b, TAGS_META_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, TAGS_META_TOKEN);
    p = r; // pin = 1
    r = r && TAGS_META_1(b, l + 1);
    exit_section_(b, l, m, TAGS_META, r, p, null);
    return r || p;
  }

  // TAG_LIST_OR_ELLIPSES*
  private static boolean TAGS_META_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAGS_META_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TAG_LIST_OR_ELLIPSES(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TAGS_META_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // (COLUMN_SEP_TOKEN TAG)+
  static boolean TAG_LIST(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_LIST")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TAG_LIST_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!TAG_LIST_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TAG_LIST", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // COLUMN_SEP_TOKEN TAG
  private static boolean TAG_LIST_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_LIST_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && TAG(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TAG_LIST | ELLIPSES_FOR_TEST_TABLE
  static boolean TAG_LIST_OR_ELLIPSES(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_LIST_OR_ELLIPSES")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TAG_LIST(b, l + 1);
    if (!r) r = ELLIPSES_FOR_TEST_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TAG_LIST | ELLIPSES_FOR_SETTINGS_TABLE
  static boolean TAG_LIST_OR_ELLIPSES_NO_COL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TAG_LIST_OR_ELLIPSES_NO_COL")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TAG_LIST(b, l + 1);
    if (!r) r = ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEST_SETTING_LINE  END_OF_LINE* |
  //                   EXECUTION_LINE     END_OF_LINE* |
  //                   ELLIPSES_LINE_TEST END_OF_LINE* |
  //                   FOR_LOOP_IN_RANGE  END_OF_LINE* |
  //                   FOR_LOOP_IN        END_OF_LINE* |
  //                   KEYWORD_ARG_LIST   END_OF_LINE* |
  //                   COLUMN_SEP_TOKEN
  public static boolean TESTCASE_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<testcase line>");
    r = TESTCASE_LINE_0(b, l + 1);
    if (!r) r = TESTCASE_LINE_1(b, l + 1);
    if (!r) r = TESTCASE_LINE_2(b, l + 1);
    if (!r) r = TESTCASE_LINE_3(b, l + 1);
    if (!r) r = TESTCASE_LINE_4(b, l + 1);
    if (!r) r = TESTCASE_LINE_5(b, l + 1);
    if (!r) r = consumeToken(b, COLUMN_SEP_TOKEN);
    exit_section_(b, l, m, TESTCASE_LINE, r, false, not_a_newline_token_parser_);
    return r;
  }

  // TEST_SETTING_LINE  END_OF_LINE*
  private static boolean TESTCASE_LINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TEST_SETTING_LINE(b, l + 1);
    r = r && TESTCASE_LINE_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TESTCASE_LINE_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TESTCASE_LINE_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // EXECUTION_LINE     END_OF_LINE*
  private static boolean TESTCASE_LINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EXECUTION_LINE(b, l + 1);
    r = r && TESTCASE_LINE_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TESTCASE_LINE_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TESTCASE_LINE_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ELLIPSES_LINE_TEST END_OF_LINE*
  private static boolean TESTCASE_LINE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ELLIPSES_LINE_TEST(b, l + 1);
    r = r && TESTCASE_LINE_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TESTCASE_LINE_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_2_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TESTCASE_LINE_2_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // FOR_LOOP_IN_RANGE  END_OF_LINE*
  private static boolean TESTCASE_LINE_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_LOOP_IN_RANGE(b, l + 1);
    r = r && TESTCASE_LINE_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TESTCASE_LINE_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_3_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TESTCASE_LINE_3_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // FOR_LOOP_IN        END_OF_LINE*
  private static boolean TESTCASE_LINE_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FOR_LOOP_IN(b, l + 1);
    r = r && TESTCASE_LINE_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TESTCASE_LINE_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_4_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TESTCASE_LINE_4_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // KEYWORD_ARG_LIST   END_OF_LINE*
  private static boolean TESTCASE_LINE_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = KEYWORD_ARG_LIST(b, l + 1);
    r = r && TESTCASE_LINE_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TESTCASE_LINE_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TESTCASE_LINE_5_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TESTCASE_LINE_5_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // TEST_CASE_HEADER ( TESTCASE_LINE EMPTY_LINE | EMPTY_LINE )* (TESTCASE_LINE END_OF_LINE* <<eof>>)?
  public static boolean TEST_CASE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE")) return false;
    if (!nextTokenIs(b, TEST_CASE_HEADER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TEST_CASE_HEADER(b, l + 1);
    r = r && TEST_CASE_1(b, l + 1);
    r = r && TEST_CASE_2(b, l + 1);
    exit_section_(b, m, TEST_CASE, r);
    return r;
  }

  // ( TESTCASE_LINE EMPTY_LINE | EMPTY_LINE )*
  private static boolean TEST_CASE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TEST_CASE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_CASE_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // TESTCASE_LINE EMPTY_LINE | EMPTY_LINE
  private static boolean TEST_CASE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TEST_CASE_1_0_0(b, l + 1);
    if (!r) r = EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TESTCASE_LINE EMPTY_LINE
  private static boolean TEST_CASE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TESTCASE_LINE(b, l + 1);
    r = r && EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TESTCASE_LINE END_OF_LINE* <<eof>>)?
  private static boolean TEST_CASE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_2")) return false;
    TEST_CASE_2_0(b, l + 1);
    return true;
  }

  // TESTCASE_LINE END_OF_LINE* <<eof>>
  private static boolean TEST_CASE_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TESTCASE_LINE(b, l + 1);
    r = r && TEST_CASE_2_0_1(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TEST_CASE_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_CASE_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // TEST_CASES_TABLE_HEADING EMPTY_LINE* TEST_CASE*
  public static boolean TEST_CASES_TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASES_TABLE")) return false;
    if (!nextTokenIs(b, TEST_CASES_TABLE_HEADING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TEST_CASES_TABLE_HEADING(b, l + 1);
    r = r && TEST_CASES_TABLE_1(b, l + 1);
    r = r && TEST_CASES_TABLE_2(b, l + 1);
    exit_section_(b, m, TEST_CASES_TABLE, r);
    return r;
  }

  // EMPTY_LINE*
  private static boolean TEST_CASES_TABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASES_TABLE_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!EMPTY_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_CASES_TABLE_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // TEST_CASE*
  private static boolean TEST_CASES_TABLE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASES_TABLE_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!TEST_CASE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_CASES_TABLE_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // TEST_CASES_TABLE_HEADING_TOKEN END_OF_LINE* (NEWLINE_TOKEN | <<eof>>)
  public static boolean TEST_CASES_TABLE_HEADING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASES_TABLE_HEADING")) return false;
    if (!nextTokenIs(b, TEST_CASES_TABLE_HEADING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEST_CASES_TABLE_HEADING_TOKEN);
    r = r && TEST_CASES_TABLE_HEADING_1(b, l + 1);
    r = r && TEST_CASES_TABLE_HEADING_2(b, l + 1);
    exit_section_(b, m, TEST_CASES_TABLE_HEADING, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean TEST_CASES_TABLE_HEADING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASES_TABLE_HEADING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_CASES_TABLE_HEADING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // NEWLINE_TOKEN | <<eof>>
  private static boolean TEST_CASES_TABLE_HEADING_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASES_TABLE_HEADING_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEWLINE_TOKEN);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEST_CASE_HEADER_TOKEN
  public static boolean TEST_CASE_HEADER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_HEADER")) return false;
    if (!nextTokenIs(b, TEST_CASE_HEADER_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEST_CASE_HEADER_TOKEN);
    exit_section_(b, m, TEST_CASE_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // SETUP_META_TOKEN  COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  public static boolean TEST_CASE_SETUP_META(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_SETUP_META")) return false;
    if (!nextTokenIs(b, SETUP_META_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, SETUP_META_TOKEN, COLUMN_SEP_TOKEN);
    p = r; // pin = 1
    r = r && KEYWORD_INVOCATION_SETTINGS(b, l + 1);
    exit_section_(b, l, m, TEST_CASE_SETUP_META, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TEARDOWN_META_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  public static boolean TEST_CASE_TEARDOWN_META(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_TEARDOWN_META")) return false;
    if (!nextTokenIs(b, TEARDOWN_META_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, TEARDOWN_META_TOKEN, COLUMN_SEP_TOKEN);
    p = r; // pin = 1
    r = r && KEYWORD_INVOCATION_SETTINGS(b, l + 1);
    exit_section_(b, l, m, TEST_CASE_TEARDOWN_META, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TEMPLATE_SETTING_TOKEN COLUMN_SEP_TOKEN KEYWORD
  public static boolean TEST_CASE_TEMPLATE_META(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_TEMPLATE_META")) return false;
    if (!nextTokenIs(b, TEMPLATE_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, TEMPLATE_SETTING_TOKEN, COLUMN_SEP_TOKEN);
    p = r; // pin = 1
    r = r && KEYWORD(b, l + 1);
    exit_section_(b, l, m, TEST_CASE_TEMPLATE_META, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TIMEOUT_META_TOKEN COLUMN_SEP_TOKEN TIMEOUT_VALUE_TOKEN
  public static boolean TEST_CASE_TIMEOUT_META(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_CASE_TIMEOUT_META")) return false;
    if (!nextTokenIs(b, TIMEOUT_META_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, TIMEOUT_META_TOKEN, COLUMN_SEP_TOKEN, TIMEOUT_VALUE_TOKEN);
    p = r; // pin = 1
    exit_section_(b, l, m, TEST_CASE_TIMEOUT_META, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // DOCUMENTATION_META|TAGS_META|TEST_CASE_SETUP_META|TEST_CASE_TEARDOWN_META|TEST_CASE_TEMPLATE_META|TEST_CASE_TIMEOUT_META
  public static boolean TEST_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_SETTING")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<test setting>");
    r = DOCUMENTATION_META(b, l + 1);
    if (!r) r = TAGS_META(b, l + 1);
    if (!r) r = TEST_CASE_SETUP_META(b, l + 1);
    if (!r) r = TEST_CASE_TEARDOWN_META(b, l + 1);
    if (!r) r = TEST_CASE_TEMPLATE_META(b, l + 1);
    if (!r) r = TEST_CASE_TIMEOUT_META(b, l + 1);
    exit_section_(b, l, m, TEST_SETTING, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLUMN_SEP_TOKEN  TEST_SETTING
  public static boolean TEST_SETTING_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_SETTING_LINE")) return false;
    if (!nextTokenIs(b, COLUMN_SEP_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && TEST_SETTING(b, l + 1);
    exit_section_(b, m, TEST_SETTING_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // TEST_SETUP_TOKEN ELLIPSES_FOR_SETTINGS_TABLE+ COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS |
  //                        TEST_SETUP_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  public static boolean TEST_SETUP_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_SETUP_SETTING")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<test setup setting>");
    r = TEST_SETUP_SETTING_0(b, l + 1);
    if (!r) r = TEST_SETUP_SETTING_1(b, l + 1);
    exit_section_(b, l, m, TEST_SETUP_SETTING, r, false, null);
    return r;
  }

  // TEST_SETUP_TOKEN ELLIPSES_FOR_SETTINGS_TABLE+ COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  private static boolean TEST_SETUP_SETTING_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_SETUP_SETTING_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TEST_SETUP_TOKEN(b, l + 1);
    r = r && TEST_SETUP_SETTING_0_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_INVOCATION_SETTINGS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELLIPSES_FOR_SETTINGS_TABLE+
  private static boolean TEST_SETUP_SETTING_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_SETUP_SETTING_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_SETUP_SETTING_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // TEST_SETUP_TOKEN COLUMN_SEP_TOKEN KEYWORD_INVOCATION_SETTINGS
  private static boolean TEST_SETUP_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_SETUP_SETTING_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TEST_SETUP_TOKEN(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_INVOCATION_SETTINGS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TEST_SETUP_SETTING_TOKEN | TEST_TEARDOWN_SETTING_TOKEN | SUITE_SETUP_SETTING_TOKEN | SUITE_TEARDOWN_SETTING_TOKEN
  public static boolean TEST_SETUP_TOKEN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_SETUP_TOKEN")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<test setup token>");
    r = consumeToken(b, TEST_SETUP_SETTING_TOKEN);
    if (!r) r = consumeToken(b, TEST_TEARDOWN_SETTING_TOKEN);
    if (!r) r = consumeToken(b, SUITE_SETUP_SETTING_TOKEN);
    if (!r) r = consumeToken(b, SUITE_TEARDOWN_SETTING_TOKEN);
    exit_section_(b, l, m, TEST_SETUP_TOKEN, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TEST_TEMPLATE_SETTING_TOKEN ELLIPSES_FOR_SETTINGS_TABLE* COLUMN_SEP_TOKEN KEYWORD
  public static boolean TEST_TEMPLATE_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_TEMPLATE_SETTING")) return false;
    if (!nextTokenIs(b, TEST_TEMPLATE_SETTING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEST_TEMPLATE_SETTING_TOKEN);
    r = r && TEST_TEMPLATE_SETTING_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD(b, l + 1);
    exit_section_(b, m, TEST_TEMPLATE_SETTING, r);
    return r;
  }

  // ELLIPSES_FOR_SETTINGS_TABLE*
  private static boolean TEST_TEMPLATE_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_TEMPLATE_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_TEMPLATE_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // TEST_TIMEOUT_SETTING_TOKEN  ELLIPSES_FOR_SETTINGS_TABLE+ COLUMN_SEP_TOKEN TIMEOUT_VALUE_TOKEN |
  //                          TEST_TIMEOUT_SETTING_TOKEN  COLUMN_SEP_TOKEN  TIMEOUT_VALUE_TOKEN
  public static boolean TEST_TIMEOUT_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_TIMEOUT_SETTING")) return false;
    if (!nextTokenIs(b, TEST_TIMEOUT_SETTING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TEST_TIMEOUT_SETTING_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, TEST_TIMEOUT_SETTING_TOKEN, COLUMN_SEP_TOKEN, TIMEOUT_VALUE_TOKEN);
    exit_section_(b, m, TEST_TIMEOUT_SETTING, r);
    return r;
  }

  // TEST_TIMEOUT_SETTING_TOKEN  ELLIPSES_FOR_SETTINGS_TABLE+ COLUMN_SEP_TOKEN TIMEOUT_VALUE_TOKEN
  private static boolean TEST_TIMEOUT_SETTING_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_TIMEOUT_SETTING_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEST_TIMEOUT_SETTING_TOKEN);
    r = r && TEST_TIMEOUT_SETTING_0_1(b, l + 1);
    r = r && consumeTokens(b, 0, COLUMN_SEP_TOKEN, TIMEOUT_VALUE_TOKEN);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELLIPSES_FOR_SETTINGS_TABLE+
  private static boolean TEST_TIMEOUT_SETTING_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TEST_TIMEOUT_SETTING_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TEST_TIMEOUT_SETTING_0_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SCALAR_VARIABLE | ARRAY_VARIABLE
  public static boolean VARIABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE")) return false;
    if (!nextTokenIs(b, "<variable>", ARRAY_VARIABLE_TOKEN, VARIABLE_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variable>");
    r = SCALAR_VARIABLE(b, l + 1);
    if (!r) r = ARRAY_VARIABLE(b, l + 1);
    exit_section_(b, l, m, VARIABLE, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SCALAR_ASSIGNMENT_LHS (ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE*  |
  //                    ARRAY_ASSIGNMENT_LHS  (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE*  |
  //                    ELLIPSES_LINE_SETTINGS END_OF_LINE*
  public static boolean VARIABLES_LINE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variables line>");
    r = VARIABLES_LINE_0(b, l + 1);
    if (!r) r = VARIABLES_LINE_1(b, l + 1);
    if (!r) r = VARIABLES_LINE_2(b, l + 1);
    exit_section_(b, l, m, VARIABLES_LINE, r, false, not_a_newline_token_parser_);
    return r;
  }

  // SCALAR_ASSIGNMENT_LHS (ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE*
  private static boolean VARIABLES_LINE_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SCALAR_ASSIGNMENT_LHS(b, l + 1);
    r = r && VARIABLES_LINE_0_1(b, l + 1);
    r = r && VARIABLES_LINE_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGNABLE_IN_VARIABLES_TBL)?
  private static boolean VARIABLES_LINE_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_0_1")) return false;
    VARIABLES_LINE_0_1_0(b, l + 1);
    return true;
  }

  // (ASSIGNABLE_IN_VARIABLES_TBL)
  private static boolean VARIABLES_LINE_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ASSIGNABLE_IN_VARIABLES_TBL(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean VARIABLES_LINE_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARIABLES_LINE_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ARRAY_ASSIGNMENT_LHS  (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)? END_OF_LINE*
  private static boolean VARIABLES_LINE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ARRAY_ASSIGNMENT_LHS(b, l + 1);
    r = r && VARIABLES_LINE_1_1(b, l + 1);
    r = r && VARIABLES_LINE_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)?
  private static boolean VARIABLES_LINE_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_1_1")) return false;
    VARIABLES_LINE_1_1_0(b, l + 1);
    return true;
  }

  // (ARRAY_ASSIGNABLE_IN_VARIABLES_TBL)
  private static boolean VARIABLES_LINE_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ARRAY_ASSIGNABLE_IN_VARIABLES_TBL(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean VARIABLES_LINE_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_1_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARIABLES_LINE_1_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ELLIPSES_LINE_SETTINGS END_OF_LINE*
  private static boolean VARIABLES_LINE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ELLIPSES_LINE_SETTINGS(b, l + 1);
    r = r && VARIABLES_LINE_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean VARIABLES_LINE_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_LINE_2_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARIABLES_LINE_2_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLES_TABLE_HEADING (VARIABLES_LINE EMPTY_LINE | EMPTY_LINE)* (VARIABLES_LINE END_OF_LINE* <<eof>>)?
  public static boolean VARIABLES_TABLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE")) return false;
    if (!nextTokenIs(b, VARIABLES_TABLE_HEADING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = VARIABLES_TABLE_HEADING(b, l + 1);
    r = r && VARIABLES_TABLE_1(b, l + 1);
    p = r; // pin = 2
    r = r && VARIABLES_TABLE_2(b, l + 1);
    exit_section_(b, l, m, VARIABLES_TABLE, r, p, null);
    return r || p;
  }

  // (VARIABLES_LINE EMPTY_LINE | EMPTY_LINE)*
  private static boolean VARIABLES_TABLE_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!VARIABLES_TABLE_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARIABLES_TABLE_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // VARIABLES_LINE EMPTY_LINE | EMPTY_LINE
  private static boolean VARIABLES_TABLE_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VARIABLES_TABLE_1_0_0(b, l + 1);
    if (!r) r = EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VARIABLES_LINE EMPTY_LINE
  private static boolean VARIABLES_TABLE_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VARIABLES_LINE(b, l + 1);
    r = r && EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (VARIABLES_LINE END_OF_LINE* <<eof>>)?
  private static boolean VARIABLES_TABLE_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE_2")) return false;
    VARIABLES_TABLE_2_0(b, l + 1);
    return true;
  }

  // VARIABLES_LINE END_OF_LINE* <<eof>>
  private static boolean VARIABLES_TABLE_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VARIABLES_LINE(b, l + 1);
    r = r && VARIABLES_TABLE_2_0_1(b, l + 1);
    r = r && eof(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean VARIABLES_TABLE_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE_2_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARIABLES_TABLE_2_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLES_TABLE_HEADING_TOKEN EMPTY_LINE
  public static boolean VARIABLES_TABLE_HEADING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLES_TABLE_HEADING")) return false;
    if (!nextTokenIs(b, VARIABLES_TABLE_HEADING_TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VARIABLES_TABLE_HEADING_TOKEN);
    r = r && EMPTY_LINE(b, l + 1);
    exit_section_(b, m, VARIABLES_TABLE_HEADING, r);
    return r;
  }

  /* ********************************************************** */
  // ( MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS ) ELLIPSES_FOR_TEST_TABLE* COLUMN_SEP_TOKEN  KEYWORD_INVOCATION_TEST
  public static boolean VARIABLE_ASSIGN_TO_KEYWORD(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_ASSIGN_TO_KEYWORD")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variable assign to keyword>");
    r = VARIABLE_ASSIGN_TO_KEYWORD_0(b, l + 1);
    r = r && VARIABLE_ASSIGN_TO_KEYWORD_1(b, l + 1);
    r = r && consumeToken(b, COLUMN_SEP_TOKEN);
    r = r && KEYWORD_INVOCATION_TEST(b, l + 1);
    exit_section_(b, l, m, VARIABLE_ASSIGN_TO_KEYWORD, r, false, null);
    return r;
  }

  // MULTI_ASSIGNMENT_LHS | SINGLE_ASSIGNMENT_LHS
  private static boolean VARIABLE_ASSIGN_TO_KEYWORD_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_ASSIGN_TO_KEYWORD_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MULTI_ASSIGNMENT_LHS(b, l + 1);
    if (!r) r = SINGLE_ASSIGNMENT_LHS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELLIPSES_FOR_TEST_TABLE*
  private static boolean VARIABLE_ASSIGN_TO_KEYWORD_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_ASSIGN_TO_KEYWORD_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ELLIPSES_FOR_TEST_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARIABLE_ASSIGN_TO_KEYWORD_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // VARIABLE_SETTING_TOKEN  ELLIPSES_FOR_SETTINGS_TABLE* COLUMN_SEP_TOKEN  RESOURCE_FILE
  public static boolean VARIABLE_SETTING(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_SETTING")) return false;
    if (!nextTokenIs(b, VARIABLE_SETTING_TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, VARIABLE_SETTING_TOKEN);
    p = r; // pin = 1
    r = r && report_error_(b, VARIABLE_SETTING_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLUMN_SEP_TOKEN)) && r;
    r = p && RESOURCE_FILE(b, l + 1) && r;
    exit_section_(b, l, m, VARIABLE_SETTING, r, p, null);
    return r || p;
  }

  // ELLIPSES_FOR_SETTINGS_TABLE*
  private static boolean VARIABLE_SETTING_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARIABLE_SETTING_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!ELLIPSES_FOR_SETTINGS_TABLE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARIABLE_SETTING_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // ! NEWLINE_TOKEN
  static boolean not_a_newline_token(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_a_newline_token")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !consumeToken(b, NEWLINE_TOKEN);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (TABLE | EMPTY_LINE )* END_OF_LINE*
  static boolean robotFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "robotFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = robotFile_0(b, l + 1);
    r = r && robotFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TABLE | EMPTY_LINE )*
  private static boolean robotFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "robotFile_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!robotFile_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "robotFile_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // TABLE | EMPTY_LINE
  private static boolean robotFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "robotFile_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TABLE(b, l + 1);
    if (!r) r = EMPTY_LINE(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // END_OF_LINE*
  private static boolean robotFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "robotFile_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!END_OF_LINE(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "robotFile_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  final static Parser not_a_newline_token_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return not_a_newline_token(b, l + 1);
    }
  };
}
