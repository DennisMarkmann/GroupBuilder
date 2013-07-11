package com.kn.groupBuilder.FileOperations.Output;

import dennis.markmann.MyLibraries.PrintJob.*;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class PrintJobHelper {

    public final void printAllGroups(final Pojo pojo) {
        for (final Group group : pojo.getGroupList()) {
            this.printGroup(group);
        }
    }

    private void printGroup(final Group group) {
        final String printText = new TextCreator().createText(group);
        new PrintJob(printText).printText();
    }
}
