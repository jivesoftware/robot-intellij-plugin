package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.util.PsiTreeUtil;
import com.jivesoftware.robot.intellij.plugin.psi.*;

import java.util.Collection;

/**
 * Created by charles on 6/11/14.
 */
public class PresentationPsiUtil {
    public static String getPresentableMethodParametersText(PsiMethod method) {
        String parameterText = method.getParameterList().getText();
        return parameterText.replaceAll("\\s+", " ");
    }

    public static String getRobotKeywordArgumentTest(RobotKeywordTitle def) {
        PsiElement parent = def.getParent();
        if (!(parent instanceof RobotKeywordDefinitionHeader)) {
            return "";
        }
        PsiElement parentParent = parent.getParent();
        if (!(parentParent instanceof RobotKeywordDefinition)) {
            return "";
        }
        RobotKeywordDefinition robotKeywordDefinition = (RobotKeywordDefinition) parentParent;
        Collection<RobotKeywordSettingLine> settings = PsiTreeUtil.findChildrenOfType(robotKeywordDefinition, RobotKeywordSettingLine.class);
        for (RobotKeywordSettingLine line: settings) {
            RobotKeywordSetting setting = line.getKeywordSetting();
            RobotArgumentsSetting args = setting.getArgumentsSetting();
            if (args == null) {
                continue;
            }
            return args.getText().replaceAll("\\s+", " ");
        }
        return "";
    }
}
