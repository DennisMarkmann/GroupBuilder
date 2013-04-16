package com.kn.groupBuilder.Test;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class PojoContentTester {

	public void initializeDefaultTest(Pojo pojo) {

		TestDataCreator testListCreator = new TestDataCreator();
		testListCreator.fillTestMemberList(pojo);
		testListCreator.fillTestGroupList(pojo);
		this.testLists(pojo);

	}

	public void testLists(Pojo pojo) {

		System.out.println("---ListTest---");
		System.out.println("Groups: ");

		for (Group group : pojo.getGroupList()) {
			System.out.println(group.getName());
		}

		System.out.println("");
		System.out.println("Member: ");

		for (Member member : pojo.getMemberList()) {
			System.out.print(member.getFirstName() + ".");
			System.out.println(member.getLastName());
		}

		System.out.println("---------------\n");
	}
}
