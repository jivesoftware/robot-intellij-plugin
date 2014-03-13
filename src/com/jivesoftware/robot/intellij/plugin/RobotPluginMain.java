package com.jivesoftware.robot.intellij.plugin;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.psi.ElementManipulators;
import com.jivesoftware.robot.intellij.plugin.elements.TrivialManipulator;
import com.jivesoftware.robot.intellij.plugin.psi.RobotRobotKeywordEl;
import com.jivesoftware.robot.intellij.plugin.psi.RobotRobotOtherEl;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotRobotKeywordElImpl;
import com.jivesoftware.robot.intellij.plugin.psi.impl.RobotRobotOtherElImpl;
import org.jetbrains.annotations.NotNull;

public class RobotPluginMain implements ApplicationComponent {
  public void initComponent() {
    ApplicationManager.getApplication().runWriteAction(new Runnable() {
      public void run() {
        ElementManipulators.INSTANCE.addExplicitExtension(RobotRobotKeywordEl.class, new TrivialManipulator());
        ElementManipulators.INSTANCE.addExplicitExtension(RobotRobotKeywordElImpl.class, new TrivialManipulator());
        ElementManipulators.INSTANCE.addExplicitExtension(RobotRobotOtherEl.class, new TrivialManipulator());
        ElementManipulators.INSTANCE.addExplicitExtension(RobotRobotOtherElImpl.class, new TrivialManipulator());
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
