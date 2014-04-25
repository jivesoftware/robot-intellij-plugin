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
%eof{ return;
%eof}

%line
%column
%char

%{
  int yyline, yycolumn, yychar;
  private boolean onTagsLine = false;
  private boolean onDocsLine = false;
  private boolean onTimeoutLine = false;
  private boolean keywordToLeft = false;
  private boolean startLine = true;
  private boolean forceTags = false;

  private IElementType next(IElementType toReturn) {
    startLine = false;
    if (toReturn == BAD_CHAR_TOKEN) {
        System.out.println(String.format("Bad char %s at line %d col %d", yytext(), yyline, yycolumn));
    }
    return toReturn;
  }
  private IElementType newLine() {
    startLine = true;
    keywordToLeft = onTagsLine = forceTags = onDocsLine = onTimeoutLine = false;
    return RobotTypes.NEWLINE_TOKEN;
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

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

/* floating point literals */
FloatLiteral = [0-9]+ \. [0-9]+

/* comments */
Comment = "#" {InputCharacter}*

/* identifiers */
Variable = "${" {Identifier} "}"
Assignment = {Variable} "="

RobotKeyword = {RobotWord} ({SingleSpace} {RobotWord})*
RobotWord = [a-zA-Z][a-zA-Z0-9]*

Identifier = [a-zA-Z_][a-zA-Z0-9_]*

TestCaseHeaderWord = {TestCaseHeaderChar}+
TestCaseHeader = {TestCaseHeaderWord} ({SingleSpace} {TestCaseHeaderWord})*

KeywordArgumentWord = {KeywordArgumentChar}+
KeywordArgument = ({KeywordArgumentWord} ({SingleSpace} {KeywordArgumentWord})*) | {Variable}
ForceTags = [Ff] "orce" " "? [Tt] "ags"

/* Settings for robot test cases */
Meta = "[" {Identifier} "]"
TagsMeta = "[" {WhiteSpace}* [Tt] "ags" {WhiteSpace}* "]"
DocsMeta = "[" {WhiteSpace}* [Dd] "ocumentation" {WhiteSpace}* "]"
SetupMeta = ("[" {WhiteSpace}* [Ss] "etup" {WhiteSpace}* "]") | ("[" {WhiteSpace}* [Pp] "recondition" {WhiteSpace}* "]")
TeardownMeta = ("[" {WhiteSpace}* [Tt] "eardown" {WhiteSpace}* "]") | ("[" {WhiteSpace}* [Pp] "ostcondition" {WhiteSpace}* "]")
TimeoutMeta = "[" {WhiteSpace}* [Tt] "imeout" {WhiteSpace}* "]"

HourTime =  {DecIntegerLiteral} {SingleSpace}? [Hh] "our" ("s")?
MinuteTime= {DecIntegerLiteral} {SingleSpace}? ([Mm] "inute" | [Mm] "in") ("s")?
SecondTime = {DecIntegerLiteral} {SingleSpace}? ([Ss] "econd" | [Ss] "ec") ("s")?

TimeoutValue = {HourTime} {SingleSpace} {MinuteTime} {SingleSpace} {SecondTime} | {HourTime} | {HourTime} {SingleSpace} {MinuteTime} |
{HourTime} {SingleSpace} {SecondTime} | {MinuteTime} {SingleSpace} {SecondTime} | {MinuteTime} | {SecondTime}

/* Settings for Robot Keywords table */
ArgumentsMeta = "[" {WhiteSpace}* [Aa] "rguments" {WhiteSpace}* "]"
ReturnMeta = "[" {WhiteSpace}* [Rr] "eturn" {WhiteSpace}* "]"

/* Table headings */
TableHeading = "*"+ {WhiteSpace}* {Identifier} ({SingleSpace} {Identifier})* {WhiteSpace}* "*"*
SettingsTableHeading  = "*"+ {WhiteSpace}* [Ss] "ettings" {WhiteSpace}* "*"*
VariablesTableHeading = "*"+ {WhiteSpace}* [Vv] "ariables" {WhiteSpace}* "*"*
TestCasesTableHeading = "*"+ {WhiteSpace}* [Tt] "est" " "? [Cc] "ases" {WhiteSpace}* "*"*
KeywordsTableHeading = "*"+ {WhiteSpace}* [Kk] "eywords" {WhiteSpace}* "*"*



NumberLiteral = {DecIntegerLiteral} | {FloatLiteral}

%state TEST_CASES
%state KEYWORDS

%%

<YYINITIAL> {
    /* identifiers */
    {LineTerminator}             { return newLine(); }
    {SettingsTableHeading}       { return next(SETTINGS_TABLE_HEADING_TOKEN); }
    {VariablesTableHeading}      { return next(VARIABLES_TABLE_HEADING_TOKEN); }
    {TestCasesTableHeading}      { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
    {KeywordsTableHeading}       { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
    {TableHeading}      { return next(TABLE_HEADING_TOKEN); }
    {DocsMeta}          { onDocsLine = true; return next(DOCUMENTATION_SETTING_TOKEN); }
    {SetupMeta}         { return next(SETUP_SETTING_TOKEN); }
    {TeardownMeta}      { return next(TEARDOWN_SETTING_TOKEN); }
    {TimeoutMeta}       { onTimeoutLine = true; return next(TIMEOUT_SETTING_TOKEN); }
    {ReturnMeta}        { return next(RETURN_SETTING_TOKEN); }
    {TimeoutValue}      { if (onTimeoutLine) { return next(TIMEOUT_VALUE_TOKEN);} return next(ROBOT_KEYWORD_ARG_TOKEN); }
    {ArgumentsMeta}     { return next(ARGUMENTS_SETTING_TOKEN); }

    {Comment}           { return next(COMMENT_TOKEN); }
    {Assignment}        { return next(ASSIGNMENT_TOKEN); }
    {Variable}          { return next(VARIABLE_TOKEN); }
    {ForceTags}         { forceTags = true; keywordToLeft = true; return next(ROBOT_KEYWORD_TOKEN);}
    {RobotKeyword}      { if (onTagsLine || forceTags) { return next(TAG_TOKEN); }
                          if (onDocsLine) { return next(DOCUMENTATION_TOKEN);}
                          if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                          keywordToLeft = true; return next(ROBOT_KEYWORD_TOKEN); }
    {NumberLiteral}     { return next(NUMBER_LITERAL_TOKEN); }
    {KeywordArgument}   { if (onTagsLine || forceTags) { return next(TAG_TOKEN); }
                          if (onDocsLine) { return next(DOCUMENTATION_TOKEN);}
                            return next(ROBOT_KEYWORD_ARG_TOKEN); }
    {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
    {SingleSpace}       { return next(SINGLE_SPACE_TOKEN); }
    .                   { return next(BAD_CHAR_TOKEN);}

}

<SETTINGS> {
 /* identifiers */
     {LineTerminator}    {  return newLine(); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TableHeading}      { yybegin(YYINITIAL); return next(TABLE_HEADING_TOKEN); }
     {TagsMeta}          { onTagsLine = true; return next(TAGS_SETTING_TOKEN); }
     {DocsMeta}          { onDocsLine = true; return next(DOCUMENTATION_SETTING_TOKEN); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {RobotKeyword}      { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); }
                           if (onTagsLine) { return next(TAG_TOKEN); }
                           if (onDocsLine) { return next(DOCUMENTATION_TOKEN); }
                           if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                           keywordToLeft= true; return next(ROBOT_KEYWORD_TOKEN); }
     {TestCaseHeader}    { if (startLine) { return next(TEST_CASE_HEADER_TOKEN);  } return next(ROBOT_KEYWORD_ARG_TOKEN); }

     {NumberLiteral}     { return next(NUMBER_LITERAL_TOKEN); }
     {KeywordArgument}   { return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {SingleSpace}       { return next(SINGLE_SPACE_TOKEN); }

     .                   { return next(BAD_CHAR_TOKEN);}

}


<TEST_CASES> {

     /* identifiers */
     {LineTerminator}    {  return newLine(); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TableHeading}      { yybegin(YYINITIAL); return next(TABLE_HEADING_TOKEN); }
     {TagsMeta}          { onTagsLine = true; return next(TAGS_SETTING_TOKEN); }
     {DocsMeta}          { onDocsLine = true; return next(DOCUMENTATION_SETTING_TOKEN); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {Assignment}        { return next(ASSIGNMENT_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {RobotKeyword}      { if (startLine) { return next(TEST_CASE_HEADER_TOKEN); }
                           if (onTagsLine) { return next(TAG_TOKEN); }
                           if (onDocsLine) { return next(DOCUMENTATION_TOKEN); }
                           if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                           keywordToLeft= true; return next(ROBOT_KEYWORD_TOKEN); }
     {TestCaseHeader}    { if (startLine) { return next(TEST_CASE_HEADER_TOKEN);  } return next(ROBOT_KEYWORD_ARG_TOKEN); }

     {NumberLiteral}     { return next(NUMBER_LITERAL_TOKEN); }
     {KeywordArgument}   { return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {SingleSpace}       { return next(SINGLE_SPACE_TOKEN); }

     .                   { return next(BAD_CHAR_TOKEN);}

}

<KEYWORDS> {

     /* identifiers */
     {LineTerminator}    { return newLine(); }
     {TableHeading}      { yybegin(YYINITIAL); return next(TABLE_HEADING_TOKEN); }
     {DocsMeta}          { onDocsLine = true; return next(DOCUMENTATION_SETTING_TOKEN); }
     {ArgumentsMeta}     { return next(ARGUMENTS_SETTING_TOKEN); }
     {TeardownMeta}      { return next(TEARDOWN_SETTING_TOKEN); }
     {TimeoutMeta}       { onTimeoutLine = true; return next(TIMEOUT_SETTING_TOKEN); }
     {ReturnMeta}        { return next(RETURN_SETTING_TOKEN); }
     {Comment}           { return next(COMMENT_TOKEN); }
     {Variable}          { return next(VARIABLE_TOKEN); }
     {Assignment}        { return ASSIGNMENT_TOKEN; }
     {RobotKeyword}      { if (startLine) { return next(ROBOT_KEYWORD_DEF_TOKEN); }
                           if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                           keywordToLeft= true; return next(ROBOT_KEYWORD_TOKEN);
                         }
     {NumberLiteral}     { return next(NUMBER_LITERAL_TOKEN); }
     {KeywordArgument}   { return next(ROBOT_KEYWORD_ARG_TOKEN); }
     {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
     {SingleSpace}       { return next(SINGLE_SPACE_TOKEN); }

     .                   { return next(BAD_CHAR_TOKEN);}

}

.                   { return next(BAD_CHAR_TOKEN);}
