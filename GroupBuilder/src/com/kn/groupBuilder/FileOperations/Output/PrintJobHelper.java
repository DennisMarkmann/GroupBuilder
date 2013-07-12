package com.kn.groupBuilder.FileOperations.Output;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.DefaultJobs.PrintJob;

/**
 * Initializes the different print operations.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrintJobHelper {

    public final void printAllGroups(final Pojo pojo) {
        for (final Group group : pojo.getGroupList()) {
            this.printGroup(group);
        }
    }

    public final void printGroup(final Group group) {
        final String printText = new TextCreator().createText(group);
        new PrintJob(printText).printText();
    }
}
