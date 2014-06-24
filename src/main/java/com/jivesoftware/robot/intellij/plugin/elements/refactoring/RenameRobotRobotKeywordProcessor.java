package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.intellij.psi.PsiElement;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Created by charles.capps on 6/5/14.
 * <p/>
 * Enable renaming Robot-defined Robot Keywords, and having this propagate to all usages in Robot files.
 */
public class RenameRobotRobotKeywordProcessor extends RenamePsiElementProcessor {
    @Override
    public boolean canProcessElement(@NotNull PsiElement psiElement) {
        return psiElement instanceof RobotKeywordDef;
    }

    @Override
    public void prepareRenaming(final PsiElement element, final String newName,
                                final Map<PsiElement, String> allRenames) {
        if (!canProcessElement(element)) {
            return;
        }
        final RobotKeywordDef robotKeywordDef = (RobotKeywordDef) element;
        final String name = robotKeywordDef.getName();
        final List<RobotKeyword> robotKeywords = RobotPsiUtil.findKeywordUsagesByName(name, robotKeywordDef.getProject());
        final String robotName = RobotPsiUtil.methodToRobotKeyword(newName);
        for (RobotKeyword robotKeyword : robotKeywords) {
            allRenames.put(robotKeyword, robotName);
        }
    }
}
