package com.kn.groupBuilder.FileOperations.Output;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class PrintJobHelper {

    private String generateGroupText(final Group group) {

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

    public final void printAllGroups(final Pojo pojo) {
        for (final Group group : pojo.getGroupList()) {
            this.printGroup(group);
        }
    }

    private void printGroup(final Group group) {
        final String printText = this.generateGroupText(group);
        final PrintJob pt = new PrintJob(printText);
        pt.printAllPages();
    }
}
