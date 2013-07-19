package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

/**
 * Group object. Contains various elements and is able to get members assigned to.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class Group implements Comparable<Group> {

    private String name = "";
    private ArrayList<Member> memberList = new ArrayList<Member>();
    private int fixSize = 0;
    private String description = "";

    public Group(final String name) {
        this.name = name;
    }

    private Group(final String name, final int fixSize) {
        this(name);
        this.fixSize = fixSize;
    }

    public Group(final String name, final String description) {
        this(name);
        this.description = description;
    }

    public Group(final String name, final String descrition, final int fixSize) {
        this(name, fixSize);
        this.description = descrition;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final ArrayList<Member> getMemberList() {
        return this.memberList;
    }

    public final void setMemberList(final ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public final int getFixSize() {
        return this.fixSize;
    }

    public final void setFixSize(final int fixSize) {
        this.fixSize = fixSize;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(final String description) {
        this.description = description;
    }

    public final void addMember(final Member member) {
        this.memberList.add(member);
    }

    public final void removeMemberFromGroup(final Group group, final Member member) {
        this.memberList.remove(member);
        member.setGroup(null);
    }

    @Override
    public final int compareTo(final Group group) {
        return this.getName().compareTo(group.getName());
    }
}
