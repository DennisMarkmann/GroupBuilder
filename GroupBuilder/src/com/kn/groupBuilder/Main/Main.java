package com.kn.groupBuilder.Main;

import java.io.IOException;

import com.kn.groupBuilder.FileOperations.Other.FileCleaner;
import com.kn.groupBuilder.Gui.MainFrame.MainFrame;
import com.kn.groupBuilder.Jobs.GroupBuilder;
import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Test.PojoContentTester;

public final class Main { // NO_UCD

    private Main() {
        // final Prevent instantiation
        // throws an exception e.g. AssertionError
        // if this ever *is* called
        throw new AssertionError("Instantiating utility class");
    }

    public static void main(final String[] args) throws IOException {

        final Pojo pojo = new Pojo();

        new FileCleaner().cleanFiles(pojo.getSettings().getPath());
        new PojoContentTester().initializeDefaultTest(pojo);
        // new GroupListReader().readXmlFile(pojo);
        // new MemberListReader().readXmlFile(pojo);

        new GroupBuilder().buildGroups(pojo);

        // new GroupFileReader().readFiles(pojo.getDefaultPath() +
        // "//Groups//");
        // new MemberListWriter().createXmlFile(pojo);
        // new GroupListWriter().createXmlFile(pojo);
        // new GroupFileWriter().initializeXMLPrint(pojo);
        // new DefaultTestCreator().startTests(pojo);
        // new GroupFileArchiver().archivGroupFiles(pojo.getDefaultPath());
        // new EmailJobHelper().initializeEmailSending(pojo);
        // new PrintJobHelper().printAllGroups(pojo);
        //
        // new FileCleaner().cleanFolder(pojo.getDefaultPath() + "\\Archive\\");

        new MainFrame().createGui(pojo);

        // System.out.println("Das Programm wird beedent.");
        // System.exit(0);

        // Veraltet
        // new TextFileReader().readDefaultLists(pojo);
        // new GroupFolderCleaner().cleanGroupFolder(pojo.getDefaultPath());
        // new TextFileWriter().writeDefaultFiles(pojo);
        // System.exit(0);
    }
}
