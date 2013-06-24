package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

public class NoFilesFoundException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public NoFilesFoundException(final String path) {
        super("No valid data was found at \"" + path + "\"" + System.lineSeparator() + "Please change the chosen path.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
