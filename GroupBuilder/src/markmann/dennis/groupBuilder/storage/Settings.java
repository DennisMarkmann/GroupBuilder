package markmann.dennis.groupBuilder.storage;

import java.io.File;

import dennis.markmann.MyLibraries.DefaultJobs.File.CopyOperationException;
import dennis.markmann.MyLibraries.DefaultJobs.File.FileCopy;
import markmann.dennis.groupBuilder.exceptions.CopyException;
import markmann.dennis.groupBuilder.fileOperations.writer.FileCleaner;
import markmann.dennis.groupBuilder.main.PropertyHandler;

/**
 * Storage for the settings used in the application. Contains various elements that can be saved via XML file.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class Settings { // NO_UCD

    private static final int DEFAULT_ARCHIVING_DAYS = 7;

    private String path = System.getProperty("user.home") + System.getProperty("file.separator") + "GroupBuilder"
            + System.getProperty("file.separator");

    private String language = "english"; // german or english
    private boolean archive = true;
    private int archivingDays = DEFAULT_ARCHIVING_DAYS; // if the value is 0 the
                                                        // archiving will be
                                                        // disabled
    private boolean sendMailAutomatically = false;
    private boolean printAutomatically = false;
    private String printer;

    public final int getArchivingDays() {
        return this.archivingDays;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getPrinter() {
        return this.printer;
    }

    public final boolean isArchived() {
        return this.archive;
    }

    public final boolean isPrintAutomatically() {
        return this.printAutomatically;
    }

    public final boolean isSendMailAutomatically() {
        return this.sendMailAutomatically;
    }

    public final void setArchived(final boolean archive) {
        this.archive = archive;
    }

    public final void setArchivingDays(final int archivingDays) {
        this.archivingDays = archivingDays;
    }

    public final void setLanguage(final String language) {
        this.language = language;
    }

    public final void setPath(String path) {
        if (this.path.equals(path)) {
            return;
        }
        if (!path.endsWith("GroupBuilder")) {
            path = path + "GroupBuilder\\";
        }
        File source = new File(this.path);
        if (source.listFiles() != null) {
            try {
                new FileCopy().copyFolder(source, new File(path), true);
            }
            catch (final CopyOperationException e) {
                new CopyException(e).showDialog();
            }
            new FileCleaner().cleanFolder(this.path);
        }
        new PropertyHandler().storeProperties(path);
        this.path = path;
    }

    public final void setPathInitially(final String path) {
        this.path = path;
    }

    public final void setPrintAutomatically(final boolean printAutomatically) {
        this.printAutomatically = printAutomatically;
    }

    public final void setPrinter(final String printer) {
        this.printer = printer;
    }

    public final void setSendMailAutomatically(final boolean sendMailAutomatically) {
        this.sendMailAutomatically = sendMailAutomatically;
    }

}
