package com.kn.groupBuilder.Jobs;

import java.util.ArrayList;
import java.util.Collections;

import com.kn.groupBuilder.Gui.Popups.OperationSuccessfullFrame;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to assign or unassign members to groups.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class GroupBuilder {

    private int memberIndex = 0;

    public final void buildGroups(final Pojo pojo) {

        new GroupListSorter().sortArrayListForPriority(pojo);
        this.assignGroups(this.mixList(pojo.getMemberList()), pojo.getGroupList());
    }

    public final void buildUnassignedGroups(final Pojo pojo) {

        new GroupListSorter().sortArrayListForPriority(pojo);
        final ArrayList<Member> unassignedMemberList = new ArrayList<Member>();
        for (final Member member : pojo.getMemberList()) {
            if (member.getGroup() == null) {
                unassignedMemberList.add(member);
            }
        }
        this.assignGroups(this.mixList(unassignedMemberList), pojo.getGroupList());
        if (unassignedMemberList.size() != 0) {
            OperationSuccessfullFrame.getInstance("Unassigned groups were successfully build.");
        } else {
            OperationSuccessfullFrame.getInstance("No changes. All groups were allready assigned.");
        }
    }

    public final void removeGroups(final Pojo pojo) {
        for (final Member member : pojo.getMemberList()) {
            member.setGroup(null);
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
        OperationSuccessfullFrame.getInstance("All groups were successfully build.");
    }

    private void addMemberToGroup(final Group group, final ArrayList<Member> memberList, final int fixSize) {

        if (fixSize == 0 || group.getMemberList().size() < fixSize) {
            final Member member = memberList.get(this.memberIndex);
            member.setGroup(group);
            group.addMember(member);
            this.memberIndex++;

            if (group.getMemberList().size() < fixSize) {
                this.addMemberToGroup(group, memberList, fixSize);
            }

        }
    }
}
