package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown if a file can't be written sucessfully.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class PrinterSelectionException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "PrinterSelectionException";
    private static final String errorMessage = "The chosen printer is not available.";
    private static final long serialVersionUID = 6498733673905740756L;

    private final String message;

    public PrinterSelectionException(final PrinterSelectionException e) {

        super(errorTitel, errorMessage, true, e);
        this.message = (Pojo.getPojo().getTranslation("PrinterSelectionExceptionMessage"));
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
