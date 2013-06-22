package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

public class Pojo {

    private ArrayList<Member> memberList = new ArrayList<Member>();;
    private ArrayList<Group> groupList = new ArrayList<Group>();
    private final String[] languageList = { "German", "English" };
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

}
