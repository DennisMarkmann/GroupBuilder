package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown if no tasks have to be done during the current operation.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class NothingToDoExeption extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "NothingToDoExeption";
    private static final String errorMessage = "Nothing to do for the chosen operation.";
    private static final long serialVersionUID = -4565962119370664301L;

    private final String message;

    public NothingToDoExeption(final String operation) {

        super(errorTitel, errorMessage, false, null);
        this.message = (Pojo.getPojo().getTranslation("NothingSelectedExceptionMessage") + operation + ".");
        Pojo.getPojo().setError(true);
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
