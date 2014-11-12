package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.collect.Lists;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by charles on 6/9/14.
 */
public class RobotKeywordEmbeddedArgsProcessor implements Processor<RobotKeyword> {
    private final List<RobotKeyword> results = Lists.newArrayList();
    private final Pattern expectedRegex;
    private final boolean findAll;

    public RobotKeywordEmbeddedArgsProcessor(Pattern expectedRegex, boolean findAll) {
        this.expectedRegex = expectedRegex;
        this.findAll = findAll;
    }

    @Override
    public boolean process(RobotKeyword robotKeyword) {
        final String normalized = RobotPsiUtil.normalizeEmbeddedArgKeyword(robotKeyword.getName());
        final Matcher matcher = expectedRegex.matcher(normalized);
        if (matcher.matches()) {
            results.add(robotKeyword);
        }
        return results.isEmpty() || findAll;
    }

    public List<RobotKeyword> getResults() {
        return results;
    }
}
