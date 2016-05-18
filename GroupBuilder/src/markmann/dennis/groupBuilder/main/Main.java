package markmann.dennis.groupBuilder.main;

import java.io.IOException;
import java.io.PrintStream;

import markmann.dennis.groupBuilder.gui.mainFrame.MainFrame;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.logging.LoggingOutputStream;
import markmann.dennis.groupBuilder.storage.Pojo;
import markmann.dennis.groupBuilder.test.PojoContentTester;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Main class for the project. Creates the POJO to store all data in. Starts the read operation for stored GroupBuilder files.
 * Creates the GUI for the user.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class Main { // NO_UCD

    private static final Logger LOGGER = LogHandler.getLogger("./logs/GroupBuilder.log");

    private Main() {
        // Should prevent instantiation, throws an exception in case this still
        // is called somehow.
        throw new AssertionError("Instantiating utility class");
    }

    public static void main(final String[] args) throws IOException {

        System.setOut(new PrintStream(new LoggingOutputStream(LOGGER, Level.INFO), true));
        System.setErr(new PrintStream(new LoggingOutputStream(LOGGER, Level.ERROR), true));

        LOGGER.info("Application starting.");

        final Pojo pojo = new Pojo();
        new PropertyHandler().getProperties(pojo);

        new PojoContentTester().initializeDefaultTest(pojo);
        // new FileReaderHelper().readXMLFiles(pojo);
        new LanguageChooser().chooseLanguage(pojo);

        // new DefaultTestCreator().startTests(pojo);

        MainFrame.getInstance().createGui(pojo);

    }
}
