package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.intellij.psi.*;
import com.intellij.util.Processor;
import com.jivesoftware.robot.intellij.plugin.elements.references.PsiMethodWithRobotName;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by charles.capps on 6/24/14.
 */
public class RobotJavaFileProcessor implements Processor<PsiFile> {
    private final List<PsiElement> populateMe;
    private final SearchType searchType;
    private final Optional<String> searchTerm;
    private String normalizedSearch;
    private final boolean wrapPsiMethods;

    public RobotJavaFileProcessor(@NotNull List<PsiElement> populateMe, @NotNull SearchType searchType, @NotNull Optional<String> robotKeywordName, boolean wrapPsiMethods) {
        this.populateMe = populateMe;
        this.searchType = searchType;
        this.searchTerm = robotKeywordName;
        this.wrapPsiMethods = wrapPsiMethods;
        if (searchType == SearchType.FIRST_EXACT_MATCH || searchType == SearchType.FIND_ALL_EXACT_MATCHES || searchType == SearchType.STARTS_WITH) {
            Preconditions.checkArgument(robotKeywordName.isPresent(),
                    "A search string must be specified when searching by exact match or starts with.");
            normalizedSearch = RobotPsiUtil.normalizeKeywordForIndex(robotKeywordName.get());
        }
    }

    @Override
    public boolean process(PsiFile psiFile) {
        return addResultsForJavaFile(psiFile, populateMe);
    }

    private boolean addResultsForJavaFile(PsiFile psiFile, List<PsiElement> resultsToAdd) {
        if (psiFile instanceof PsiJavaFile) {
            PsiClass[] classes = ((PsiClassOwner) psiFile).getClasses();
            for (PsiClass psiClass : classes) {
                for (PsiMethod psiMethod : psiClass.getMethods()) {
                    if (include(psiMethod)) {
                        resultsToAdd.add(wrap(psiMethod));
                        if (searchType == SearchType.FIRST_EXACT_MATCH) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private PsiMethod wrap(PsiMethod method) {
        if (wrapPsiMethods) {
            return new PsiMethodWithRobotName(method.getNode(), method);
        }
        return method;
    }

    private boolean include(PsiMethod method) {
        if (!RobotJavaPsiUtil.isPsiMethodRobotKeyword(method)) {
            return false;
        }
        final String normalizedName = RobotPsiUtil.normalizeKeywordForIndex(method.getName());
        if (searchType == SearchType.FIND_ALL) {
            return true;
        } else if (searchType == SearchType.FIRST_EXACT_MATCH || searchType == SearchType.FIND_ALL_EXACT_MATCHES) {
            return normalizedSearch.equals(normalizedName);
        } else if (searchType == SearchType.STARTS_WITH) {
            return normalizedName.startsWith(normalizedSearch);
        } else {
            throw new RuntimeException("Need to have a case for every type of SearchType in RobotJavaKeywordProcessor!");
        }

    }

}
