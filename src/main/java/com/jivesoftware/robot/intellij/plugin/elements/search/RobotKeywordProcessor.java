package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class RobotKeywordProcessor implements Processor<RobotKeyword> {
    private final List<RobotKeyword> results = Lists.newArrayList();
    private final String expectedNormalizedName;
    private final boolean findAll;

    public RobotKeywordProcessor(String expectedNormalizedName, boolean findAll) {
        Preconditions.checkArgument(!expectedNormalizedName.contains(" "), "Normalized Keyword name cannot contain spaces!");
        Preconditions.checkArgument(expectedNormalizedName.equals(expectedNormalizedName.toLowerCase()), "Normalized keyword name cannot contain uppercase letters!");
        this.expectedNormalizedName = expectedNormalizedName;
        this.findAll = findAll;
    }

    @Override
    public boolean process(RobotKeyword robotKeyword) {
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

    public List<RobotKeyword> getResults() {
        return results;
    }
}
