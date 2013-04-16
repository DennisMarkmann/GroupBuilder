package com.kn.groupBuilder.Test;

import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Pojo;

public class TestDataCreator {

	public void fillTestMemberList(Pojo pojo) {

		MemberCreator creator = new MemberCreator();

		creator.createMember("Test1", "User1", "godlikeBot@gmx.net", pojo);
		creator.createMember("Test2", "User2", "godlike_bot@gmx.de", pojo);
		creator.createMember("Test3", "User3", pojo);
		creator.createMember("Test1", "User4", pojo);
		creator.createMember("Test2", "User5", pojo);
		creator.createMember("Test3", "User6", pojo);
		creator.createMember("Test1", "User7", pojo);
		creator.createMember("Test2", "User8", pojo);
		creator.createMember("Test3", "User9", "godlikeBot@gmx.net", pojo);

	}

	public void fillTestGroupList(Pojo pojo) {

		GroupCreator creator = new GroupCreator();

		creator.createGroupsManually("Group1", 4, "desc", pojo);
		creator.createGroupsManually("Group2", 1, "test", pojo);
		creator.createGroupsManually("Group3", "test", pojo);
		creator.createGroupsManually("Group4", "", pojo);
		creator.createGroupsManually("Group5", 1, "", pojo);

		// creator.createGroupsAutmatically(4, pojo);

	}
}
