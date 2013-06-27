package com.kn.groupBuilder.Jobs;

import java.util.ArrayList;
import java.util.Collections;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupBuilder {

    private int memberIndex = 0;

    public final void buildGroups(final Pojo pojo) {

        new GroupListSorter().sortArrayList(pojo);
        this.assignGroups(this.mixList(pojo.getMemberList()), pojo.getGroupList());
    }

    public final void buildUnassignedGroups(final Pojo pojo) {

        new GroupListSorter().sortArrayList(pojo);
        final ArrayList<Member> unassignedMemberList = new ArrayList<Member>();
        for (final Member member : pojo.getMemberList()) {
            if (member.getGroupList().size() == 0) {
                unassignedMemberList.add(member);
            }
        }
        this.assignGroups(this.mixList(unassignedMemberList), pojo.getGroupList());

    }

    public final void removeGroups(final Pojo pojo) {
        for (final Member member : pojo.getMemberList()) {
            member.setGroupList(new ArrayList<Group>());
        }
        for (final Group group : pojo.getGroupList()) {
            group.setMemberList(new ArrayList<Member>());
        }
    }

    private ArrayList<Member> mixList(final ArrayList<Member> list) {

        Collections.shuffle(list);
        return list;

    }

    private void assignGroups(final ArrayList<Member> memberList, final ArrayList<Group> groupList) {

        for (final Group group : groupList) {
            final int fixSize = group.getFixSize();

            if (this.memberIndex < memberList.size()) {
                this.addMemberToGroup(group, memberList, fixSize);

            } else {
                return;
            }

        }
        this.assignGroups(memberList, groupList);

    }

    private void addMemberToGroup(final Group group, final ArrayList<Member> memberList, final int fixSize) {

        if (fixSize == 0 || group.getMemberList().size() < fixSize) {
            group.addMemberToGroup(group, memberList.get(this.memberIndex));

            // group.getMemberList().add(memberList.get(this.memberIndex));
            // memberList.get(this.memberIndex).getGroupList().add(group);
            this.memberIndex++;

            if (group.getMemberList().size() < fixSize) {
                this.addMemberToGroup(group, memberList, fixSize);
            }

        }
    }
}
