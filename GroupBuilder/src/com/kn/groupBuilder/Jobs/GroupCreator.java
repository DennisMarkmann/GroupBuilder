package com.kn.groupBuilder.Jobs;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupCreator {

    public final void createGroupsManually(final String name, final String description, final Pojo pojo) {
        pojo.getGroupList().add(new Group(name, description));
    }

    public final void createGroupsManually(final String name, final int fixSize, final String description, final Pojo pojo) {
        pojo.getGroupList().add(new Group(name, fixSize, description));
    }

    public final void createGroupsAutmatically(final int memberPerGroup, final Pojo pojo) {

        final int numberOfGroups = pojo.getMemberList().size() / memberPerGroup;

        for (int i = 0; i < numberOfGroups; i++) {
            pojo.getGroupList().add(new Group("Group" + i));
        }
    }
}
