/*
 * Copyright 2010 - 2012 Ed Venaglia
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

package com.jivesoftware.robot.intellij.plugin.lang;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User: ed
 * Date: Jul 31, 2010
 * Time: 2:48:16 PM
 *
 * Color settings page used for customizing the syntax highlighting of soy files.
 */
public class RobotColorsAndFontsPage implements ColorSettingsPage {
  @NotNull
  public String getDisplayName() {
    return "Robot";
  }

  @Nullable
  public Icon getIcon() {
    return RobotIcons.FILE;
  }

  @Override
  @NotNull
  public AttributesDescriptor[] getAttributeDescriptors() {
    return ATTRS;
  }

  private static final AttributesDescriptor[] ATTRS =
      new AttributesDescriptor[] {
          new AttributesDescriptor("Table Header", RobotSyntaxHighlighter.ROBOT_TABLE_HEADER_KEY),
          new AttributesDescriptor("Test Case Title", RobotSyntaxHighlighter.ROBOT_TEST_CASE_HEADER_KEY),
          new AttributesDescriptor("Robot Keyword", RobotSyntaxHighlighter.ROBOT_KEYWORD_KEY),
          new AttributesDescriptor("Robot Variable", RobotSyntaxHighlighter.ROBOT_VARIABLE_KEY),
          new AttributesDescriptor("Robot Variable Assignment", RobotSyntaxHighlighter.ROBOT_ASSIGNMENT_KEY),
          new AttributesDescriptor("Robot Comment", RobotSyntaxHighlighter.ROBOT_COMMENT_KEY),
          new AttributesDescriptor("Number literal", RobotSyntaxHighlighter.ROBOT_NUMBER_LITERAL_KEY),
          new AttributesDescriptor("Keyword argument", RobotSyntaxHighlighter.ROBOT_KEYWORD_ARG_KEY),
          new AttributesDescriptor("Tags & Documentation headers", RobotSyntaxHighlighter.ROBOT_META_INFO_KEY),
          new AttributesDescriptor("Tags", RobotSyntaxHighlighter.ROBOT_TAG_KEY),
          new AttributesDescriptor("Documentation", RobotSyntaxHighlighter.ROBOT_DOCS_KEY),
          new AttributesDescriptor("Column Separator", RobotSyntaxHighlighter.ROBOT_COL_SEP_KEY),
          new AttributesDescriptor("Error", RobotSyntaxHighlighter.ROBOT_BAD_CHAR_KEY)
      };

  @Override
  @NotNull
  public ColorDescriptor[] getColorDescriptors() {
    return new ColorDescriptor[0];
  }

  @Override
  @NotNull
  public SyntaxHighlighter getHighlighter() {
    return new RobotSyntaxHighlighter();
  }

  @NonNls
  @NotNull
  @Override
  public String getDemoText() {
    return
        "***Settings***\n" +
            "Resource                                   ../CommonResource.txt\n" +
            "\n" +
            "***Variables***\n" +
            "${announcementDetails}=                    Super important announcement from Robot!\n" +
            "\n" +
            "***Test Cases***\n" +
            "Create An Announcement\n" +
            "  [Documentation]                          Written by Gandalf the Gray\n" +
            "  [tags]                                   announcement    Pri0       \n" +
            "\n" +
            "# Create a user VIA the API \n" +
            "  ${userName}=                             Api Create Standard User\n" +
            "\n" +
            "  Login App As Admin\n" +
            "  ${announcementTitle}=                    Create Announcement           ${announcementDetails}";
  }

  @Override
  @Nullable
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    Map<String, TextAttributesKey> map = new HashMap<String, TextAttributesKey>();
    return map;
  }
}
