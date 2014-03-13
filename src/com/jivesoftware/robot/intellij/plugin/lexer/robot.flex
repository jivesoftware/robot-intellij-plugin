/*
   Copyright 2010 - 2013 Ed Venaglia

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
%debug

%{
  int yyline, yycolumn, yychar;
  private boolean onTagsLine = false;
  private boolean onDocsLine = false;
  private boolean keywordToLeft = false;
  private boolean startLine = true;

  private IElementType next(IElementType toReturn) {
    startLine = false;
    return toReturn;
  }
  private IElementType newLine() {
    startLine = true;
    keywordToLeft = onTagsLine = onDocsLine = false;
    return RobotTypes.NEWLINE_TOKEN;
  }


%}


/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
KeywordArgumentChar = [^\r\n\t\$ ]

ColumnSep = "\t"+ | [ \t] [ \t]+
SingleSpace = " "
WhiteSpace = [ \t]

/* comments */
Comment = "#" {InputCharacter}*

/* identifiers */
Variable = "${" {Identifier} "}"
Assignment = {Variable} "="

RobotKeyword = {RobotWord} ({SingleSpace} {RobotWord})*
RobotWord = [a-zA-Z][a-zA-Z0-9]*

Identifier = [a-zA-Z_][a-zA-Z0-9_]*

TestCaseHeader = {Identifier} ({SingleSpace} {Identifier})*

KeywordArgumentWord = {KeywordArgumentChar}+
KeywordArgument = ({KeywordArgumentWord} ({SingleSpace} {KeywordArgumentWord})*) | {Variable}

/* Meta documentation for robot test cases */
Meta = "[" {Identifier} "]"
TagsMeta = "[" [Tt] "ags]"
DocsMeta = "[" [Dd] "ocumentation]"

/* Table headings */
TableHeading = "*"+ {WhiteSpace}* {Identifier} ({SingleSpace} {Identifier})* {WhiteSpace}* "*"*
SettingsTableHeading  = "*"+ {WhiteSpace}* [Ss] "ettings" {WhiteSpace}* "*"*
TestCasesTableHeading = "*"+ {WhiteSpace}* [Tt] "est" " "? [Cc] "ases" {WhiteSpace}* "*"*
KeywordsTableHeading = "*"+ {WhiteSpace}* [Kk] "eywords" {WhiteSpace}* "*"*

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

/* floating point literals */
FloatLiteral = [0-9]+ \. [0-9]+

NumberLiteral = {DecIntegerLiteral} | {FloatLiteral}

%state TEST_CASES
%state KEYWORDS

%%

<YYINITIAL> {
    /* identifiers */
    {LineTerminator}             { return newLine(); }
    {TestCasesTableHeading}      { yybegin(TEST_CASES); return next(TEST_CASES_TABLE_HEADING_TOKEN); }
    {KeywordsTableHeading}       { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
    {TableHeading}      { return next(TABLE_HEADING_TOKEN); }
    {TagsMeta}          { onTagsLine = true; return next(META_INFO_TOKEN); }
    {DocsMeta}          { onDocsLine = true; return next(META_INFO_TOKEN); }
    {Meta}              { return next(META_INFO_TOKEN); }

    {Comment}           { return next(COMMENT_TOKEN); }
    {Assignment}        { return next(ASSIGNMENT_TOKEN); }
    {Variable}          { return next(VARIABLE_TOKEN); }
    {RobotKeyword}      { if (onTagsLine) { return next(TAG_TOKEN); }
                          if (onDocsLine) { return next(DOCUMENTATION_TOKEN);}
                          if (keywordToLeft) { return next(ROBOT_KEYWORD_ARG_TOKEN); }
                          keywordToLeft = true; return next(ROBOT_KEYWORD_TOKEN); }
    {NumberLiteral}     { return next(NUMBER_LITERAL_TOKEN); }
    {KeywordArgument}   { if (onTagsLine) { return next(TAG_TOKEN); }
                          if (onDocsLine) { return next(DOCUMENTATION_TOKEN);}
                            return next(ROBOT_KEYWORD_ARG_TOKEN); }
    {ColumnSep}         { return next(COLUMN_SEP_TOKEN); }
    {SingleSpace}       { return next(SINGLE_SPACE_TOKEN); }

    .                   { return next(BAD_CHAR_TOKEN); }

    <<EOF>>             { return null; }
}


<TEST_CASES> {

     /* identifiers */
     {LineTerminator}    {  return newLine(); }
     {KeywordsTableHeading}      { yybegin(KEYWORDS); return next(KEYWORDS_TABLE_HEADING_TOKEN); }
     {TableHeading}      { yybegin(YYINITIAL); return next(TABLE_HEADING_TOKEN); }
     {TagsMeta}          { onTagsLine = true; return next(META_INFO_TOKEN); }
     {DocsMeta}          { onDocsLine = true; return next(META_INFO_TOKEN); }
     {Meta}              { return next(META_INFO_TOKEN); }
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

     .                   { return next(BAD_CHAR_TOKEN); }

     <<EOF>>             { yybegin(YYINITIAL); }
}

<KEYWORDS> {

     /* identifiers */
     {LineTerminator}    { return newLine(); }
     {TableHeading}      { yybegin(YYINITIAL); return next(TABLE_HEADING_TOKEN); }
     {DocsMeta}          { onDocsLine = true; return next(META_INFO_TOKEN); }
     {Meta}              { return next(META_INFO_TOKEN); }
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

     .                   { return next(BAD_CHAR_TOKEN); }

     <<EOF>>             { yybegin(YYINITIAL); }
}

/* error fallback */
[^]                              { throw new Error("Illegal text: <" + yytext() + ">"); }
