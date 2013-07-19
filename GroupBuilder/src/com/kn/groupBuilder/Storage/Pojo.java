package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

/**
 * Storage of the application. Contains various elements and is reached through the whole program. Most of the content can be
 * saved via XML files.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class Pojo {

    private ArrayList<Member> memberList = new ArrayList<Member>();;
    private ArrayList<Group> groupList = new ArrayList<Group>();
    private final String[] languageList = { "English", "German" };
    private final String[] formatList = { "XML", "TXT" };
    private final Settings settings = new Settings();

    public final ArrayList<Member> getMemberList() {
        return this.memberList;
    }

    public final void setMemberList(final ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public final void setGroupList(final ArrayList<Group> groupList) {
        this.groupList = groupList;

    }

    public final ArrayList<Group> getGroupList() {
        return this.groupList;
    }

    public final String[] getLanguageList() {
        return this.languageList;
    }

    public final String[] getFormatList() {
        return this.formatList;
    }

    public final Settings getSettings() {
        return this.settings;
    }

    public final Group getGroupByName(final String name) {
        for (final Group group : this.groupList) {
            if (group.getName().equals(name)) {
                return group;
            }
        }
        return null;
    }

    public final Member getMemberByName(final String firstName, final String lastName) {
        for (final Member member : this.memberList) {
            if (member.getFirstName().equals(firstName) && member.getLastName().equals(lastName)) {
                return member;
            }
        }
        return null;
    }

    public final String[] getGroupListAsArray() {

        final String[] groupListArray = new String[this.groupList.size() + 1];
        groupListArray[0] = "";
        for (int i = 1; i < groupListArray.length; i++) {
            groupListArray[i] = this.groupList.get(i - 1).getName();
        }
        return groupListArray;
    }
}
