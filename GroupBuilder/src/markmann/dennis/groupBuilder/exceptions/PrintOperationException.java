package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown if a file can't be written sucessfully.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class PrintOperationException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "PrintOperationException";
    private static final String errorMessage = "The print operation was not successfull.";
    private static final long serialVersionUID = 6498733673905740756L;

    private final String message;

    public PrintOperationException(final PrintOperationException e) {

        super(errorTitel, errorMessage, true, e);
        this.message = (Pojo.getPojo().getTranslation("PrintOperationExceptionMessage"));
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
