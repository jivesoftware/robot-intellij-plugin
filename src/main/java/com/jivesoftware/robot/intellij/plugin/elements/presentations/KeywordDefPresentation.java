package com.jivesoftware.robot.intellij.plugin.elements.presentations;

import com.intellij.navigation.ItemPresentation;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by charles on 6/5/14.
 */
public class KeywordDefPresentation implements ItemPresentation {
    private final RobotKeywordDef def;

    public KeywordDefPresentation(@NotNull RobotKeywordDef def) {
        this.def = def;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return String.format("Robot Keyword: %s", def.getText());
    }

    @Nullable
    @Override
    public String getLocationString() {
        if (def.getContainingFile() == null) {
            return null;
        }
        return def.getContainingFile().getName();
    }

    @Nullable
    @Override
    public Icon getIcon(boolean b) {
        return RobotIcons.ROBOT;
    }
}
