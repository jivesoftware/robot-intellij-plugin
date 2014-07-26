package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import org.jetbrains.annotations.NotNull;

/**
 * Handles auto-completion of Keywords, Tags, and Variables.
 *
 * Variables are auto-completed when there's a RobotKeyword token or RobotKeywordArg token,
 * because you won't have a Variable token until after you complete the last '}' in "${someVariable}".
 */
public class RobotCompletionProvider extends CompletionProvider<CompletionParameters> {

    public RobotCompletionProvider() {
        super();
    }


    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
        PsiElement element = parameters.getOriginalPosition();
        if (!(element instanceof LeafPsiElement)) {
            return;
        }
        LeafPsiElement leaf = (LeafPsiElement) element;
        String text = leaf.getText();
        if (leaf.getElementType() == RobotTypes.TAG_TOKEN) {
            RobotTagCompletionHelper.INSTANCE.handleCompletions(leaf, parameters, result, text);
        } else if (leaf.getElementType() == RobotTypes.ROBOT_KEYWORD_TOKEN) {
            RobotKeywordCompletionHelper.INSTANCE.handleCompletions(leaf, parameters, result, text);
            RobotVariableCompletionHelper.INSTANCE.handleCompletions(leaf, parameters, result, text);
        } else if (leaf.getElementType() == RobotTypes.ROBOT_KEYWORD_ARG_TOKEN) {
            RobotVariableCompletionHelper.INSTANCE.handleCompletions(leaf, parameters, result, text);
        }
    }



}
