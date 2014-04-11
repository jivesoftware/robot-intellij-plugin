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

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * IntelliJ language definition for Robot Test Case Files.
 */
public class RobotLanguage extends Language {

  public static final RobotLanguage INSTANCE = new RobotLanguage();

  @NonNls
  private static final String ID = "RobotTestFile";

  private RobotLanguage() {
    super(ID);
    SyntaxHighlighterFactory.LANGUAGE_FACTORY.addExplicitExtension(this, new SingleLazyInstanceSyntaxHighlighterFactory() {
      @NotNull
      protected SyntaxHighlighter createHighlighter() {
        return new RobotSyntaxHighlighter();
      }
    });
  }

  @Override
  public boolean isCaseSensitive() {
    return true;
  }

  @Override
  public String getDisplayName() {
    return "Robot Test File Language";
  }
}

