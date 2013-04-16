package com.kn.groupBuilder.Test;

import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;

public class SortingTest {

	public void testGroupLists(ArrayList<Group> groupList) {
		System.out
				.println("Show results after sorting: (sorted after fix groupSize) ");
		for (Group group : groupList) {
			System.out.println(group.getName() + " " + group.getFixSize());
		}
		System.out.println("---------------\n");
	}
}
