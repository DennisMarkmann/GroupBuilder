package com.kn.groupBuilder.Jobs;

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
        this.pojo.getMemberList().add(new Member(firstName, lastName));

    }

    public final void createMember(final String firstName, final String lastName, final String eMailAdress) {
        this.pojo.getMemberList().add(new Member(firstName, lastName, eMailAdress));

    }
}
