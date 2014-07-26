package com.jivesoftware.robot.intellij.plugin.elements.presentations;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Defines the pretty presentation for various contexts of a Robot Test Case.
 */
public class TestCasePresentation implements ItemPresentation {
    private final RobotTestCase robotTestCase;

    public TestCasePresentation(RobotTestCase robotTestCase) {
        this.robotTestCase = robotTestCase;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return String.format("Robot Test: %s", robotTestCase.getName());
    }

    @Nullable
    @Override
    public String getLocationString() {
        if (robotTestCase.getContainingFile() == null) {
            return null;
        }
        return robotTestCase.getContainingFile().getName();
    }

    @Nullable
    @Override
    public Icon getIcon(boolean b) {
        return RobotIcons.ROBOT;
    }
}
