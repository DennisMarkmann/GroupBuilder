package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

import com.kn.groupBuilder.Storage.Pojo;

/**
 * Exception thrown if no tasks have to be done during the current operation.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class NothingToDoExeption extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public NothingToDoExeption(final String operation) {
        super(Pojo.getPojo().getMessages("NothingSelectedText") + operation + ".");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        Pojo.getPojo().setError(true);
    }
}
