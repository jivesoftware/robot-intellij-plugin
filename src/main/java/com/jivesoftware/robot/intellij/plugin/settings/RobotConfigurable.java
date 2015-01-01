package com.jivesoftware.robot.intellij.plugin.settings;

import com.intellij.ide.DataManager;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectUtil;
import org.jdesktop.swingx.VerticalLayout;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by charlescapps on 12/29/14.
 */
public class RobotConfigurable implements Configurable {
    public static final String HIGHLIGHT_INVALID_KEYWORDS = "robot.plugin.highlight_invalid_keywords";
    public static final String AUTOCOMPLETE_KEYWORDS_STRICT = "robot.plugin.autocomplete_keywords_strict";

    private JPanel robotPanel;
    private JCheckBox myHighlightInvalidKeywords;
    private JCheckBox myAutocompleteRobotKeywordsStrict;
    private final Project myProject;

    public RobotConfigurable(Project project) {
        myProject = project;
    }

    public static boolean isHighlightInvalidKeywords(Project project) {
        PropertiesComponent pc = PropertiesComponent.getInstance(project);
        return pc.getBoolean(HIGHLIGHT_INVALID_KEYWORDS, false);
    }

    public static boolean isAutocompleteKeywordsStrict(Project project) {
        PropertiesComponent pc = PropertiesComponent.getInstance(project);
        return pc.getBoolean(AUTOCOMPLETE_KEYWORDS_STRICT, false);
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Robot";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return "Robot";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        myHighlightInvalidKeywords = new JCheckBox("Highlight invalid Robot Keywords?");
        myAutocompleteRobotKeywordsStrict = new JCheckBox("Only autocomplete Robot Keywords that are in scope?");
        robotPanel = new JPanel(new VerticalLayout(20));
        robotPanel.add(myHighlightInvalidKeywords);
        robotPanel.add(myAutocompleteRobotKeywordsStrict);
        return robotPanel;
    }

    @Override
    public boolean isModified() {
        PropertiesComponent pc = getPropertiesComponentForProject();
        boolean storedHighlightValue = pc.getBoolean(HIGHLIGHT_INVALID_KEYWORDS, false);
        boolean storedStrictAutocompleteValue = pc.getBoolean(AUTOCOMPLETE_KEYWORDS_STRICT, false);
        return storedHighlightValue != myHighlightInvalidKeywords.isSelected() ||
               storedStrictAutocompleteValue != myAutocompleteRobotKeywordsStrict.isSelected();
    }

    @Override
    public void apply() throws ConfigurationException {
        boolean currentHighlightValue = myHighlightInvalidKeywords.isSelected();
        boolean currentAutocompleteStrictValue = myAutocompleteRobotKeywordsStrict.isSelected();
        PropertiesComponent pc = getPropertiesComponentForProject();
        pc.setValue(HIGHLIGHT_INVALID_KEYWORDS, String.valueOf(currentHighlightValue));
        pc.setValue(AUTOCOMPLETE_KEYWORDS_STRICT, String.valueOf(currentAutocompleteStrictValue));
    }

    @Override
    public void reset() {
        PropertiesComponent pc = getPropertiesComponentForProject();
        boolean storedHighlight = pc.getBoolean(HIGHLIGHT_INVALID_KEYWORDS, false);
        boolean storedAutocompleteStrict = pc.getBoolean(AUTOCOMPLETE_KEYWORDS_STRICT, false);
        myHighlightInvalidKeywords.setSelected(storedHighlight);
        myAutocompleteRobotKeywordsStrict.setSelected(storedAutocompleteStrict);
    }

    @Override
    public void disposeUIResources() {
        robotPanel = null;
        myHighlightInvalidKeywords = myAutocompleteRobotKeywordsStrict = null;
    }

    // ------------ Private -------------
    private PropertiesComponent getPropertiesComponentForProject() {
        return PropertiesComponent.getInstance(myProject);
    }
}
