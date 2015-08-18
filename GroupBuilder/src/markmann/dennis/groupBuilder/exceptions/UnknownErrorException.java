package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception without any specified solution.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class UnknownErrorException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "UnknownErrorException";
    private static final String errorMessage = "An unknown error appeared.";
    private final String message;

    private static final long serialVersionUID = -4565962119370664301L;

    public UnknownErrorException(final String operation) {

        super(errorTitel, errorMessage);
        this.message = (Pojo.getPojo().getTranslation("UnknownErrorLineOne") + operation
                + Pojo.getPojo().getTranslation("UnknownErrorLineTwo"));
        Pojo.getPojo().setError(true);
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
