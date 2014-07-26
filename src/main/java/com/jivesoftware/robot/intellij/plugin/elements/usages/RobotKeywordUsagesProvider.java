package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.google.common.base.Optional;
import com.intellij.find.impl.HelpID;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariablePsiUtil;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotScannerAdapter;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotKeywordUsagesProvider implements FindUsagesProvider {
    public static final TokenSet IDENTIFIERS = TokenSet.create(RobotTypes.ROBOT_KEYWORD_TOKEN, RobotTypes.ROBOT_KEYWORD_TITLE_TOKEN);

    public static final TokenSet COMMENTS = TokenSet.EMPTY;

    public static final TokenSet LITERALS = TokenSet.create(RobotTypes.TAGS_SETTING_TOKEN, RobotTypes.FORCE_TAGS_SETTING_KEYWORD_TOKEN);


    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new RobotWordsScanner(new RobotScannerAdapter(), IDENTIFIERS, COMMENTS, LITERALS);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof RobotKeyword ||
                psiElement instanceof RobotKeywordTitle ||
                psiElement instanceof RobotScalarVariable ||
                psiElement instanceof RobotScalarAssignment ||
                psiElement instanceof RobotScalarAssignmentLhs ||
                psiElement instanceof RobotArgumentDef ||
                psiElement instanceof RobotScalarDefaultArgValue ||
                psiElement instanceof RobotPsiFile;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return HelpID.FIND_IN_PROJECT;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof RobotKeywordTitle || element instanceof RobotKeyword) {
            return "Robot Keyword";
        } else if (element instanceof RobotScalarVariable ||
                element instanceof RobotScalarAssignment ||
                element instanceof RobotScalarAssignmentLhs ||
                element instanceof RobotArgumentDef ||
                element instanceof RobotScalarDefaultArgValue) {
            return "Robot Variable";
        } else if (element instanceof RobotResourceFile) {
            return "Robot Resource Setting";
        } else if (element instanceof RobotPsiFile) {
            return "Robot File";
        }
        return "";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof RobotScalarVariable ||
                element instanceof RobotScalarAssignment ||
                element instanceof RobotScalarAssignmentLhs ||
                element instanceof RobotArgumentDef ||
                element instanceof RobotScalarDefaultArgValue) {
            Optional<String> optVariableName = VariablePsiUtil.getVariableName(element);
            if (optVariableName.isPresent()) {
                return "${" + optVariableName.get() + "}";
            }
        }
        if (element instanceof RobotPsiFile) {
            return ((RobotPsiFile) element).getName();
        }
        return element.getText();
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return element.getText();
    }
}
