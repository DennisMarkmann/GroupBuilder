package com.kn.groupBuilder.UnusedFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.kn.groupBuilder.Exceptions.WriteOperationException;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

class TextFileWriter {

    public final void writeDefaultFiles(final Pojo pojo) {

        try {
            this.writeTextFile(pojo.getMemberList(), null, "MemberList.txt", pojo.getSettings().getPath(), null);
        } catch (final IOException e) {
            new WriteOperationException(pojo.getSettings().getPath() + "MemberList.txt", e.getStackTrace()).showDialog();
        }
        try {
            this.writeTextFile(null, pojo.getGroupList(), "GroupList.txt", pojo.getSettings().getPath(), null);
        } catch (final IOException e) {
            new WriteOperationException(pojo.getSettings().getPath() + "GroupList.txt", e.getStackTrace()).showDialog();
        }
    }

    final void writeTextFile(
            final ArrayList<Member> memberList,
            final ArrayList<Group> groupList,
            final String fileName,
            final String path,
            final Group group) throws IOException {

        FileWriter writer = null;
        final File file = new File(path);

        try {
            writer = new FileWriter(path + fileName);

        } catch (final FileNotFoundException e) {
            file.mkdirs();
            writer = new FileWriter(path + fileName);
        }

        try {

            if (group != null) {

                for (final Member member : group.getMemberList()) {
                    writer.write(member.getFirstName() + "." + member.getLastName());
                    writer.write(System.getProperty("line.separator"));
                }

            } else if (groupList != null) {
                for (final Group group2 : groupList) {
                    if (group2.getFixSize() != 0) {
                        writer.write(group2.getName() + ", " + group2.getFixSize());
                    } else {
                        writer.write(group2.getName());
                    }

                    writer.write(System.getProperty("line.separator"));
                }

            } else if (memberList != null) {
                for (final Member member : memberList) {
                    writer.write(member.getFirstName() + "." + member.getLastName());
                    writer.write(System.getProperty("line.separator"));
                }
            }

            writer.flush();

        } finally {

            writer.close();
        }
    }
}
