package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;

/**
 * Registers the RobotCompletionProvider to perform Autocomplete when certain tokens are under the cursor.
 *
 * Autocompletion for Robot Keywords, Variables, and Tags.
 */
public class RobotCompletionContributor extends CompletionContributor {
  public RobotCompletionContributor() {
    extend(CompletionType.BASIC,
           PlatformPatterns.or(PlatformPatterns.psiElement(RobotTypes.ROBOT_KEYWORD_TOKEN).withLanguage(RobotLanguage.INSTANCE),
                               PlatformPatterns.psiElement(RobotTypes.ROBOT_KEYWORD_ARG_TOKEN).withLanguage(RobotLanguage.INSTANCE),
                               PlatformPatterns.psiElement(RobotTypes.ASSIGNMENT_TOKEN).withLanguage(RobotLanguage.INSTANCE),
                               PlatformPatterns.psiElement(RobotTypes.VARIABLE_TOKEN).withLanguage(RobotLanguage.INSTANCE),
                               PlatformPatterns.psiElement(RobotTypes.TAG_TOKEN).withLanguage(RobotLanguage.INSTANCE)),
           new RobotCompletionProvider());
  }

    @Override
    public void fillCompletionVariants(final CompletionParameters parameters, CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}
