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

import static com.intellij.psi.xml.XmlTokenType.*;
import static com.jivesoftware.robot.intellij.plugin.lexer.RobotToken.*;

import java.util.regex.Matcher;
import com.intellij.psi.tree.IElementType;

@SuppressWarnings({ "ALL" })

%%

%class RobotScanner
%implements com.intellij.lexer.FlexLexer
%function advance

%unicode
%type IElementType

%line
%column

%{
  StringBuffer string = new StringBuffer();

  private IElementType symbol(RobotToken.TYPE type, String text) {
    return new RobotToken(type, text, yyline, yycolumn);
  }
  private IElementType symbol(RobotToken.TYPE type) {
    return symbol(type, null, yyline, yycolumn);
  }
%}


/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f][ \t\f]+

/* comments */
Comment = "#" {InputCharacter}*

/* identifiers */
Variable = "${" {Identifier} "}"
VariableAssignment = "${" {Identifier} "}="

RobotKeyword = {Identifier} {NextIdentifier}*
Identifier = [a-zA-Z_][a-zA-Z0-9_]*
NextIdentifier = " " {Identifier}

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*

/* floating point literals */
FloatLiteral = [0-9]+ \. [0-9]+ {Exponent}?

%%

<YYINITIAL> "*** Settings ***"              { return symbol(TYPE.SETTINGS_TABLE); }
<YYINITIAL> "*** Test Cases ***"            { return symbol(TYPE.TEST_CASES_TABLE); }

<YYINITIAL> {
    /* identifiers */
    {Comment}           { return symbol(TYPE.COMMENT, yytext()); }
    {RobotKeyword}      { return symbol(TYPE.ROBOT_KEYWORD, yytext()); }
    {WhiteSpace}        { /* ignore */ }

    <<EOF>>                        { return null; }

}
