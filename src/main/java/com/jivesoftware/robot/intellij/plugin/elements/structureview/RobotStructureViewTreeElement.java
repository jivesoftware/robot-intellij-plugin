package com.jivesoftware.robot.intellij.plugin.elements.structureview;

import com.google.common.collect.Lists;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.jivesoftware.robot.intellij.plugin.elements.presentations.KeywordTitleStructureViewPresentation;
import com.jivesoftware.robot.intellij.plugin.elements.presentations.TestCaseStructureViewPresentation;
import com.jivesoftware.robot.intellij.plugin.icons.RobotIcons;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * Created by charles on 6/5/14.
 */
public class RobotStructureViewTreeElement implements StructureViewTreeElement, SortableTreeElement {

    private final PsiElement myElement;

    public RobotStructureViewTreeElement(PsiElement myElement) {
        this.myElement = myElement;
    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @Override
    public void navigate(boolean requestFocus) {
        PsiElement navEl = myElement.getNavigationElement();
        if (navEl instanceof NavigationItem) {
            ((NavigationItem) navEl).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return true;
    }

    @Override
    public boolean canNavigateToSource() {
        return true;
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        if (myElement instanceof RobotTestCase) {
            return new TestCaseStructureViewPresentation((RobotTestCase) myElement);
        }
        if (myElement instanceof RobotKeywordTitle) {
            return new KeywordTitleStructureViewPresentation((RobotKeywordTitle) myElement);
        }
        if (myElement instanceof RobotKeywordsTable) {
            return ((RobotKeywordsTable) myElement).getPresentation();
        }
        if (myElement instanceof RobotTestCasesTable) {
            return ((RobotTestCasesTable) myElement).getPresentation();
        }
        if (myElement instanceof RobotPsiFile) {
            ItemPresentation presentation = ((RobotPsiFile) myElement).getPresentation();
            if (presentation != null) {
                return presentation;
            }
        }
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return myElement.getText();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return myElement.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return RobotIcons.ROBOT;
            }
        };
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        if (myElement instanceof RobotPsiFile) {
            return getChildren((RobotPsiFile)myElement);
        }
        else if (myElement instanceof RobotSettingsTable) {
            return TreeElement.EMPTY_ARRAY; //TODO: Show settings in structure view.
        }
        else if (myElement instanceof RobotVariablesTable) {
            return TreeElement.EMPTY_ARRAY; //TODO: Show variables in structure view
        }
        else if (myElement instanceof RobotKeywordsTable) {
            return getChildren((RobotKeywordsTable)myElement);
        }
        else if (myElement instanceof RobotTestCasesTable) {
            return getChildren((RobotTestCasesTable)myElement);
        }
        return TreeElement.EMPTY_ARRAY;
    }

    private TreeElement[] getChildren(RobotPsiFile root) {
        List<TreeElement> children = Lists.newArrayList();

        for (PsiElement el: root.getChildren()) {
            if (el instanceof RobotTable) {
                RobotTable table = (RobotTable)el;
                if (table.getKeywordsTable() != null) {
                    children.add(new RobotStructureViewTreeElement(table.getKeywordsTable()));
                }
                if (table.getTestCasesTable() != null) {
                    children.add(new RobotStructureViewTreeElement(table.getTestCasesTable()));
                }
                if (table.getSettingsTable() != null) {
                 //   children.add(new RobotStructureViewTreeElement(table.getSettingsTable()));
                }
                if (table.getVariablesTable() != null) {
                 //   children.add(new RobotStructureViewTreeElement(table.getVariablesTable()));
                }
            }
        }
        return children.toArray(new TreeElement[children.size()]);
    }

    private TreeElement[] getChildren(RobotKeywordsTable table) {
        List<TreeElement> children = Lists.newArrayList();

        for (RobotKeywordDefinition robotKeywordDefinition: table.getKeywordDefinitionList()) {
            RobotKeywordDefinitionHeader header = robotKeywordDefinition.getKeywordDefinitionHeader();
            children.add(new RobotStructureViewTreeElement(header.getKeywordTitle()));
        }

        return children.toArray(new TreeElement[children.size()]);
    }

    private TreeElement[] getChildren(RobotTestCasesTable table) {
        List<TreeElement> children = Lists.newArrayList();

        for (RobotTestCase robotTestCase: table.getTestCaseList()) {
           children.add(new RobotStructureViewTreeElement(robotTestCase));
        }

        return children.toArray(new TreeElement[children.size()]);
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        return myElement.getText();
    }
}
