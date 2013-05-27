package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

public class Pojo {

    private String defaultPath = System.getProperty("user.home") + "\\Desktop\\" + "\\GroupBuilder\\";

    private ArrayList<Member> memberList = new ArrayList<Member>();;
    private ArrayList<Group> groupList = new ArrayList<Group>();

    public final String getDefaultPath() {
        return this.defaultPath;
    }

    public final void setDefaultPath(final String defaultPath) {
        this.defaultPath = defaultPath;
    }

    public final ArrayList<Member> getMemberList() {
        return this.memberList;
    }

    public final void setMemberList(final ArrayList<Member> memberList) {
        this.memberList = memberList;
    }

    public final void setGroupList(final ArrayList<Group> groupList) {
        this.groupList = groupList;

    }

    public ArrayList<Group> getGroupList() {
        return this.groupList;
    }
}
