package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.base.Optional;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.util.PsiTreeUtil;
import com.jgoodies.common.base.Objects;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariablePsiUtil;
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

    @Nullable
    @Override
    public PsiElement resolve() {
        final Optional<String> optVariableName = VariablePsiUtil.getVariableName(myElement);
        final PsiFile myFile = myElement.getContainingFile();
        final VirtualFile myVirtualFile = myFile != null ? myFile.getVirtualFile() : null;
        final String myCanonicalPath = myVirtualFile != null ? myVirtualFile.getCanonicalPath() : null;

        if (!optVariableName.isPresent()) {
            return null;
        }
        final String varName = optVariableName.get();
        final String normalName = RobotPsiUtil.normalizeKeywordForIndex(varName);

        RobotTestCase containingTest = PsiTreeUtil.getParentOfType(myElement, RobotTestCase.class);
        if (containingTest != null) {
            Optional<PsiElement> definition = VariablePsiUtil.findFirstDefinitionOfVariable(containingTest, normalName);
            if (definition.isPresent()) {
                PsiFile containingFile = definition.get().getContainingFile();
                VirtualFile virtualFile = containingFile != null ? containingFile.getVirtualFile() : null;
                String canonicalPath = virtualFile != null ? virtualFile.getCanonicalPath() : null;

                //If the variable resolved to itself, return null
                if (canonicalPath != null && myCanonicalPath != null &&
                        canonicalPath.equals(myCanonicalPath) &&
                        Objects.equals(definition.get().getTextRange(), myElement.getTextRange())) {
                    return null;
                }

                return definition.get();
            }
        }

        RobotKeywordDefinition containingKeywordDefinition = PsiTreeUtil.getParentOfType(myElement, RobotKeywordDefinition.class);
        if (containingKeywordDefinition != null) {
            Optional<PsiElement> definition = VariablePsiUtil.findFirstDefinitionOfVariable(containingKeywordDefinition, normalName);
            if (definition.isPresent()) {
                PsiFile containingFile = definition.get().getContainingFile();
                VirtualFile virtualFile = containingFile != null ? containingFile.getVirtualFile() : null;
                String canonicalPath = virtualFile != null ? virtualFile.getCanonicalPath() : null;

                //If the variable resolved to itself, return null
                if (canonicalPath != null && myCanonicalPath != null &&
                        canonicalPath.equals(myCanonicalPath) &&
                        Objects.equals(definition.get().getTextRange(), myElement.getTextRange())) {
                    return null;
                }
                return definition.get();
            }
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
