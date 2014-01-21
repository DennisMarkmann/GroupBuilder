package markmann.dennis.groupBuilder.toImplement.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class LoaderThread {

	/**
	 * This will run the Configuration thread.
	 * 
	 * @param locationConfigFile
	 *            is the path and filename regarding the configuration file.
	 * 
	 * @author dennis.markmann
	 */

	void start(final String locationConfigFile) {

		// Runner to execute the data arrived methods
		final Runnable readConfig = new Runnable() {

			@Override
			public void run() {

				final File f = new File(locationConfigFile);
				long fileChange = 0;

				while (!Thread.interrupted()) {
					if (fileChange != f.lastModified()) {
						try {

							fileChange = f.lastModified();

							Configuration.properties.load(new FileInputStream(
									locationConfigFile));

						} catch (final IOException e) {
							System.err.println("Can not read properties: "
									+ e.getMessage());
						}
					}

					Configuration.isLoaded = true;

					try {
						Thread.sleep(15000);
					} catch (final InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		};

		final Thread thread = new Thread(readConfig, "Configuration Thread");
		thread.start();
	}
}
