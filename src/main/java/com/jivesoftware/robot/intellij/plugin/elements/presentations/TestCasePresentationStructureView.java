package com.jivesoftware.robot.intellij.plugin.elements.presentations;

import com.intellij.navigation.ItemPresentation;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by charles on 6/5/14.
 */
public class TestCasePresentationStructureView implements ItemPresentation {
    private final RobotTestCase robotTestCase;

    public TestCasePresentationStructureView(RobotTestCase robotTestCase) {
        this.robotTestCase = robotTestCase;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return String.format("%s", robotTestCase.getNameIdentifier().getText());
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
