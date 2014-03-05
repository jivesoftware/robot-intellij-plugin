package com.jivesoftware.robot.intellij.plugin.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.jivesoftware.robot.intellij.plugin.lexer.RobotToken;
import org.jetbrains.annotations.NotNull;

public class RobotParser implements PsiParser {
  @NotNull
  @Override
  public ASTNode parse(IElementType root, PsiBuilder builder) {

    PsiBuilder.Marker robotRoot = builder.mark();

    while (builder.getTokenType() != null) {
      IElementType type = builder.getTokenType();
      if (type.equals(RobotToken.ROBOT_KEYWORD_TOKEN)) {
        PsiBuilder.Marker keyword = builder.mark();
        builder.advanceLexer();
        keyword.done(RobotElementType.ROBOT_KEYWORD_EL);
      } else {
        PsiBuilder.Marker other = builder.mark();
        builder.advanceLexer();
        other.done(RobotElementType.ROBOT_OTHER_EL);
      }
    }

    robotRoot.done(RobotFileElementType.INSTANCE);

    return builder.getTreeBuilt();
  }

}
