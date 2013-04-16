package com.kn.groupBuilder.Jobs;

import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class MemberCreator {

	public void createMember(String firstName, String lastName, Pojo pojo) {

		pojo.getMemberList().add(new Member(firstName, lastName));

	}

	public void createMember(String firstName, String lastName,
			String eMailAdress, Pojo pojo) {

		pojo.getMemberList().add(new Member(firstName, lastName, eMailAdress));

	}
}
