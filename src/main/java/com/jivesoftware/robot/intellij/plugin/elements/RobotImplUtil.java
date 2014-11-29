package com.jivesoftware.robot.intellij.plugin.elements;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.jivesoftware.robot.intellij.plugin.elements.presentations.KeywordTitlePresentation;
import com.jivesoftware.robot.intellij.plugin.elements.presentations.RobotResourceFilePresentation;
import com.jivesoftware.robot.intellij.plugin.elements.presentations.TestCasePresentation;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotVariableUtil;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotKeywordTitleStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotScalarAssignmentStub;
import com.jivesoftware.robot.intellij.plugin.elements.stubindex.RobotScalarVariableStub;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import com.jivesoftware.robot.intellij.plugin.util.RegexUtils;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.util.List;

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
        return element.getTestCaseHeader();
    }


    public static ItemPresentation getPresentation(final RobotTestCase element) {
        return new TestCasePresentation(element);
    }

    public static String toString(RobotTestCase element) {
        return element.getClass().getSimpleName() + ": " + element.getText();
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

    public static String toString(RobotKeyword element) {
        return element.getClass().getSimpleName() + ": " + element.getText();
    }

    /* Methods for RobotKeywordArg */

    @Nullable
    @NonNls
    public static String getName(RobotKeywordArg element) {
        return element.getText();
    }

    public static PsiElement setName(RobotKeywordArg element, @NonNls @NotNull String newName) throws IncorrectOperationException {
        RobotKeywordArg replacement = RobotElementFactory.createKeywordArg(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotKeywordArg element) {
        return element;
    }

    public static PsiElement handleElementRename(RobotKeywordArg element, String name) {
        return element.setName(name);
    }


    public static PsiReference getReference(RobotKeywordArg element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    public static PsiReference[] getReferences(RobotKeywordArg element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

      /* Methods for RobotJavaClassReference */

    @NotNull
    public static PsiReference[] getReferences(RobotJavaClassReference element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    @Nullable
    public static PsiReference getReference(RobotJavaClassReference element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    /* Methods for RobotResourceFile */

    @NotNull
    public static PsiReference[] getReferences(RobotResourceFile element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    @Nullable
    public static PsiReference getReference(RobotResourceFile element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    @Nullable
    @NonNls
    public static String getName(RobotResourceFile element) {
        final String text = element.getText();
        final int indexOfLastSlash = text.lastIndexOf(File.separatorChar);
        return text.substring(indexOfLastSlash + 1);
    }

    public static PsiElement setName(RobotResourceFile element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        final String oldText = element.getText();
        final int indexOfLastSlash = oldText.lastIndexOf(File.separatorChar);
        final String fullPathOfNewResourceName = oldText.substring(0, indexOfLastSlash + 1) + newName;
        RobotResourceFile replacement = RobotElementFactory.createRobotResourceFile(element.getProject(), fullPathOfNewResourceName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotResourceFile element) {
        return element;
    }

    public static PsiElement handleElementRename(RobotResourceFile element, String name) {
        return element.setName(name);
    }

    public static ItemPresentation getPresentation(final RobotResourceFile element) {
        return new RobotResourceFilePresentation(element);
    }

    public static String toString(RobotResourceFile element) {
        return "Resource Setting: " + element.getText();
    }

     /* Methods for RobotScalarVariable */
     @Nullable
     @NonNls
     public static String getName(RobotScalarVariable element) {
         RobotScalarVariableStub stub = element.getStub();
         if (stub != null) {
             return stub.getName();
         }
         Optional<String> optVariableName = RobotVariableUtil.getVariableName(element);
         if (optVariableName.isPresent()) {
             return optVariableName.get();
         }
         return null;
     }

    public static PsiElement setName(RobotScalarVariable element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotScalarVariable replacement = RobotElementFactory.createScalarVariable(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotScalarVariable element) {
        return element;
    }

    @NotNull
    public static PsiReference[] getReferences(RobotScalarVariable element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    @Nullable
    public static PsiReference getReference(RobotScalarVariable element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    public static PsiElement handleElementRename(RobotScalarVariable element, String name) {
        return element.setName(name);
    }

    public static String toString(RobotScalarVariable element) {
        return "RobotScalarVariable: " + element.getText();
    }

    /* Methods for RobotScalarAssignment */
    @Nullable
    @NonNls
    public static String getName(RobotScalarAssignment element) {
        RobotScalarAssignmentStub stub = element.getStub();
        if (stub != null) {
            return stub.getName();
        }
        Optional<String> optVariableName = RobotVariableUtil.getVariableName(element);
        if (optVariableName.isPresent()) {
            return optVariableName.get();
        }
        return null;
    }

    public static PsiElement setName(RobotScalarAssignment element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotScalarAssignment replacement = RobotElementFactory.createScalarAssignment(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotScalarAssignment element) {
        return element;
    }

    @NotNull
    public static PsiReference[] getReferences(RobotScalarAssignment element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    @Nullable
    public static PsiReference getReference(RobotScalarAssignment element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    public static PsiElement handleElementRename(RobotScalarAssignment element, String name) {
        return element.setName(name);
    }

    public static String toString(RobotScalarAssignment element) {
        return "RobotScalarAssignment: " + element.getText();
    }

    /* Methods for RobotScalarAssingmentLhs */
    @Nullable
    @NonNls
    public static String getName(RobotScalarAssignmentLhs element) {
        Optional<String> optVariableName = RobotVariableUtil.getVariableName(element);
        if (optVariableName.isPresent()) {
            return optVariableName.get();
        }
        return null;
    }

    public static PsiElement setName(RobotScalarAssignmentLhs element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotScalarAssignmentLhs replacement = RobotElementFactory.createScalarAssignmentLhs(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotScalarAssignmentLhs element) {
        RobotScalarAssignment assignment = PsiTreeUtil.findChildOfType(element, RobotScalarAssignment.class);
        if (assignment != null) {
            return assignment;
        }
        RobotScalarVariable variable = PsiTreeUtil.findChildOfType(element, RobotScalarVariable.class);
        if (variable != null) {
            return variable;
        }
        return element;
    }

    @Nullable
    public static PsiReference getReference(RobotScalarAssignmentLhs element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    @NotNull
    public static PsiReference[] getReferences(RobotScalarAssignmentLhs element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    public static PsiElement handleElementRename(RobotScalarAssignmentLhs element, String name) {
        return element.setName(name);
    }

    public static String toString(RobotScalarAssignmentLhs element) {
        return "RobotScalarAssignmentLhs: " + element.getText();
    }

    /* Methods for RobotScalarDefaultArgValue */
    @Nullable
    @NonNls
    public static String getName(RobotScalarDefaultArgValue element) {
        Optional<String> optVariableName = RobotVariableUtil.getVariableName(element);
        if (optVariableName.isPresent()) {
            return optVariableName.get();
        }
        return null;
    }

    public static PsiElement setName(RobotScalarDefaultArgValue element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotScalarDefaultArgValue replacement = RobotElementFactory.createScalarDefaultArgValue(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotScalarDefaultArgValue element) {
        return element;
    }

    @Nullable
    public static PsiReference getReference(RobotScalarDefaultArgValue element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    @NotNull
    public static PsiReference[] getReferences(RobotScalarDefaultArgValue element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    public static PsiElement handleElementRename(RobotScalarDefaultArgValue element, String name) {
        return element.setName(name);
    }

    public static String toString(RobotScalarDefaultArgValue element) {
        return "RobotScalarDefaultArgValue: " + element.getText();
    }


    /* Methods for RobotArgumentDef */
    @Nullable
    @NonNls
    public static String getName(RobotArgumentDef element) {
        Optional<String> optVariableName = RobotVariableUtil.getVariableName(element);
        if (optVariableName.isPresent()) {
            return optVariableName.get();
        }
        return null;
    }

    public static PsiElement setName(RobotArgumentDef element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotArgumentDef replacement = RobotElementFactory.createArgumentDef(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotArgumentDef element) {
        RobotScalarVariable scalarVariable = PsiTreeUtil.findChildOfType(element, RobotScalarVariable.class);
        if (scalarVariable != null) {
            return scalarVariable;
        }
        RobotScalarDefaultArgValue defaultArgValue = PsiTreeUtil.findChildOfType(element, RobotScalarDefaultArgValue.class);
        if (defaultArgValue != null) {
            return defaultArgValue;
        }
        RobotArrayVariable arrayVariable = PsiTreeUtil.findChildOfType(element, RobotArrayVariable.class);
        if (arrayVariable != null) {
            return arrayVariable;
        }
        return element;
    }

    @Nullable
    public static PsiReference getReference(RobotArgumentDef element) {
        PsiReference[] refs = ReferenceProvidersRegistry.getReferencesFromProviders(element);
        if (refs.length <= 0) {
            return null;
        }
        return refs[0];
    }

    @NotNull
    public static PsiReference[] getReferences(RobotArgumentDef element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    public static PsiElement handleElementRename(RobotArgumentDef element, String name) {
        return element.setName(name);
    }

    public static String toString(RobotArgumentDef element) {
        return "RobotArgumentDef: " + element.getText();
    }

    /* Methods for RobotKeywordTitle type */

    public static ItemPresentation getPresentation(final RobotKeywordTitle element) {
       return new KeywordTitlePresentation(element);
    }

    @Nullable
    @NonNls
    public static String getName(RobotKeywordTitle element) {
        RobotKeywordTitleStub stub = element.getStub();
        if (stub != null) {
            return stub.getName();
        }
        return element.getText();
    }

    public static PsiElement setName(RobotKeywordTitle element, @NonNls @NotNull String newName) throws com.intellij.util.IncorrectOperationException {
        RobotKeywordTitle replacement = RobotElementFactory.createKeywordTitle(element.getProject(), newName);
        element.getParent().getNode().replaceChild(element.getNode(), replacement.getNode());
        return replacement;
    }

    @Nullable
    public static PsiElement getNameIdentifier(RobotKeywordTitle element) {
        return element;
    }

    /**
     * Return a regex for matching the usage of a Keyword that has embedded keyword args
     * @param element
     * @return
     */
    public static String getRegex(RobotKeywordTitle element) {
        final String text = element.getText();
        if (Strings.isNullOrEmpty(text)) {
            return null;
        }
        // Get occurrences of embedded arguments
        List<TextRange> unescapedVars = RobotVariableUtil.getOccurrencesOfUnescapedVariablesInText(text);

        StringBuilder sb = new StringBuilder();
        int lastChar = 0;
        for (TextRange textRange: unescapedVars) {
            String between = text.substring(lastChar, textRange.getStartOffset());
            // Replace the embedded arg with wildcard regex (.*)
            sb.append(RegexUtils.escapeStringForRegex(between.toLowerCase()));
            sb.append("(.*)"); // Match any value inside the embedded argument ${arg}
            lastChar = textRange.getEndOffset();
        }

        String remaining = text.substring(lastChar, text.length());
        sb.append(RegexUtils.escapeStringForRegex(remaining.toLowerCase()));
        return sb.toString();
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

    public static String toString(RobotKeywordTitle element) {
        return "RobotKeywordTitle: " + getName(element);
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
