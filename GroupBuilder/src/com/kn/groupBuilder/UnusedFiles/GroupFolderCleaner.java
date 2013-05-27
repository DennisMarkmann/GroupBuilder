package com.kn.groupBuilder.UnusedFiles;

import java.io.File;

public class GroupFolderCleaner {

    public final boolean cleanGroupFolder(final String defaultPath) {
        final File path = new File(defaultPath + "\\GroupsXML\\");
        try {
            for (final File file : path.listFiles()) {
                if (file.isDirectory()) {
                    this.cleanGroupFolder(defaultPath);
                    file.delete();
                }
                path.delete();
            }
        } catch (final java.lang.NullPointerException e) {
            // nothing to do.
        }
        return true;
    }
}
