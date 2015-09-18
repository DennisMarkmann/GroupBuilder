package markmann.dennis.groupBuilder.exceptions;

/**
 * Exception thrown if a file can't be written sucessfully.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmailAddressException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "EmailAddressException";
    private static final String errorMessage = "The chosen email address is not valid.";
    private final String message;

    private static final long serialVersionUID = 6498733673905740756L;

    public EmailAddressException(final EmailAddressException e) {

        // TODO deutsche Übersetzung
        super(errorTitel, errorMessage, true, e);
        this.message = (e.getMessage());
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
