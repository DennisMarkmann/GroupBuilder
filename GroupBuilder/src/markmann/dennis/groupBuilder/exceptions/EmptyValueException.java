package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown in case a value is empty but needed.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmptyValueException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "EmptyValueException";
    private static final String errorMessage = "The chosen value is not allowed to be empty.";
    private final String message;

    private static final long serialVersionUID = -4565962119370664301L;

    public EmptyValueException(final String field) {

        super(errorTitel, errorMessage);
        this.message = (Pojo.getPojo().getTranslation("EmptyValueLineOne") + field
                + Pojo.getPojo().getTranslation("EmptyValueLineTwo"));
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
