package com.kn.groupBuilder.Jobs;

import com.kn.groupBuilder.Exceptions.DuplicateEntryException;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to create new member objects.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class MemberCreator {

    private final Pojo pojo;

    public MemberCreator(final Pojo pojo) {
        this.pojo = pojo;
    }

    public final void createMember(final String firstName, final String lastName) {
        this.addMemberToList(new Member(this.correctFormat(firstName), this.correctFormat(lastName)));
    }

    public final void createMember(final String firstName, final String lastName, final String eMailAdress) {
        this.addMemberToList(new Member(this.correctFormat(firstName), this.correctFormat(lastName), eMailAdress));
    }

    public void createMember(final String firstName, final String lastName, final String eMailAdress, final Group group) {
        this.addMemberToList(new Member(this.correctFormat(firstName), this.correctFormat(lastName), eMailAdress, group));

    }

    private final void addMemberToList(final Member member) {
        try {
            this.checkDuplicates(member.getFirstName(), member.getLastName());
        } catch (final DuplicateEntryException e) {
            e.showDialog();
            return;
        }
        this.pojo.getMemberList().add(member);
    }

    public final void removeMember(final Member member) {
        this.pojo.getMemberList().remove(this.pojo.getMemberByName(member.getFirstName(), member.getLastName()));
    }

    public final void editMember(final Member oldMember, final Member newMember) {
        final Member member = this.pojo.getMemberByName(oldMember.getFirstName(), oldMember.getLastName());
        member.setFirstName(newMember.getFirstName());
        member.setLastName(newMember.getLastName());
        member.setEMailAdress(newMember.getEMailAdress());
        // member.setGroupList(newMember.getGroupList());
    }

    private void checkDuplicates(final String firstName, final String lastName) throws DuplicateEntryException {
        if (this.pojo.getMemberByName(firstName, lastName) != null) {
            throw new DuplicateEntryException(firstName + "." + lastName);
        }
    }

    private String correctFormat(String string) {
        string = string.trim();
        string = string.toLowerCase();
        string = string.substring(0, 1).toUpperCase() + string.substring(1);
        return string;
    }
}
