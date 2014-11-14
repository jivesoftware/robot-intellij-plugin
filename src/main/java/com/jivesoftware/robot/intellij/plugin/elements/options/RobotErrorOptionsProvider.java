package com.jivesoftware.robot.intellij.plugin.elements.options;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.profile.codeInspection.ui.ErrorOptionsProvider;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by charlescapps on 11/13/14.
 */
public class RobotErrorOptionsProvider implements ErrorOptionsProvider {
    public static final String HIGHLIGHT_INVALID_KEYWORDS = "robot.plugin.highlight_invalid_keywords";

    private JCheckBox mySuppressInvalidKeywords;

    @Nullable
    @Override
    public JComponent createComponent() {
        mySuppressInvalidKeywords = new JCheckBox("Highlight invalid Robot Keywords?");
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(mySuppressInvalidKeywords, BorderLayout.EAST);
        return panel;
    }

    @Override
    public boolean isModified() {
        boolean currentValue = mySuppressInvalidKeywords.isSelected();
        PropertiesComponent pc = PropertiesComponent.getInstance();
        boolean storedValue = pc.getBoolean(HIGHLIGHT_INVALID_KEYWORDS, false);
        return currentValue != storedValue;
    }

    @Override
    public void apply() throws ConfigurationException {
        boolean currentValue = mySuppressInvalidKeywords.isSelected();
        PropertiesComponent pc = PropertiesComponent.getInstance();
        pc.setValue(HIGHLIGHT_INVALID_KEYWORDS, String.valueOf(currentValue));
    }

    @Override
    public void reset() {
        PropertiesComponent pc = PropertiesComponent.getInstance();
        boolean storedValue = pc.getBoolean(HIGHLIGHT_INVALID_KEYWORDS, false);
        mySuppressInvalidKeywords.setSelected(storedValue);
    }

    @Override
    public void disposeUIResources() {
        mySuppressInvalidKeywords = null;
    }
}
