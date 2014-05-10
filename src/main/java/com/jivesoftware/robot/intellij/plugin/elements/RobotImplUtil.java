package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RobotImplUtil {

    @Nullable
    @NonNls
    public static String getName(RobotKeyword element) {
        return element.getText();
    }

    public static PsiElement setName(RobotKeyword element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotKeyword replacement = RobotElementFactory.createKeyword(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotKeyword element) {
        return element;
    }

    @NotNull
    public static PsiReference[] getReferences(RobotKeyword element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    @Nullable
    public static PsiReference getReference(RobotKeyword element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    // Robot Keyword Definition methods
    public static ItemPresentation getPresentation(final RobotKeywordDef element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return String.format("Robot Keyword: %s", element.getText());
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return RobotIcons.FILE;
            }
        };
    }

    @Nullable
    @NonNls
    public static String getName(RobotKeywordDef element) {
        return element.getText();
    }

    public static PsiElement setName(RobotKeywordDef element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotKeywordDef replacement = RobotElementFactory.createKeywordDef(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotKeywordDef element) {
        return element;
    }

}
