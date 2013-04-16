package com.kn.groupBuilder.UnusedFiles;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class TextFileReader {

	public void readDefaultLists(Pojo pojo) {

		try {
			this.readTextFile(pojo, "GroupList.txt");
		} catch (IOException e) {
			System.out
					.println("An error occured reading the file: \"GroupList.txt\"");
		}
		try {
			this.readTextFile(pojo, "MemberList.txt");
		} catch (IOException e) {
			System.out
					.println("An error occured reading the file: \"MemberList.txt\"");
		}
	}

	public void readTextFile(Pojo pojo, String fileName) throws IOException {

		try {

			DataInputStream in = new DataInputStream(new FileInputStream(
					pojo.getDefaultPath() + fileName));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";

			if (fileName.equals("GroupList.txt")) {

				ArrayList<Group> groupList = new ArrayList<Group>();

				while ((strLine = br.readLine()) != null) {

					if (strLine.contains(", ")) {
						String groupName = strLine.substring(0,
								strLine.indexOf(", "));
						int groupSize = 0;
						try {
							groupSize = Integer.parseInt(strLine.substring(
									strLine.indexOf(", ") + 2,
									strLine.indexOf(", ") + 3));
						} catch (Exception e) {
							System.out
									.println("An error occured writing the file: \"GroupList.txt\"");
							System.err.print(e);
						}
						groupList.add(new Group(groupName, groupSize));
					} else {
						groupList.add(new Group(strLine));
					}

				}
				pojo.setGroupList(groupList);

			} else if (fileName.equals("MemberList.txt")) {

				ArrayList<Member> memberList = new ArrayList<Member>();

				while ((strLine = br.readLine()) != null) {

					String firstName = strLine.substring(0,
							(strLine.indexOf(".")));
					String lastName = strLine.substring(
							(strLine.indexOf(".") + 1), (strLine.length()));

					memberList.add(new Member(firstName, lastName));
				}

				pojo.setMemberList(memberList);

			} else {

				System.out.println("Unknown file. No operations defined.");
			}
			in.close();
			br.close();
		} catch (IOException e) {
		}
	}
}
