package com.kn.groupBuilder.UnusedFiles;

import java.io.File;

public class GroupFolderCleaner {

    public final boolean cleanGroupFolder(final String path) {
        final File folderPath = new File(path + "GroupsXML\\");
        try {
            for (final File file : folderPath.listFiles()) {
                if (file.isDirectory()) {
                    this.cleanGroupFolder(path);
                    file.delete();
                }
                folderPath.delete();
            }
        } catch (final java.lang.NullPointerException e) {
            // nothing to do.
        }
        return true;
    }
}
