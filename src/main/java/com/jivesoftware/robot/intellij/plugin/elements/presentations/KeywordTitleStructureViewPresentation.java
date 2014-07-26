package com.jivesoftware.robot.intellij.plugin.elements.presentations;

import com.intellij.navigation.ItemPresentation;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Defines the presentation of a KeywordTitle (the title line of a user-defined Keyword) for Structure View.
 */
public class KeywordTitleStructureViewPresentation implements ItemPresentation {
    private final RobotKeywordTitle title;

    public KeywordTitleStructureViewPresentation(@NotNull RobotKeywordTitle title) {
        this.title = title;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return title.getText();
    }

    @Nullable
    @Override
    public String getLocationString() {
        return null;
    }

    @Nullable
    @Override
    public Icon getIcon(boolean b) {
        return RobotIcons.KEYWORD;
    }
}
