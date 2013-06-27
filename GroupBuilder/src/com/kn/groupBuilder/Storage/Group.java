package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

public class Group {

    private String name = "";
    private ArrayList<Member> memberList = new ArrayList<Member>();
    private int fixSize = 0;
    private String description = "";

    public Group(final String name) {
        this.name = name;
    }

    public Group(final String name, final int fixSize) {
        this(name);
        this.fixSize = fixSize;
    }

    public Group(final String name, final String description) {
        this(name);
        this.description = description;
    }

    public Group(final String name, final int fixSize, final String descrition) {
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

    public void addMemberToGroup(final Group group, final Member member) {
        this.memberList.add(member);
        member.getGroupList().add(group);
    }

    public void removeMemberFromGroup(final Group group, final Member member) {
        this.memberList.remove(member);
        member.getGroupList().remove(group);
    }
}
