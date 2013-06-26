package com.kn.groupBuilder.Exceptions;

import javax.swing.JOptionPane;

public class SendEmailOperationException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public SendEmailOperationException(final String message) {
        super("An error appeared while trying to send an e-mail."
                + " Please disable your firewall and check your network connection before trying again.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
