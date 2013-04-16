package com.kn.groupBuilder.Jobs;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupCreator {

	public void createGroupsManually(String name, String description, Pojo pojo) {

		pojo.getGroupList().add(new Group(name, description));

	}

	public void createGroupsManually(String name, int fixSize,
			String description, Pojo pojo) {

		pojo.getGroupList().add(new Group(name, fixSize, description));

	}

	public void createGroupsAutmatically(int memberPerGroup, Pojo pojo) {

		int numberOfGroups = pojo.getMemberList().size() / memberPerGroup;

		for (int i = 0; i < numberOfGroups; i++) {

			pojo.getGroupList().add(new Group("Group" + i));
		}

		for (Group group : pojo.getGroupList()) {
			System.out.println(group.getName());
		}
	}
}
