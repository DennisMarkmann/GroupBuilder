package com.kn.groupBuilder.Storage;

import java.util.ArrayList;

/**
 * Member object. Contains various elements and is able to get assigned to groups.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class Member implements Comparable<Member> {

    private String firstName = "";
    private String lastName = "";
    private ArrayList<Group> groupList = new ArrayList<Group>();
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

    @Override
    public int compareTo(final Member member) {
        int result = this.getFirstName().compareTo(member.getFirstName());
        if (result == 0) {
            result = this.getLastName().compareTo(member.getLastName());
        }
        return result;
    }
}
