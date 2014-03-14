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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotKeywordUsagesProvider implements FindUsagesProvider {
  private static final DefaultWordsScanner WORDS_SCANNER = new DefaultWordsScanner(new RobotScannerAdapter(),
                                                                                   TokenSet.create(RobotTypes.ROBOT_KEYWORD_DEF_TOKEN, RobotTypes.TAG_TOKEN),
                                                                                   TokenSet.create(RobotTypes.COMMENT_TOKEN, RobotTypes.DOCUMENTATION_TOKEN),
                                                                                   TokenSet.create(RobotTypes.NUMBER_LITERAL_TOKEN,
                                                                                                   RobotTypes.ROBOT_KEYWORD_ARG_TOKEN));
  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return WORDS_SCANNER;
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
