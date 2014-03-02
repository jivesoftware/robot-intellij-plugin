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

  static final TextAttributesKey ROBOT_TABLE_HEADER_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.SETTINGS_TABLE",
                                                                                               DefaultLanguageHighlighterColors.CONSTANT);
  static final TextAttributesKey ROBOT_TEST_CASE_HEADER_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.TEST_CASE_HEADER",
                                                                                                        DefaultLanguageHighlighterColors.INSTANCE_METHOD);
  static final TextAttributesKey ROBOT_KEYWORD_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.KEYWORD",
                                                                                     DefaultLanguageHighlighterColors.KEYWORD);
  static final TextAttributesKey ROBOT_VARIABLE_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.VARIABLE",
                                                                                         DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
  static final TextAttributesKey ROBOT_COMMENT_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.COMMENT",
                                                                                           DefaultLanguageHighlighterColors.LINE_COMMENT);
  static final TextAttributesKey ROBOT_NUMBER_LITERAL_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.NUMBER",
                                                                                           DefaultLanguageHighlighterColors.NUMBER);
  static final TextAttributesKey ROBOT_KEYWORD_ARG_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.KEYWORD_ARG",
                                                                                                      DefaultLanguageHighlighterColors.STRING);
  static final TextAttributesKey ROBOT_META_INFO_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.META_INFO",
                                                                                                   DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
  static final TextAttributesKey ROBOT_COL_SEP_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.COLUMN_SEP",
                                                                                               DefaultLanguageHighlighterColors.COMMA);
  static final TextAttributesKey ROBOT_BAD_CHAR_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.BAD",
                                                                                                DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);


  static {
    keys1 = new HashMap<IElementType, TextAttributesKey>();

    keys1.put(RobotToken.TABLE_HEADING_TOKEN, ROBOT_TABLE_HEADER_KEY);
    keys1.put(RobotToken.TEST_CASE_HEADER_TOKEN, ROBOT_TEST_CASE_HEADER_KEY);
    keys1.put(RobotToken.ROBOT_KEYWORD_TOKEN, ROBOT_KEYWORD_KEY);
    keys1.put(RobotToken.VARIABLE_TOKEN, ROBOT_VARIABLE_KEY);
    keys1.put(RobotToken.ASSIGNMENT_TOKEN, ROBOT_VARIABLE_KEY);
    keys1.put(RobotToken.COMMENT_TOKEN, ROBOT_COMMENT_KEY);
    keys1.put(RobotToken.NUMBER_LITERAL_TOKEN, ROBOT_NUMBER_LITERAL_KEY);
    keys1.put(RobotToken.ROBOT_KEYWORD_ARG_TOKEN, ROBOT_KEYWORD_ARG_KEY);
    keys1.put(RobotToken.META_INFO_TOKEN, ROBOT_META_INFO_KEY);
    keys1.put(RobotToken.BAD_CHAR_TOKEN, ROBOT_BAD_CHAR_KEY);
    keys1.put(RobotToken.COLUMN_SEP_TOKEN, ROBOT_COL_SEP_KEY);

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

