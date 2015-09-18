package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.fileOperations.output.ExceptionLogger;

/**
 * Exception thrown if a file can't be written sucessfully.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrintOperationException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "PrintOperationException";
    private static final String errorMessage = "The print operation was not successfull.";
    private final String message;

    private static final long serialVersionUID = 6498733673905740756L;

    public PrintOperationException(final PrintOperationException e) {

        // TODO deutsche Übersetzung
        super(errorTitel, errorMessage, true, e);
        new ExceptionLogger().logException(this);
        this.message = (e.getMessage());
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
