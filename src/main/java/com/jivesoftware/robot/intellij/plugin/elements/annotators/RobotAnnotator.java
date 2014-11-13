package com.jivesoftware.robot.intellij.plugin.elements.annotators;

import com.intellij.codeInsight.daemon.impl.HighlightInfoType;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.RobotBuiltInKeywords;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotKeywordReference;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charlescapps on 11/12/14.
 *
 * Annotator to indicate when a RobotKeyword usage doesn't refer to a valid RobotKeyword definition, in either
 * Java or in the built-in keywords.
 */
public class RobotAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof RobotKeyword) {
            RobotKeyword robotKeyword = (RobotKeyword) element;
            RobotKeywordReference ref = new RobotKeywordReference(robotKeyword);
            PsiElement keywordDef = ref.resolve();
            if (keywordDef == null) {
                String normalKeywordName = RobotPsiUtil.normalizeKeywordForIndex(robotKeyword.getText());
                if (RobotBuiltInKeywords.isBuiltInKeyword(normalKeywordName)) {
                    Annotation annotation = holder.createInfoAnnotation(robotKeyword, "Built-in Robot Keyword");
                    annotation.setTextAttributes(DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
                } else {
                    holder.createErrorAnnotation(robotKeyword,
                            String.format("No Keyword found with name \"%s\"", robotKeyword.getText()));
                }
            }
        }
    }
}
