package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

public class NoFilesFoundException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public NoFilesFoundException(final String path) {
        super("Es konnte keine gültige Datei in \"" + path + "\" gefunden werden. " + System.lineSeparator()
                + "Bitte ändern sie den gewählten Pfad.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
    }
}
