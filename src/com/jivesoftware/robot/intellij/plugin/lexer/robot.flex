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
RobotWord = [A-Z][a-zA-Z0-9]*

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

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

/* floating point literals */
FloatLiteral = [0-9]+ \. [0-9]+

NumberLiteral = {DecIntegerLiteral} | {FloatLiteral}

%state START_OF_LINE
%state TEST_CASES
%state TEST_CASES_START_OF_LINE

%%

<YYINITIAL> {
    /* identifiers */
    {LineTerminator}             { onTagsLine = onDocsLine = keywordToLeft = false; yybegin(START_OF_LINE); return RobotTypes.NEWLINE_TOKEN; }
    {TestCasesTableHeading}      { yybegin(TEST_CASES); return RobotTypes.TEST_CASES_TABLE_HEADING_TOKEN; }
    {TableHeading}      { return RobotTypes.TABLE_HEADING_TOKEN; }
    {TagsMeta}          { onTagsLine = true; return RobotTypes.META_INFO_TOKEN; }
    {DocsMeta}          { onDocsLine = true; return RobotTypes.META_INFO_TOKEN; }
    {Meta}              { return RobotTypes.META_INFO_TOKEN; }

    {Comment}           { return RobotTypes.COMMENT_TOKEN; }
    {Variable}          { return RobotTypes.VARIABLE_TOKEN; }
    {RobotKeyword}      { if (onTagsLine) { return RobotTypes.TAG_TOKEN; }
                          if (onDocsLine) { return RobotTypes.DOCUMENTATION_TOKEN;}
                          if (keywordToLeft) { return RobotTypes.ROBOT_KEYWORD_ARG_TOKEN; }
                          keywordToLeft = true; return RobotTypes.ROBOT_KEYWORD_TOKEN; }
    {NumberLiteral}     { return RobotTypes.NUMBER_LITERAL_TOKEN; }
    {KeywordArgument}   { if (onTagsLine) { return RobotTypes.TAG_TOKEN; } if (onDocsLine) { return RobotTypes.DOCUMENTATION_TOKEN;} return RobotTypes.ROBOT_KEYWORD_ARG_TOKEN; }
    {ColumnSep}         { return RobotTypes.COLUMN_SEP_TOKEN; }
    {SingleSpace}       { return RobotTypes.SINGLE_SPACE_TOKEN; }

    .                   { return RobotTypes.BAD_CHAR_TOKEN; }

    <<EOF>>             { return null; }
}

<START_OF_LINE> {
    {Assignment}        { yybegin(YYINITIAL); return RobotTypes.ASSIGNMENT_TOKEN; }
    {LineTerminator}    { return RobotTypes.NEWLINE_TOKEN; }
    .                   { yypushback(1); yybegin(YYINITIAL); }
    <<EOF>>             { yybegin(YYINITIAL); }
}

<TEST_CASES> {

     /* identifiers */
     {LineTerminator}    { yybegin(TEST_CASES_START_OF_LINE); keywordToLeft = onTagsLine = onDocsLine = false; return RobotTypes.NEWLINE_TOKEN; }
     {TableHeading}      { yybegin(YYINITIAL); return RobotTypes.TABLE_HEADING_TOKEN; }
     {TagsMeta}          { onTagsLine = true; return RobotTypes.META_INFO_TOKEN; }
     {DocsMeta}          { onDocsLine = true; return RobotTypes.META_INFO_TOKEN; }
     {Meta}              { return RobotTypes.META_INFO_TOKEN; }
     {Comment}           { return RobotTypes.COMMENT_TOKEN; }
     {Variable}          { return RobotTypes.VARIABLE_TOKEN; }
     {Assignment}        { return RobotTypes.ASSIGNMENT_TOKEN; }
     {RobotKeyword}      { if (keywordToLeft) { return RobotTypes.ROBOT_KEYWORD_ARG_TOKEN; } keywordToLeft = true; return RobotTypes.ROBOT_KEYWORD_TOKEN; }
     {NumberLiteral}     { return RobotTypes.NUMBER_LITERAL_TOKEN; }
     {KeywordArgument}   { return RobotTypes.ROBOT_KEYWORD_ARG_TOKEN; }
     {ColumnSep}         { return RobotTypes.COLUMN_SEP_TOKEN; }
     {SingleSpace}       { return RobotTypes.SINGLE_SPACE_TOKEN; }

     .                   { return RobotTypes.BAD_CHAR_TOKEN; }

     <<EOF>>             { yybegin(YYINITIAL); }
}

<TEST_CASES_START_OF_LINE> {
    {TestCaseHeader}    { yybegin(TEST_CASES); return RobotTypes.TEST_CASE_HEADER_TOKEN; }
    {LineTerminator}    { return RobotTypes.NEWLINE_TOKEN; }
    .                   { yypushback(1); yybegin(TEST_CASES); }
    <<EOF>>             { yybegin(YYINITIAL); }
}

/* error fallback */
[^]                              { throw new Error("Illegal text: <" + yytext() + ">"); }
