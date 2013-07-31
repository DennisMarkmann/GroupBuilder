package com.kn.groupBuilder.Main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kn.groupBuilder.Exceptions.NotToHandleException;
import com.kn.groupBuilder.Exceptions.WriteOperationException;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Handler to write down and read in the applications default properties. Saves the application path for the pojo.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PropertyHandler {

    public final void storeProperties(final String path) {

        final Properties properties = new Properties();

        properties.put("path", path);

        final String fileName = System.getProperty("user.home") + System.getProperty("file.separator")
                + "groupBuilder.properties";
        try {
            properties.store(new FileOutputStream(fileName), "groupBuilderProperties");
        } catch (final Exception e) {
            new WriteOperationException(fileName, e.getStackTrace());
        }
    }

    final void getProperties(final Pojo pojo) {

        final Properties properties = new Properties();
        BufferedInputStream stream = null;
        final String propertyPath = System.getProperty("user.home") + System.getProperty("file.separator")
                + "groupBuilder.properties";
        try {
            stream = new BufferedInputStream(new FileInputStream(propertyPath));
            properties.load(stream);
            stream.close();
            final String path = properties.getProperty("path");

            if (path != null) {
                pojo.getSettings().setPathInitially(path);
            }
        } catch (final FileNotFoundException e) {
            new NotToHandleException(e.getStackTrace());
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }
}
