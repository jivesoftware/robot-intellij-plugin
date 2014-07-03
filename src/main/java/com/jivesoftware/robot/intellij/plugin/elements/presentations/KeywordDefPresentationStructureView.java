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
public class KeywordDefPresentationStructureView implements ItemPresentation {
    private final RobotKeywordTitle title;

    public KeywordDefPresentationStructureView(@NotNull RobotKeywordTitle title) {
        this.title = title;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return String.format("%s", title.getText());
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
