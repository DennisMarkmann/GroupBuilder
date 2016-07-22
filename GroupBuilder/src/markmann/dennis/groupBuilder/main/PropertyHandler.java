package markmann.dennis.groupBuilder.main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import markmann.dennis.groupBuilder.exceptions.NotToHandleException;
import markmann.dennis.groupBuilder.exceptions.WriteOperationException;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Handler to write down and read in the applications default properties. Saves the application path for the pojo.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class PropertyHandler {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/GroupBuilder.log");

    private final String propertyPath = "./groupBuilder.properties";

    public final void getProperties(final Pojo pojo) {

        LOGGER.info("Get properties.");

        final Properties properties = new Properties();
        BufferedInputStream stream = null;

        try {
            stream = new BufferedInputStream(new FileInputStream(this.propertyPath));
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

    public final void storeProperties(final String path) {

        LOGGER.info("Storing properties.");
        final Properties properties = new Properties();

        properties.put("path", path);
        try {
            properties.store(new FileOutputStream(this.propertyPath), "groupBuilderProperties");
        } catch (final Exception e) {
            new WriteOperationException(this.propertyPath);
        }
    }
}
