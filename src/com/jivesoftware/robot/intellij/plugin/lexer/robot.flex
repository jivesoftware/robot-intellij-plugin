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
SingleWhiteSpace = " "
WhiteSpace = [ \t]

/* comments */
Comment = "#" {InputCharacter}*

/* identifiers */
Variable = "${" {Identifier} "}"
Assignment = {Variable} "="

RobotKeyword = {RobotWord} {NextWord}*
RobotWord = [A-Z][a-zA-Z]*
NextWord = {SingleWhiteSpace} {RobotWord}
Identifier = [a-zA-Z_][a-zA-Z0-9_]*

KeywordArgumentWord = {KeywordArgumentChar}+
KeywordArgumentNextWord = {SingleWhiteSpace} {KeywordArgumentWord}
KeywordArgument = ({KeywordArgumentWord} {KeywordArgumentNextWord}*) | {Variable}

/* Meta documentation for robot test cases */
Meta = "[" {Identifier} "]"

/* Table headings */
TableHeading = "*"+ {WhiteSpace}* {Identifier} {WhiteSpace}* "*"*

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

/* floating point literals */
FloatLiteral = [0-9]+ \. [0-9]+

NumberLiteral = {DecIntegerLiteral} | {FloatLiteral}

%%

<YYINITIAL> {
    /* identifiers */
    {TableHeading}      { debug(RobotToken.TABLE_HEADING_TOKEN); return RobotToken.TABLE_HEADING_TOKEN; }
    {Meta}              { return RobotToken.META_INFO_TOKEN; }
    {Comment}           { debug(RobotToken.COMMENT_TOKEN); return RobotToken.COMMENT_TOKEN; }
    {Variable}          { debug(RobotToken.VARIABLE_TOKEN); return RobotToken.VARIABLE_TOKEN; }
    {RobotKeyword}      { debug(RobotToken.ROBOT_KEYWORD_TOKEN); return RobotToken.ROBOT_KEYWORD_TOKEN; }
    {NumberLiteral}     { debug(RobotToken.NUMBER_LITERAL_TOKEN); return RobotToken.NUMBER_LITERAL_TOKEN; }
    {KeywordArgument}   { debug(RobotToken.ROBOT_KEYWORD_ARG_TOKEN); return RobotToken.ROBOT_KEYWORD_ARG_TOKEN; }
    {ColumnSep}         { /* ignore */ }
    {SingleWhiteSpace}  { /* ignore */ }

    {Assignment}        { debug(RobotToken.ASSIGNMENT_TOKEN); return RobotToken.ASSIGNMENT_TOKEN; }
    {LineTerminator}    { /* ignore */ }

    <<EOF>>             { return null; }

}

/* error fallback */
[^]                              { throw new Error("Illegal text: <" + yytext() + ">"); }
