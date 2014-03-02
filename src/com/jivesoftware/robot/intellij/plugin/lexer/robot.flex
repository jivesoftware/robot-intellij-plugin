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

import static com.jivesoftware.robot.intellij.plugin.lexer.RobotToken.*;

import com.intellij.psi.tree.IElementType;

//@SuppressWarnings({ "ALL" })

%%

%class RobotScanner
%implements com.intellij.lexer.FlexLexer
%function advance

%unicode
%type IElementType

%line
%column
%char
%debug

%{
  public RobotScanner() {
    this((java.io.Reader)null);
  }

  int yyline, yycolumn, yychar;

  private static final void debug(RobotToken type) {
    System.out.println("Found token " + type.toString());
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
RobotWord = [A-Z][a-zA-Z0-9]*

Identifier = [a-zA-Z_][a-zA-Z0-9_]*

TestCaseHeader = {Identifier} ({SingleSpace} {Identifier})*

KeywordArgumentWord = {KeywordArgumentChar}+
KeywordArgument = ({KeywordArgumentWord} ({SingleSpace} {KeywordArgumentWord})*) | {Variable}

/* Meta documentation for robot test cases */
Meta = "[" {Identifier} "]"

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
    {LineTerminator}             { yybegin(START_OF_LINE); return RobotToken.NEWLINE_TOKEN; }
    {TestCasesTableHeading}      { yybegin(TEST_CASES); return RobotToken.TEST_CASES_TABLE_HEADING_TOKEN; }
    {TableHeading}      { return RobotToken.TABLE_HEADING_TOKEN; }
    {Meta}              { return RobotToken.META_INFO_TOKEN; }

    {Comment}           { return RobotToken.COMMENT_TOKEN; }
    {Variable}          { return RobotToken.VARIABLE_TOKEN; }
    {RobotKeyword}      { return RobotToken.ROBOT_KEYWORD_TOKEN; }
    {NumberLiteral}     { return RobotToken.NUMBER_LITERAL_TOKEN; }
    {KeywordArgument}   { return RobotToken.ROBOT_KEYWORD_ARG_TOKEN; }
    {ColumnSep}         { return RobotToken.COLUMN_SEP_TOKEN; }
    {SingleSpace}       { return RobotToken.SINGLE_SPACE_TOKEN; }

    .                   { return RobotToken.BAD_CHAR_TOKEN; }

    <<EOF>>             { return null; }
}

<START_OF_LINE> {
    {Assignment}        { yybegin(YYINITIAL); return RobotToken.ASSIGNMENT_TOKEN; }
    {LineTerminator}    { return RobotToken.NEWLINE_TOKEN; }
    .                   {  System.out.println("Matched . as: '" + yytext() + "'"); yypushback(1); yybegin(YYINITIAL); }
    <<EOF>>             {  yybegin(YYINITIAL); }
}

<TEST_CASES> {

     /* identifiers */
     {LineTerminator}    { yybegin(START_OF_LINE); return RobotToken.NEWLINE_TOKEN; }
     {TableHeading}      { yybegin(YYINITIAL); return RobotToken.TABLE_HEADING_TOKEN; }
     {Meta}              { return RobotToken.META_INFO_TOKEN; }
     {Comment}           { return RobotToken.COMMENT_TOKEN; }
     {Variable}          { return RobotToken.VARIABLE_TOKEN; }
     {Assignment}        { return RobotToken.ASSIGNMENT_TOKEN; }
     {RobotKeyword}      { return RobotToken.ROBOT_KEYWORD_TOKEN; }
     {NumberLiteral}     { return RobotToken.NUMBER_LITERAL_TOKEN; }
     {KeywordArgument}   { return RobotToken.ROBOT_KEYWORD_ARG_TOKEN; }
     {ColumnSep}         { return RobotToken.COLUMN_SEP_TOKEN; }
     {SingleSpace}       { return RobotToken.SINGLE_SPACE_TOKEN; }

     .                   { return RobotToken.BAD_CHAR_TOKEN; }

     <<EOF>>             { yybegin(YYINITIAL); }
}

<TEST_CASES_START_OF_LINE> {
    {TestCaseHeader}    { yybegin(TEST_CASES); return RobotToken.TEST_CASE_HEADER_TOKEN; }
    {LineTerminator}    { return RobotToken.NEWLINE_TOKEN; }
    .                   { yypushback(1); yybegin(TEST_CASES); }
    <<EOF>>             { yybegin(YYINITIAL); }
}

/* error fallback */
[^]                              { throw new Error("Illegal text: <" + yytext() + ">"); }
