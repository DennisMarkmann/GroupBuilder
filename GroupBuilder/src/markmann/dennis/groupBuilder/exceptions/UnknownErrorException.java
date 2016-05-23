package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception without any specified solution.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class UnknownErrorException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "UnknownErrorException";
    private static final String errorMessage = "An unknown error appeared.";
    private static final long serialVersionUID = -4565962119370664301L;

    private final String message;

    public UnknownErrorException(final String operation) {

        super(errorTitel, errorMessage, true, null);
        this.message = (Pojo.getPojo().getTranslation("UnknownErrorMessageLineOne") + operation
                + Pojo.getPojo().getTranslation("UnknownErrorMessageLineTwo"));
        Pojo.getPojo().setError(true);
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
