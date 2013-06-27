package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

public class Member {

    private String firstName = "";
    private String lastName = "";
    private ArrayList<Group> groupList = new ArrayList<Group>();
    // private ArrayList<Group> groupList = new ArrayList<Group>();
    private String eMailAdress = "";

    public Member(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Member(final String firstName, final String lastName, final String eMailAdress) {
        this(firstName, lastName);
        this.eMailAdress = eMailAdress;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final void setFirstName(final String name) {
        this.firstName = name;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final ArrayList<Group> getGroupList() {
        return this.groupList;
    }

    public final void setGroupList(final ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    public final String getEMailAdress() {
        return this.eMailAdress;
    }

    public final void setEMailAdress(final String eMailAdress) {
        this.eMailAdress = eMailAdress;
    }

}
