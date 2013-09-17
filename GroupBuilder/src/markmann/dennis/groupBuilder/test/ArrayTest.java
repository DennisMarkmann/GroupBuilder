package markmann.dennis.groupBuilder.test;

import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Used to see all groups and members currently in the POJO. Is going to be replaced with a JUnit test.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class ArrayTest {

    public final void testArrays(final Pojo pojo) {

        System.out.println("Show groupList of member:");
        for (final Member member : pojo.getMemberList()) {
            System.out.print(member.getFirstName() + "." + member.getLastName() + ": ");
            // for (final Group group : member.getGroupList()) {
            // System.out.print(group.getName() + " ");
            // }
            System.out.println();
        }
        System.out.println("\nShow memberList of groups:");
        for (final Group group : pojo.getGroupList()) {
            System.out.print(group.getName() + ": ");
            for (final Member member : group.getMemberList()) {
                System.out.print(member.getFirstName() + "." + member.getLastName() + " ");
            }
            System.out.println();
        }
        System.out.println("---------------\n");
    }
}
