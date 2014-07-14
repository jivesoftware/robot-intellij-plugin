package com.jivesoftware.robot.intellij.plugin.elements.references;

import com.google.common.collect.Maps;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiReferenceBase;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariableInfo;
import com.jivesoftware.robot.intellij.plugin.elements.search.VariablePsiUtil;
import com.jivesoftware.robot.intellij.plugin.lang.RobotPsiFile;
import com.jivesoftware.robot.intellij.plugin.psi.RobotResourceFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Map;

/**
 * Created by charles on 7/13/14.
 */
public class RobotFileReference extends PsiReferenceBase<RobotResourceFile> {

    public RobotFileReference(RobotResourceFile robotResourceFile) {
        super(robotResourceFile);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        Map<String, VariableInfo> env = Maps.newHashMap();
        final PsiFile file = myElement.getContainingFile();
        if (!(file instanceof RobotPsiFile)) {
            return null;
        }
        RobotPsiFile robotPsiFile = (RobotPsiFile) file;
        env = VariablePsiUtil.getVariableEnvironment(robotPsiFile, env);
        return resolve(env);
    }

    @Nullable
    public PsiElement resolve(Map<String, VariableInfo> environment) {
        final String fileName = VariablePsiUtil.substitute(myElement.getText(), environment);
        final Project project = myElement.getProject();
        final File file = new File(fileName);

        if (!file.isAbsolute()) {
            PsiFile currentPsiFile = myElement.getContainingFile();
            VirtualFile currentVirtualFile = currentPsiFile.getVirtualFile();
            VirtualFile containingDir = currentVirtualFile.getParent();

            VirtualFile virtualResourceFile = containingDir.findFileByRelativePath(fileName);

            if (virtualResourceFile != null) {
                return PsiManager.getInstance(project).findFile(virtualResourceFile);
            }
        }

        VirtualFile virtualResourceFile = LocalFileSystem.getInstance().findFileByIoFile(file);
        if (virtualResourceFile != null) {
            return PsiManager.getInstance(project).findFile(virtualResourceFile);
        }
        return null;
    }

    @NotNull
    @Override
    public String getCanonicalText() {
        return myElement.getText();
    }

    @Override
    public TextRange calculateDefaultRangeInElement() {
        return new TextRange(0, myElement.getText().length());
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }
}
