package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.collect.Maps;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotFileReference;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by charles on 7/13/14.
 */
public class VariablePsiUtil {
    public static final Pattern VARIABLE_PATTERN = Pattern.compile("\\$\\{ ?([^\\{\\}]+) ?\\}");

    public static Optional<String> getVariableName(@NotNull PsiElement element) {
        String text = element.getText();
        Matcher matcher = VARIABLE_PATTERN.matcher(text);
        if (matcher.find()) {
            return Optional.of(matcher.group(1));
        }
        return Optional.absent();
    }

    public static Map<String, String> getVariableEnvironment(@NotNull RobotPsiFile file, Map<String, String> env) {
        env = getVariableEnvironmentCurrentFile(file, env);

        RobotTable[] tables = file.findChildrenByClass(RobotTable.class);
        for (RobotTable table: tables) {
            if (table.getSettingsTable() == null) {
                continue;
            }
            RobotSettingsTable settingsTable = table.getSettingsTable();
            Collection<RobotResourceSetting> resourceSettings = PsiTreeUtil.findChildrenOfType(settingsTable, RobotResourceSetting.class);
            for (RobotResourceSetting resourceSetting : resourceSettings) {
                RobotResourceFile robotResourceFile = resourceSetting.getResourceFile();
                RobotFileReference robotFileReference = new RobotFileReference(robotResourceFile);
                PsiElement resourceFile = robotFileReference.resolve(env);
                if (resourceFile instanceof RobotPsiFile) {
                    RobotPsiFile robotPsiFile = (RobotPsiFile) resourceFile;
                    env = getVariableEnvironment(robotPsiFile, env);
                }
            }
        }
        return env;
    }

    private static Map<String, String> getVariableEnvironmentCurrentFile(@NotNull RobotPsiFile file, Map<String, String> env) {
        RobotTable[] tables = file.findChildrenByClass(RobotTable.class);
        for (RobotTable table: tables) {
            if (table.getVariablesTable() == null) {
                continue;
            }
            RobotVariablesTable robotVariablesTable = table.getVariablesTable();
            for (RobotVariablesLine line: robotVariablesTable.getVariablesLineList()) {
                if (line.getScalarAssignmentLhs() == null) {
                    continue;
                }
                RobotScalarAssignmentLhs lhs = line.getScalarAssignmentLhs();
                Optional<String> varNameOpt = getVariableName(lhs);
                if (!varNameOpt.isPresent()) {
                    continue;
                }

                if (line.getAssignableInVariablesTbl() == null) {
                    continue;
                }
                String varName = varNameOpt.get();
                String normalVarName = RobotPsiUtil.normalizeKeywordForIndex(varName);

                String varValue = line.getAssignableInVariablesTbl().getKeywordArg().getText();
                String actualValue = substitute(varValue, env);

                env.put(normalVarName, actualValue);
            }
        }
        return env;
    }

    public static String substitute(String varValue, Map<String, String> env) {
        String newValue = varValue;
        Matcher matcher = VARIABLE_PATTERN.matcher(varValue);
        while (matcher.find()) {
            String varName = matcher.group(1);
            String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(varName);
            String envValue = env.get(normalizedName);
            if (envValue != null) {
                newValue = newValue.replace(matcher.group(0), envValue);
            }
        }
        return newValue;
    }
}
