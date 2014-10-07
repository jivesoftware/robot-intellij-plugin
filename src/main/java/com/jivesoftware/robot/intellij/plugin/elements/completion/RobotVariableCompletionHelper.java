package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariablePsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarAssignment;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarDefaultArgValue;
import com.jivesoftware.robot.intellij.plugin.psi.RobotScalarVariable;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Does the real work for autocompletion of variables.
 */
public class RobotVariableCompletionHelper implements RobotCompletionHelper {
    public static final RobotVariableCompletionHelper INSTANCE = new RobotVariableCompletionHelper();

    private RobotVariableCompletionHelper() {
    }

    @Override
    public void handleCompletions(LeafPsiElement leaf, CompletionParameters parameters, @NotNull CompletionResultSet result, String text) {
        if (text.startsWith("${")) {
            handleScalarVariableAutocomplete(leaf, parameters, result, text);
        }
    }

    private void handleScalarVariableAutocomplete(LeafPsiElement leaf, CompletionParameters parameters, CompletionResultSet result, String text) {
        // Check if the variable text matches the regex
        Pattern variableRegEx = Pattern.compile("\\$\\{([^\\}]*)(\\}?|\\} ?\\=)");
        Matcher m = variableRegEx.matcher(text);
        if(!m.matches()){
            return;
        }

        // Obtain the actual variable string
        String variableText = m.group(1).trim();

        // Normalize the variable text in order to perform lookup
        final String normalizedVariableText = RobotPsiUtil.normalizeKeywordForIndex(variableText);
        final Set<String> includedNormalNames = Sets.newHashSet();

        // Look up the variable
        Set<LookupElement> lookupsFromScalarVariables = getLookupElementsFromScalarVariables(leaf, normalizedVariableText,
                RobotScalarVariable.class, includedNormalNames);
        Set<LookupElement> lookupsFromScalarAssignments = getLookupElementsFromScalarVariables(leaf, normalizedVariableText,
                RobotScalarAssignment.class, includedNormalNames);
        Set<LookupElement> lookupsFromScalarDefaultArgs = getLookupElementsFromScalarVariables(leaf, normalizedVariableText,
                RobotScalarDefaultArgValue.class, includedNormalNames);

        result.addAllElements(lookupsFromScalarVariables);
        result.addAllElements(lookupsFromScalarAssignments);
        result.addAllElements(lookupsFromScalarDefaultArgs);
    }

    private <T extends PsiElement> Set<LookupElement> getLookupElementsFromScalarVariables(LeafPsiElement element,
                                                                                           String normalizedVariableText,
                                                                                           Class<T> variableClass,
                                                                                           Set<String> includedNormalNames) {
        // List of all scalar elements in scope
        List<T> scalarsInScope = RobotPsiUtil.findVariablesInScope(element, variableClass);
        Set<LookupElement> lookupElements = Sets.newHashSet();
        for (T var: scalarsInScope) {
            Matcher matcher = VariablePsiUtil.VARIABLE_PATTERN.matcher(var.getText());
            if (matcher.find()) {
                String variableName = matcher.group(1);
                String normalizedVariableName = RobotPsiUtil.normalizeKeywordForIndex(variableName);
                // Remove duplicates
                if (includedNormalNames.contains(normalizedVariableName)) {
                    continue;
                }
                LookupElement lookupElement = createLookupElementFromVariableName(variableName);
                lookupElements.add(lookupElement);
                includedNormalNames.add(normalizedVariableName);
            }
        }
        return lookupElements;
    }

    private static LookupElement createLookupElementFromVariableName(String variableName) {
        String variableString = "${" + variableName + "}";
        return LookupElementBuilder.create(variableString)
                .withCaseSensitivity(false)
                .withTailText("    Variable", true);
    }
}
