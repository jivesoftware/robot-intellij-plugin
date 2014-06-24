package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.intellij.psi.PsiElement;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;

import java.util.List;

/**
 * Created by charles on 6/9/14.
 */
public class RobotKeywordDefProcessor implements Processor<RobotKeywordDef> {
    private final List<PsiElement> results;
    private final SearchType searchType;
    private final String normalizedSearchTerm;

    public RobotKeywordDefProcessor(List<PsiElement> results, SearchType searchType, String searchTerm) {
        this.results = results;
        this.searchType = searchType;
        this.normalizedSearchTerm = RobotPsiUtil.normalizeKeywordForIndex(searchTerm);
    }

    @Override
    public boolean process(RobotKeywordDef robotKeywordDef) {
        if (include(robotKeywordDef)) {
            results.add(robotKeywordDef);
            return doContinue();
        }
        return doContinue();
    }

    private boolean doContinue() {
        return searchType == SearchType.FIND_ALL || searchType == SearchType.STARTS_WITH || results.isEmpty();
    }

    private boolean include(RobotKeywordDef def) {
        if (searchType == SearchType.FIND_ALL) {
            return true;
        }
        final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(def.getName());
        if (searchType == SearchType.EXACT_MATCH) {
            return normalizedName.equals(normalizedSearchTerm);
        } else if (searchType == SearchType.STARTS_WITH) {
            return normalizedName.startsWith(normalizedSearchTerm);
        }
        throw new RuntimeException("Must account for all values of SearchType in RobotKeywordDefProcessor!");
    }

}
