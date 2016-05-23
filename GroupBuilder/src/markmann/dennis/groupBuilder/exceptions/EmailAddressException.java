package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown if a file can't be written sucessfully.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class EmailAddressException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "EmailAddressException";
    private static final String errorMessage = "The chosen email address is not valid.";
    private static final long serialVersionUID = 6498733673905740756L;

    private final String message;

    public EmailAddressException(final EmailAddressException e) {

        super(errorTitel, errorMessage, true, e);
        this.message = (Pojo.getPojo().getTranslation("CopyExceptionMessage"));
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
