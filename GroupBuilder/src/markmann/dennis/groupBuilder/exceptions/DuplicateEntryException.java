package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown if a the sendEmail operation fails.
 *
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class DuplicateEntryException extends SuperException implements ExceptionDialogInterface {

    private final static String errorTitel = "DuplicateEntryException";
    private final static String errorMessage = "The entry already exists.";
    private static final long serialVersionUID = -4565962119370664301L;

    private final String message;

    public DuplicateEntryException(final String name) {

        super(errorTitel, errorMessage, true, null);
        this.message = (Pojo.getPojo().getTranslation("DuplicateEntryExceptionMessageLineOne") + name
                + Pojo.getPojo().getTranslation("DuplicateEntryExceptionMessageLineTwo"));
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
