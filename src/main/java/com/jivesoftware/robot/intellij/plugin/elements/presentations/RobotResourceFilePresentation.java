package com.jivesoftware.robot.intellij.plugin.elements.presentations;

import com.intellij.navigation.ItemPresentation;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotResourceFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Defines the pretty presentation for various contexts of a RobotResourceFile- the text after the "Resource" setting
 * that specifies a Robot file to include as a Resource.
 */
public class RobotResourceFilePresentation implements ItemPresentation {
    private final RobotResourceFile robotResourceFile;

    public RobotResourceFilePresentation(@NotNull RobotResourceFile robotResourceFile) {
        this.robotResourceFile = robotResourceFile;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        String location = getLocationString();
        if (location == null) {
            return String.format("Resource Setting: %s", robotResourceFile.getText());
        }
        return String.format("Resource Setting: %s (%s)", robotResourceFile.getText(), location);
    }

    @Nullable
    @Override
    public String getLocationString() {
        if (robotResourceFile.getContainingFile() == null) {
            return null;
        }
        return robotResourceFile.getContainingFile().getName();
    }

    @Nullable
    @Override
    public Icon getIcon(boolean b) {
        return RobotIcons.ROBOT;
    }
}
