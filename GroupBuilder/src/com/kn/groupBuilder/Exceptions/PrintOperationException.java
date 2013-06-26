package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

public class PrintOperationException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public PrintOperationException(final StackTraceElement[] stackTraceElements) {
        super("An error appeared while trying to print.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
