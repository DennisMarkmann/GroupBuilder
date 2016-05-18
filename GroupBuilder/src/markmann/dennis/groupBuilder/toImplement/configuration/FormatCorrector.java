package markmann.dennis.groupBuilder.toImplement.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import markmann.dennis.groupBuilder.logging.LogHandler;

import org.apache.log4j.Logger;

/**
 * Used to replace slashes with backslashes in order to properly read in the property file later.
 * 
 * @author dennis.markmann
 * 
 */

public class FormatCorrector {

    private static Logger LOGGER = LogHandler.getLogger("./logs/FileMover.log");

    /**
     * Only replaces the property file in case there are backslashes contained.
     */

    public void correctPropertyFormat() {

        final File file = new File("./properties/FileMover.properties");

        try {
            final ArrayList<String> propertyContext = this.readIn(file);
            if (this.isWrongFormat(propertyContext)) {
                this.printOut(file, propertyContext);
                LOGGER.info("Corrected format of property file.");
            }

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads in the propertyFile line for line.
     * 
     * @param file the File to read in.
     * @return the ArrayList containing all lines of the file.
     * 
     * @throws IOException
     */

    private ArrayList<String> readIn(final File file) throws IOException {

        final ArrayList<String> propertyContext = new ArrayList<String>();
        final Reader fr = new FileReader(file);
        final BufferedReader br = new BufferedReader(fr);

        while (br.ready()) {
            propertyContext.add(br.readLine());
        }
        br.close();
        fr.close();
        return propertyContext;
    }

    /**
     * Checks if the format is wrong / the file contains slashes.
     * 
     * @param propertyContext the ArrayList containing all lines of the file.
     * 
     * @return boolean - shows if the format is wrong or not.
     */

    private boolean isWrongFormat(final ArrayList<String> propertyContext) {
        for (final String line : propertyContext) {
            if (line.contains("\\")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Overrides the property file with the new, corrected content.
     * 
     * @param file the file to override.
     * 
     * @param propertyContext the lines to write in the file.
     * 
     * @throws IOException
     */

    private void printOut(final File file, final ArrayList<String> propertyContext) throws IOException {

        final FileWriter fw = new FileWriter(file);
        for (String line : propertyContext) {
            line = line.replace("\\", "/");
            fw.write(line + "\n");
        }
        fw.close();
    }
}
