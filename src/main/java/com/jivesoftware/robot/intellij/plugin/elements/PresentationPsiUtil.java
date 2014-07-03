package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.jivesoftware.robot.intellij.plugin.psi.*;

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
        RobotKeywordSettings settings = robotKeywordDefinition.getKeywordSettings();
        for (RobotKeywordSettingLine line: settings.getKeywordSettingLineList()) {
            RobotKeywordSetting setting = line.getKeywordSetting();
            if (setting == null) {
                continue;
            }
            RobotArgumentsSetting args = setting.getArgumentsSetting();
            if (args == null) {
                continue;
            }
            return args.getText().replaceAll("\\s+", " ");
        }
        return "";
    }
}
