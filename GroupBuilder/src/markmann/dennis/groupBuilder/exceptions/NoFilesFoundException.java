package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;
import dennis.markmann.MyLibraries.DefaultJobs.IconHelper.FileNotFoundException;

/**
 * Exception thrown if no file can't be found at the chosen location.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class NoFilesFoundException extends SuperException implements ExceptionDialogInterface {

    private static final String errorTitel = "NoFilesFoundException";
    private static final String errorMessage = "No valid data was found at the chosen path.";
    private final String message;

    private static final long serialVersionUID = -4565962119370664301L;

    public NoFilesFoundException(final String path) {

        super(errorTitel, errorMessage);
        this.message = (Pojo.getPojo().getTranslation("NoFilesFoundText") + path);
    }

    public NoFilesFoundException(final FileNotFoundException e) {
        super(errorTitel, errorMessage);
        // TODO deutsche Übersetzung
        this.message = (e.getErrorMessage());
    }

    @Override
    public final void showDialog() {
        super.showDialog(this.message);
    }
}
