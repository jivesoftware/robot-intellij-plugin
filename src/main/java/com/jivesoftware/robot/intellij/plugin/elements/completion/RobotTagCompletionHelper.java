package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.google.common.collect.Sets;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotTagFinder;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Does the real work for autocompletion of Tags.
 */
public class RobotTagCompletionHelper implements RobotCompletionHelper {
    public static final RobotTagCompletionHelper INSTANCE = new RobotTagCompletionHelper();

    private RobotTagCompletionHelper() {
    }

    public void handleCompletions(LeafPsiElement leaf, @NotNull CompletionParameters parameters, @NotNull CompletionResultSet result, String text) {
        Set<LookupElement> tagCompletions = getTagCompletions(leaf.getProject(), parameters, leaf.getText());
        result.addAllElements(tagCompletions);
    }

    private Set<LookupElement> getTagCompletions(Project project, CompletionParameters parameters, String currentlyTyped) {
        Set<LookupElement> myTagCompletions = Sets.newHashSet();
        populateTags(project, myTagCompletions, currentlyTyped);
        return myTagCompletions;
    }

    private void populateTags(Project project, Collection<LookupElement> populateMe, String currentlyTyped) {
        RobotTagFinder robotTagFinder = new RobotTagFinder(project);
        robotTagFinder.process();
        List<String> tags = robotTagFinder.getResults();
        for (String tag : tags) {
            if (tag.equals(currentlyTyped)) {
                continue;
            }
            populateMe.add(LookupElementBuilder.create(tag));
        }
    }
}
