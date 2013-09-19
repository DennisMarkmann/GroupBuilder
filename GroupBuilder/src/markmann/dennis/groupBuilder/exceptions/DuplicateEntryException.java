package markmann.dennis.groupBuilder.exceptions;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Exception thrown if a the sendEmail operation fails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class DuplicateEntryException extends SuperException implements
		ExceptionDialogInterface {

	private final static String errorTitel = "DuplicateEntryException";
	private final static String errorMessage = "The entry already exists.";
	private final String message;

	private static final long serialVersionUID = -4565962119370664301L;

	public DuplicateEntryException(final String name) {

		super(errorTitel, errorMessage);
		this.message = (Pojo.getPojo().getTranslation("DuplicateEntryLineOne")
				+ name + Pojo.getPojo().getTranslation("DuplicateEntryLineTwo"));
	}

	@Override
	public final void showDialog() {
		super.showDialog(this.message);
	}
}
