package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception thrown if a the sendEmail operation fails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class SendEmailOperationException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public SendEmailOperationException(final StackTraceElement[] stackTraceElements) {
        super("An error appeared while trying to send an e-mail."
                + " Please disable your firewall and check your network connection before trying again.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
