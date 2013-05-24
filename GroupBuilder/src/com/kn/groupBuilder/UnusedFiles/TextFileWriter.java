package com.kn.groupBuilder.UnusedFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class TextFileWriter {

	public void writeDefaultFiles(Pojo pojo) {

		try {
			this.writeTextFile(pojo.getMemberList(), null, "MemberList.txt",
					pojo.getDefaultPath(), null);
		} catch (IOException e) {
			System.out
					.println("An error occured writing the file: \"GroupList.txt\"");
			e.printStackTrace();
		}
		try {
			this.writeTextFile(null, pojo.getGroupList(), "GroupList.txt",
					pojo.getDefaultPath(), null);
		} catch (IOException e) {
			System.out
					.println("An error occured writing the file: \"GroupList.txt\"");
			e.printStackTrace();
		}
	}

	public final void writeTextFile(final ArrayList<Member> memberList,
			final ArrayList<Group> groupList, final String fileName,
			final String path, final Group group) throws IOException {

		FileWriter writer = null;
		File file = new File(path);

		try {
			writer = new FileWriter(path + fileName);

		} catch (FileNotFoundException e) {
			file.mkdirs();
			writer = new FileWriter(path + fileName);
		}

		try {

			if (group != null) {

				for (Member member : group.getMemberList()) {
					writer.write(member.getFirstName() + "."
							+ member.getLastName());
					writer.write(System.getProperty("line.separator"));
				}

			} else if (groupList != null) {
				for (Group group2 : groupList) {
					if (group2.getFixSize() != 0) {
						writer.write(group2.getName() + ", "
								+ group2.getFixSize());
					} else {
						writer.write(group2.getName());
					}

					writer.write(System.getProperty("line.separator"));
				}

			} else if (memberList != null) {
				for (Member member : memberList) {
					writer.write(member.getFirstName() + "."
							+ member.getLastName());
					writer.write(System.getProperty("line.separator"));
				}
			}

			writer.flush();

		} finally {

			writer.close();
		}
	}
}
