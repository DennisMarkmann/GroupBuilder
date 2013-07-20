package com.kn.groupBuilder.Main;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kn.groupBuilder.Exceptions.NoFilesFoundException;
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

    public void storeProperties(final Pojo pojo) {

        final Properties properties = new Properties();

        properties.put("path", pojo.getSettings().getPath());

        final String fileName = System.getProperty("user.home") + System.getProperty("file.separator")
                + "groupBuilder.properties";
        try {
            properties.store(new FileOutputStream(fileName), "groupBuilderProperties");
        } catch (final Exception e) {
            new WriteOperationException(fileName, e.getStackTrace());
        }
    }

    public String getProperties() {

        final Properties properties = new Properties();
        BufferedInputStream stream = null;
        final String path = System.getProperty("user.home") + System.getProperty("file.separator") + "groupBuilder.properties";
        try {
            stream = new BufferedInputStream(new FileInputStream(path));
            properties.load(stream);
            stream.close();

        } catch (final FileNotFoundException e) {
            new NoFilesFoundException(path, e.getStackTrace());
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty("path");

    }
}