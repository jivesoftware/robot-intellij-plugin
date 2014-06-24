package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.intellij.psi.*;
import com.intellij.util.Processor;

import java.util.List;

/**
 * Created by charles.capps on 6/24/14.
 */
public class RobotKeywordPsiAnnotationProcessor implements Processor<PsiAnnotation> {
    private final List<PsiElement> results;
    private final SearchType searchType;
    private final Optional<String> searchTerm;
    private final boolean wrapPsiMethods;
    private String normalizedSearchTerm;

    public RobotKeywordPsiAnnotationProcessor(List<PsiElement> results, SearchType searchType, Optional<String> searchTerm, boolean wrapPsiMethods) {
        this.results = results;
        this.searchType = searchType;
        this.searchTerm = searchTerm;
        if (searchTerm.isPresent()) {
            this.normalizedSearchTerm = RobotPsiUtil.normalizeKeywordForIndex(searchTerm.get());
        }
        this.wrapPsiMethods = wrapPsiMethods;
    }

    @Override
    public boolean process(PsiAnnotation psiAnnotation) {
        PsiAnnotationOwner owner = psiAnnotation.getOwner();
        if (!(owner instanceof PsiModifierList)) {
            return doContinue();
        }
        PsiElement parent = ((PsiModifierList) owner).getParent();
        if (!(parent instanceof PsiMethod)) {
            return doContinue();
        }
        PsiMethod method = (PsiMethod)parent;
        if (include(method)) {
            results.add(RobotJavaPsiUtil.wrap(method, wrapPsiMethods));
            return doContinue();
        }
        return doContinue();
    }

    private boolean doContinue() {
        return searchType == SearchType.FIND_ALL || searchType == SearchType.STARTS_WITH || results.isEmpty();
    }

    private boolean include(PsiMethod method) {
        if (searchType == SearchType.FIND_ALL) {
            return true;
        }
        final String normalizedMethodName = method.getName().toLowerCase();
        if (searchType == SearchType.EXACT_MATCH) {
            return normalizedSearchTerm.equals(normalizedMethodName);
        } else if (searchType == SearchType.STARTS_WITH) {
            return normalizedMethodName.startsWith(normalizedSearchTerm);
        }
        return false;
    }

}
