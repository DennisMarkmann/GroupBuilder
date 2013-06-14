package com.kn.groupBuilder.Storage;

/**
 * Currently unused. TODO:Has to be implemented.
 * 
 * @param path
 */
@SuppressWarnings("unused")
public class Settings {

    private String defaultPath;

    // german or english
    private String language;

    private boolean archive;
    private int archivingDays;

    // txt or xml
    private String ausgabeFormat;

    private boolean sendMailAutomatically;
    private boolean printAutomatically;

}
