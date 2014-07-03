package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.collect.Lists;
import com.intellij.psi.PsiFile;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class FindRobotKeywordsUsagesByNameProcessor implements Processor<PsiFile> {
    private final List<RobotKeyword> results = Lists.newArrayList();
    private final String keywordName;
    private final boolean findAll;

    public FindRobotKeywordsUsagesByNameProcessor(String keywordName, boolean findAll) {
        this.keywordName = keywordName;
        this.findAll = findAll;
    }

    @Override
    public boolean process(PsiFile psiFile) {
        RobotPsiUtil.findKeywordUsagesInFileByName(psiFile, keywordName, results);
        return results.size() == 0 || findAll;
    }

    public List<RobotKeyword> getResults() {
        return results;
    }
}
