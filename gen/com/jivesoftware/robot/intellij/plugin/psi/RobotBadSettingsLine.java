// This is a generated file. Not intended for manual editing.
package com.jivesoftware.robot.intellij.plugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;

public interface RobotBadSettingsLine extends PsiErrorElement {

  @NotNull
  List<RobotTestSetupToken> getTestSetupTokenList();

  String getErrorDescription();

}
