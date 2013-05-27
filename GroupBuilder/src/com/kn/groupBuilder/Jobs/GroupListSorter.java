package com.kn.groupBuilder.Jobs;

import java.util.ArrayList;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupListSorter {

    public final void sortArrayList(final Pojo pojo) {
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

    public final boolean hasFixSize(final Group group) {

        return group.getFixSize() != 0;
    }
}
