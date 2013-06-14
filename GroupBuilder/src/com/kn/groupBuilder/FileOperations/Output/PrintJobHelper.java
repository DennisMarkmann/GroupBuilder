package com.kn.groupBuilder.FileOperations.Output;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class PrintJobHelper {

    private String generateGroupText(final Group group) {

        String printText = "GroupName: " + group.getName() + "\r\n" + "GroupSize: " + group.getMemberList().size() + "\r\n"
                + "Decription: " + group.getDescription() + "\r\n" + "\r\n" + "Member:" + "\r\n";

        for (final Member member : group.getMemberList()) {
            final String memberInfo = member.getLastName() + ", " + member.getFirstName() + " : " + member.getEMailAdress()
                    + "\r\n";
            printText = printText + memberInfo;
        }
        return printText;

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
