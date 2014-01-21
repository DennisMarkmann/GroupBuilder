package markmann.dennis.groupBuilder.toImplement.move;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import markmann.dennis.groupBuilder.logging.LogHandler;

import org.apache.log4j.Logger;

/**
 * Used to read files from the given sourcePath (number of files is given via
 * property file*2). And to start the moving of the files to the given
 * destination.
 * 
 * @author dennis.markmann
 * 
 */

public class FileReader {

	private static Logger logger = LogHandler.getLogger("./logs/FileMover.log");
	private int i = 0;

	public final void readFiles(final String sourcePath, final String destPath,
			final int filesToLoad) {

		final FileMover mover = new FileMover(destPath);
		final Path path = FileSystems.getDefault().getPath(sourcePath);

		try {
			Files.walkFileTree(path, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(final Path dir,
						final BasicFileAttributes attrs) throws IOException {
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(final Path file,
						final BasicFileAttributes attrs) throws IOException {
					mover.moveFile(file.toFile());
					i++;
					if (i == filesToLoad) {
						logger.info("Completed moving files.");
						return FileVisitResult.TERMINATE;
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(final Path file,
						final IOException exc) throws IOException {
					return FileVisitResult.TERMINATE;
				}

				@Override
				public FileVisitResult postVisitDirectory(final Path dir,
						final IOException exc) throws IOException {
					return FileVisitResult.CONTINUE;
				}
			});

			if (i != filesToLoad) {
				logger.info("Number of files actually moved: " + i + ".");
				logger.info("Completed moving files.");
			}

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}
