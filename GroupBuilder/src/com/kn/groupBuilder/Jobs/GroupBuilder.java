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
        final ArrayList<Member> memberList = this.mixMemberList(pojo.getMemberList());
        this.assignGroups(memberList, pojo.getGroupList());
    }

    private ArrayList<Member> mixMemberList(final ArrayList<Member> memberList) {

        Collections.shuffle(memberList);
        return memberList;

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
            group.getMemberList().add(memberList.get(this.memberIndex));
            memberList.get(this.memberIndex).getGroupList().add(group);
            this.memberIndex++;

            if (group.getMemberList().size() < fixSize) {
                this.addMemberToGroup(group, memberList, fixSize);
            }

        }
    }
}
