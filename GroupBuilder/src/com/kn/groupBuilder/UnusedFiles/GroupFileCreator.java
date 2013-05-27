package com.kn.groupBuilder.UnusedFiles;

import java.io.IOException;
import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;

public class GroupFileCreator {

    public final void writeGroupFiles(final String defaultPath, final ArrayList<Group> groupList) {

        TextFileWriter writer = new TextFileWriter();

        for (Group group : groupList) {
            String fileName = group.getName() + ".txt\\";

            try {
                writer.writeTextFile(null, null, fileName, defaultPath + "\\Groups\\", group);

            } catch (IOException e) {
                System.out.println("An error occured writing the file: \"" + fileName + "\"");
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
