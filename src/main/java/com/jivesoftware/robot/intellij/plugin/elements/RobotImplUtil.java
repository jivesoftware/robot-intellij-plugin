package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.util.IncorrectOperationException;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCaseHeader;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class RobotImplUtil {




    /* Methods for RobotTestCase type */

    @Nullable
    @NonNls
    public static String getName(RobotTestCase element) {
        PsiElement header = getNameIdentifier(element);
        if (header == null) {
            return null;
        }
        return header.getText();
    }

    public static PsiElement setName(RobotTestCase element, @NonNls @NotNull String newName) throws IncorrectOperationException {
        return element;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotTestCase element) {
        if (element == null) {
            return null;
        }
        RobotTestCaseHeader header = element.getTestCaseHeader();
        return header;
    }


    public static ItemPresentation getPresentation(final RobotTestCase element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return String.format("Robot Test Case: %s", getNameIdentifier(element).getText());
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

    /* Methods for RobotKeyword type */

    @Nullable
    @NonNls
    public static String getName(RobotKeyword element) {
        return element.getText();
    }

    public static PsiElement setName(RobotKeyword element, @NonNls @NotNull String newName) throws IncorrectOperationException {
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

    /* Methods for RobotKeywordDef type */

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
