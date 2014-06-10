package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.util.ProcessingContext;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.references.PsiMethodWithRobotName;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotTagFinder;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Handles auto-completion of Java-defined keywords when writing Robot Code.
 * Apparently, the RobotKeywordUsagesProvider already handles auto-completing robot-defined keywords.
 */
public class RobotCompletionProvider extends CompletionProvider<CompletionParameters> {
  @Override
  protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
    PsiElement element = parameters.getOriginalPosition();
    if (!(element instanceof LeafPsiElement)) {
      return;
    }
    LeafPsiElement leaf = (LeafPsiElement) element;
    if (leaf.getElementType() == RobotTypes.TAG_TOKEN) {
      handleTagTokens(leaf, parameters, context, result);
    } else if (leaf.getElementType() == RobotTypes.ROBOT_KEYWORD_TOKEN) {
      handleKeywordTokens(leaf, parameters, context, result);
    }

  }

  private void handleTagTokens(LeafPsiElement leaf, @NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
    RobotTagFinder robotTagFinder = new RobotTagFinder(leaf.getProject());
    robotTagFinder.process();
    List<String> tags = robotTagFinder.getResults();
    for (String tag: tags) {
        result.addElement(LookupElementBuilder.create(tag));
    }
  }

  private void handleKeywordTokens(LeafPsiElement leaf, @NotNull CompletionParameters parameters, ProcessingContext context,
                                   @NotNull CompletionResultSet result) {
    if (!(leaf.getParent() instanceof RobotKeyword)) {
        return;
    }
    RobotKeyword parent = (RobotKeyword) leaf.getParent();
    PsiReference ref = parent.getReference();
    if (ref == null) {
      return;
    }
    final String text = leaf.getText();
    final String textMethodName = RobotPsiUtil.robotKeywordToMethodFast(text);
    PsiFile file = leaf.getContainingFile();
    Project project = file.getProject();
    Map<String, PsiElement> keywordDefinitions = getRobotKeywordDefinitions(textMethodName, project);
    Set<String> keys = keywordDefinitions.keySet();
    for (String key: keys) {
      PsiElement el = keywordDefinitions.get(key);
      if (el instanceof PsiNamedElement) {
        PsiNamedElement named = (PsiNamedElement) el;
        String name = named.getName();
        String methodName = RobotPsiUtil.robotKeywordToMethodFast(name);
        if (!methodName.toLowerCase().contains(textMethodName.toLowerCase())) {
          continue;
        }
        if (named instanceof PsiMethod) {
          named = new PsiMethodWithRobotName(named.getNode());
            result.addElement(LookupElementBuilder.create(named)
                    .withCaseSensitivity(false)
                    .withTypeText("Java Keyword")
                    .withIcon(RobotIcons.FILE));
        } else if (named instanceof RobotKeywordDef) {
            result.addElement(LookupElementBuilder.create(named)
                    .withCaseSensitivity(false)
                    .withTypeText("Robot Keyword")
                    .withIcon(RobotIcons.FILE));
        }
      }
    }
  }

  private Map<String, PsiElement> getRobotKeywordDefinitions(String textMethodName, Project project) {
    RobotKeywordDefinitionFinder robotKeywordDefinitionFinder = new RobotKeywordDefinitionFinder(project, "", RobotKeywordDefinitionFinder.SCOPE.ALL, true, true);
    robotKeywordDefinitionFinder.process();
    List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
    Map<String, PsiElement> defs = Maps.newHashMap();
    for (PsiElement el: results) {
        String elText = ((PsiNamedElement) el).getName();
        if (elText.toLowerCase().contains(textMethodName.toLowerCase())) {
            defs.put(elText.toLowerCase(), el);
        }
    }
      return defs;
  }
}
