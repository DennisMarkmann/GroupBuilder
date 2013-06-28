package com.kn.groupBuilder.Test;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to start the different test operations. Another test for the POJO content. Is going to be replaced with a JUnit test.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PojoContentTester {

    public final void initializeDefaultTest(final Pojo pojo) {

        final TestDataCreator testListCreator = new TestDataCreator();
        testListCreator.fillTestMemberList(pojo);
        testListCreator.fillTestGroupList(pojo);
        this.testLists(pojo);

    }

    public final void testLists(final Pojo pojo) {

        System.out.println("---ListTest---");
        System.out.println("Groups: ");

        for (final Group group : pojo.getGroupList()) {
            System.out.println(group.getName());
        }

        System.out.println("");
        System.out.println("Member: ");

        for (final Member member : pojo.getMemberList()) {
            System.out.print(member.getFirstName() + ".");
            System.out.println(member.getLastName());
        }

        System.out.println("---------------\n");
    }
}
