package markmann.dennis.groupBuilder.toImplement.configuration;

/**
 * This class offers different methods to get the variables of the property
 * file.
 * 
 * @author dennis.markmann
 * 
 */

public class ConfigLoader {

	public final int getFilesToLoad() {
		return Integer.parseInt(this.getValueOfProperty("FilesToLoad"));
	}

	public final String getSourcePath() {
		return this.getValueOfProperty("SourcePath");
	}

	public final String getDestPath() {
		return this.getValueOfProperty("DestPath");
	}

	private String getValueOfProperty(final String property) {
		return Configuration.properties.getProperty(property);
	}

}
