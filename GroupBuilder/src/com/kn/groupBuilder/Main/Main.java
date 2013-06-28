package com.kn.groupBuilder.Main;

import java.io.IOException;

import com.kn.groupBuilder.FileOperations.Reader.FileReaderHelper;
import com.kn.groupBuilder.Gui.MainFrame.MainFrame;
import com.kn.groupBuilder.Storage.Pojo;

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
