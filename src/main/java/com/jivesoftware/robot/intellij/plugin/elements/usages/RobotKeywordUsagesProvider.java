package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.impl.HelpID;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.jivesoftware.robot.intellij.plugin.elements.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotScannerAdapter;
import com.jivesoftware.robot.intellij.plugin.parser.RobotTypes;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeywordDef;
import com.jivesoftware.robot.intellij.plugin.psi.RobotKeyword;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RobotKeywordUsagesProvider implements FindUsagesProvider {
  public static final TokenSet IDENTIFIERS = TokenSet.create(RobotTypes.ROBOT_KEYWORD_TOKEN, RobotTypes.ROBOT_KEYWORD_DEF_TOKEN);

  public static final TokenSet COMMENTS = TokenSet.EMPTY;

  public static final TokenSet LITERALS = TokenSet.EMPTY;


  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return new RobotWordsScanner(new RobotScannerAdapter(), IDENTIFIERS, COMMENTS, LITERALS);
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof RobotKeywordDef;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return HelpID.FIND_IN_PROJECT;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof RobotKeywordDef) {
      return "Robot Keyword Definition";
    } else if (element instanceof RobotKeyword) {
      return "Robot Keyword Usage";
    }
    return "";
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof RobotKeywordDef) {
      return element.getText();
    }
    return "";
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof RobotKeywordDef) {
      return element.getText();
    }
    return "";
  }
}
