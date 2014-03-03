/*
 * Copyright 2010 - 2012 Ed Venaglia
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
import com.intellij.psi.tree.IFileElementType;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * User: ed
 * Date: Jul 31, 2010
 * Time: 9:50:44 AM
 *
 * IntelliJ file type to represent the closure template language used in soy
 * files.
 */
public class RobotFileType extends LanguageFileType {

    public static final RobotFileType INSTANCE = new RobotFileType();
    public static final IFileElementType FILE = new IFileElementType("Robot File Type", RobotLanguage.INSTANCE);

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
        return RobotIcons.FILE;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
