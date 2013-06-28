package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;
import java.util.Date;

import com.kn.groupBuilder.HelperClasses.DateHelper;
import com.kn.groupBuilder.Storage.Pojo;

public class FileCleaner {

    public final void updateArchive(final Pojo pojo) {

        if (pojo.getSettings().isArchived()) {
            final File filePath = new File(pojo.getSettings().getPath() + "Archive\\");
            try {
                for (final File file : filePath.listFiles()) {
                    if (this.checkDeletionDate(file.getName(), pojo)) {
                        this.cleanFolder(file.getPath());
                    }
                }
            } catch (final java.lang.NullPointerException e) {
                // nothing to do.
            }
        }
    }

    public final void cleanArchive(final Pojo pojo) {
        this.cleanFolder(pojo.getSettings().getPath() + "Archive\\");
    }

    private void cleanGroupList(final Pojo pojo) {
        new File(pojo.getSettings().getPath() + "GroupList.xml").delete();
    }

    private void cleanMemberList(final Pojo pojo) {
        new File(pojo.getSettings().getPath() + "MemberList.xml").delete();
    }

    private void cleanSettings(final Pojo pojo) {
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

    private boolean checkDeletionDate(final String fileName, final Pojo pojo) {
        final DateHelper helper = new DateHelper();

        final Date archiveDate = helper.parseStringToDate(fileName.substring(0, fileName.indexOf("_")));
        final Date currentDate = helper.parseStringToDate(helper.getDate(-7));

        if (archiveDate.before(currentDate)) {
            return true;
        }
        return false;

    }
}
