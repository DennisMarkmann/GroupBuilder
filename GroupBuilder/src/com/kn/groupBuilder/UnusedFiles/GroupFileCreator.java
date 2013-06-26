package com.kn.groupBuilder.UnusedFiles;

import java.io.IOException;
import java.util.ArrayList;

import com.kn.groupBuilder.Exceptions.WriteOperationException;
import com.kn.groupBuilder.Storage.Group;

public class GroupFileCreator {

    public final void writeGroupFiles(final String path, final ArrayList<Group> groupList) {

        final TextFileWriter writer = new TextFileWriter();

        for (final Group group : groupList) {
            final String fileName = group.getName() + ".txt\\";

            try {
                writer.writeTextFile(null, null, fileName, path + "Groups\\", group);

            } catch (final IOException e) {
                new WriteOperationException(path + "Groups.txt").showDialog();
            }
        }
    }
}
