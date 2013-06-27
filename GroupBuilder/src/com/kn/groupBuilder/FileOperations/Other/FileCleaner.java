package com.kn.groupBuilder.FileOperations.Other;

import java.io.File;

public class FileCleaner {

    public final void cleanFiles(final String path) {

        new File(path + "GroupList.xml").delete();
        new File(path + "MemberList.xml").delete();
        new File(path + "Settings.xml").delete();

        this.cleanFolder(path + "Groups\\");
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
