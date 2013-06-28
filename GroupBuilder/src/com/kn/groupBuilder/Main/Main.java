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
        // final Prevent instantiation
        // throws an exception e.g. AssertionError
        // if this ever *is* called
        throw new AssertionError("Instantiating utility class");
    }

    public static void main(final String[] args) throws IOException {

        final Pojo pojo = new Pojo();
        // new PojoContentTester().initializeDefaultTest(pojo);

        new FileReaderHelper().readXMLFiles(pojo);

        // new DefaultTestCreator().startTests(pojo);
        //

        new MainFrame().createGui(pojo);

        // Veraltet
        // new TextFileReader().readDefaultLists(pojo);
        // new GroupFolderCleaner().cleanGroupFolder(pojo.getSettings().getPath());
        // new TextFileWriter().writeDefaultFiles(pojo);
        // System.exit(0);
    }
}
