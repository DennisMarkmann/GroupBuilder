package com.kn.groupBuilder.Main;

import java.io.IOException;

import com.kn.groupBuilder.FileOperations.Reader.FileReaderHelper;
import com.kn.groupBuilder.Gui.MainFrame.MainFrame;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Main class for the project. Creates the pojo to store all data in. Starts the read operation for stored GroupBuilder files.
 * Creates the GUI for the user.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class Main { // NO_UCD

    private Main() {
        // Should prevent instantiation, throws an exception in case this still
        // is called somehow.
        throw new AssertionError("Instantiating utility class");
    }

    public static void main(final String[] args) throws IOException {

        final Pojo pojo = new Pojo();
        new PropertyHandler().getProperties(pojo);

        // new PojoContentTester().initializeDefaultTest(pojo);
        new FileReaderHelper().readXMLFiles(pojo);
        new LanguageChooser().chooseLanguage(pojo);

        // new DefaultTestCreator().startTests(pojo);

        new MainFrame().createGui(pojo);

    }
}
