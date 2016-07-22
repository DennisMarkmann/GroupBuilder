package markmann.dennis.groupBuilder.exceptions;

import java.util.Date;

import javax.swing.JOptionPane;

import markmann.dennis.groupBuilder.fileOperations.output.ExceptionLogger;

/**
 * Used as super class for other exceptions to implement the showErrorMessage method.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class SuperException extends Exception {

    private static final long serialVersionUID = 708521289592050569L;

    private String errorTitel = "";
    private String errorMessage = "";
    private Date date = null;
    private Exception exceptionBody = null;

    SuperException(final String errorTitel, final String errorMessage, boolean logException, Exception exceptionBody) {
        super(errorMessage);
        // TODO use exception for logging?
        this.errorTitel = errorTitel;
        this.errorMessage = errorMessage;
        this.date = new Date();
        this.exceptionBody = exceptionBody;
        if (logException) {
            new ExceptionLogger().logException(this);
        }
    }

    public final String createLogingMessage() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.date);
        sb.append("' Titel'");
        sb.append(this.errorTitel);
        sb.append("'");
        sb.append("/n" + this.exceptionBody);
        return sb.toString();
    }

    final void showDialog(final String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public final String showErrorMessage() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.errorTitel);
        sb.append("' '");
        sb.append(this.errorMessage);
        sb.append("'");
        return sb.toString();
    }
}
