package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.psi.RobotTestCase;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class RobotTestCaseProcessor implements Processor<RobotTestCase> {
    private final List<RobotTestCase> results;
    private final SearchType searchType;
    private final String normalizedSearchTerm;

    public RobotTestCaseProcessor(List<RobotTestCase> results, SearchType searchType, String searchTerm) {
        this.results = results;
        this.searchType = searchType;
        this.normalizedSearchTerm = RobotPsiUtil.normalizeKeywordForIndex(searchTerm);
    }

    @Override
    public boolean process(RobotTestCase robotTestCase) {
        if (include(robotTestCase)) {
            results.add(robotTestCase);
            return doContinue();
        }
        return doContinue();
    }

    private boolean doContinue() {
        return searchType == SearchType.FIND_ALL || searchType == SearchType.STARTS_WITH || results.isEmpty();
    }

    private boolean include(RobotTestCase robotTestCase) {
        if (searchType == SearchType.FIND_ALL) {
            return true;
        }
        final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(robotTestCase.getName());
        if (searchType == SearchType.FIRST_EXACT_MATCH) {
            return normalizedName.equals(normalizedSearchTerm);
        } else if (searchType == SearchType.STARTS_WITH) {
            return normalizedName.startsWith(normalizedSearchTerm);
        }
        throw new RuntimeException("Must account for all values of SearchType in RobotTestCaseProcessor!");
    }

}
