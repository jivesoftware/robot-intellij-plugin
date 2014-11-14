package com.jivesoftware.robot.intellij.plugin.elements.annotators;

import com.google.common.base.Optional;
import com.intellij.codeInsight.daemon.ImplicitUsageProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotJavaPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;

/**
 * Created by charlescapps on 11/13/14.
 *
 * This allows Java methods to be considered used and no longer greyed out, if they are
 * annotated with @RobotKeyword and used in a Robot file.
 */
public class RobotImplicitUsageProvider implements ImplicitUsageProvider {
    @Override
    public boolean isImplicitUsage(PsiElement element) {
        if (!RobotJavaPsiUtil.isJavaRobotKeyword(element)) {
            return false;
        }
        PsiMethod method = (PsiMethod)element;
        Optional<RobotKeyword> firstUsage = RobotPsiUtil.findFirstJavaDefinedKeywordUsage(method);
        return firstUsage.isPresent();
    }

    @Override
    public boolean isImplicitRead(PsiElement element) {
        return false;
    }

    @Override
    public boolean isImplicitWrite(PsiElement element) {
        return false;
    }
}
