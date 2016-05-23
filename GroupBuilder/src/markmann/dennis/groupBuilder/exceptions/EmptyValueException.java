package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown in case a value is empty but needed.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class EmptyValueException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "EmptyValueException";
    private static final String errorMessage = "The chosen value is not allowed to be empty.";
    private static final long serialVersionUID = -4565962119370664301L;

    private final String message;

    public EmptyValueException(final String field) {

        super(errorTitel, errorMessage, false, null);
        this.message = (Pojo.getPojo().getTranslation("EmptyValueExceptionMessageLineOne") + field
                + Pojo.getPojo().getTranslation("EmptyValueExceptionMessageLineTwo"));
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
