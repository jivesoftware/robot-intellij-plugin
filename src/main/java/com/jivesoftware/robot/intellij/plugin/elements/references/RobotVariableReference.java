package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.base.Optional;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.util.PsiTreeUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariablePsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotForLoopIn;
import com.jivesoftware.robot.intellij.plugin.psi.RobotForLoopInRange;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefinition;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by charles on 7/13/14.
 */
public class RobotVariableReference extends PsiReferenceBase<PsiElement> {
    public RobotVariableReference(PsiElement element) {
        super(element);
    }

    /**
     * @param element PSI element
     * @param range range relatively to the element's start offset
     */
    public RobotVariableReference(PsiElement element, TextRange range) {
        super(element, range);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        TextRange range = getRangeInElement();
        final Optional<String> optVariableName;

        optVariableName = VariablePsiUtil.getVariableName(myElement, range);

        if (!optVariableName.isPresent()) {
            return null;
        }

        RobotForLoopIn containingLoop = PsiTreeUtil.getParentOfType(myElement, RobotForLoopIn.class);
        if (containingLoop != null) {
            Optional<PsiElement> definition = VariablePsiUtil.findFirstDefinitionOfVariableFromForLoopIn(containingLoop, myElement, range);
            if (definition.isPresent()) {
                if (RobotPsiUtil.areIdenticalTextualOccurrences(myElement, definition.get())) {
                    return null;
                }
                return definition.get();
            }
        }

        RobotForLoopInRange containingLoopInRange = PsiTreeUtil.getParentOfType(myElement, RobotForLoopInRange.class);
        if (containingLoop != null) {
            Optional<PsiElement> definition = VariablePsiUtil.findFirstDefinitionOfVariableFromForLoopInRange(containingLoopInRange, myElement, range);
            if (definition.isPresent()) {
                if (RobotPsiUtil.areIdenticalTextualOccurrences(myElement, definition.get())) {
                    return null;
                }
                return definition.get();
            }
        }

        RobotTestCase containingTest = PsiTreeUtil.getParentOfType(myElement, RobotTestCase.class);
        if (containingTest != null) {
            Optional<PsiElement> definition = VariablePsiUtil.findFirstDefinitionOfVariable(containingTest, myElement, range);
            if (definition.isPresent()) {
                if (RobotPsiUtil.areIdenticalTextualOccurrences(myElement, definition.get())) {
                    return null;
                }
                return definition.get();
            }
        }

        RobotKeywordDefinition containingKeywordDefinition = PsiTreeUtil.getParentOfType(myElement, RobotKeywordDefinition.class);
        if (containingKeywordDefinition != null) {
            Optional<PsiElement> definition = VariablePsiUtil.findFirstDefinitionOfVariable(containingKeywordDefinition, myElement, range);
            if (definition.isPresent()) {
                if (RobotPsiUtil.areIdenticalTextualOccurrences(myElement, definition.get())) {
                    return null;
                }
                return definition.get();
            }
        }

        Optional<PsiElement> definition = VariablePsiUtil.findFirstDefinitionOfVariableNotInKeywordOrTestCase(myElement, range);
        if (definition.isPresent()) {
            if (RobotPsiUtil.areIdenticalTextualOccurrences(myElement, definition.get())) {
                return null;
            }
            return definition.get();
        }

        return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

    @NotNull
    @Override
    public String getCanonicalText() {
        return myElement.getText();
    }

    @Override
    public TextRange calculateDefaultRangeInElement() {
        return new TextRange(0, myElement.getText().length());
    }

}
