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
  public RobotScanner() {
    this((java.io.Reader)null);
  }

  StringBuffer string = new StringBuffer();

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd(){
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end,int initialState){
      zzBuffer = buffer == null ? null : buffer.toString().toCharArray();
      zzCurrentPos = zzMarkedPos = zzStartRead = start;
      zzAtEOF  = false;
      zzAtBOL = true;
      zzEndRead = end;
      yybegin(initialState);
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

<YYINITIAL> "*** Settings ***"              { return RobotToken.create(TYPE.SETTINGS_TABLE); }
<YYINITIAL> "*** Variables ***"             { return RobotToken.create(TYPE.VARIABLES_TABLE); }
<YYINITIAL> "*** Test Cases ***"            { return RobotToken.create(TYPE.TEST_CASES_TABLE); }

<YYINITIAL> {
    /* identifiers */
    {Comment}           { return RobotToken.create(TYPE.COMMENT); }
    {RobotKeyword}      { return RobotToken.create(TYPE.ROBOT_KEYWORD); }
    {WhiteSpace}        { /* ignore */ }

    <<EOF>>                        { return null; }

}
