package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

import com.kn.groupBuilder.Storage.Pojo;

/**
 * Exception thrown if a the sendEmail operation fails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class DuplicateEntryException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public DuplicateEntryException(final String name) {
        super(Pojo.getPojo().getTranslation("DuplicateEntryLineOne") + name + Pojo.getPojo().getTranslation("DuplicateEntryLineTwo"));
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        Pojo.getPojo().setError(true);
    }
}
