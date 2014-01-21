package markmann.dennis.groupBuilder.main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import markmann.dennis.groupBuilder.exceptions.NotToHandleException;
import markmann.dennis.groupBuilder.exceptions.WriteOperationException;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Handler to write down and read in the applications default properties. Saves
 * the application path for the pojo.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PropertyHandler {

	final String propertyPath = "./groupBuilder.properties";

	public final void storeProperties(final String path) {

		final Properties properties = new Properties();

		properties.put("path", path);
		try {
			properties.store(new FileOutputStream(propertyPath),
					"groupBuilderProperties");
		} catch (final Exception e) {
			new WriteOperationException(propertyPath);
		}
	}

	public final void getProperties(final Pojo pojo) {

		final Properties properties = new Properties();
		BufferedInputStream stream = null;

		try {
			stream = new BufferedInputStream(new FileInputStream(propertyPath));
			properties.load(stream);
			stream.close();
			final String path = properties.getProperty("path");

			if (path != null) {
				pojo.getSettings().setPathInitially(path);
			}
		} catch (final FileNotFoundException e) {
			new NotToHandleException();
		} catch (final IOException e) {
			e.printStackTrace();
		}

	}
}
