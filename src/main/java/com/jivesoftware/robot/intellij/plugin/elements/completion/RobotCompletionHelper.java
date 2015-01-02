package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Interface for helpers that do all the real work for Autocompletion.
 */
public interface RobotCompletionHelper {

    void handleCompletions(LeafPsiElement leaf, CompletionParameters parameters, @NotNull CompletionResultSet result);

}
