package com.kn.groupBuilder.Jobs;

import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to sort the GroupList. Sorts the Groups with fix size to the beginning, so that this will be prioritized before the
 * others. Important for building groups.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class GroupListSorter {

    final void sortArrayListForPriority(final Pojo pojo) {
        boolean hasFixSize = false;
        final ArrayList<Group> groupList = pojo.getGroupList();
        final ArrayList<Group> tempGroupList = new ArrayList<Group>();

        for (final Group group : groupList) {
            hasFixSize = this.hasFixSize(group);

            if (!hasFixSize) {
                tempGroupList.add(group);
            }
        }

        for (final Group group : tempGroupList) {
            groupList.remove(group);
            groupList.add(group);
        }
        pojo.setGroupList(groupList);
    }

    private boolean hasFixSize(final Group group) {
        return group.getFixSize() != 0;
    }
}
