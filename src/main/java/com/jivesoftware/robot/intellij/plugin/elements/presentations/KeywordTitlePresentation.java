package com.jivesoftware.robot.intellij.plugin.elements.presentations;

import com.intellij.navigation.ItemPresentation;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by charles on 6/5/14.
 */
public class KeywordTitlePresentation implements ItemPresentation {
    private final RobotKeywordTitle robotKeywordTitle;

    public KeywordTitlePresentation(@NotNull RobotKeywordTitle robotKeywordTitle) {
        this.robotKeywordTitle = robotKeywordTitle;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return String.format("Robot Keyword: %s", robotKeywordTitle.getText());
    }

    @Nullable
    @Override
    public String getLocationString() {
        if (robotKeywordTitle.getContainingFile() == null) {
            return null;
        }
        return robotKeywordTitle.getContainingFile().getName();
    }

    @Nullable
    @Override
    public Icon getIcon(boolean b) {
        return RobotIcons.ROBOT;
    }
}
