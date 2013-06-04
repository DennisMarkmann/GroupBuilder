package com.kn.groupBuilder.Storage;

public class Settings {

    private String defaultPath;

    // german or english
    private Enum language;

    private boolean archive;
    private int archivingDays;

    // txt or xml
    private Enum ausgabeFormat;

    private boolean sendMailAutomatically;
    private boolean printAutomatically;

}
