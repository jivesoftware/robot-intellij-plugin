package com.jivesoftware.robot.intellij.plugin.util;

import java.util.regex.Pattern;

/**
 * Created by charlescapps on 11/11/14.
 */
public class RegexUtils {
    private static final Pattern REGEX_SPECIAL_CHARS = Pattern.compile("([\\\\\\.\\[\\]\\{\\}\\(\\)\\*\\+\\?\\^\\$\\|])");
    /**
     * This is for escaping a String so it's interpreted literally by a regex,
     * WITHOUT using Pattern.quote(), because Pattern.quote() only works for the entire string.
     *
     * This will work if we're building a new regular expression from substrings.
     * @param s
     * @return
     */
    public static String escapeStringForRegex(String s) {
        return REGEX_SPECIAL_CHARS.matcher(s).replaceAll("\\\\$1");
    }
}
