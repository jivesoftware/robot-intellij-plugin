package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordArg;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class RobotKeywordArgProcessor implements Processor<RobotKeywordArg> {
    private final List<RobotKeywordArg> results = Lists.newArrayList();
    private final String expectedNormalizedName;
    private final boolean findAll;

    public RobotKeywordArgProcessor(String expectedNormalizedName, boolean findAll) {
        Preconditions.checkArgument(expectedNormalizedName.equals(expectedNormalizedName.toLowerCase()), "Normalized keyword name cannot contain uppercase letters!");
        this.expectedNormalizedName = expectedNormalizedName;
        this.findAll = findAll;
    }

    @Override
    public boolean process(RobotKeywordArg robotKeyword) {
        final String normalized = RobotPsiUtil.normalizeRobotDefinedKeywordForIndex(robotKeyword.getName());
        if (normalized.equals(expectedNormalizedName)) {
            results.add(robotKeyword);
        } else {
            System.err.printf(
                    "Error: Keyword retrieved from index did not have the expected normalized value: found '%s' expected '%s'",
                    normalized, expectedNormalizedName);
        }
        return results.isEmpty() || findAll;
    }

    public List<RobotKeywordArg> getResults() {
        return results;
    }
}
