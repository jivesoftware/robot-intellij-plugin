package com.jivesoftware.robot.intellij.plugin.actions;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDirectory;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;

import javax.swing.*;

/**
 * Action to create a new Robot file from a simple template file.
 */
public class NewRobotFileAction extends CreateFileFromTemplateAction {
  public NewRobotFileAction() {
    super("NewRobotFile.robot", "Create a new robot test case file", RobotIcons.ROBOT);
  }

  public NewRobotFileAction(String text, String description, Icon icon) {
    super(text, description, icon);
  }

  @Override
  protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
    builder
        .setTitle("New Robot File")
        .addKind("Robot Test Case File", RobotIcons.ROBOT, "RobotTestCaseFile")
        .addKind("Robot Keywords File", RobotIcons.ROBOT, "RobotKeywordsFile");

  }

  @Override
  protected String getActionName(PsiDirectory directory, String newName, String templateName) {
    return String.format("Create Robot file %s", newName);
  }
}
