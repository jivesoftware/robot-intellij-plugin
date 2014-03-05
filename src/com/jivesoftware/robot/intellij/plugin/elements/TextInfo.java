package com.jivesoftware.robot.intellij.plugin.elements;

import com.intellij.openapi.util.TextRange;

public class TextInfo {

  public TextInfo(int textOffset, String text) {
    this.startTextOffset = textOffset;
    this.text = text;
  }

  private final int startTextOffset;
  private final String text;

  public int getTextOffset() {
    return startTextOffset;
  }

  public int getEndTextOffset() {
    return startTextOffset + text.length();
  }

  public TextRange getTextRange() {
    return new TextRange(startTextOffset, startTextOffset + text.length());
  }

  public String getText() {
    return text;
  }

}
