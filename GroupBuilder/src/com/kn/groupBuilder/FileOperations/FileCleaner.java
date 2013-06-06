package com.kn.groupBuilder.FileOperations;

import java.io.File;

public class FileCleaner {

    public final void cleanFiles(final String defaultPath) {

        new File(defaultPath + "GroupList.xml").delete();
        new File(defaultPath + "MemberList.xml").delete();

        this.cleanFolder(defaultPath + "\\Groups\\");
    }

    private void cleanFolder(final String path) {

        final File filePath = new File(path);
        try {
            for (final File file : filePath.listFiles()) {
                if (!file.isDirectory()) {
                    file.delete();
                } else {
                    this.cleanFolder(file.getAbsolutePath());
                }
            }
            filePath.delete();
        } catch (final java.lang.NullPointerException e) {
            // nothing to do.
        }
    }
}
