package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.google.common.collect.Lists;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.util.containers.MultiMap;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotNamedElement;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotJavaPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Created by charles.capps on 6/5/14.
 * <p/>
 * Enable renaming Java-defined Robot Keywords, and having this propagate to all usages in Robot files.
 */
public class RenameJavaRobotKeywordProcessor extends RenamePsiElementProcessor {
    @Override
    public boolean canProcessElement(@NotNull PsiElement psiElement) {
        return RobotJavaPsiUtil.isJavaRobotKeyword(psiElement);
    }

    @Override
    public void prepareRenaming(final PsiElement element, final String newName,
                                final Map<PsiElement, String> allRenames) {
        PsiMethod psiMethod = (PsiMethod) element;
        List<RobotNamedElement> usagesInRobot = RobotPsiUtil.findJavaDefinedKeywordUsages(psiMethod);
        final String robotName = RobotPsiUtil.methodToRobotKeyword(newName);
        for (RobotNamedElement usage : usagesInRobot) {
            allRenames.put(usage, robotName);
        }
    }

    @Override
    public void findExistingNameConflicts(PsiElement element, String newName, MultiMap<PsiElement, String> conflicts) {
        String robotName = RobotPsiUtil.methodToRobotKeyword(newName);
        List<PsiElement> conflictingDefs = Lists.newArrayList();
        RobotPsiUtil.findKeywordDefsByName(robotName, element.getProject(), conflictingDefs);
        for (PsiElement def : conflictingDefs) {
            conflicts.put(def, Lists.newArrayList(newName));
        }
    }
}
