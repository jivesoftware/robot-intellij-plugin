package com.jivesoftware.robot.intellij.plugin.elements.structureview;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.TextEditorBasedStructureViewModel;
import com.intellij.psi.PsiFile;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;

/**
 * Created by charles on 6/5/14.
 */
public class RobotStructureViewModel extends TextEditorBasedStructureViewModel {

    public RobotStructureViewModel(PsiFile psiFile) {
        super(psiFile);
    }

    @NotNull
    @Override
    public StructureViewTreeElement getRoot() {
        return new RobotStructureViewTreeElement(getPsiFile());
    }

    @Override
    @NotNull
    public Class[] getSuitableClasses() {
        return new Class[] {RobotPsiFile.class, RobotTestCasesTable.class, RobotKeywordsTable.class, RobotSettingsTable.class, RobotVariablesTable.class,
                RobotKeyword.class, RobotKeywordDef.class, RobotTestCase.class};
    }
}
