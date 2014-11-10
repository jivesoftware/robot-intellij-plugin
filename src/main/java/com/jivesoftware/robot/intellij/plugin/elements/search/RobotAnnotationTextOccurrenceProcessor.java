package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Optional;
import com.intellij.psi.*;
import com.intellij.psi.search.TextOccurenceProcessor;

import java.util.List;

/**
 * Created by charles.capps on 9/9/14.
 */
public class RobotAnnotationTextOccurrenceProcessor implements TextOccurenceProcessor {

    private final List<PsiElement> results;
    private final SearchType searchType;
    private final boolean wrapPsiMethods;
    private String normalizedSearchTerm;

    public RobotAnnotationTextOccurrenceProcessor(List<PsiElement> results, SearchType searchType, Optional<String> searchTerm, boolean wrapPsiMethods) {
        this.results = results;
        this.searchType = searchType;
        if (searchTerm.isPresent()) {
            this.normalizedSearchTerm = RobotPsiUtil.normalizeKeywordForIndex(searchTerm.get());
        }
        this.wrapPsiMethods = wrapPsiMethods;
    }

    @Override
    public boolean execute(PsiElement element, int offsetInElement) {
        if (!(element instanceof PsiAnnotation)) {
            return true;
        }
        PsiAnnotation psiAnnotation = (PsiAnnotation) element;
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
