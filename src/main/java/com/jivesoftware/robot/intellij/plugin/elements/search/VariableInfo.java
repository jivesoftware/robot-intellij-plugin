package com.jivesoftware.robot.intellij.plugin.elements.search;

import com.google.common.base.Preconditions;
import com.intellij.psi.PsiElement;
import com.jgoodies.common.base.Objects;

/**
 * Created by charles on 7/13/14.
 *
 * Represents the value of a variable and the PsiElement where its defined.
 */
public class VariableInfo {
    private final String value;
    private final PsiElement definition;

    public VariableInfo(String value, PsiElement definition) {
        this.value = Preconditions.checkNotNull(value);
        this.definition = Preconditions.checkNotNull(definition);
    }

    public String getValue() {
        return value;
    }

    public PsiElement getDefinition() {
        return definition;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(getClass())) {
            return false;
        }
        VariableInfo other = (VariableInfo) o;
        return Objects.equals(value, other.value) && Objects.equals(definition, other.definition);
    }

    @Override
    public int hashCode() {
        return (value == null ? 0 : value.hashCode()) ^ (definition == null ? 0 : definition.hashCode());
    }

}
