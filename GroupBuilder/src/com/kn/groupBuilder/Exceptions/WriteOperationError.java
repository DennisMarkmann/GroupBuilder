package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

public class WriteOperationError extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = 6498733673905740756L;

    public WriteOperationError(final String path) {
        super("An error occured writing the file: \"" + path + "\"");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
