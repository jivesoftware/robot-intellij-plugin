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

//@SuppressWarnings({ "ALL" })

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

%{
  int yyline, yycolumn, yychar;
  private boolean onDocsLine = false;
  private boolean onTagsLine = false;
  private boolean onTimeoutLine = false;
  private boolean keywordToLeft = false;
  private boolean startLine = true;
  private boolean firstRobotCell = true;
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
           keywordToLeft = onTagsLine = onTimeoutLine = onDocsLine = false;
        }
        firstRobotCell = false;
    }

    if (toReturn == BAD_SYNTAX_TOKEN) {
        System.out.println(String.format("Bad syntax \"%s\" at line %d col %d", yytext(), yyline, yycolumn));
    }
    else if (toReturn == ROBOT_KEYWORD_TOKEN) {
        if (keywordToLeft) {
            return ROBOT_KEYWORD_ARG_TOKEN;
        }
        if (onTagsLine) {
            return TAG_TOKEN;
        }
        if (onDocsLine) {
            return DOCUMENTATION_TOKEN;
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
         return ROBOT_KEYWORD_ARG_TOKEN;
    }
    else if (toReturn == TAGS_SETTING_TOKEN) {
        onTagsLine = true;
    }
    else if (toReturn == TIMEOUT_SETTING_TOKEN) {
        onTimeoutLine = true;
    }
    else if (toReturn == FORCE_TAGS_SETTING_KEYWORD_TOKEN) {
        onTagsLine = true;
    }
    else if (toReturn == DOCUMENTATION_SETTING_TOKEN) {
        onDocsLine = true;
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

ColumnSep = " " " "+ | [ \t]* "\t" [ \t]* | [ \t]+ \| [ \t]+
SingleSpace = " "
WhiteSpace = [ \t]
NonWhiteSpace = [^ \t\r\n]

EndOfLine = {WhiteSpace}* {LineTerminator}
Ellipses = \.\.\.
EmptyCell = "\\"

/* integer literals */
DecIntegerLiteral = 0 | "-"? [1-9][0-9]*

/* comments */
Comment = "#" {InputCharacter}*

/* identifiers */
Variable = "${" {Identifier} "}"
ArrayVariable = "@{" {Identifier} "}"
Assignment = {Variable} " "? "="
ArrayAssignment = {ArrayVariable} " "? "="

RobotKeyword = {RobotWord} ({SingleSpace} {RobotWord})*
RobotWord = [a-zA-Z][a-zA-Z0-9\-]*

Identifier = [a-zA-Z_][a-zA-Z0-9_]*

TestCaseHeaderWord = {TestCaseHeaderChar}+
TestCaseHeader = {TestCaseHeaderWord} ({SingleSpace} {TestCaseHeaderWord})*

KeywordArgumentWord = {KeywordArgumentChar}+
KeywordArgument = ({KeywordArgumentWord} ({SingleSpace} {KeywordArgumentWord})*) | {Variable} | {EmptyCell}

/* Settings for the ***Settings*** Table*/
TestSetupSetting = [Tt] [Ee] [Ss] [Tt] " "? [Ss] [Ee] [Tt] [Uu] [Pp]
TestTeardownSetting = [Tt] [Ee] [Ss] [Tt] " "? [Tt] [Ee] [Aa] [Rr] [Dd] [Oo] [Ww] [Nn]
SuiteSetupSetting = [Ss] [Uu] [Ii] [Tt] [Ee] " "? [Ss] [Ee] [Tt] [Uu] [Pp]
ForceTags = [Ff] "orce" " "? [Tt] "ags"
ResourceSetting = [Rr] [Ee] [Ss] [Oo] [Uu] [Rr] [Cc] [Ee]

/* Settings for robot test cases */
TagsMeta = "[" {WhiteSpace}* [Tt] [Aa] [Gg] [Ss] {WhiteSpace}* "]"
DocsMeta = "[" {WhiteSpace}* [Dd] "ocumentation" {WhiteSpace}* "]"
DocsArgument = {NonWhiteSpace} {InputCharacter}*

SetupMeta = ("[" {WhiteSpace}* [Ss] [Ee] [Tt] [Uu] [Pp] {WhiteSpace}* "]")
          | ("[" {WhiteSpace}* [Pp] "recondition" {WhiteSpace}* "]")
TeardownMeta = ("[" {WhiteSpace}* [Tt] [Ee] [Aa] [Rr] [Dd] [Oo] [Ww] [Nn] {WhiteSpace}* "]")
             | ("[" {WhiteSpace}* [Pp] "ostcondition" {WhiteSpace}* "]")
TimeoutMeta = "[" {WhiteSpace}* [Tt] "imeout" {WhiteSpace}* "]"
TemplateMeta = "[" {WhiteSpace}* [Tt] "emplate" {WhiteSpace}* "]"

HourTime =  {DecIntegerLiteral} {SingleSpace}? [Hh] "our" ("s")?
MinuteTime= {DecIntegerLiteral} {SingleSpace}? ([Mm] "inute" | [Mm] "in") ("s")?
SecondTime = {DecIntegerLiteral} {SingleSpace}? ([Ss] "econd" | [Ss] "ec") ("s")?

TimeoutValue = {HourTime} {SingleSpace} {MinuteTime} {SingleSpace} {SecondTime} | {HourTime} | {HourTime} {SingleSpace} {MinuteTime} |
{HourTime} {SingleSpace} {SecondTime} | {MinuteTime} {SingleSpace} {SecondTime} | {MinuteTime} | {SecondTime}

/* Settings for Robot Keywords table */
ArgumentsMeta = "[" {WhiteSpace}* [Aa] "rguments" {WhiteSpace}* "]"
ReturnMeta = "[" {WhiteSpace}* [Rr] "eturn" {WhiteSpace}* "]"

/* Table headings */
SettingsTableHeading  = "*"+ {WhiteSpace}* (([Ss] [Ee] [Tt] [Tt] [Ii] [Nn] [Gg] [Ss]?) | "Metadata") {WhiteSpace}* ("*")*
VariablesTableHeading = "*"+ {WhiteSpace}* ([Vv] [Aa] [Rr] [Ii] [Aa] [Bb] [Ll] [Ee] [Ss]?) {WhiteSpace}* "*"*
TestCasesTableHeading = "*"+ {WhiteSpace}* [Tt] [Ee] [Ss] [Tt] " "? [Cc] [Aa] [Ss] [Ee] [Ss]? {WhiteSpace}* "*"*
KeywordsTableHeading = "*"+ {WhiteSpace}* ([Uu] [Ss] [Ee] [Rr] " "*)? [Kk] [Ee] [Yy] [Ww] [Oo] [Rr] [Dd] [Ss]? {WhiteSpace}* "*"*

/*For loops*/
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
    {EndOfLine}             { return newLine(); }
    {SettingsTableHeading}       { yybegin(SETTINGS); return next(SETTINGS_TABLE_HEADING_TOKEN); }
    {VariablesTableHeading}      { yybegin(VARIABLES); return next(VARIABLES_TABLE_HEADING_TOKEN); }
    {TestCasesTableHeading}      { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
    {KeywordsTableHeading}       { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
    {Comment}                    { return next(COMMENT_TOKEN); }
    {ColumnSep}                  { return next(COLUMN_SEP_TOKEN); }
    {WhiteSpace}                 { return next(WHITESPACE_TOKEN); }
    {EmptyCell}                  { return next(EMPTY_CELL_TOKEN); }
    {ForLoopStart}               { return next(FOR_LOOP_START_TOKEN); }
    {InRange}                    { return next(IN_RANGE_TOKEN); }
    {In}                         { return next(IN_TOKEN); }
    {Ellipses}                   { return next(ELLIPSES_TOKEN); }
    {RobotKeyword}               { return next(ROBOT_KEYWORD_TOKEN); }
    {KeywordArgument}            { return next(ROBOT_KEYWORD_ARG_TOKEN); }
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
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN); } return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ForceTags}         { return next(FORCE_TAGS_SETTING_KEYWORD_TOKEN);}
     {ResourceSetting}     { return next(RESOURCE_SETTING_TOKEN); }
     {TestSetupSetting}     { return next(TEST_SETUP_SETTING_TOKEN); }
     {TestTeardownSetting}  { return next(TEST_TEARDOWN_SETTING_TOKEN); }
     {SuiteSetupSetting}    { return next(SUITE_SETUP_SETTING_TOKEN); }
     {RobotKeyword}      { return next(ROBOT_KEYWORD_TOKEN); }
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
     {RobotKeyword}      { return next(ROBOT_KEYWORD_TOKEN); }
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
     {TagsMeta}          { return next(TAGS_SETTING_TOKEN); }
     {DocsMeta}          { previous_state = yystate(); yybegin(DOCS_SETTING); return next(DOCUMENTATION_SETTING_TOKEN); }
     {SetupMeta}         { return next(SETUP_SETTING_TOKEN); }
     {TeardownMeta}      { return next(TEARDOWN_SETTING_TOKEN); }
     {TimeoutMeta}       { return next(TIMEOUT_SETTING_TOKEN); }
     {TemplateMeta}      { return next(TEMPLATE_SETTING_TOKEN); }
     {EmptyCell}                  { return next(EMPTY_CELL_TOKEN); }
     {ForLoopStart}               { return next(FOR_LOOP_START_TOKEN); }
     {InRange}                    { return next(IN_RANGE_TOKEN); }
     {In}                         { return next(IN_TOKEN); }
     {DecIntegerLiteral}          { return next(INTEGER_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {ArrayAssignment}   { return ARRAY_ASSIGNMENT_TOKEN; }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN);} return next(ROBOT_KEYWORD_ARG_TOKEN); }
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
     {DocsMeta}          { previous_state = yystate(); yybegin(DOCS_SETTING); return next(DOCUMENTATION_SETTING_TOKEN); }
     {ArgumentsMeta}     { return next(ARGUMENTS_SETTING_TOKEN); }
     {SetupMeta}         { return next(SETUP_SETTING_TOKEN); }
     {TeardownMeta}      { return next(TEARDOWN_SETTING_TOKEN); }
     {TimeoutMeta}       { return next(TIMEOUT_SETTING_TOKEN); }
     {ReturnMeta}        { return next(RETURN_SETTING_TOKEN); }
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN);} return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {EmptyCell}                  { return next(EMPTY_CELL_TOKEN); }
     {ForLoopStart}               { return next(FOR_LOOP_START_TOKEN); }
     {InRange}                    { return next(IN_RANGE_TOKEN); }
     {In}                         { return next(IN_TOKEN); }
     {DecIntegerLiteral}          { return next(INTEGER_TOKEN); }
     {Assignment}        { return ASSIGNMENT_TOKEN; }
     {ArrayAssignment}   { return ARRAY_ASSIGNMENT_TOKEN; }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {RobotKeyword}      { if (startLine) { return next(ROBOT_KEYWORD_DEF_TOKEN); } return next(ROBOT_KEYWORD_TOKEN); }
     {KeywordArgument}   { if (startLine) { return next(BAD_SYNTAX_TOKEN); } return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {WhiteSpace}        { return next(WHITESPACE_TOKEN); }
}

<BAD_SYNTAX> {
    .+                     { return next(BAD_SYNTAX_TOKEN);}
}

[^]                   { return next(BAD_SYNTAX_TOKEN);}
