package com.kn.groupBuilder.FileOperations.Output;

import javax.print.PrintService;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.DefaultJobs.PrintJob;
import dennis.markmann.MyLibraries.DefaultJobs.PrinterSelector;

/**
 * Initializes the different print operations.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrintJobHelper {

    private final Pojo pojo;

    public PrintJobHelper(final Pojo pojo) {
        this.pojo = pojo;
        this.selectPrinter();
    }

    public final void printAllGroups() {
        for (final Group group : this.pojo.getGroupList()) {
            this.printGroup(group);
        }
    }

    public final void printGroup(final Object object) {
        final String printText = new TextCreator().createText(this.pojo.getGroupByName((String) object));
        new PrintJob(printText).printText();
    }

    private void selectPrinter() {
        final PrintService printService = this.pojo.getSettings().getPrintService();
        if (printService != null) {
            PrinterSelector.getInstance().setPrinter(printService);
        }
    }
}
