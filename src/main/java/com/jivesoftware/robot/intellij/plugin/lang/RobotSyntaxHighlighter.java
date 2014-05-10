package com.jivesoftware.robot.intellij.plugin.lang;

/*
 * Copyright 2014
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
import com.jivesoftware.robot.intellij.plugin.lexer.RobotScannerAdapter;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotToken;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * IntelliJ syntax highlighter implementation for Robot Test Case Files
 */
public class RobotSyntaxHighlighter extends SyntaxHighlighterBase {

    private static Map<IElementType, TextAttributesKey> keys1;
    private static Map<IElementType, TextAttributesKey> keys2;
    public static final HtmlFileHighlighter HTML_FILE_HIGHLIGHTER = new HtmlFileHighlighter();

    @NotNull
    public Lexer getHighlightingLexer() {
        return new RobotScannerAdapter();
    }

    static final TextAttributesKey ROBOT_TABLE_HEADER_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.TABLE",
            DefaultLanguageHighlighterColors.CONSTANT);

    static final TextAttributesKey ROBOT_TEST_CASE_HEADER_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.TEST_CASE_HEADER",
            DefaultLanguageHighlighterColors.INSTANCE_METHOD);

    static final TextAttributesKey ROBOT_KEYWORD_DEF_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.KEYWORD_DEF",
            DefaultLanguageHighlighterColors.INSTANCE_METHOD);

    static final TextAttributesKey ROBOT_TAG_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.TAG",
            DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);

    static final TextAttributesKey ROBOT_DOCS_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.DOCS",
            DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    static final TextAttributesKey ROBOT_KEYWORD_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD);

    static final TextAttributesKey ROBOT_SETTING_KEYWORD_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.SETTING",
            DefaultLanguageHighlighterColors.KEYWORD);

    static final TextAttributesKey ROBOT_VARIABLE_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.VARIABLE",
            DefaultLanguageHighlighterColors.LOCAL_VARIABLE);

    static final TextAttributesKey ROBOT_ASSIGNMENT_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.ASSIGNMENT",
            DefaultLanguageHighlighterColors.CLASS_NAME);

    static final TextAttributesKey ROBOT_COMMENT_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);

    static final TextAttributesKey ROBOT_KEYWORD_ARG_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.KEYWORD_ARG",
            DefaultLanguageHighlighterColors.STRING);

    static final TextAttributesKey ROBOT_TABLE_SETTING_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.META_INFO",
            DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);

    static final TextAttributesKey ROBOT_COL_SEP_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.COLUMN_SEP",
            DefaultLanguageHighlighterColors.COMMA);

    static final TextAttributesKey ROBOT_BAD_SYNTAX_KEY = TextAttributesKey.createTextAttributesKey("ROBOT.BAD",
            DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);


    static {
        keys1 = new HashMap<IElementType, TextAttributesKey>();
        keys2 = new HashMap<IElementType, TextAttributesKey>();

        // Table headers
        keys1.put(RobotTypes.SETTINGS_TABLE_HEADING_TOKEN, ROBOT_TABLE_HEADER_KEY);
        keys1.put(RobotTypes.VARIABLES_TABLE_HEADING_TOKEN, ROBOT_TABLE_HEADER_KEY);
        keys1.put(RobotTypes.TEST_CASES_TABLE_HEADING_TOKEN, ROBOT_TABLE_HEADER_KEY);
        keys1.put(RobotTypes.KEYWORDS_TABLE_HEADING_TOKEN, ROBOT_TABLE_HEADER_KEY);

        // Keyword definition
        keys1.put(RobotTypes.ROBOT_KEYWORD_DEF_TOKEN, ROBOT_KEYWORD_DEF_KEY);

        //Test case header
        keys1.put(RobotTypes.TEST_CASE_HEADER_TOKEN, ROBOT_TEST_CASE_HEADER_KEY);

        //Robot keyword usage
        keys1.put(RobotTypes.ROBOT_KEYWORD_TOKEN, ROBOT_KEYWORD_KEY);
        keys1.put(RobotTypes.FORCE_TAGS_SETTING_KEYWORD_TOKEN, ROBOT_SETTING_KEYWORD_KEY);

        //Variables
        keys1.put(RobotTypes.VARIABLE_TOKEN, ROBOT_VARIABLE_KEY);
        keys1.put(RobotTypes.ASSIGNMENT_TOKEN, ROBOT_ASSIGNMENT_KEY);
        keys1.put(RobotTypes.ARRAY_VARIABLE_TOKEN, ROBOT_VARIABLE_KEY);
        keys1.put(RobotTypes.ARRAY_ASSIGNMENT_TOKEN, ROBOT_ASSIGNMENT_KEY);

        //Comments
        keys1.put(RobotTypes.COMMENT_TOKEN, ROBOT_COMMENT_KEY);

        //Documentation
        keys1.put(RobotTypes.DOCUMENTATION_TOKEN, ROBOT_DOCS_KEY);

        //Number literals and keyword arguments
        keys1.put(RobotTypes.ROBOT_KEYWORD_ARG_TOKEN, ROBOT_KEYWORD_ARG_KEY);

        //Table settings tokens for settings like [tags]
        keys1.put(RobotTypes.TAGS_SETTING_TOKEN, ROBOT_TABLE_SETTING_KEY);
        keys1.put(RobotTypes.TIMEOUT_SETTING_TOKEN, ROBOT_TABLE_SETTING_KEY);
        keys1.put(RobotTypes.ARGUMENTS_SETTING_TOKEN, ROBOT_TABLE_SETTING_KEY);
        keys1.put(RobotTypes.DOCUMENTATION_SETTING_TOKEN, ROBOT_TABLE_SETTING_KEY);
        keys1.put(RobotTypes.SETUP_SETTING_TOKEN, ROBOT_TABLE_SETTING_KEY);
        keys1.put(RobotTypes.TEARDOWN_SETTING_TOKEN, ROBOT_TABLE_SETTING_KEY);

        //Bad characters
        keys1.put(RobotTypes.BAD_SYNTAX_TOKEN, ROBOT_BAD_SYNTAX_KEY);

        //Tags
        keys1.put(RobotTypes.TAG_TOKEN, ROBOT_TAG_KEY);


    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType instanceof RobotToken) {
            return pack(keys1.get(tokenType));
        } else {
            return new TextAttributesKey[] {};
        }
    }
}

