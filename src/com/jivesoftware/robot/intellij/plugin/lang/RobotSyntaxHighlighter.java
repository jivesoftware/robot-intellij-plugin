package com.jivesoftware.robot.intellij.plugin.lang;

/*
 * Copyright 2010 - 2013 Ed Venaglia
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import com.intellij.ide.highlighter.HtmlFileHighlighter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotLexer;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotToken;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * IntelliJ syntax highlighter implementation for soy files.
 */
public class RobotSyntaxHighlighter extends SyntaxHighlighterBase {

  private static Map<IElementType, TextAttributesKey> keys1;
  private static Map<IElementType, TextAttributesKey> keys2;
  public static final HtmlFileHighlighter HTML_FILE_HIGHLIGHTER = new HtmlFileHighlighter();

  @NotNull
  public Lexer getHighlightingLexer() {
    return new RobotLexer();
  }

  static final TextAttributesKey ROBOT_TABLE_HEADER = TextAttributesKey.createTextAttributesKey("ROBOT.SETTINGS_TABLE",
                                                                                               DefaultLanguageHighlighterColors.KEYWORD);
  static final TextAttributesKey ROBOT_KEYWORD = TextAttributesKey.createTextAttributesKey("ROBOT.KEYWORD",
                                                                                     DefaultLanguageHighlighterColors.INSTANCE_METHOD);
  static final TextAttributesKey ROBOT_VARIABLE = TextAttributesKey.createTextAttributesKey("ROBOT.VARIABLE",
                                                                                         DefaultLanguageHighlighterColors.LOCAL_VARIABLE);


  static {
    keys1 = new HashMap<IElementType, TextAttributesKey>();

    fillMap(keys1, TokenSet.create(RobotToken.TABLE_HEADING_TOKEN), ROBOT_TABLE_HEADER);
    fillMap(keys1, TokenSet.create(RobotToken.ROBOT_KEYWORD_TOKEN), ROBOT_KEYWORD);
    fillMap(keys1, TokenSet.create(RobotToken.VARIABLE_TOKEN), ROBOT_VARIABLE);

    keys1.put(RobotToken.TABLE_HEADING_TOKEN, ROBOT_TABLE_HEADER);
    keys1.put(RobotToken.ROBOT_KEYWORD_TOKEN, ROBOT_KEYWORD);
    keys1.put(RobotToken.VARIABLE_TOKEN, ROBOT_VARIABLE);

  }

  @NotNull
  public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
    if (tokenType instanceof RobotToken) {
      return pack(keys1.get(tokenType));
    } else {
      return HTML_FILE_HIGHLIGHTER.getTokenHighlights(tokenType);
    }
  }
}

