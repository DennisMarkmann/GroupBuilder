package com.kn.groupBuilder.Main;

import java.io.IOException;

import com.kn.groupBuilder.Archiving.GroupFileArchiver;
import com.kn.groupBuilder.FileOperations.FileCleaner;
import com.kn.groupBuilder.FileOperations.Reader.GroupListReader;
import com.kn.groupBuilder.FileOperations.Reader.MemberListReader;
import com.kn.groupBuilder.FileOperations.Writer.GroupListWriter;
import com.kn.groupBuilder.FileOperations.Writer.MemberListWriter;
import com.kn.groupBuilder.Gui.MainFrame;
import com.kn.groupBuilder.Jobs.GroupBuilder;
import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Test.DefaultTestCreator;
import com.kn.groupBuilder.Test.PojoContentTester;

public class Main {

    public static void main(final String[] args) throws IOException {

        final Pojo pojo = new Pojo();

        new FileCleaner().cleanFiles(pojo.getDefaultPath());
        new PojoContentTester().initializeDefaultTest(pojo);
        new GroupListReader().readXmlFile(pojo);
        new MemberListReader().readXmlFile(pojo);

        new GroupBuilder().buildGroups(pojo);

        // new GroupFileReader().readFiles(pojo.getDefaultPath() +
        // "//Groups//");
        new MemberListWriter().createXmlFile(pojo);
        new GroupListWriter().createXmlFile(pojo);

        new DefaultTestCreator().startTests(pojo);
        new GroupFileArchiver().archivGroupFiles(pojo.getDefaultPath());
        // new EmailJob().initializeEmailSending(pojo);
        // new PrintTool(null).printAllGroups(pojo);

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
