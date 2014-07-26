package com.jivesoftware.robot.intellij.plugin.elements.presentations;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Defines the presentation for a Test Case when displayed in Structure View.
 */
public class TestCaseStructureViewPresentation implements ItemPresentation {
    private final RobotTestCase robotTestCase;

    public TestCaseStructureViewPresentation(RobotTestCase robotTestCase) {
        this.robotTestCase = robotTestCase;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return robotTestCase.getName();
    }

    @Nullable
    @Override
    public String getLocationString() {
        return null;
    }

    @Nullable
    @Override
    public Icon getIcon(boolean b) {
        return RobotIcons.ROBOT;
    }
}
