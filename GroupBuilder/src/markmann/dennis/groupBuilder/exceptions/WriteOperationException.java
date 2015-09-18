package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown if a file can't be written sucessfully.
 *
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class WriteOperationException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "WriteOperationException";
    private static final String errorMessage = "An error appeared while trying to fullfill the operation. Cookie was invalid.";
    private static final long serialVersionUID = 6498733673905740756L;

    private final String message;

    public WriteOperationException(final String path) {

        super(errorTitel, errorMessage, true, null);
        this.message = (Pojo.getPojo().getTranslation("WriteOperationExceptionMessage") + path);
        Pojo.getPojo().setError(true);
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
