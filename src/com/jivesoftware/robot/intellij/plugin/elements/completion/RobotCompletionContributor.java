package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;

public class RobotCompletionContributor extends CompletionContributor {
  public RobotCompletionContributor() {
    extend(CompletionType.BASIC,
           PlatformPatterns.or(PlatformPatterns.psiElement(RobotTypes.ROBOT_KEYWORD_TOKEN).withLanguage(RobotLanguage.INSTANCE),
                               PlatformPatterns.psiElement(RobotTypes.TAG_TOKEN).withLanguage(RobotLanguage.INSTANCE)),
           new RobotCompletionProvider());
  }
}
