package com.jivesoftware.robot.intellij.plugin.elements.completion;

import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotVariableUtil;
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
        Pattern variableRegEx = Pattern.compile("\\$\\{ ?([^\\}]*)(\\}?|\\} ?\\=)");
        Matcher m = variableRegEx.matcher(text);
        if(!m.matches()){
            return;
        }

        // The Set of variable names we have already included for auto-completion
        final Set<String> includedNormalNames = Sets.newHashSet();

        Optional<String> leafElementVariable = RobotVariableUtil.getVariableName(leaf);

        // We don't want to auto-complete the variable at the cursor.
        if (leafElementVariable.isPresent()) {
            String normalizedLeafName = RobotPsiUtil.normalizeKeywordForIndex(leafElementVariable.get());
            includedNormalNames.add(normalizedLeafName);
        }

        // Look up the variable
        Set<LookupElement> lookupsFromScalarVariables = getLookupElementsFromScalarVariables(leaf,
                RobotScalarVariable.class, includedNormalNames);
        Set<LookupElement> lookupsFromScalarAssignments = getLookupElementsFromScalarVariables(leaf,
                RobotScalarAssignment.class, includedNormalNames);
        Set<LookupElement> lookupsFromScalarDefaultArgs = getLookupElementsFromScalarVariables(leaf,
                RobotScalarDefaultArgValue.class, includedNormalNames);
        Set<LookupElement> lookupsFromEmbeddedArgs = getLookupElementsFromEmbeddedArgsInKeywordTitle(leaf, includedNormalNames);

        result.addAllElements(lookupsFromScalarVariables);
        result.addAllElements(lookupsFromScalarAssignments);
        result.addAllElements(lookupsFromScalarDefaultArgs);
        result.addAllElements(lookupsFromEmbeddedArgs);
    }

    private Set<LookupElement> getLookupElementsFromEmbeddedArgsInKeywordTitle(LeafPsiElement element, Set<String> includedNormalNames) {
        List<String> embeddedArgs = RobotVariableUtil.getEmbeddedArgsFromContainingKeyword(element);

        Set<LookupElement> lookupElements = Sets.newHashSet();

        for (String embeddedArg: embeddedArgs) {
            if (includedNormalNames.contains(embeddedArg)) {
                continue;
            }
            LookupElement lookupElement = createLookupElementFromVariableName(embeddedArg);
            lookupElements.add(lookupElement);
            includedNormalNames.add(embeddedArg);
        }
        return lookupElements;
    }

    private <T extends PsiElement> Set<LookupElement> getLookupElementsFromScalarVariables(LeafPsiElement element,
                                                                                           Class<T> variableClass,
                                                                                           Set<String> includedNormalNames) {
        // List of all scalar elements in scope
        List<T> scalarsInScope = RobotPsiUtil.findVariablesInScope(element, variableClass);
        Set<LookupElement> lookupElements = Sets.newHashSet();
        for (T var: scalarsInScope) {
            Optional<String> variableNameOpt = RobotVariableUtil.getVariableName(var);
            if (!variableNameOpt.isPresent()) {
                continue;
            }
            String variableName = variableNameOpt.get();
            String normalizedVariableName = RobotPsiUtil.normalizeKeywordForIndex(variableName);
            // Remove duplicates
            if (includedNormalNames.contains(normalizedVariableName)) {
                continue;
            }
            LookupElement lookupElement = createLookupElementFromVariableName(variableName);
            lookupElements.add(lookupElement);
            includedNormalNames.add(normalizedVariableName);
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
