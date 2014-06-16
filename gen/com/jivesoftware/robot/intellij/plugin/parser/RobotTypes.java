// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotToken;
import com.jivesoftware.robot.intellij.plugin.psi.impl.*;

public interface RobotTypes {

  IElementType ARGUMENTS_SETTING = new RobotElementType("ARGUMENTS_SETTING");
  IElementType ARGUMENT_DEF = new RobotElementType("ARGUMENT_DEF");
  IElementType ARGUMENT_LIST = new RobotElementType("ARGUMENT_LIST");
  IElementType ARRAY_ASSIGNABLE = new RobotElementType("ARRAY_ASSIGNABLE");
  IElementType ASSIGNABLE = new RobotElementType("ASSIGNABLE");
  IElementType ASSIGNMENT = new RobotElementType("ASSIGNMENT");
  IElementType DOCUMENTATION_SETTING = new RobotElementType("DOCUMENTATION_SETTING");
  IElementType ELLIPSES = new RobotElementType("ELLIPSES");
  IElementType ELLIPSES_FOR_SETTINGS_TABLE = new RobotElementType("ELLIPSES_FOR_SETTINGS_TABLE");
  IElementType ELLIPSES_FOR_TEST_TABLE = new RobotElementType("ELLIPSES_FOR_TEST_TABLE");
  IElementType ELLIPSES_LINE_SETTINGS = new RobotElementType("ELLIPSES_LINE_SETTINGS");
  IElementType ELLIPSES_LINE_TEST = new RobotElementType("ELLIPSES_LINE_TEST");
  IElementType EMPTY_LINE = new RobotElementType("EMPTY_LINE");
  IElementType END_OF_LINE = new RobotElementType("END_OF_LINE");
  IElementType ERROR = new RobotElementType("ERROR");
  IElementType FORCE_TAGS_SETTING = new RobotElementType("FORCE_TAGS_SETTING");
  IElementType GENERIC_SETTING = new RobotElementType("GENERIC_SETTING");
  IElementType KEYWORD = new RobotElementType("KEYWORD");
  IElementType KEYWORDS_TABLE = new RobotElementType("KEYWORDS_TABLE");
  IElementType KEYWORDS_TABLE_HEADING = new RobotElementType("KEYWORDS_TABLE_HEADING");
  IElementType KEYWORD_ARG = new RobotElementType("KEYWORD_ARG");
  IElementType KEYWORD_ARG_LIST = new RobotElementType("KEYWORD_ARG_LIST");
  IElementType KEYWORD_DEF = new RobotElementType("KEYWORD_DEF");
  IElementType KEYWORD_DEFINITION = new RobotElementType("KEYWORD_DEFINITION");
  IElementType KEYWORD_DEFINITION_HEADER = new RobotElementType("KEYWORD_DEFINITION_HEADER");
  IElementType KEYWORD_INVOCATION_SETTINGS = new RobotElementType("KEYWORD_INVOCATION_SETTINGS");
  IElementType KEYWORD_INVOCATION_TEST = new RobotElementType("KEYWORD_INVOCATION_TEST");
  IElementType KEYWORD_LINE = new RobotElementType("KEYWORD_LINE");
  IElementType KEYWORD_SETTING = new RobotElementType("KEYWORD_SETTING");
  IElementType KEYWORD_SETTINGS = new RobotElementType("KEYWORD_SETTINGS");
  IElementType KEYWORD_SETTING_LINE = new RobotElementType("KEYWORD_SETTING_LINE");
  IElementType MULTI_ASSIGNMENT = new RobotElementType("MULTI_ASSIGNMENT");
  IElementType RETURN_LINE = new RobotElementType("RETURN_LINE");
  IElementType RETURN_SETTING = new RobotElementType("RETURN_SETTING");
  IElementType ROBOT_TABLE = new RobotElementType("ROBOT_TABLE");
  IElementType SETTING = new RobotElementType("SETTING");
  IElementType SETTINGS_LINE = new RobotElementType("SETTINGS_LINE");
  IElementType SETTINGS_TABLE = new RobotElementType("SETTINGS_TABLE");
  IElementType SETTINGS_TABLE_HEADING = new RobotElementType("SETTINGS_TABLE_HEADING");
  IElementType SETTING_LIST = new RobotElementType("SETTING_LIST");
  IElementType SETTING_LIST_OR_ELLIPSES = new RobotElementType("SETTING_LIST_OR_ELLIPSES");
  IElementType SETUP_SETTING = new RobotElementType("SETUP_SETTING");
  IElementType SINGLE_ASSIGNMENT = new RobotElementType("SINGLE_ASSIGNMENT");
  IElementType TAG = new RobotElementType("TAG");
  IElementType TAGS_SETTING = new RobotElementType("TAGS_SETTING");
  IElementType TAG_LIST = new RobotElementType("TAG_LIST");
  IElementType TAG_LIST_OR_ELLIPSES = new RobotElementType("TAG_LIST_OR_ELLIPSES");
  IElementType TAG_LIST_OR_ELLIPSES_NO_COL = new RobotElementType("TAG_LIST_OR_ELLIPSES_NO_COL");
  IElementType TEARDOWN_SETTING = new RobotElementType("TEARDOWN_SETTING");
  IElementType TEMPLATE_SETTING = new RobotElementType("TEMPLATE_SETTING");
  IElementType TESTCASE_LINE = new RobotElementType("TESTCASE_LINE");
  IElementType TEST_CASE = new RobotElementType("TEST_CASE");
  IElementType TEST_CASES_TABLE = new RobotElementType("TEST_CASES_TABLE");
  IElementType TEST_CASES_TABLE_HEADING = new RobotElementType("TEST_CASES_TABLE_HEADING");
  IElementType TEST_CASE_HEADER = new RobotElementType("TEST_CASE_HEADER");
  IElementType TEST_CASE_SETTINGS = new RobotElementType("TEST_CASE_SETTINGS");
  IElementType TEST_SETTING = new RobotElementType("TEST_SETTING");
  IElementType TEST_SETTING_LINE = new RobotElementType("TEST_SETTING_LINE");
  IElementType TEST_SETUP_SETTING = new RobotElementType("TEST_SETUP_SETTING");
  IElementType TEST_SETUP_TOKEN = new RobotElementType("TEST_SETUP_TOKEN");
  IElementType TIMEOUT_SETTING = new RobotElementType("TIMEOUT_SETTING");
  IElementType VARIABLE = new RobotElementType("VARIABLE");
  IElementType VARIABLES_LINE = new RobotElementType("VARIABLES_LINE");
  IElementType VARIABLES_TABLE = new RobotElementType("VARIABLES_TABLE");
  IElementType VARIABLES_TABLE_HEADING = new RobotElementType("VARIABLES_TABLE_HEADING");
  IElementType VARIABLE_ASSIGN_TO_KEYWORD = new RobotElementType("VARIABLE_ASSIGN_TO_KEYWORD");

  IElementType ARGUMENTS_SETTING_TOKEN = new RobotToken("ARGUMENTS_SETTING_TOKEN");
  IElementType ARRAY_ASSIGNMENT_TOKEN = new RobotToken("ARRAY_ASSIGNMENT_TOKEN");
  IElementType ARRAY_VARIABLE_TOKEN = new RobotToken("ARRAY_VARIABLE_TOKEN");
  IElementType ASSIGNMENT_TOKEN = new RobotToken("ASSIGNMENT_TOKEN");
  IElementType BAD_SYNTAX_TOKEN = new RobotToken("BAD_SYNTAX_TOKEN");
  IElementType COLUMN_SEP_TOKEN = new RobotToken("COLUMN_SEP_TOKEN");
  IElementType COMMENT_TOKEN = new RobotToken("COMMENT_TOKEN");
  IElementType DOCUMENTATION_SETTING_TOKEN = new RobotToken("DOCUMENTATION_SETTING_TOKEN");
  IElementType DOCUMENTATION_TOKEN = new RobotToken("DOCUMENTATION_TOKEN");
  IElementType ELLIPSES_TOKEN = new RobotToken("ELLIPSES_TOKEN");
  IElementType FORCE_TAGS_SETTING_KEYWORD_TOKEN = new RobotToken("FORCE_TAGS_SETTING_KEYWORD_TOKEN");
  IElementType KEYWORDS_TABLE_HEADING_TOKEN = new RobotToken("KEYWORDS_TABLE_HEADING_TOKEN");
  IElementType NEWLINE_TOKEN = new RobotToken("NEWLINE_TOKEN");
  IElementType RETURN_SETTING_TOKEN = new RobotToken("RETURN_SETTING_TOKEN");
  IElementType ROBOT_KEYWORD_ARG_TOKEN = new RobotToken("ROBOT_KEYWORD_ARG_TOKEN");
  IElementType ROBOT_KEYWORD_DEF_TOKEN = new RobotToken("ROBOT_KEYWORD_DEF_TOKEN");
  IElementType ROBOT_KEYWORD_TOKEN = new RobotToken("ROBOT_KEYWORD_TOKEN");
  IElementType SETTINGS_TABLE_HEADING_TOKEN = new RobotToken("SETTINGS_TABLE_HEADING_TOKEN");
  IElementType SETUP_SETTING_TOKEN = new RobotToken("SETUP_SETTING_TOKEN");
  IElementType SUITE_SETUP_SETTING_TOKEN = new RobotToken("SUITE_SETUP_SETTING_TOKEN");
  IElementType TAGS_SETTING_TOKEN = new RobotToken("TAGS_SETTING_TOKEN");
  IElementType TAG_TOKEN = new RobotToken("TAG_TOKEN");
  IElementType TEARDOWN_SETTING_TOKEN = new RobotToken("TEARDOWN_SETTING_TOKEN");
  IElementType TEMPLATE_SETTING_TOKEN = new RobotToken("TEMPLATE_SETTING_TOKEN");
  IElementType TEST_CASES_TABLE_HEADING_TOKEN = new RobotToken("TEST_CASES_TABLE_HEADING_TOKEN");
  IElementType TEST_CASE_HEADER_TOKEN = new RobotToken("TEST_CASE_HEADER_TOKEN");
  IElementType TEST_SETUP_SETTING_TOKEN = new RobotToken("TEST_SETUP_SETTING_TOKEN");
  IElementType TEST_TEARDOWN_SETTING_TOKEN = new RobotToken("TEST_TEARDOWN_SETTING_TOKEN");
  IElementType TIMEOUT_SETTING_TOKEN = new RobotToken("TIMEOUT_SETTING_TOKEN");
  IElementType TIMEOUT_VALUE_TOKEN = new RobotToken("TIMEOUT_VALUE_TOKEN");
  IElementType VARIABLES_TABLE_HEADING_TOKEN = new RobotToken("VARIABLES_TABLE_HEADING_TOKEN");
  IElementType VARIABLE_TOKEN = new RobotToken("VARIABLE_TOKEN");
  IElementType WHITESPACE_TOKEN = new RobotToken("WHITESPACE_TOKEN");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARGUMENTS_SETTING) {
        return new RobotArgumentsSettingImpl(node);
      }
      else if (type == ARGUMENT_DEF) {
        return new RobotArgumentDefImpl(node);
      }
      else if (type == ARGUMENT_LIST) {
        return new RobotArgumentListImpl(node);
      }
      else if (type == ARRAY_ASSIGNABLE) {
        return new RobotArrayAssignableImpl(node);
      }
      else if (type == ASSIGNABLE) {
        return new RobotAssignableImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new RobotAssignmentImpl(node);
      }
      else if (type == DOCUMENTATION_SETTING) {
        return new RobotDocumentationSettingImpl(node);
      }
      else if (type == ELLIPSES) {
        return new RobotEllipsesImpl(node);
      }
      else if (type == ELLIPSES_FOR_SETTINGS_TABLE) {
        return new RobotEllipsesForSettingsTableImpl(node);
      }
      else if (type == ELLIPSES_FOR_TEST_TABLE) {
        return new RobotEllipsesForTestTableImpl(node);
      }
      else if (type == ELLIPSES_LINE_SETTINGS) {
        return new RobotEllipsesLineSettingsImpl(node);
      }
      else if (type == ELLIPSES_LINE_TEST) {
        return new RobotEllipsesLineTestImpl(node);
      }
      else if (type == EMPTY_LINE) {
        return new RobotEmptyLineImpl(node);
      }
      else if (type == END_OF_LINE) {
        return new RobotEndOfLineImpl(node);
      }
      else if (type == ERROR) {
        return new RobotErrorImpl(node);
      }
      else if (type == FORCE_TAGS_SETTING) {
        return new RobotForceTagsSettingImpl(node);
      }
      else if (type == GENERIC_SETTING) {
        return new RobotGenericSettingImpl(node);
      }
      else if (type == KEYWORD) {
        return new RobotKeywordImpl(node);
      }
      else if (type == KEYWORDS_TABLE) {
        return new RobotKeywordsTableImpl(node);
      }
      else if (type == KEYWORDS_TABLE_HEADING) {
        return new RobotKeywordsTableHeadingImpl(node);
      }
      else if (type == KEYWORD_ARG) {
        return new RobotKeywordArgImpl(node);
      }
      else if (type == KEYWORD_ARG_LIST) {
        return new RobotKeywordArgListImpl(node);
      }
      else if (type == KEYWORD_DEF) {
        return new RobotKeywordDefImpl(node);
      }
      else if (type == KEYWORD_DEFINITION) {
        return new RobotKeywordDefinitionImpl(node);
      }
      else if (type == KEYWORD_DEFINITION_HEADER) {
        return new RobotKeywordDefinitionHeaderImpl(node);
      }
      else if (type == KEYWORD_INVOCATION_SETTINGS) {
        return new RobotKeywordInvocationSettingsImpl(node);
      }
      else if (type == KEYWORD_INVOCATION_TEST) {
        return new RobotKeywordInvocationTestImpl(node);
      }
      else if (type == KEYWORD_LINE) {
        return new RobotKeywordLineImpl(node);
      }
      else if (type == KEYWORD_SETTING) {
        return new RobotKeywordSettingImpl(node);
      }
      else if (type == KEYWORD_SETTINGS) {
        return new RobotKeywordSettingsImpl(node);
      }
      else if (type == KEYWORD_SETTING_LINE) {
        return new RobotKeywordSettingLineImpl(node);
      }
      else if (type == MULTI_ASSIGNMENT) {
        return new RobotMultiAssignmentImpl(node);
      }
      else if (type == RETURN_LINE) {
        return new RobotReturnLineImpl(node);
      }
      else if (type == RETURN_SETTING) {
        return new RobotReturnSettingImpl(node);
      }
      else if (type == ROBOT_TABLE) {
        return new RobotRobotTableImpl(node);
      }
      else if (type == SETTING) {
        return new RobotSettingImpl(node);
      }
      else if (type == SETTINGS_LINE) {
        return new RobotSettingsLineImpl(node);
      }
      else if (type == SETTINGS_TABLE) {
        return new RobotSettingsTableImpl(node);
      }
      else if (type == SETTINGS_TABLE_HEADING) {
        return new RobotSettingsTableHeadingImpl(node);
      }
      else if (type == SETTING_LIST) {
        return new RobotSettingListImpl(node);
      }
      else if (type == SETTING_LIST_OR_ELLIPSES) {
        return new RobotSettingListOrEllipsesImpl(node);
      }
      else if (type == SETUP_SETTING) {
        return new RobotSetupSettingImpl(node);
      }
      else if (type == SINGLE_ASSIGNMENT) {
        return new RobotSingleAssignmentImpl(node);
      }
      else if (type == TAG) {
        return new RobotTagImpl(node);
      }
      else if (type == TAGS_SETTING) {
        return new RobotTagsSettingImpl(node);
      }
      else if (type == TAG_LIST) {
        return new RobotTagListImpl(node);
      }
      else if (type == TAG_LIST_OR_ELLIPSES) {
        return new RobotTagListOrEllipsesImpl(node);
      }
      else if (type == TAG_LIST_OR_ELLIPSES_NO_COL) {
        return new RobotTagListOrEllipsesNoColImpl(node);
      }
      else if (type == TEARDOWN_SETTING) {
        return new RobotTeardownSettingImpl(node);
      }
      else if (type == TEMPLATE_SETTING) {
        return new RobotTemplateSettingImpl(node);
      }
      else if (type == TESTCASE_LINE) {
        return new RobotTestcaseLineImpl(node);
      }
      else if (type == TEST_CASE) {
        return new RobotTestCaseImpl(node);
      }
      else if (type == TEST_CASES_TABLE) {
        return new RobotTestCasesTableImpl(node);
      }
      else if (type == TEST_CASES_TABLE_HEADING) {
        return new RobotTestCasesTableHeadingImpl(node);
      }
      else if (type == TEST_CASE_HEADER) {
        return new RobotTestCaseHeaderImpl(node);
      }
      else if (type == TEST_CASE_SETTINGS) {
        return new RobotTestCaseSettingsImpl(node);
      }
      else if (type == TEST_SETTING) {
        return new RobotTestSettingImpl(node);
      }
      else if (type == TEST_SETTING_LINE) {
        return new RobotTestSettingLineImpl(node);
      }
      else if (type == TEST_SETUP_SETTING) {
        return new RobotTestSetupSettingImpl(node);
      }
      else if (type == TEST_SETUP_TOKEN) {
        return new RobotTestSetupTokenImpl(node);
      }
      else if (type == TIMEOUT_SETTING) {
        return new RobotTimeoutSettingImpl(node);
      }
      else if (type == VARIABLE) {
        return new RobotVariableImpl(node);
      }
      else if (type == VARIABLES_LINE) {
        return new RobotVariablesLineImpl(node);
      }
      else if (type == VARIABLES_TABLE) {
        return new RobotVariablesTableImpl(node);
      }
      else if (type == VARIABLES_TABLE_HEADING) {
        return new RobotVariablesTableHeadingImpl(node);
      }
      else if (type == VARIABLE_ASSIGN_TO_KEYWORD) {
        return new RobotVariableAssignToKeywordImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
