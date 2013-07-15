package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception without any handling needed.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmptyValueException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public EmptyValueException(final String field) {
        super("The value of \"" + field + "\" is not allow to be empty.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
