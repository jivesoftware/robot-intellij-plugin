package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.jivesoftware.robot.intellij.plugin.elements.search.KeywordScope;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotKeywordDefinitionFinder;
import com.jivesoftware.robot.intellij.plugin.elements.search.RobotPsiUtil;
import com.jivesoftware.robot.intellij.plugin.elements.search.SearchType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RobotKeywordReference extends PsiPolyVariantReferenceBase<PsiElement> {

    public RobotKeywordReference(PsiElement element) {
        super(element);
    }

    /**
     * Return the java method name corresponding to the Robot keyword.
     */
    @NotNull
    @Override
    public String getCanonicalText() {
        return myElement.getText();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0]; // code completion handled by RobotCompletionProvider
    }

    @Override
    public TextRange calculateDefaultRangeInElement() {
        return new TextRange(0, myElement.getText().length());
    }

    @Override
    public PsiElement handleElementRename(String name) {
        if (myElement instanceof PsiNamedElement) {
            PsiNamedElement psiNamedElement = (PsiNamedElement) myElement;
            return psiNamedElement.setName(RobotPsiUtil.methodToRobotKeyword(name));
        }
        return myElement;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();

        RobotKeywordDefinitionFinder robotKeywordDefinitionFinder =
                new RobotKeywordDefinitionFinder(project, getCanonicalText(), KeywordScope.ROBOT_AND_JAVA_KEYWORDS,
                        SearchType.FIND_ALL_EXACT_MATCHES);
        robotKeywordDefinitionFinder.process();
        List<PsiElement> results = robotKeywordDefinitionFinder.getResults();
        ResolveResult[] resolveResults = new ResolveResult[results.size()];
        for (int i = 0; i < results.size(); i++) {
            PsiElement psi = results.get(i);
            ResolveResult resolveResult = new PsiElementResolveResult(psi, false);
            resolveResults[i] = resolveResult;
        }
        return resolveResults;
    }
}
