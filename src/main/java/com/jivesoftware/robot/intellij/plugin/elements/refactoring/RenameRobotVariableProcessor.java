package com.jivesoftware.robot.intellij.plugin.elements.refactoring;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiMethod;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import com.intellij.util.containers.MultiMap;
import com.jivesoftware.robot.intellij.plugin.elements.references.RobotVariableReference;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariableInfo;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariablePsiUtil;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import com.jivesoftware.robot.intellij.plugin.psi.RobotVariable;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

/**
 * Created by charles on 7/20/14.
 */
public class RenameRobotVariableProcessor extends RenamePsiElementProcessor {
    @Override
    public boolean canProcessElement(@NotNull PsiElement element) {
        PsiFile file = element.getContainingFile();
        if (!(file instanceof RobotPsiFile)) {
            return false;
        }
        Optional<String> optVariableName = VariablePsiUtil.getVariableName(element);
        return optVariableName.isPresent();
    }

    @Override
    public void prepareRenaming(final PsiElement element, final String newName,
                                final Map<PsiElement, String> allRenames) {

        RobotVariableReference ref = new RobotVariableReference(element);
        PsiElement resolvesTo = ref.resolve();
        if (resolvesTo == null) {
            resolvesTo = element;
        }
        List<PsiElement> usages = VariablePsiUtil.findVariableUsages(resolvesTo);

        for (PsiElement usage : usages) {
            allRenames.put(usage, newName);
        }
    }

    @Override
    public void findExistingNameConflicts(PsiElement element, String newName, MultiMap<PsiElement, String> conflicts) {
        final String newNormalName = RobotPsiUtil.normalizeKeywordForIndex(newName);

        Map<String, VariableInfo> env = VariablePsiUtil.getVariableEnvironment((RobotPsiFile)element.getContainingFile());

        VariableInfo existingDef = env.get(newNormalName);

        if (existingDef != null) {
            conflicts.put(existingDef.getDefinition(), Lists.newArrayList(newName));
        }

    }
}
