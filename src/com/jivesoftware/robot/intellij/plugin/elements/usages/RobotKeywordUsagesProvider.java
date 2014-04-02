package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.impl.HelpID;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotScannerAdapter;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDefEl;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordEl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotKeywordUsagesProvider implements FindUsagesProvider {
  public static final TokenSet IDENTIFIERS = TokenSet.create(RobotTypes.ROBOT_KEYWORD_DEF_TOKEN,
                                                             RobotTypes.ROBOT_KEYWORD_TOKEN,
                                                             RobotTypes.ASSIGNMENT_TOKEN,
                                                             RobotTypes.VARIABLE_TOKEN,
                                                             RobotTypes.KEYWORDS_TABLE_HEADING_TOKEN,
                                                             RobotTypes.TEST_CASES_TABLE_HEADING_TOKEN,
                                                             RobotTypes.TABLE_HEADING_TOKEN,
                                                             RobotTypes.META_INFO_TOKEN,
                                                             RobotTypes.TEST_CASE_HEADER_TOKEN,
                                                             RobotTypes.TAG_TOKEN);
  public static final TokenSet COMMENTS = TokenSet.create(RobotTypes.COMMENT_TOKEN,
                                                          RobotTypes.DOCUMENTATION_TOKEN);
  public static final TokenSet LITERALS = TokenSet.create(RobotTypes.NUMBER_LITERAL_TOKEN,
                                                          RobotTypes.ROBOT_KEYWORD_ARG_TOKEN);
  public static final TokenSet IGNORED = TokenSet.create(RobotTypes.COLUMN_SEP_TOKEN,
                                                         RobotTypes.BAD_CHAR_TOKEN,
                                                         RobotTypes.SINGLE_SPACE_TOKEN,
                                                         RobotTypes.NEWLINE_TOKEN);

  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new DefaultWordsScanner(new RobotScannerAdapter(), IDENTIFIERS, COMMENTS, LITERALS, IGNORED);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof RobotKeywordDefEl;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return HelpID.FIND_OTHER_USAGES;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof RobotKeywordDefEl) {
      return "Robot Keyword Definition";
    } else if (element instanceof RobotKeywordEl) {
      return "Robot Keyword Usage";
    }
    return "";
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof RobotKeywordDefEl) {
      return element.getText();
    }
    return "";
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof RobotKeywordDefEl) {
      return element.getText();
    }
    return "";
  }
}
