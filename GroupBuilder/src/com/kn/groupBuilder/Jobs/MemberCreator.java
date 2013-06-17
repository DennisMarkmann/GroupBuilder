package com.kn.groupBuilder.Jobs;

import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class MemberCreator {

    public final void createMember(final String firstName, final String lastName, final Pojo pojo) {
        pojo.getMemberList().add(new Member(firstName, lastName));

    }

    public final void createMember(final String firstName, final String lastName, final String eMailAdress, final Pojo pojo) {
        pojo.getMemberList().add(new Member(firstName, lastName, eMailAdress));

    }
}
