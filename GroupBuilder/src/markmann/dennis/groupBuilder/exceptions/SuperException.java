package markmann.dennis.groupBuilder.exceptions;

import java.util.Date;

import javax.swing.JOptionPane;

import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Used as super class for other exceptions to implement the showErrorMessage
 * method.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

public class SuperException extends Exception {

	private static final long serialVersionUID = 708521289592050569L;

	private String errorTitel = "";
	private String errorMessage = "";
	private Date date = null;

	public SuperException(final String errorTitel, final String errorMessage) {
		super(errorMessage);

		this.errorTitel = errorTitel;
		this.errorMessage = errorMessage;
		this.date = new Date();
	}

	public final String createLogingMessage() {
		final StringBuffer sb = new StringBuffer();
		sb.append(this.date);
		sb.append("' Titel'");
		sb.append(this.errorTitel);
		sb.append("'");
		return sb.toString();
	}

	public final String showErrorMessage() {
		final StringBuffer sb = new StringBuffer();
		sb.append(this.errorTitel);
		sb.append("' '");
		sb.append(this.errorMessage);
		sb.append("'");
		return sb.toString();
	}

	public final void showDialog(final String message) {
		JOptionPane.showMessageDialog(null, message, "Error",
				JOptionPane.ERROR_MESSAGE);
		Pojo.getPojo().setError(true);
	}
}
