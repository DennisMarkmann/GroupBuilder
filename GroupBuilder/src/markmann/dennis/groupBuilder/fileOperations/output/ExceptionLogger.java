package markmann.dennis.groupBuilder.fileOperations.output;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import markmann.dennis.groupBuilder.exceptions.SuperException;

/**
 * Used to log exceptions thrown into a TXT file.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

public class ExceptionLogger {

	private boolean failed = false;

	public final boolean logException(final SuperException exception) {
		final String path = System.getProperty("user.home")
				+ System.getProperty("file.separator") + "GroupBuilder_log.txt";

		final String text = this.readFile(path);
		this.writeFile(text, exception, path);

		return this.failed;
	}

	private String readFile(final String path) {

		final StringBuffer sb = new StringBuffer();

		try {
			final FileReader fr = new FileReader(path);
			int ch;
			while ((ch = fr.read()) != -1) {
				sb.append((char) ch);
			}
			fr.close();

		} catch (final IOException e) {
		}
		return sb.toString();
	}

	private void writeFile(final String text, final SuperException exception,
			final String path) {
		try {
			final PrintWriter writer = new PrintWriter(new FileWriter(path));

			final StringBuilder sb = new StringBuilder();
			sb.append(text);
			sb.append(exception.createLogingMessage());
			writer.println(sb.toString());

			writer.flush();
			writer.close();

		} catch (final IOException e) {
			this.failed = true;
			// no way to handle an error when the error handling fails
		}
	}
}
