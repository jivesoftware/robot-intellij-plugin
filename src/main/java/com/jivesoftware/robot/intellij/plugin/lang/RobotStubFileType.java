package com.jivesoftware.robot.intellij.plugin.lang;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IStubFileElementType;

/**
 * Created by charles on 6/21/14.
 */
public class RobotStubFileType extends IStubFileElementType<RobotPsiFileStub> {
    public RobotStubFileType(Language language) {
        super(language);
    }
}
