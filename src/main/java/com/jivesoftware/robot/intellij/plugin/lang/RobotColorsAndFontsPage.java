/*
 * Copyright 2014 Charles Capps
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
 * Color settings page used for customizing the syntax highlighting of Robot files
 */
public class RobotColorsAndFontsPage implements ColorSettingsPage {
  @NotNull
  public String getDisplayName() {
    return "Robot";
  }

  @Nullable
  public Icon getIcon() {
    return RobotIcons.ROBOT;
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
          new AttributesDescriptor("Keyword argument", RobotSyntaxHighlighter.ROBOT_KEYWORD_ARG_KEY),
          new AttributesDescriptor("Table Settings", RobotSyntaxHighlighter.ROBOT_TABLE_SETTING_KEY),
          new AttributesDescriptor("Tags", RobotSyntaxHighlighter.ROBOT_TAG_KEY),
          new AttributesDescriptor("Documentation", RobotSyntaxHighlighter.ROBOT_DOCS_KEY),
          new AttributesDescriptor("Column Separator", RobotSyntaxHighlighter.ROBOT_COL_SEP_KEY),
          new AttributesDescriptor("Robot Keyword Definition", RobotSyntaxHighlighter.ROBOT_KEYWORD_TITLE_KEY),
          new AttributesDescriptor("Error", RobotSyntaxHighlighter.ROBOT_BAD_SYNTAX_KEY)
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
            "  ${announcementTitle}=                    Create Announcement           ${announcementDetails}\n" +
        "*** Keywords ***\n" +
        "My User Defined Keyword\n" +
            "  [Documentation]                          Written by Robby Robot\n" +
            "  Go To Home Page";
  }

  @Override
  @Nullable
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    Map<String, TextAttributesKey> map = new HashMap<String, TextAttributesKey>();
    return map;
  }
}
