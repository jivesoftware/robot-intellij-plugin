package com.jivesoftware.robot.intellij.plugin.lang;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class RobotPsiFile extends PsiFileBase {

  public RobotPsiFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, RobotLanguage.INSTANCE);
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return RobotFileType.INSTANCE;
  }

  @Override
  public Icon getIcon(int flags) {
    return super.getIcon(flags);
  }
}
