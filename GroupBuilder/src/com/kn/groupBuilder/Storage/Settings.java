package com.kn.groupBuilder.Storage;

/**
 * Currently unused. TODO:Has to be implemented.
 * 
 */
public class Settings {

    private String path = System.getProperty("user.home") + "\\Desktop\\" + "GroupBuilder\\";;

    private String language; // german or english
    private boolean archive;
    private int archivingDays;
    private String ausgabeFormat; // txt or xml
    private boolean sendMailAutomatically;
    private boolean printAutomatically;

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public boolean isArchive() {
        return this.archive;
    }

    public void setArchive(final boolean archive) {
        this.archive = archive;
    }

    public int getArchivingDays() {
        return this.archivingDays;
    }

    public void setArchivingDays(final int archivingDays) {
        this.archivingDays = archivingDays;
    }

    public String getAusgabeFormat() {
        return this.ausgabeFormat;
    }

    public void setAusgabeFormat(final String ausgabeFormat) {
        this.ausgabeFormat = ausgabeFormat;
    }

    public boolean isSendMailAutomatically() {
        return this.sendMailAutomatically;
    }

    public void setSendMailAutomatically(final boolean sendMailAutomatically) {
        this.sendMailAutomatically = sendMailAutomatically;
    }

    public boolean isPrintAutomatically() {
        return this.printAutomatically;
    }

    public void setPrintAutomatically(final boolean printAutomatically) {
        this.printAutomatically = printAutomatically;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }
}
