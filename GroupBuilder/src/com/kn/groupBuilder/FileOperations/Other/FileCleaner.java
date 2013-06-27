package com.kn.groupBuilder.FileOperations.Other;

import java.io.File;

import com.kn.groupBuilder.Storage.Pojo;

public class FileCleaner {

    public final void updateArchive(final Pojo pojo) {

        final File filePath = new File(pojo.getSettings().getPath() + "Archive\\");
        try {
            for (final File file : filePath.listFiles()) {
                if (!file.isDirectory()) {
                    if (this.checkDeletionDate(file.getName())) {
                        file.delete();
                    }
                }
            }
        } catch (final java.lang.NullPointerException e) {
            // nothing to do.
        }
    }

    public final void cleanArchive(final Pojo pojo) {
        this.cleanFolder(pojo.getSettings().getPath() + "Archive\\");
    }

    public final void cleanGroupList(final Pojo pojo) {
        new File(pojo.getSettings().getPath() + "GroupList.xml").delete();
    }

    public final void cleanMemberList(final Pojo pojo) {
        new File(pojo.getSettings().getPath() + "MemberList.xml").delete();
    }

    public final void cleanSettings(final Pojo pojo) {
        new File(pojo.getSettings().getPath() + "Settings.xml").delete();
    }

    public final void cleanAllFiles(final Pojo pojo) {

        this.cleanGroupList(pojo);
        this.cleanMemberList(pojo);
        this.cleanSettings(pojo);

        this.cleanFolder(pojo.getSettings().getPath() + "Groups\\");
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

    public boolean checkDeletionDate(final String fileName) {

        final String test = fileName.substring(0, fileName.indexOf("_"));
        System.out.println(test);
        return false;

    }
}
