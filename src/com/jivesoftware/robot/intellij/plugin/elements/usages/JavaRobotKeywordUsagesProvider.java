package com.jivesoftware.robot.intellij.plugin.elements.usages;

import com.intellij.find.impl.HelpID;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.lang.java.lexer.JavaLexer;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.impl.java.stubs.JavaStubElementTypes;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JavaRobotKeywordUsagesProvider implements FindUsagesProvider {
  private static final DefaultWordsScanner WORDS_SCANNER = new DefaultWordsScanner(new JavaLexer(LanguageLevel.JDK_1_7),
                                                                                   TokenSet.create(JavaTokenType.IDENTIFIER, JavaStubElementTypes.METHOD),
                                                                                   TokenSet.create(JavaTokenType.END_OF_LINE_COMMENT, JavaTokenType.C_STYLE_COMMENT),
                                                                                   TokenSet.EMPTY);
  @Nullable
  @Override
  public WordsScanner getWordsScanner() {
    return WORDS_SCANNER;
  }

  @Override
  public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
    return psiElement instanceof PsiMethod;
  }

  @Nullable
  @Override
  public String getHelpId(@NotNull PsiElement psiElement) {
    return HelpID.FIND_OTHER_USAGES;
  }

  @NotNull
  @Override
  public String getType(@NotNull PsiElement element) {
    if (element instanceof PsiMethod) {
      return "Robot Java Method Keyword Definition";
    }
    return "";
  }

  @NotNull
  @Override
  public String getDescriptiveName(@NotNull PsiElement element) {
    if (element instanceof PsiMethod) {
      return ((PsiMethod) element).getName();
    }
    return "";
  }

  @NotNull
  @Override
  public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
    if (element instanceof PsiMethod) {
      return element.getText();
    }
    return "";
  }
}
