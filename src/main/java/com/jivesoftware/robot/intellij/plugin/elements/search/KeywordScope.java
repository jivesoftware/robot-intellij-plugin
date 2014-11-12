package com.jivesoftware.robot.intellij.plugin.elements.search;

/**
* Created by charles.capps on 6/24/14.
*/
public enum KeywordScope {
    ROBOT_KEYWORDS, JAVA_KEYWORDS, ROBOT_AND_JAVA_KEYWORDS;

    public boolean includesRobotFiles() {
        return this == ROBOT_KEYWORDS || this == ROBOT_AND_JAVA_KEYWORDS;
    }

    public boolean includesJavaFiles() {
        return this == JAVA_KEYWORDS || this == ROBOT_AND_JAVA_KEYWORDS;
    }
}
