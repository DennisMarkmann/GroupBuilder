package com.kn.groupBuilder.Storage;

/**
 * Currently unused. TODO:Has to be implemented.
 * 
 */
public class Settings { // NO_UCD

    private String path = System.getProperty("user.home") + "\\Desktop\\" + "GroupBuilder\\";;

    private String language; // german or english
    private boolean archive;
    private int archivingDays;
    private String ausgabeFormat; // txt or xml
    private boolean sendMailAutomatically;
    private boolean printAutomatically;

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(final String language) {
        this.language = language;
    }

    public final boolean isArchive() {
        return this.archive;
    }

    public final void setArchive(final boolean archive) {
        this.archive = archive;
    }

    public final int getArchivingDays() {
        return this.archivingDays;
    }

    public final void setArchivingDays(final int archivingDays) {
        this.archivingDays = archivingDays;
    }

    public final String getAusgabeFormat() {
        return this.ausgabeFormat;
    }

    public final void setAusgabeFormat(final String ausgabeFormat) {
        this.ausgabeFormat = ausgabeFormat;
    }

    public final boolean isSendMailAutomatically() {
        return this.sendMailAutomatically;
    }

    public final void setSendMailAutomatically(final boolean sendMailAutomatically) {
        this.sendMailAutomatically = sendMailAutomatically;
    }

    public final boolean isPrintAutomatically() {
        return this.printAutomatically;
    }

    public final void setPrintAutomatically(final boolean printAutomatically) {
        this.printAutomatically = printAutomatically;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(final String path) {
        this.path = path;
    }
}
