package com.kn.groupBuilder.FileOperations.Output;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.DefaultJobs.PrintJob;

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
