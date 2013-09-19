package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.fileOperations.output.ExceptionLogger;

/**
 * Exception thrown if a file can't be written sucessfully.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrinterSelectionException extends SuperException implements
		ExceptionDialogInterface {

	private static final String errorTitel = "PrinterSelectionException";
	private static final String errorMessage = "The chosen printer is not available.";
	private final String message;

	private static final long serialVersionUID = 6498733673905740756L;

	public PrinterSelectionException(
			final dennis.markmann.MyLibraries.DefaultJobs.Print.PrinterSelectionException e) {

		// TODO deutsche Übersetzung
		super(errorTitel, errorMessage);
		new ExceptionLogger().logException(this);
		this.message = (e.getErrorMessage());
	}

	@Override
	public final void showDialog() {
		super.showDialog(this.message);
	}
}
