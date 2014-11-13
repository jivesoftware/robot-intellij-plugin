package com.jivesoftware.robot.intellij.plugin.elements;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;

import java.util.List;
import java.util.Set;

/**
 * Created by charlescapps on 11/12/14.
 */
public class RobotBuiltInKeywords {

    public static final List<String> BUILD_IN_KEYWORDS = ImmutableList.<String>builder().add(
            "Catenate",
            "Comment",
            "Continue For Loop",
            "Continue For Loop If",
            "Convert To Binary",
            "Convert To Boolean",
            "Convert To Bytes",
            "Convert To Hex",
            "Convert To Integer",
            "Convert To Number",
            "Convert To Octal",
            "Convert To String",
            "Create List",
            "Evaluate",
            "Exit For Loop",
            "Exit For Loop If",
            "Fail",
            "Fatal Error",
            "Get Count",
            "Get Length",
            "Get Library Instance",
            "Get Time",
            "Get Variable Value",
            "Get Variables",
            "Import Library",
            "Import Resource",
            "Import Variables",
            "Keyword Should Exist",
            "Length Should Be",
            "Log",
            "Log Many",
            "Log To Console",
            "Log Variables",
            "No Operation",
            "Pass Execution",
            "Pass Execution If",
            "Regexp Escape",
            "Remove Tags",
            "Repeat Keyword",
            "Replace Variables",
            "Return From Keyword",
            "Return From Keyword If",
            "Run Keyword",
            "Run Keyword And Continue On Failure",
            "Run Keyword And Expect Error",
            "Run Keyword And Ignore Error",
            "Run Keyword And Return",
            "Run Keyword And Return If",
            "Run Keyword And Return Status",
            "Run Keyword If",
            "Run Keyword If All Critical Tests Passed",
            "Run Keyword If All Tests Passed",
            "Run Keyword If Any Critical Tests Failed",
            "Run Keyword If Any Tests Failed",
            "Run Keyword If Test Failed",
            "Run Keyword If Test Passed",
            "Run Keyword If Timeout Occurred",
            "Run Keyword Unless",
            "Run Keywords",
            "Set Global Variable",
            "Set Library Search Order",
            "Set Log Level",
            "Set Suite Documentation",
            "Set Suite Metadata",
            "Set Suite Variable",
            "Set Tags",
            "Set Test Documentation",
            "Set Test Message",
            "Set Test Variable",
            "Set Variable",
            "Set Variable If",
            "Should Be Empty",
            "Should Be Equal",
            "Should Be Equal As Integers",
            "Should Be Equal As Numbers",
            "Should Be Equal As Strings",
            "Should Be True",
            "Should Contain",
            "Should Contain X Times",
            "Should End With",
            "Should Match",
            "Should Match Regexp",
            "Should Not Be Empty",
            "Should Not Be Equal",
            "Should Not Be Equal As Integers",
            "Should Not Be Equal As Numbers",
            "Should Not Be Equal As Strings",
            "Should Not Be True",
            "Should Not Contain",
            "Should Not End With",
            "Should Not Match",
            "Should Not Match Regexp",
            "Should Not Start With",
            "Should Start With",
            "Sleep",
            "Variable Should Exist",
            "Variable Should Not Exist",
            "Wait Until Keyword Succeeds").build();

    private static final Set<String> NORMAL_BUILT_IN_KEYWORDS = Sets.newHashSet();

    static {
        for (String keyword: BUILD_IN_KEYWORDS) {
            String normal = RobotPsiUtil.normalizeKeywordForIndex(keyword);
            NORMAL_BUILT_IN_KEYWORDS.add(normal);
        }
    }

    public static boolean isBuiltInKeyword(String normalName) {
        return NORMAL_BUILT_IN_KEYWORDS.contains(normalName);
    }
}
