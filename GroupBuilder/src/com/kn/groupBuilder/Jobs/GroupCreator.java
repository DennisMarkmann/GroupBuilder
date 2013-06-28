package com.kn.groupBuilder.Jobs;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to create new group objects.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class GroupCreator {

    private final Pojo pojo;

    public GroupCreator(final Pojo pojo) {
        this.pojo = pojo;
    }

    public final void createGroupsManually(final String name, final String description) {
        this.pojo.getGroupList().add(new Group(name, description));
    }

    public final void createGroupsManually(final String name, final int fixSize, final String description) {
        this.pojo.getGroupList().add(new Group(name, fixSize, description));
    }

    public final void createGroupsAutmatically(final int memberPerGroup) {

        final int numberOfGroups = this.pojo.getMemberList().size() / memberPerGroup;

        for (int i = 0; i < numberOfGroups; i++) {
            this.pojo.getGroupList().add(new Group("Group" + i));
        }
    }
}
