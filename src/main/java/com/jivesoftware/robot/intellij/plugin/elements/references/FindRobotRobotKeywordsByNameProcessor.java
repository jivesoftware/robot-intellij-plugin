package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.psi.PsiFile;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class FindRobotRobotKeywordsByNameProcessor implements Processor<PsiFile> {
    private final List<RobotKeywordDef> results = Lists.newArrayList();
    private final String keywordName;

    public FindRobotRobotKeywordsByNameProcessor(String keywordName) {
        this.keywordName = keywordName;
    }

    @Override
    public boolean process(PsiFile psiFile) {
        RobotPsiUtil.findKeywordDefsInFileByName(psiFile, keywordName, results);
        return results.size() == 0;
    }

    public List<RobotKeywordDef> getResults() {
        return results;
    }
}
