package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception without any specified solution.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class UnknownErrorException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public UnknownErrorException(final String operation, final StackTraceElement[] stackTraceElements) {
        super("An unknown error happened processing the \"" + operation + "\" operation.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
