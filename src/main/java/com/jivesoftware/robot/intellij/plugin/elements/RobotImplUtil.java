package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.util.IncorrectOperationException;
import com.jivesoftware.robot.intellij.plugin.elements.presentations.KeywordDefPresentation;
import com.jivesoftware.robot.intellij.plugin.elements.presentations.TestCasePresentation;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordDefStub;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
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
        return new TestCasePresentation(element);
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

    public static PsiElement handleElementRename(RobotKeyword element, String name) {
      return element.setName(name);
    }

    /* Methods for RobotKeywordDef type */

    public static ItemPresentation getPresentation(final RobotKeywordDef element) {
       return new KeywordDefPresentation(element);
    }

    @Nullable
    @NonNls
    public static String getName(RobotKeywordDef element) {
        RobotKeywordDefStub stub = element.getStub();
        if (stub != null) {
            return stub.getName();
        }
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

    /*   Robot Test Case Table   */
    public static ItemPresentation getPresentation(final RobotTestCasesTable element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return "Test Case Table";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return RobotIcons.ROBOT;
            }
        };
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotTestCasesTable element) {
        return element.getTestCasesTableHeading();
    }

    /*   Robot Keywords Table   */
    public static ItemPresentation getPresentation(final RobotKeywordsTable element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return "Keywords Table";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return RobotIcons.ROBOT;
            }
        };
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotKeywordsTable element) {
        return element.getKeywordsTableHeading();
    }

    /*   Robot File   */
    public static ItemPresentation getPresentation(final RobotPsiFile element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return "Robot File";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return RobotIcons.ROBOT;
            }
        };
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotPsiFile element) {
        return element;
    }

}
