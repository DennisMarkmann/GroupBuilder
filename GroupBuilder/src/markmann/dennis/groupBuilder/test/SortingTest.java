package markmann.dennis.groupBuilder.test;

import java.util.ArrayList;

import markmann.dennis.groupBuilder.storage.Group;

/**
 * Used to show the groupList content after sorting. Is going to be replaced with a JUnit test.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class SortingTest {

    public final void testGroupLists(final ArrayList<Group> groupList) {
        System.out.println("Show results after sorting: (sorted after fix groupSize) ");
        for (final Group group : groupList) {
            System.out.println(group.getName() + " " + group.getFixSize());
        }
        System.out.println("---------------\n");
    }
}
