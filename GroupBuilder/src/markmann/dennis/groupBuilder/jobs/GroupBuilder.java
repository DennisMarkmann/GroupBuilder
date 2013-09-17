package markmann.dennis.groupBuilder.jobs;

import java.util.ArrayList;
import java.util.Collections;

import markmann.dennis.groupBuilder.gui.popups.OperationSuccessfullFrame;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Used to assign or unassign members to groups.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class GroupBuilder {

    private int memberIndex = 0;
    private Pojo pojo;

    public final void buildGroups(final Pojo pojo) {

        this.pojo = pojo;
        new GroupListSorter().sortArrayListForPriority(pojo);
        this.assignGroups(this.mixList(pojo.getMemberList()), pojo.getGroupList());
    }

    public final void buildUnassignedGroups(final Pojo pojo) {

        this.pojo = pojo;

        new GroupListSorter().sortArrayListForPriority(pojo);
        final ArrayList<Member> unassignedMemberList = new ArrayList<Member>();
        for (final Member member : pojo.getMemberList()) {
            if (member.getGroup() == null) {
                unassignedMemberList.add(member);
            }
        }
        this.assignGroups(this.mixList(unassignedMemberList), pojo.getGroupList());
        if (unassignedMemberList.size() != 0) {
            OperationSuccessfullFrame.getInstance(pojo.getTranslation("UnassignedSuccess"), pojo);
        } else {
            OperationSuccessfullFrame.getInstance(pojo.getTranslation("NoChangesAssigned"), pojo);
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
        OperationSuccessfullFrame.getInstance(this.pojo.getTranslation("BuildSuccess"), this.pojo);
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
