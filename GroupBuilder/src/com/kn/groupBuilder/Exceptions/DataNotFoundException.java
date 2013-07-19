package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception thrown if no entry can't be found in the program.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class DataNotFoundException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public DataNotFoundException(final String entry) {
        super(entry + " could not be found.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
