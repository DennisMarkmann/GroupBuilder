package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.fileOperations.output.ExceptionLogger;

/**
 * Exception thrown if a file can't be written sucessfully.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmailSendingException extends SuperException implements
		ExceptionDialogInterface {

	private static final String errorTitel = "EmailSendingException";
	private static final String errorMessage = "An error appeared while trying to send a mail.";
	private final String message;

	private static final long serialVersionUID = 6498733673905740756L;

	public EmailSendingException(
			final dennis.markmann.MyLibraries.DefaultJobs.Email.EmailSendingException e) {

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
