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
%debug
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
  private boolean onTagsLine = false;
  private boolean onTimeoutLine = false;
  private boolean keywordToLeft = false;
  private boolean startLine = true;
  private boolean forceTags = false;
  private int previous_state = YYINITIAL;

  private IElementType next(IElementType toReturn) {
    System.out.println("zzLexicalState == " + zzLexicalState);
    startLine = false;
    if (toReturn == BAD_SYNTAX_TOKEN) {
        System.out.println(String.format("Bad syntax \"%s\" at line %d col %d", yytext(), yyline, yycolumn));
    }
    if (toReturn == ROBOT_KEYWORD_TOKEN) {
        keywordToLeft = true;
    }
    if (toReturn == TAGS_SETTING_TOKEN) {
        onTagsLine = true;
    }
    if (toReturn == TIMEOUT_SETTING_TOKEN) {
        onTimeoutLine = true;
    }
    if (toReturn == FORCE_TAGS_SETTING_KEYWORD_TOKEN) {
        forceTags = true;
    }
    return toReturn;
  }
  private IElementType newLine() {
    startLine = true;
    keywordToLeft = onTagsLine = forceTags = onTimeoutLine = false;
    return NEWLINE_TOKEN;
  }


%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

/* Keyword arguments and test case headers use the same chars.*/
KeywordArgumentChar = [^\r\n\t\# ]
TestCaseHeaderChar = [^\r\n\t\# ]

ColumnSep = "\t"+ | [ \t] [ \t]+
SingleSpace = " "
WhiteSpace = [ \t]
NonWhiteSpace = [^ \t\r\n]

EndOfLine = {WhiteSpace}* {LineTerminator}

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

/* comments */
Comment = "#" {InputCharacter}*

/* identifiers */
Variable = "${" {Identifier} "}"
ArrayVariable = "@{" {Identifier} "}"
Assignment = {Variable} {WhiteSpace}* "="
ArrayAssignment = {ArrayVariable} {WhiteSpace}* "="

RobotKeyword = {RobotWord} ({SingleSpace} {RobotWord})*
RobotWord = [a-zA-Z][a-zA-Z0-9]*

Identifier = [a-zA-Z_][a-zA-Z0-9_]*

TestCaseHeaderWord = {TestCaseHeaderChar}+
TestCaseHeader = {TestCaseHeaderWord} ({SingleSpace} {TestCaseHeaderWord})*

KeywordArgumentWord = {KeywordArgumentChar}+
KeywordArgument = ({KeywordArgumentWord} ({SingleSpace} {KeywordArgumentWord})*) | {Variable}
ForceTags = [Ff] "orce" " "? [Tt] "ags"

/* Settings for robot test cases */
TagsMeta = "[" {WhiteSpace}* [Tt] "ags" {WhiteSpace}* "]"
DocsMeta = "[" {WhiteSpace}* [Dd] "ocumentation" {WhiteSpace}* "]"
DocsArgument = {NonWhiteSpace} {InputCharacter}*

SetupMeta = ("[" {WhiteSpace}* [Ss] "etup" {WhiteSpace}* "]") | ("[" {WhiteSpace}* [Pp] "recondition" {WhiteSpace}* "]")
TeardownMeta = ("[" {WhiteSpace}* [Tt] "eardown" {WhiteSpace}* "]") | ("[" {WhiteSpace}* [Pp] "ostcondition" {WhiteSpace}* "]")
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
SettingsTableHeading  = "*"+ {WhiteSpace}* (([Ss] "etting" "s"?) | "Metadata") {WhiteSpace}* ("*")*
VariablesTableHeading = "*"+ {WhiteSpace}* ([Vv] "ariable" "s"?) {WhiteSpace}* "*"*
TestCasesTableHeading = "*"+ {WhiteSpace}* [Tt] "est" " "? [Cc] "ase" "s"? {WhiteSpace}* "*"*
KeywordsTableHeading = "*"+ {WhiteSpace}* ([Uu] "ser" " "?)? [Kk] "eyword" "s"? {WhiteSpace}* "*"*

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
}

<SETTINGS> {
 /* identifiers */
     {EndOfLine}         { return newLine(); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {VariablesTableHeading}     { yybegin(VARIABLES); return next(VARIABLES_TABLE_HEADING_TOKEN); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TestCasesTableHeading}     { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
     {SettingsTableHeading}      { yybegin(BAD_SYNTAX); return next(BAD_SYNTAX_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN); } return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ForceTags}         { return next(FORCE_TAGS_SETTING_KEYWORD_TOKEN);}
     {RobotKeyword}      { if (forceTags) {return next(TAG_TOKEN); }
                           if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                           return next(ROBOT_KEYWORD_TOKEN);
                         }
     {KeywordArgument}   { if (forceTags) {return next(TAG_TOKEN);}
                           return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {WhiteSpace}        { return next(WHITESPACE_TOKEN); }
}

<VARIABLES> {
 /* identifiers */
     {EndOfLine}         { return newLine(); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {VariablesTableHeading}     { yybegin(BAD_SYNTAX); return next(BAD_SYNTAX_TOKEN); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TestCasesTableHeading}     { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
     {SettingsTableHeading}      { yybegin(SETTINGS); return next(SETTINGS_TABLE_HEADING_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {ArrayAssignment}   { return next(ARRAY_ASSIGNMENT_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {RobotKeyword}      { if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                           return next(ROBOT_KEYWORD_TOKEN);
                         }
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
     {TestCasesTableHeading}      { yybegin(BAD_SYNTAX); return next(BAD_SYNTAX_TOKEN); }
     {TagsMeta}          { return next(TAGS_SETTING_TOKEN); }
     {DocsMeta}          { previous_state = yystate(); yybegin(DOCS_SETTING); return next(DOCUMENTATION_SETTING_TOKEN); }
     {SetupMeta}         { return next(SETUP_SETTING_TOKEN); }
     {TeardownMeta}      { return next(TEARDOWN_SETTING_TOKEN); }
     {TimeoutMeta}       { return next(TIMEOUT_SETTING_TOKEN); }
     {TemplateMeta}      { return next(TEMPLATE_SETTING_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {ArrayAssignment}   { return ARRAY_ASSIGNMENT_TOKEN; }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN);} return next(ROBOT_KEYWORD_ARG_TOKEN); }

     {RobotKeyword}      { if (startLine)  { return next(TEST_CASE_HEADER_TOKEN); }
                           if (onTagsLine) { return next(TAG_TOKEN); }
                           if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                           keywordToLeft= true; return next(ROBOT_KEYWORD_TOKEN); }
     {TestCaseHeader}    { if (startLine) { return next(TEST_CASE_HEADER_TOKEN);  } return next(ROBOT_KEYWORD_ARG_TOKEN); }

     {KeywordArgument}   { return next(ROBOT_KEYWORD_ARG_TOKEN); }
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
     {DocsMeta}          { return next(DOCUMENTATION_SETTING_TOKEN); }
     {ArgumentsMeta}     { return next(ARGUMENTS_SETTING_TOKEN); }
     {SetupMeta}         { return next(SETUP_SETTING_TOKEN); }
     {TeardownMeta}      { return next(TEARDOWN_SETTING_TOKEN); }
     {TimeoutMeta}       { return next(TIMEOUT_SETTING_TOKEN); }
     {ReturnMeta}        { return next(RETURN_SETTING_TOKEN); }
     {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN);} return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {Assignment}        { return ASSIGNMENT_TOKEN; }
     {ArrayAssignment}   { return ARRAY_ASSIGNMENT_TOKEN; }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {ArrayVariable}     { return next(ARRAY_VARIABLE_TOKEN); }
     {RobotKeyword}      { if (startLine) { return next(ROBOT_KEYWORD_DEF_TOKEN); }
                           if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                           keywordToLeft= true; return next(ROBOT_KEYWORD_TOKEN);
                         }
     {KeywordArgument}   { return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {WhiteSpace}        { return next(WHITESPACE_TOKEN); }
}

<BAD_SYNTAX> {
    .+                     { return next(BAD_SYNTAX_TOKEN);}
}

[^]                   { return next(BAD_SYNTAX_TOKEN);}
