package markmann.dennis.groupBuilder.fileOperations.writer;

import java.io.File;
import java.util.Date;

import markmann.dennis.groupBuilder.exceptions.NotToHandleException;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Pojo;

import org.apache.log4j.Logger;

import dennis.markmann.MyLibraries.DefaultJobs.DateHelper;

/**
 * Used to delete all different kind of folders.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class FileCleaner {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/FileCleaning.log");

    final void updateArchive(final Pojo pojo) {

        LOGGER.info("Updating archive.");

        final File filePath = new File(pojo.getSettings().getPath() + "Archive\\");
        try {
            for (final File file : filePath.listFiles()) {
                if (!pojo.getSettings().isArchived() || this.checkDeletionDate(file.getName(), pojo)) {
                    this.cleanFolder(file.getPath());
                }
            }
        } catch (final java.lang.NullPointerException e) {
            new NotToHandleException();
        }
    }

    public final void cleanFolder(final String path) {

        LOGGER.info("Cleaning folder: " + path + ".");

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
            new NotToHandleException();
        }
    }

    private boolean checkDeletionDate(final String fileName, final Pojo pojo) {
        final DateHelper helper = new DateHelper();

        final Date archiveDate = helper.parseStringToDate(fileName.substring(0, fileName.indexOf("_")));
        helper.addTime(0, 0, -pojo.getSettings().getArchivingDays(), 0, 0, 0);
        final Date deletionDate = helper.parseStringToDate(helper.getDate());

        if (archiveDate.before(deletionDate) || archiveDate.equals(deletionDate)) {
            return true;
        }
        return false;
    }
}
