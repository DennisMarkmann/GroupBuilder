package com.kn.groupBuilder.Test;

import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;

/**
 * Used to show the groupList content after sorting. Is going to be replaced with a JUnit test.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
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
