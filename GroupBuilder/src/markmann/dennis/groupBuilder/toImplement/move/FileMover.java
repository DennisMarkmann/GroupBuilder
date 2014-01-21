package markmann.dennis.groupBuilder.toImplement.move;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Used to move a file from its current position to the given destination.
 * 
 * @author dennis.markmann
 * 
 */

class FileMover {

	private final File destFolder;

	FileMover(final String destPath) {
		destFolder = new File(destPath);
	}

	final void moveFile(final File file) {
		try {
			FileUtils.moveFileToDirectory(file, destFolder, true);
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
