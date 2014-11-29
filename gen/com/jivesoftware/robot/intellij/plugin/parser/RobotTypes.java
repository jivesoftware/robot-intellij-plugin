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
  IElementType ARRAY_ASSIGNABLE_IN_VARIABLES_TBL = new RobotElementType("ARRAY_ASSIGNABLE_IN_VARIABLES_TBL");
  IElementType ARRAY_ASSIGNMENT = new RobotElementType("ARRAY_ASSIGNMENT");
  IElementType ARRAY_ASSIGNMENT_LHS = new RobotElementType("ARRAY_ASSIGNMENT_LHS");
  IElementType ARRAY_VARIABLE = new RobotElementType("ARRAY_VARIABLE");
  IElementType ASSIGNABLE_IN_VARIABLES_TBL = new RobotElementType("ASSIGNABLE_IN_VARIABLES_TBL");
  IElementType ASSIGNMENT = new RobotElementType("ASSIGNMENT");
  IElementType DOCUMENTATION_META = new RobotElementType("DOCUMENTATION_META");
  IElementType DOCUMENTATION_SETTING = new RobotElementType("DOCUMENTATION_SETTING");
  IElementType DOUBLE_BOUND_FOR_LOOP = new RobotElementType("DOUBLE_BOUND_FOR_LOOP");
  IElementType DOUBLE_BOUND_FOR_LOOP_WITH_STEP = new RobotElementType("DOUBLE_BOUND_FOR_LOOP_WITH_STEP");
  IElementType ELLIPSES = new RobotElementType("ELLIPSES");
  IElementType ELLIPSES_LINE_TEST = new RobotElementType("ELLIPSES_LINE_TEST");
  IElementType EMPTY_LINE = new RobotElementType("EMPTY_LINE");
  IElementType ERROR = new RobotElementType("ERROR");
  IElementType EXECUTION_LINE = new RobotElementType("EXECUTION_LINE");
  IElementType FORCE_TAGS_SETTING = new RobotElementType("FORCE_TAGS_SETTING");
  IElementType FOR_LOOP_IN = new RobotElementType("FOR_LOOP_IN");
  IElementType FOR_LOOP_IN_RANGE = new RobotElementType("FOR_LOOP_IN_RANGE");
  IElementType FOR_LOOP_VALUE_LIST = new RobotElementType("FOR_LOOP_VALUE_LIST");
  IElementType FOR_VAR_IN = new RobotElementType("FOR_VAR_IN");
  IElementType FOR_VAR_IN_RANGE = new RobotElementType("FOR_VAR_IN_RANGE");
  IElementType GENERIC_SETTING = new RobotElementType("GENERIC_SETTING");
  IElementType GENERIC_SETTING_NAME = new RobotElementType("GENERIC_SETTING_NAME");
  IElementType INDENTED_KEYWORD_INVOCATION_TEST = new RobotElementType("INDENTED_KEYWORD_INVOCATION_TEST");
  IElementType INDENTED_VARIABLE_ASSIGN_TO_KEYWORD = new RobotElementType("INDENTED_VARIABLE_ASSIGN_TO_KEYWORD");
  IElementType JAVA_CLASS_REFERENCE = new RobotElementType("JAVA_CLASS_REFERENCE");
  IElementType KEYWORD = new RobotKeywordElementType("KEYWORD");
  IElementType KEYWORDS_TABLE = new RobotElementType("KEYWORDS_TABLE");
  IElementType KEYWORDS_TABLE_HEADING = new RobotElementType("KEYWORDS_TABLE_HEADING");
  IElementType KEYWORD_ARG = new RobotKeywordArgElementType("KEYWORD_ARG");
  IElementType KEYWORD_ARG_LIST = new RobotElementType("KEYWORD_ARG_LIST");
  IElementType KEYWORD_DEFINITION = new RobotElementType("KEYWORD_DEFINITION");
  IElementType KEYWORD_INVOCATION_SETTINGS = new RobotElementType("KEYWORD_INVOCATION_SETTINGS");
  IElementType KEYWORD_INVOCATION_TEST = new RobotElementType("KEYWORD_INVOCATION_TEST");
  IElementType KEYWORD_LINE = new RobotElementType("KEYWORD_LINE");
  IElementType KEYWORD_SETTING = new RobotElementType("KEYWORD_SETTING");
  IElementType KEYWORD_SETTING_LINE = new RobotElementType("KEYWORD_SETTING_LINE");
  IElementType KEYWORD_TITLE = new RobotKeywordTitleElementType("KEYWORD_TITLE");
  IElementType LIBRARY_SETTING = new RobotElementType("LIBRARY_SETTING");
  IElementType MULTI_ASSIGNMENT_LHS = new RobotElementType("MULTI_ASSIGNMENT_LHS");
  IElementType RESOURCE_FILE = new RobotElementType("RESOURCE_FILE");
  IElementType RESOURCE_SETTING = new RobotElementType("RESOURCE_SETTING");
  IElementType RETURN_LINE = new RobotElementType("RETURN_LINE");
  IElementType RETURN_SETTING = new RobotElementType("RETURN_SETTING");
  IElementType SCALAR_ASSIGNMENT = new RobotScalarAssignmentElementType("SCALAR_ASSIGNMENT");
  IElementType SCALAR_ASSIGNMENT_LHS = new RobotElementType("SCALAR_ASSIGNMENT_LHS");
  IElementType SCALAR_DEFAULT_ARG_VALUE = new RobotElementType("SCALAR_DEFAULT_ARG_VALUE");
  IElementType SCALAR_VARIABLE = new RobotScalarVariableElementType("SCALAR_VARIABLE");
  IElementType SETTING = new RobotElementType("SETTING");
  IElementType SETTINGS_LINE = new RobotElementType("SETTINGS_LINE");
  IElementType SETTINGS_TABLE = new RobotElementType("SETTINGS_TABLE");
  IElementType SETTINGS_TABLE_HEADING = new RobotElementType("SETTINGS_TABLE_HEADING");
  IElementType SETTING_LIST = new RobotElementType("SETTING_LIST");
  IElementType SINGLE_ASSIGNMENT_LHS = new RobotElementType("SINGLE_ASSIGNMENT_LHS");
  IElementType SINGLE_BOUND_FOR_LOOP = new RobotElementType("SINGLE_BOUND_FOR_LOOP");
  IElementType SINGLE_VARIABLE_LIST = new RobotElementType("SINGLE_VARIABLE_LIST");
  IElementType TABLE = new RobotElementType("TABLE");
  IElementType TAG = new RobotElementType("TAG");
  IElementType TAGS_META = new RobotElementType("TAGS_META");
  IElementType TESTCASE_LINE = new RobotElementType("TESTCASE_LINE");
  IElementType TEST_CASE = new RobotTestCaseElementType("TEST_CASE");
  IElementType TEST_CASES_TABLE = new RobotElementType("TEST_CASES_TABLE");
  IElementType TEST_CASES_TABLE_HEADING = new RobotElementType("TEST_CASES_TABLE_HEADING");
  IElementType TEST_CASE_HEADER = new RobotElementType("TEST_CASE_HEADER");
  IElementType TEST_CASE_SETUP_META = new RobotElementType("TEST_CASE_SETUP_META");
  IElementType TEST_CASE_TEARDOWN_META = new RobotElementType("TEST_CASE_TEARDOWN_META");
  IElementType TEST_CASE_TEMPLATE_META = new RobotElementType("TEST_CASE_TEMPLATE_META");
  IElementType TEST_CASE_TIMEOUT_META = new RobotElementType("TEST_CASE_TIMEOUT_META");
  IElementType TEST_SETTING = new RobotElementType("TEST_SETTING");
  IElementType TEST_SETTING_LINE = new RobotElementType("TEST_SETTING_LINE");
  IElementType TEST_SETUP_SETTING = new RobotElementType("TEST_SETUP_SETTING");
  IElementType TEST_SETUP_TOKEN = new RobotElementType("TEST_SETUP_TOKEN");
  IElementType TEST_TIMEOUT_SETTING = new RobotElementType("TEST_TIMEOUT_SETTING");
  IElementType VARIABLE = new RobotElementType("VARIABLE");
  IElementType VARIABLES_LINE = new RobotElementType("VARIABLES_LINE");
  IElementType VARIABLES_TABLE = new RobotElementType("VARIABLES_TABLE");
  IElementType VARIABLES_TABLE_HEADING = new RobotElementType("VARIABLES_TABLE_HEADING");
  IElementType VARIABLE_ASSIGN_TO_KEYWORD = new RobotElementType("VARIABLE_ASSIGN_TO_KEYWORD");

  IElementType ARGUMENTS_SETTING_TOKEN = new RobotToken("ARGUMENTS_SETTING_TOKEN");
  IElementType ARRAY_ASSIGNMENT_TOKEN = new RobotToken("ARRAY_ASSIGNMENT_TOKEN");
  IElementType ARRAY_VARIABLE_ACCESS_TOKEN = new RobotToken("ARRAY_VARIABLE_ACCESS_TOKEN");
  IElementType ARRAY_VARIABLE_TOKEN = new RobotToken("ARRAY_VARIABLE_TOKEN");
  IElementType ASSIGNMENT_TOKEN = new RobotToken("ASSIGNMENT_TOKEN");
  IElementType BAD_SYNTAX_TOKEN = new RobotToken("BAD_SYNTAX_TOKEN");
  IElementType COLUMN_SEP_TOKEN = new RobotToken("COLUMN_SEP_TOKEN");
  IElementType COMMENT_TOKEN = new RobotToken("COMMENT_TOKEN");
  IElementType DOCUMENTATION_META_TOKEN = new RobotToken("DOCUMENTATION_META_TOKEN");
  IElementType DOCUMENTATION_SETTING_TOKEN = new RobotToken("DOCUMENTATION_SETTING_TOKEN");
  IElementType DOCUMENTATION_TOKEN = new RobotToken("DOCUMENTATION_TOKEN");
  IElementType ELLIPSES_TOKEN = new RobotToken("ELLIPSES_TOKEN");
  IElementType EMPTY_CELL_TOKEN = new RobotToken("EMPTY_CELL_TOKEN");
  IElementType FORCE_TAGS_SETTING_KEYWORD_TOKEN = new RobotToken("FORCE_TAGS_SETTING_KEYWORD_TOKEN");
  IElementType FOR_LOOP_START_TOKEN = new RobotToken("FOR_LOOP_START_TOKEN");
  IElementType GENERIC_SETTING_TOKEN = new RobotToken("GENERIC_SETTING_TOKEN");
  IElementType INTEGER_TOKEN = new RobotToken("INTEGER_TOKEN");
  IElementType IN_RANGE_TOKEN = new RobotToken("IN_RANGE_TOKEN");
  IElementType IN_TOKEN = new RobotToken("IN_TOKEN");
  IElementType JAVA_CLASS_TOKEN = new RobotToken("JAVA_CLASS_TOKEN");
  IElementType KEYWORDS_TABLE_HEADING_TOKEN = new RobotToken("KEYWORDS_TABLE_HEADING_TOKEN");
  IElementType LIBRARY_SETTING_TOKEN = new RobotToken("LIBRARY_SETTING_TOKEN");
  IElementType NEWLINE_TOKEN = new RobotToken("NEWLINE_TOKEN");
  IElementType RESOURCE_SETTING_TOKEN = new RobotToken("RESOURCE_SETTING_TOKEN");
  IElementType RETURN_SETTING_TOKEN = new RobotToken("RETURN_SETTING_TOKEN");
  IElementType ROBOT_FILE_TOKEN = new RobotToken("ROBOT_FILE_TOKEN");
  IElementType ROBOT_KEYWORD_ARG_TOKEN = new RobotToken("ROBOT_KEYWORD_ARG_TOKEN");
  IElementType ROBOT_KEYWORD_TITLE_TOKEN = new RobotToken("ROBOT_KEYWORD_TITLE_TOKEN");
  IElementType ROBOT_KEYWORD_TOKEN = new RobotToken("ROBOT_KEYWORD_TOKEN");
  IElementType SCALAR_DEFAULT_ARG_VALUE_TOKEN = new RobotToken("SCALAR_DEFAULT_ARG_VALUE_TOKEN");
  IElementType SETTINGS_TABLE_HEADING_TOKEN = new RobotToken("SETTINGS_TABLE_HEADING_TOKEN");
  IElementType SETUP_META_TOKEN = new RobotToken("SETUP_META_TOKEN");
  IElementType SUITE_SETUP_SETTING_TOKEN = new RobotToken("SUITE_SETUP_SETTING_TOKEN");
  IElementType SUITE_TEARDOWN_SETTING_TOKEN = new RobotToken("SUITE_TEARDOWN_SETTING_TOKEN");
  IElementType TAGS_META_TOKEN = new RobotToken("TAGS_META_TOKEN");
  IElementType TAG_TOKEN = new RobotToken("TAG_TOKEN");
  IElementType TEARDOWN_META_TOKEN = new RobotToken("TEARDOWN_META_TOKEN");
  IElementType TEMPLATE_SETTING_TOKEN = new RobotToken("TEMPLATE_SETTING_TOKEN");
  IElementType TEST_CASES_TABLE_HEADING_TOKEN = new RobotToken("TEST_CASES_TABLE_HEADING_TOKEN");
  IElementType TEST_CASE_HEADER_TOKEN = new RobotToken("TEST_CASE_HEADER_TOKEN");
  IElementType TEST_SETUP_SETTING_TOKEN = new RobotToken("TEST_SETUP_SETTING_TOKEN");
  IElementType TEST_TEARDOWN_SETTING_TOKEN = new RobotToken("TEST_TEARDOWN_SETTING_TOKEN");
  IElementType TEST_TIMEOUT_SETTING_TOKEN = new RobotToken("TEST_TIMEOUT_SETTING_TOKEN");
  IElementType TIMEOUT_META_TOKEN = new RobotToken("TIMEOUT_META_TOKEN");
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
      else if (type == ARRAY_ASSIGNABLE_IN_VARIABLES_TBL) {
        return new RobotArrayAssignableInVariablesTblImpl(node);
      }
      else if (type == ARRAY_ASSIGNMENT) {
        return new RobotArrayAssignmentImpl(node);
      }
      else if (type == ARRAY_ASSIGNMENT_LHS) {
        return new RobotArrayAssignmentLhsImpl(node);
      }
      else if (type == ARRAY_VARIABLE) {
        return new RobotArrayVariableImpl(node);
      }
      else if (type == ASSIGNABLE_IN_VARIABLES_TBL) {
        return new RobotAssignableInVariablesTblImpl(node);
      }
      else if (type == ASSIGNMENT) {
        return new RobotAssignmentImpl(node);
      }
      else if (type == DOCUMENTATION_META) {
        return new RobotDocumentationMetaImpl(node);
      }
      else if (type == DOCUMENTATION_SETTING) {
        return new RobotDocumentationSettingImpl(node);
      }
      else if (type == DOUBLE_BOUND_FOR_LOOP) {
        return new RobotDoubleBoundForLoopImpl(node);
      }
      else if (type == DOUBLE_BOUND_FOR_LOOP_WITH_STEP) {
        return new RobotDoubleBoundForLoopWithStepImpl(node);
      }
      else if (type == ELLIPSES) {
        return new RobotEllipsesImpl(node);
      }
      else if (type == ELLIPSES_LINE_TEST) {
        return new RobotEllipsesLineTestImpl(node);
      }
      else if (type == EMPTY_LINE) {
        return new RobotEmptyLineImpl(node);
      }
      else if (type == ERROR) {
        return new RobotErrorImpl(node);
      }
      else if (type == EXECUTION_LINE) {
        return new RobotExecutionLineImpl(node);
      }
      else if (type == FORCE_TAGS_SETTING) {
        return new RobotForceTagsSettingImpl(node);
      }
      else if (type == FOR_LOOP_IN) {
        return new RobotForLoopInImpl(node);
      }
      else if (type == FOR_LOOP_IN_RANGE) {
        return new RobotForLoopInRangeImpl(node);
      }
      else if (type == FOR_LOOP_VALUE_LIST) {
        return new RobotForLoopValueListImpl(node);
      }
      else if (type == FOR_VAR_IN) {
        return new RobotForVarInImpl(node);
      }
      else if (type == FOR_VAR_IN_RANGE) {
        return new RobotForVarInRangeImpl(node);
      }
      else if (type == GENERIC_SETTING) {
        return new RobotGenericSettingImpl(node);
      }
      else if (type == GENERIC_SETTING_NAME) {
        return new RobotGenericSettingNameImpl(node);
      }
      else if (type == INDENTED_KEYWORD_INVOCATION_TEST) {
        return new RobotIndentedKeywordInvocationTestImpl(node);
      }
      else if (type == INDENTED_VARIABLE_ASSIGN_TO_KEYWORD) {
        return new RobotIndentedVariableAssignToKeywordImpl(node);
      }
      else if (type == JAVA_CLASS_REFERENCE) {
        return new RobotJavaClassReferenceImpl(node);
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
      else if (type == KEYWORD_DEFINITION) {
        return new RobotKeywordDefinitionImpl(node);
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
      else if (type == KEYWORD_SETTING_LINE) {
        return new RobotKeywordSettingLineImpl(node);
      }
      else if (type == KEYWORD_TITLE) {
        return new RobotKeywordTitleImpl(node);
      }
      else if (type == LIBRARY_SETTING) {
        return new RobotLibrarySettingImpl(node);
      }
      else if (type == MULTI_ASSIGNMENT_LHS) {
        return new RobotMultiAssignmentLhsImpl(node);
      }
      else if (type == RESOURCE_FILE) {
        return new RobotResourceFileImpl(node);
      }
      else if (type == RESOURCE_SETTING) {
        return new RobotResourceSettingImpl(node);
      }
      else if (type == RETURN_LINE) {
        return new RobotReturnLineImpl(node);
      }
      else if (type == RETURN_SETTING) {
        return new RobotReturnSettingImpl(node);
      }
      else if (type == SCALAR_ASSIGNMENT) {
        return new RobotScalarAssignmentImpl(node);
      }
      else if (type == SCALAR_ASSIGNMENT_LHS) {
        return new RobotScalarAssignmentLhsImpl(node);
      }
      else if (type == SCALAR_DEFAULT_ARG_VALUE) {
        return new RobotScalarDefaultArgValueImpl(node);
      }
      else if (type == SCALAR_VARIABLE) {
        return new RobotScalarVariableImpl(node);
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
      else if (type == SINGLE_ASSIGNMENT_LHS) {
        return new RobotSingleAssignmentLhsImpl(node);
      }
      else if (type == SINGLE_BOUND_FOR_LOOP) {
        return new RobotSingleBoundForLoopImpl(node);
      }
      else if (type == SINGLE_VARIABLE_LIST) {
        return new RobotSingleVariableListImpl(node);
      }
      else if (type == TABLE) {
        return new RobotTableImpl(node);
      }
      else if (type == TAG) {
        return new RobotTagImpl(node);
      }
      else if (type == TAGS_META) {
        return new RobotTagsMetaImpl(node);
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
      else if (type == TEST_CASE_SETUP_META) {
        return new RobotTestCaseSetupMetaImpl(node);
      }
      else if (type == TEST_CASE_TEARDOWN_META) {
        return new RobotTestCaseTeardownMetaImpl(node);
      }
      else if (type == TEST_CASE_TEMPLATE_META) {
        return new RobotTestCaseTemplateMetaImpl(node);
      }
      else if (type == TEST_CASE_TIMEOUT_META) {
        return new RobotTestCaseTimeoutMetaImpl(node);
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
      else if (type == TEST_TIMEOUT_SETTING) {
        return new RobotTestTimeoutSettingImpl(node);
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
