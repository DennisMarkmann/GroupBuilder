package com.kn.groupBuilder.FileOperations.Output;

import java.util.ArrayList;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import com.kn.groupBuilder.Exceptions.NothingToDoExeption;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.DefaultJobs.Print.PrintJob;
import dennis.markmann.MyLibraries.DefaultJobs.Print.PrinterSelector;

/**
 * Initializes the different print operations.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrintJobHelper {

    public final void printOutForGroups(final Pojo pojo, final ArrayList<Group> groupList) {
        this.selectPrinter(pojo);

        if (groupList.size() == 0) {
            new NothingToDoExeption(pojo.getTranslation("Print")).showDialog();
            return;
        }

        for (final Group group : groupList) {
            this.printGroup(pojo, group.getName());
        }
    }

    private void printGroup(final Pojo pojo, final String groupName) {
        final String printText = new TextCreator().createGroupText(pojo.getGroupByName(groupName));
        new PrintJob().printText(printText);
    }

    private void selectPrinter(final Pojo pojo) {
        for (final PrintService printer : PrintServiceLookup.lookupPrintServices(null, null)) {
            if (printer.getName().equals(pojo.getSettings().getPrinter())) {
                PrinterSelector.getInstance().setPrinter(printer);
            }
        }
    }
}
