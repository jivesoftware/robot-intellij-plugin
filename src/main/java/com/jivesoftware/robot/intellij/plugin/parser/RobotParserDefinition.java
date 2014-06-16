package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.jivesoftware.robot.intellij.plugin.lang.RobotLanguage;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotScannerAdapter;
import org.jetbrains.annotations.NotNull;

public class RobotParserDefinition implements ParserDefinition {

  public static final TokenSet WHITE_SPACES = TokenSet.create(RobotTypes.WHITESPACE_TOKEN);
  public static final TokenSet COMMENTS = TokenSet.create(RobotTypes.COMMENT_TOKEN);
  public static final TokenSet STRING_LITERALS = TokenSet.create(RobotTypes.ROBOT_KEYWORD_ARG_TOKEN);

  public static final IFileElementType FILE = new IFileElementType(Language.<RobotLanguage>findInstance(RobotLanguage.class));


  @NotNull
  @Override
  public Lexer createLexer(Project project) {
    return new RobotScannerAdapter();
  }

  @Override
  public PsiParser createParser(Project project) {
    return new RobotParser();
  }

  @Override
  public IFileElementType getFileNodeType() {
    return FILE;
  }

  @NotNull
  @Override
  public TokenSet getWhitespaceTokens() {
    return WHITE_SPACES;
  }

  @NotNull
  @Override
  public TokenSet getCommentTokens() {
    return COMMENTS;
  }

  @NotNull
  @Override
  public TokenSet getStringLiteralElements() {
    return STRING_LITERALS;
  }

  @NotNull
  @Override
  public PsiElement createElement(ASTNode node) {
    return RobotTypes.Factory.createElement(node);
  }

  @Override
  public PsiFile createFile(FileViewProvider viewProvider) {
    return new RobotPsiFile(viewProvider);
  }

  @Override
  public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
    return SpaceRequirements.MAY;
  }
}
