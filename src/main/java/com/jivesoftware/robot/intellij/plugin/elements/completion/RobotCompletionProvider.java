package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.google.common.collect.Sets;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotTagFinder;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Handles auto-completion of Java-defined keywords when writing Robot Code.
 * Apparently, the RobotKeywordUsagesProvider already handles auto-completing robot-defined keywords.
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
