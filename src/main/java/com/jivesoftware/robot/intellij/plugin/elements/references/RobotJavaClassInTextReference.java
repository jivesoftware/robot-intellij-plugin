package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.jivesoftware.robot.intellij.plugin.psi.RobotJavaClassReference;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by charlescapps on 11/10/14.
 */
public class RobotJavaClassInTextReference extends PsiPolyVariantReferenceBase<RobotJavaClassReference> {
    public RobotJavaClassInTextReference(@NotNull RobotJavaClassReference element) {
        super(element);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        final Project project = myElement.getProject();
        PsiClass[] classes = JavaPsiFacade.getInstance(project)
                .findClasses(myElement.getText(), GlobalSearchScope.allScope(project));
        List<ResolveResult> resolveResultList = Lists.newArrayList();
        for (PsiClass clazz: classes) {
            resolveResultList.add(new PsiElementResolveResult(clazz));
        }
        return resolveResultList.toArray(new ResolveResult[resolveResultList.size()]);
    }

    @Override
    public TextRange calculateDefaultRangeInElement() {
        return new TextRange(0, myElement.getText().length());
    }
}
