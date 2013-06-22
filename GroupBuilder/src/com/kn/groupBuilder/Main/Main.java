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
        // new FileCleaner().cleanFiles(pojo.getSettings().getPath());
        // new PojoContentTester().initializeDefaultTest(pojo);

        new FileReaderHelper().readXMLFiles(pojo);
        // new GroupBuilder().buildGroups(pojo);

        // new DefaultTestCreator().startTests(pojo);
        // new EmailJobHelper().initializeEmailSending(pojo);
        // new PrintJobHelper().printAllGroups(pojo);
        //
        // new FileCleaner().cleanFolder(pojo.getDefaultPath() + "\\Archive\\");

        new MainFrame().createGui(pojo);

        // Veraltet
        // new TextFileReader().readDefaultLists(pojo);
        // new GroupFolderCleaner().cleanGroupFolder(pojo.getDefaultPath());
        // new TextFileWriter().writeDefaultFiles(pojo);
        // System.exit(0);
    }
}
