/*
 * Copyright 2014 Charles Capps
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.jivesoftware.robot.intellij.plugin.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * IntelliJ file type to represent Robot test case files (.robot extension).
 */
public class RobotFileType extends LanguageFileType {

    public static final RobotFileType INSTANCE = new RobotFileType();

    private RobotFileType() {
        super(RobotLanguage.INSTANCE);
    }

    @NotNull
    public String getName() {
        return "Robot Test Case File";
    }

    @NotNull
    public String getDescription() {
        return "Text file used by Robot Framework to define test cases in the Robot DSL.";
    }

    @NotNull
    public String getDefaultExtension() {
        return "robot";
    }

    public Icon getIcon() {
        return RobotIcons.ROBOT;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
