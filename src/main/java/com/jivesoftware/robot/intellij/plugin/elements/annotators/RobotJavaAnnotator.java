package com.jivesoftware.robot.intellij.plugin.elements.annotators;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.*;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotJavaPsiUtil;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charlescapps on 11/12/14.
 *
 * Annotator to indicate when a RobotKeyword usage doesn't refer to a valid RobotKeyword definition, in either
 * Java or in the built-in keywords.
 */
public class RobotJavaAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof PsiMethod) {
            PsiMethod psiMethod = (PsiMethod) element;
            PsiModifierList psiModifierList = psiMethod.getModifierList();
            if (psiModifierList.findAnnotation(RobotJavaPsiUtil.ROBOT_KEYWORD_ANNOTATION_LONG) == null) {
                return; // Do nothing for methods not annotated with @RobotKeyword
            }

            if (!psiModifierList.hasModifierProperty(PsiModifier.PUBLIC)) {
                PsiIdentifier methodName = psiMethod.getNameIdentifier();
                if (methodName != null) {
                    holder.createErrorAnnotation(methodName, "Robot Keyword must be public.");
                }
            }

            PsiClass psiClass = psiMethod.getContainingClass();
            if (psiClass == null) {
                return;
            }

            PsiModifierList classModifiers = psiClass.getModifierList();

            if (classModifiers == null ||
                classModifiers.findAnnotation(RobotJavaPsiUtil.ROBOT_KEYWORDS_ANNOTATION_LONG) == null) {
                PsiIdentifier methodName = psiMethod.getNameIdentifier();
                if (methodName != null) {
                    holder.createErrorAnnotation(methodName, "Robot Keyword must be in a class annotated with @RobotKeywords");
                }
            }



        } else if (element instanceof PsiClass) {
            PsiClass psiClass = (PsiClass) element;
            PsiModifierList classModifiers = psiClass.getModifierList();

            // If annotated with @RobotKeywords, the class must be public.
            if (classModifiers != null &&
                classModifiers.findAnnotation(RobotJavaPsiUtil.ROBOT_KEYWORDS_ANNOTATION_LONG) != null) {
                if (!classModifiers.hasModifierProperty(PsiModifier.PUBLIC)) {
                    PsiIdentifier className = psiClass.getNameIdentifier();
                    if (className != null) {
                        holder.createErrorAnnotation(className, "Robot Keywords class must be public.");
                    }
                }
            }
        }

    }

    private static boolean hasRobotKeyword(PsiClass psiClass) {
        PsiMethod[] methods = psiClass.getMethods();
        for (PsiMethod method: methods) {
            PsiModifierList psiModifierList = method.getModifierList();
            if (psiModifierList.findAnnotation(RobotJavaPsiUtil.ROBOT_KEYWORD_ANNOTATION_LONG) != null) {
                return true;
            }
        }
        return false;
    }

}
