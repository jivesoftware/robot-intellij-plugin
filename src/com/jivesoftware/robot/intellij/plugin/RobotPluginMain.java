package com.jivesoftware.robot.intellij.plugin;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import org.jetbrains.annotations.NotNull;

public class RobotPluginMain implements ApplicationComponent {
  public void initComponent() {
    ApplicationManager.getApplication().runWriteAction(new Runnable() {
      public void run() {

      }
    });
  }

  public void disposeComponent() {
    // TODO: insert component disposal logic here
  }

  @NotNull
  public String getComponentName() {
    return "RobotPlugin";
  }
}
