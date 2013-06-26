package com.kn.groupBuilder.FileOperations.Output;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;

public class TextCreator {

    public String createText(final Group group) {

        final StringBuilder sb = new StringBuilder();

        sb.append("GroupName: ");
        sb.append(group.getName());
        sb.append(System.lineSeparator());
        sb.append("GroupSize: ");
        sb.append(group.getMemberList().size());
        sb.append(System.lineSeparator());
        sb.append("Decription: ");
        sb.append(group.getDescription());
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Member: ");
        sb.append(System.lineSeparator());

        for (final Member member : group.getMemberList()) {
            sb.append(member.getLastName());
            sb.append(", ");
            sb.append(member.getFirstName());
            sb.append(" : ");
            sb.append(member.getEMailAdress());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
