package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.intellij.psi.PsiElement;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordTitle;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class RobotKeywordDefProcessor implements Processor<RobotKeywordTitle> {
    private final List<PsiElement> results;
    private final SearchType searchType;
    private final String normalizedSearchTerm;

    public RobotKeywordDefProcessor(List<PsiElement> results, SearchType searchType, String searchTerm) {
        this.results = results;
        this.searchType = searchType;
        this.normalizedSearchTerm = RobotPsiUtil.normalizeKeywordForIndex(searchTerm);
    }

    @Override
    public boolean process(RobotKeywordTitle robotKeywordTitle) {
        if (include(robotKeywordTitle)) {
            results.add(robotKeywordTitle);
            return doContinue();
        }
        return doContinue();
    }

    private boolean doContinue() {
        return searchType == SearchType.FIND_ALL || searchType == SearchType.STARTS_WITH || results.isEmpty();
    }

    private boolean include(RobotKeywordTitle robotKeywordTitle) {
        if (searchType == SearchType.FIND_ALL) {
            return true;
        }
        final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(robotKeywordTitle.getName());
        if (searchType == SearchType.EXACT_MATCH) {
            return normalizedName.equals(normalizedSearchTerm);
        } else if (searchType == SearchType.STARTS_WITH) {
            return normalizedName.startsWith(normalizedSearchTerm);
        }
        throw new RuntimeException("Must account for all values of SearchType in RobotKeywordDefProcessor!");
    }

}
