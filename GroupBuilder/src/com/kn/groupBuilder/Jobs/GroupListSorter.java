package com.kn.groupBuilder.Jobs;

import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupListSorter {

	public void sortArrayList(Pojo pojo) {
		boolean hasFixSize = false;
		ArrayList<Group> groupList = pojo.getGroupList();
		ArrayList<Group> tempGroupList = new ArrayList<Group>();
		for (Group group : groupList) {
			hasFixSize = this.hasFixSize(group);

			if (!hasFixSize) {
				tempGroupList.add(group);
			}
		}

		for (Group group : tempGroupList) {
			groupList.remove(group);
			groupList.add(group);
		}
		pojo.setGroupList(groupList);
	}

	public boolean hasFixSize(Group group) {

		return group.getFixSize() != 0;
	}
}
