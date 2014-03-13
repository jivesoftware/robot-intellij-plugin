package com.jivesoftware.robot.intellij.plugin.elements;

public class GeneralUtil {
  public static String robotKeywordToMethod(String keyword) {
    String[] tokens = keyword.split(" ");
    if (tokens.length == 1) {
      return tokens[0].trim();
    }
    StringBuffer buffer = new StringBuffer();
    for (int i = 0 ; i < tokens.length; i++) {
      String token = tokens[i].trim();
      if (i == 0) {
        buffer.append(token.substring(0, 1).toLowerCase() + token.substring(1));
      } else {
        buffer.append(token.substring(0, 1).toUpperCase() + token.substring(1));
      }
    }
    return buffer.toString();
  }

  public static String robotKeywordToMethodFast(String keyword) {
    return keyword.replace(" ", "");
  }
}
