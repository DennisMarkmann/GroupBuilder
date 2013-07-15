package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception without any handling needed.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class NotToHandleException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public NotToHandleException(final StackTraceElement[] stackTraceElements) {
        super();
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
