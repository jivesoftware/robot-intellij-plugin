package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiMethod;
import com.intellij.util.Processor;

import java.util.List;

/**
 * Created by charles.capps on 6/24/14.
 */
public class RobotJavaMethodProcessor implements Processor<PsiMethod> {
    private final List<PsiElement> results;
    private final SearchType searchType;
    private final Optional<String> searchTerm;
    private final boolean wrapPsiMethods;
    private String normalizedSearchTerm;

    public RobotJavaMethodProcessor(List<PsiElement> results, SearchType searchType, Optional<String> searchTerm, boolean wrapPsiMethods) {
        this.results = results;
        this.searchType = searchType;
        this.searchTerm = searchTerm;
        if (searchTerm.isPresent()) {
            this.normalizedSearchTerm = RobotPsiUtil.normalizeKeywordForIndex(searchTerm.get());
        }
        this.wrapPsiMethods = wrapPsiMethods;
    }

    @Override
    public boolean process(PsiMethod psiMethod) {
        if (include(psiMethod)) {
            results.add(RobotJavaPsiUtil.wrap(psiMethod, wrapPsiMethods));
            return doContinue();
        }
        return doContinue();
    }

    private boolean doContinue() {
        return searchType == SearchType.FIND_ALL || searchType == SearchType.FIND_ALL_EXACT_MATCHES ||
               searchType == SearchType.STARTS_WITH || results.isEmpty();
    }

    private boolean include(PsiMethod method) {
        if (searchType == SearchType.FIND_ALL) {
            return true;
        }
        final String normalizedMethodName = RobotPsiUtil.normalizeJavaMethodForIndex(method.getName());
        if (searchType == SearchType.FIRST_EXACT_MATCH || searchType == SearchType.FIND_ALL_EXACT_MATCHES) {
            return normalizedSearchTerm.equals(normalizedMethodName);
        } else if (searchType == SearchType.STARTS_WITH) {
            return normalizedMethodName.startsWith(normalizedSearchTerm);
        }
        return false;
    }

}
