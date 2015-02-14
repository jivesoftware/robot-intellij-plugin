/*
   Copyright 2014 Charles Capps

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package com.jivesoftware.robot.intellij.plugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;

import static com.jivesoftware.robot.intellij.plugin.parser.RobotTypes.*;

@SuppressWarnings({ "ALL" })

%%

%class RobotScanner
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{
return;
%eof}

%line
%column
%char
%caseless

%{
  int yyline, yycolumn, yychar;
  private boolean onDocsLine = false;
  private boolean onTagsLine = false;
  private boolean onTimeoutLine = false;
  private boolean onReturnLine = false;
  private boolean keywordToLeft = false;
  private boolean startLine = true;
  private boolean firstRobotCell = true;
  private boolean onArgumentsLine = false;
  private boolean onForLoopLine = false;
  private boolean onResourceSettingLine = false;
  private boolean onLibrarySettingLine = false;
  private int previous_state = YYINITIAL;

  private IElementType next(IElementType toReturn) {
    if (toReturn != WHITESPACE_TOKEN) {
        startLine = false;
    }

    if (firstRobotCell && toReturn != WHITESPACE_TOKEN && toReturn != COLUMN_SEP_TOKEN && toReturn != EMPTY_CELL_TOKEN) {
        // If we see an ellipses, then retain the state from the previous line so everything is tokenized properly
        if (toReturn == ELLIPSES_TOKEN && onDocsLine) {
            yybegin(DOCS_SETTING);
        } else if (toReturn != ELLIPSES_TOKEN) {
           keywordToLeft = onTagsLine = onTimeoutLine = onDocsLine = onReturnLine
                         = onArgumentsLine = onForLoopLine = onResourceSettingLine = onLibrarySettingLine = false;
        }
        firstRobotCell = false;
    }

    if (toReturn == BAD_SYNTAX_TOKEN) {
        System.out.println(String.format("Bad syntax \"%s\" at line %d col %d", yytext(), yyline, yycolumn));
    }
    else if (toReturn == ROBOT_KEYWORD_TOKEN) {
        if (keywordToLeft || onReturnLine || onForLoopLine) {
            return ROBOT_KEYWORD_ARG_TOKEN;
        }
        if (onTagsLine) {
            return TAG_TOKEN;
        }
        if (onDocsLine) {
            return DOCUMENTATION_TOKEN;
        }
        if (onResourceSettingLine) {
            return ROBOT_FILE_TOKEN;
        }
        if (onLibrarySettingLine) {
            onLibrarySettingLine = false;
            return JAVA_CLASS_TOKEN;
        }
        keywordToLeft = true;
        return ROBOT_KEYWORD_TOKEN;
    }
    else if (toReturn == ROBOT_KEYWORD_ARG_TOKEN) {
         if (keywordToLeft) {
            return ROBOT_KEYWORD_ARG_TOKEN;
         }
         if (onTagsLine) {
            return TAG_TOKEN;
         }
         if (onDocsLine) {
            return DOCUMENTATION_TOKEN;
         }
         if (onResourceSettingLine) {
             return ROBOT_FILE_TOKEN;
         }
         if (onLibrarySettingLine) {
              onLibrarySettingLine = false;
              return JAVA_CLASS_TOKEN;
          }
         return ROBOT_KEYWORD_ARG_TOKEN;
    }
    else if (toReturn == FOR_LOOP_START_TOKEN) {
        onForLoopLine = true;
        return FOR_LOOP_START_TOKEN;
    }
    else if (toReturn == TAGS_META_TOKEN) {
        onTagsLine = true;
    }
    else if (toReturn == TIMEOUT_META_TOKEN || toReturn == TEST_TIMEOUT_SETTING_TOKEN) {
        onTimeoutLine = true;
    }
    else if (toReturn == FORCE_TAGS_SETTING_KEYWORD_TOKEN) {
        onTagsLine = true;
    }
    else if (toReturn == DOCUMENTATION_META_TOKEN || toReturn == DOCUMENTATION_SETTING_TOKEN) {
        onDocsLine = true;
    }
    else if (toReturn == RETURN_SETTING_TOKEN) {
        onReturnLine = true;
    }
    else if (toReturn == ARGUMENTS_SETTING_TOKEN) {
        onArgumentsLine = true;
    }
    else if (toReturn == RESOURCE_SETTING_TOKEN || toReturn == VARIABLE_SETTING_TOKEN) {
        onResourceSettingLine = true;
    }
    else if (toReturn == LIBRARY_SETTING_TOKEN) {
            onLibrarySettingLine = true;
        }
    return toReturn;
  }
  private IElementType newLine() {
    startLine = firstRobotCell = true;
    return NEWLINE_TOKEN;
  }


%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

/* Keyword arguments and test case headers use the same chars.*/
KeywordArgumentChar = [^\r\n\t\# ] | \\#
TestCaseHeaderChar =  {KeywordArgumentChar}
VariableChar = [^\r\n\t\#\{\} ]

ColumnSep = " " " "+ | [ \t]* "\t" [ \t]* | [ \t]+ \| [ \t]+
SingleSpace = " "
WhiteSpace = [ \t]
NonWhiteSpace = [^ \t\r\n]
S = " "?

EndOfLine = {WhiteSpace}* {LineTerminator}
Ellipses = \.\.\.
EmptyCell = "\\"

/* integer literals */
DecIntegerLiteral = 0 | "-"? [1-9][0-9]*
FloatNumberLiteral= [0-9]+ \.? [0-9]* | [0-9]* \.? [0-9]+
NonNegativeIntegerLiteral = 0 | [1-9][0-9]*

/* comments */
Comment = "#" {InputCharacter}*

/* identifiers */
VariableWord = {VariableChar}+
VariableName = {VariableWord} ({SingleSpace} {VariableWord})*
Variable = "${" {S} {VariableName} {S} "}"
Assignment = {Variable} {S} "="
AssignmentNoSpace = {Variable} "="

ArrayVariable = "@{" {S} {VariableName} {S} "}"
ArrayVariableAccess = {ArrayVariable} \[ {S} ({NonNegativeIntegerLiteral} | {Variable}) {S} \]
ArrayAssignment = {ArrayVariable} {S} "="

RobotKeyword = {RobotWord} ({SingleSpace} {RobotWord})*
RobotWord = [a-zA-Z0-9\.\*\(\)\[\]\"\'\-_\$\{\}\\#&@%=\|\\]+

TestCaseHeaderWord = {TestCaseHeaderChar}+
TestCaseHeader = {TestCaseHeaderWord} ({SingleSpace} {TestCaseHeaderWord})*

KeywordArgumentWord = {KeywordArgumentChar}+
KeywordArgument = ({KeywordArgumentWord} ({SingleSpace} {KeywordArgumentWord})*) | {Variable} | {EmptyCell}

/* For Keyword definition argument lists: */
ScalarDefaultArgumentValue = {AssignmentNoSpace} {S} {KeywordArgument}

/* Common words */
Setup = s {S} e {S} t {S} u {S} p
Teardown = t {S} e {S} a {S} r {S} d {S} o {S} w {S} n
Test = t {S} e {S} s {S} t
Precondition = p {S} r {S} e {S} c {S} o {S} n {S} d {S} i {S} t {S} i {S} o {S} n
Postcondition = p {S} o {S} s {S} t {S} c {S} o {S} n {S} d {S} i {S} t {S} i {S} o {S} n
Suite = s {S} u {S} i {S}  t {S}  e
Documentation = d {S} o {S} c {S} u {S} m {S} e {S} n {S} t {S} a {S} t {S} i {S} o {S} n
OptColon = ({S} ":")?

/* Settings for the ***Settings*** Table*/
TestSetupSetting = {Test} {S} ({Setup} | {Precondition}) {OptColon}
TestTeardownSetting = {Test} {S} ({Teardown} | {Postcondition}) {OptColon}
SuiteSetupSetting = {Suite} {S} ({Setup} | {Precondition}) {OptColon}
SuiteTeardownSetting = {Suite} {S} ({Teardown} | {Postcondition}) {OptColon}
ForceTags = (f {S} o {S} r {S} c {S} e | d {S} e {S} f {S} a {S} u {S} l {S} t) {S} t {S} a {S} g {S} s {OptColon}
ResourceSetting = r {S} e {S} s {S} o {S} u {S} r {S} c {S} e {OptColon}
VariableSetting = v {S} a {S} r {S} i {S} a {S} b {S} l {S} e {S} s {OptColon}
LibrarySetting = l {S} i {S} b {S} r {S} a {S} r {S} y {OptColon}
TestTimeoutSetting = {Test} {S} t {S} i {S} m {S} e {S} o {S} u {S} t {OptColon}
DocumentationSetting = {Documentation} {OptColon}
MetadataSetting = m {S} e {S} t {S} a {S} d {S} a {S} t {S} a {OptColon}
TestTemplateSetting = {Test} {S} t {S} e {S} m {S} p {S} l {S} a {S} t {S} e {OptColon}

/* Settings for robot test cases */
TagsMeta = "[" {WhiteSpace}* t {S} a {S} g {S} s {WhiteSpace}* "]"
DocsMeta = "[" {WhiteSpace}* {Documentation} {WhiteSpace}* "]"
DocsArgument = {NonWhiteSpace} {InputCharacter}*

SetupMeta = ("[" {S} {Setup} {S} "]")
          | ("[" {WhiteSpace}* {Precondition} {WhiteSpace}* "]")
TeardownMeta = ("[" {WhiteSpace}* {Teardown} {WhiteSpace}* "]")
             | ("[" {WhiteSpace}* {Postcondition} {WhiteSpace}* "]")
TimeoutMeta = "[" {WhiteSpace}* t {S} i {S} m {S} e {S} o {S} u {S} t {WhiteSpace}* "]"
TemplateMeta = "[" {WhiteSpace}* t {S} e {S} m {S} p {S} l {S} a {S} t {S} e {WhiteSpace}* "]"

RobotDays = {FloatNumberLiteral} {S} ("days" | "day" | "d")
RobotHours =  {FloatNumberLiteral} {S} ("hours" | "hour" | "h")
RobotMinutes =  {FloatNumberLiteral} {S} ("minutes" | "minute" | "mins" | "min" | "m")
RobotSeconds =  {FloatNumberLiteral} {S} ("seconds" | "second" | "secs" | "sec" | "s")
RobotSecondsNumber = ("-" {S})? {FloatNumberLiteral}
RobotMillis = {FloatNumberLiteral} {S} ("milliseconds" | "millisecond" | "millis" | "ms")

TimeoutValue = "none" |
               {RobotSecondsNumber} |
               ("-")? {S} {RobotDays} ({S} {RobotHours})? ({S} {RobotMinutes})? ({S} {RobotSeconds})? ({S} {RobotMillis})? |
               ("-")? {S} {RobotHours} ({S} {RobotMinutes})? ({S} {RobotSeconds})? ({S} {RobotMillis})? |
               ("-")? {S} {RobotMinutes} ({S} {RobotSeconds})? ({S} {RobotMillis})? |
               ("-")? {S} {RobotSeconds} ({S} {RobotMillis})? |
               ("-")? {S} {RobotMillis}

/* Settings for Robot Keywords table */
ArgumentsMeta = "[" {S} a {S} r {S} g {S} u {S} m {S} e {S} n {S} t {S} s {S} "]"
ReturnMeta = "[" {S} r {S} e {S} t {S} u {S} r {S} n {S} "]"

/* Table headings */
Junk = {InputCharacter}*
SettingsTableHeading  = {S} "*"+ {S} ((s {S} e {S} t {S} t {S} i {S} n {S} g {S} s?)
                                 | (m {S} e {S} t {S} a {S} d {S} a {S} t {S} a)) {S} ("*")* {Junk}
VariablesTableHeading = {S} "*"+ {S} (v {S} a {S} r {S} i {S} a {S} b {S} l {S} e {S} s?) {S} "*"* {Junk}
TestCasesTableHeading = {S} "*"+ {S} t {S} e {S} s {S} t {S} c {S} a {S} s {S} e {S} s? {S} "*"* {Junk}
KeywordsTableHeading = {S} "*"+ {S} (u {S} s {S} e {S} r {S})? k {S} e {S} y {S} w {S} o {S} r {S} d {S} s? {WhiteSpace}? "*"* {Junk}

/* For loops */
ForLoopStart = ":FOR"
InRange = "IN RANGE"
In = "IN"

/*
   These states are for the different Robot tables, because different tokens are allowed in different tables.
   For example, in the "Test Cases" table, you can have a [tags] setting.
   In the "Settings" table, you can't have any [settings].
*/

%state SETTINGS
%state VARIABLES
%state TEST_CASES
%state KEYWORDS
%state DOCS_SETTING
%state BAD_SYNTAX
%%

<YYINITIAL> {
    /* identifiers */
    {EndOfLine}                  { return newLine(); }
    {SettingsTableHeading}       { yybegin(SETTINGS); return next(SETTINGS_TABLE_HEADING_TOKEN); }
    {VariablesTableHeading}      { yybegin(VARIABLES); return next(VARIABLES_TABLE_HEADING_TOKEN); }
    {TestCasesTableHeading}      { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
    {KeywordsTableHeading}       { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
    {Junk}                       { return next(COMMENT_TOKEN); }
}

<SETTINGS> {
 /* identifiers */
     {EndOfLine}         { return newLine(); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {VariablesTableHeading}     { yybegin(VARIABLES); return next(VARIABLES_TABLE_HEADING_TOKEN); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TestCasesTableHeading}     { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
     {SettingsTableHeading}      { yybegin(BAD_SYNTAX); return next(BAD_SYNTAX_TOKEN); }
     {Ellipses}          { return next(ELLIPSES_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {ArrayVariableAccess}     { return next(ARRAY_VARIABLE_ACCESS_TOKEN); }
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {ForceTags}         { if (startLine) {return next(FORCE_TAGS_SETTING_KEYWORD_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {ResourceSetting}     { if (startLine) {return next(RESOURCE_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {TestSetupSetting}     { if (startLine) {return next(TEST_SETUP_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {TestTeardownSetting}  { if (startLine) {return next(TEST_TEARDOWN_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {SuiteSetupSetting}    { if (startLine) {return next(SUITE_SETUP_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {SuiteTeardownSetting}    { if (startLine) {return next(SUITE_TEARDOWN_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {LibrarySetting}    { if (startLine) {return next(LIBRARY_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {TestTimeoutSetting}    { if (startLine) {return next(TEST_TIMEOUT_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {DocumentationSetting}    { if (startLine) {previous_state = yystate(); yybegin(DOCS_SETTING); return next(DOCUMENTATION_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {MetadataSetting}    { if (startLine) {return next(METADATA_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {VariableSetting}    { if (startLine) {return next(VARIABLE_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {TestTemplateSetting}    { if (startLine) {return next(TEST_TEMPLATE_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {RobotKeyword}      { if (startLine) {return next(GENERIC_SETTING_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {KeywordArgument}   { return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {WhiteSpace}        { return next(WHITESPACE_TOKEN); }
}

<VARIABLES> {
 /* identifiers */
     {EndOfLine}         { return newLine(); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {VariablesTableHeading}     { return next(VARIABLES_TABLE_HEADING_TOKEN); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TestCasesTableHeading}     { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
     {SettingsTableHeading}      { yybegin(SETTINGS); return next(SETTINGS_TABLE_HEADING_TOKEN); }
     {Ellipses}          { return next(ELLIPSES_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {ArrayAssignment}   { return next(ARRAY_ASSIGNMENT_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {KeywordArgument}   { return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {WhiteSpace}        { return next(WHITESPACE_TOKEN); }
}


<TEST_CASES> {

     /* identifiers */
     {EndOfLine}         {  return newLine(); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {SettingsTableHeading}      { yybegin(SETTINGS); return next(SETTINGS_TABLE_HEADING_TOKEN); }
     {VariablesTableHeading}     { yybegin(VARIABLES); return next(VARIABLES_TABLE_HEADING_TOKEN); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TestCasesTableHeading}      { return next(TEST_CASES_TABLE_HEADING_TOKEN); }
     {Ellipses}          { return next(ELLIPSES_TOKEN); }
     {TagsMeta}          { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(TAGS_META_TOKEN); }
     {DocsMeta}          { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } previous_state = yystate(); yybegin(DOCS_SETTING); return next(DOCUMENTATION_META_TOKEN); }
     {SetupMeta}         { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(SETUP_META_TOKEN); }
     {TeardownMeta}      { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(TEARDOWN_META_TOKEN); }
     {TimeoutMeta}       { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(TIMEOUT_META_TOKEN); }
     {TemplateMeta}      { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(TEMPLATE_SETTING_TOKEN); }
     {EmptyCell}                  { return next(EMPTY_CELL_TOKEN); }
     {ForLoopStart}               { return next(FOR_LOOP_START_TOKEN); }
     {InRange}                    { return next(IN_RANGE_TOKEN); }
     {In}                         { return next(IN_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {ArrayAssignment}   { return next(ARRAY_ASSIGNMENT_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {ArrayVariableAccess}     { return next(ARRAY_VARIABLE_ACCESS_TOKEN); }
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN);} return next(ROBOT_KEYWORD_TOKEN); }
     {DecIntegerLiteral}          {
                                    if (startLine) { return next(TEST_CASE_HEADER_TOKEN); }
                                    else if (firstRobotCell) { return next(ROBOT_KEYWORD_TOKEN); }
                                    else if (onForLoopLine) { return next(INTEGER_TOKEN); }
                                    else if (keywordToLeft) { return next(INTEGER_TOKEN); }
                                    return next(ROBOT_KEYWORD_TOKEN);
                                    }
     {RobotKeyword}      { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {TestCaseHeader}    { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {KeywordArgument}   { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); } return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {WhiteSpace}        { return next(WHITESPACE_TOKEN); }
}

<DOCS_SETTING> {
    {ColumnSep}          { return next(COLUMN_SEP_TOKEN); }
    {DocsArgument}       { return next(DOCUMENTATION_TOKEN); }
    {LineTerminator}     { yybegin(previous_state); return newLine();}
}

<KEYWORDS> {

     /* identifiers */
     {EndOfLine}         { return newLine(); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {SettingsTableHeading}      { yybegin(SETTINGS); return next(SETTINGS_TABLE_HEADING_TOKEN); }
     {VariablesTableHeading}     { yybegin(VARIABLES); return next(VARIABLES_TABLE_HEADING_TOKEN); }
     {TestCasesTableHeading}     { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
     {KeywordsTableHeading}      { yybegin(BAD_SYNTAX); return next(BAD_SYNTAX_TOKEN); }
     {Ellipses}          { return next(ELLIPSES_TOKEN); }
     {DocsMeta}          { previous_state = yystate(); yybegin(DOCS_SETTING); return next(DOCUMENTATION_META_TOKEN); }
     {ArgumentsMeta}     { return next(ARGUMENTS_SETTING_TOKEN); }
     {SetupMeta}         { return next(SETUP_META_TOKEN); }
     {TeardownMeta}      { return next(TEARDOWN_META_TOKEN); }
     {TimeoutMeta}       { return next(TIMEOUT_META_TOKEN); }
     {ReturnMeta}        { return next(RETURN_SETTING_TOKEN); }
     {TimeoutValue}      { if (startLine) { return next(ROBOT_KEYWORD_TITLE_TOKEN); }
                           if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN); }
                           return next(ROBOT_KEYWORD_TOKEN); }
     {EmptyCell}                  { return next(EMPTY_CELL_TOKEN); }
     {ForLoopStart}               { return next(FOR_LOOP_START_TOKEN); }
     {InRange}                    { return next(IN_RANGE_TOKEN); }
     {In}                         { return next(IN_TOKEN); }
     {ScalarDefaultArgumentValue}    { if (onArgumentsLine) { return next(SCALAR_DEFAULT_ARG_VALUE_TOKEN); } return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {ArrayAssignment}   { return next(ARRAY_ASSIGNMENT_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {ArrayVariableAccess}     { return next(ARRAY_VARIABLE_ACCESS_TOKEN); }
     {DecIntegerLiteral} { if (startLine) { return next(ROBOT_KEYWORD_TITLE_TOKEN); }
                           else if (firstRobotCell) { return next(ROBOT_KEYWORD_TOKEN); }
                           else if (onForLoopLine) { return next(INTEGER_TOKEN); }
                           else if (keywordToLeft) { return next(INTEGER_TOKEN); }
                           else { return next(ROBOT_KEYWORD_TOKEN); }}
     {RobotKeyword}      { if (startLine) { return next(ROBOT_KEYWORD_TITLE_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {KeywordArgument}   { if (startLine) { return next(BAD_SYNTAX_TOKEN); } return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {WhiteSpace}        { return next(WHITESPACE_TOKEN); }
}

<BAD_SYNTAX> {
    .+                     { return next(BAD_SYNTAX_TOKEN);}
}

[^]                   { return next(BAD_SYNTAX_TOKEN);}
