package markmann.dennis.groupBuilder.toImplement.configuration;

import java.util.Properties;

/**
 * This will hold the and reload the configuration.
 *
 * @author dennis.markmann
 *
 */

class Configuration {

    /**
     * This is the public variable to hold all configuration parts.
     */
    static Properties properties = new Properties();
    public static boolean isLoaded = false;
    private static LoaderThread loader;

    /**
     * Starts the loader thread.
     *
     * @param location - path an filename to the property file.
     */
    public static void loader(final String location) {

        loader = new LoaderThread();
        loader.start(location);
    }
}
