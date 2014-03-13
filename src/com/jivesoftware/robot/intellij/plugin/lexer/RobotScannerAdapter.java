package com.jivesoftware.robot.intellij.plugin.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class RobotScannerAdapter extends FlexAdapter {
  public RobotScannerAdapter() {
    super(new RobotScanner((Reader) null));
  }
}
