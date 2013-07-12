package com.kn.groupBuilder.Test;

import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used create testData. This contains member and groups. Is going to be replaced with a JUnit test.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class TestDataCreator {

    public final void fillTestMemberList(final Pojo pojo) {

        final MemberCreator creator = new MemberCreator(pojo);

        creator.createMember("Test1", "User1", "godlikeBot@gmx.net");
        creator.createMember("Test2", "User2", "godlike_bot@gmx.de");
        creator.createMember("Test3", "User3");
        creator.createMember("Test1", "User4");
        creator.createMember("Test2", "User5");
        creator.createMember("Test3", "User6");
        creator.createMember("Test1", "User7");
        creator.createMember("Test2", "User8");
        creator.createMember("Test3", "User9", "godlikeBot@gmx.net");

    }

    public final void fillTestGroupList(final Pojo pojo) {

        final GroupCreator creator = new GroupCreator(pojo);

        creator.createGroup("Group1", "desc", 4);
        creator.createGroup("Group2", "test", 1);
        creator.createGroup("Group3", "test");
        creator.createGroup("Group4", "");
        creator.createGroup("Group5", "", 1);

        // creator.createGroupsAutmatically(4, pojo);

    }
}
