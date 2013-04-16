package com.kn.groupBuilder.Jobs;

import java.util.ArrayList;
import java.util.Collections;

import com.kn.groupBuilder.FileOperations.Writer.GroupFileWriter;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupBuilder {

	private int memberIndex = 0;

	public void buildGroups(Pojo pojo) {

		new GroupListSorter().sortArrayList(pojo);
		ArrayList<Member> memberList = this.mixMemberList(pojo.getMemberList());
		this.assignGroups(memberList, pojo.getGroupList());
		new GroupFileWriter().initializeXMLPrint(pojo.getGroupList(),
				pojo.getDefaultPath());
	}

	private ArrayList<Member> mixMemberList(ArrayList<Member> memberList) {

		Collections.shuffle(memberList);
		return memberList;

	}

	private void assignGroups(ArrayList<Member> memberList,
			ArrayList<Group> groupList) {

		for (Group group : groupList) {

			int fixSize = group.getFixSize();

			if (this.memberIndex < memberList.size()) {

				this.addMemberToGroup(group, memberList, fixSize);

			} else {
				return;
			}

		}
		this.assignGroups(memberList, groupList);

	}

	private void addMemberToGroup(Group group, ArrayList<Member> memberList,
			int fixSize) {

		if (fixSize == 0 || group.getMemberList().size() < fixSize) {
			group.getMemberList().add(memberList.get(this.memberIndex));
			memberList.get(this.memberIndex).getGroupList().add(group);
			this.memberIndex++;

			if (group.getMemberList().size() < fixSize) {
				addMemberToGroup(group, memberList, fixSize);
			}

		}
	}
}
