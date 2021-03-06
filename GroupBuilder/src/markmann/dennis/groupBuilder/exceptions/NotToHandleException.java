package markmann.dennis.groupBuilder.exceptions;

/**
 * Exception without any handling needed.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class NotToHandleException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "NotToHandleException";
    private static final String errorMessage = "";

    private static final long serialVersionUID = -4565962119370664301L;

    public NotToHandleException() {
        super(errorTitel, errorMessage, false, null);
    }

    @Override
    public final void showDialog() {
    }
}
