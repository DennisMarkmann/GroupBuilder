package markmann.dennis.groupBuilder.fileOperations.output;

import java.util.ArrayList;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import markmann.dennis.groupBuilder.exceptions.NothingToDoExeption;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;
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
        // try {
        final Thread printThread = new Thread(new PrintJob(printText));
        printThread.run();

        // } catch (final PrinterSelectionException e) {
        // new markmann.dennis.groupBuilder.exceptions.PrinterSelectionException(e);
        // } catch (final PrintOperationException e) {
        // new markmann.dennis.groupBuilder.exceptions.PrintOperationException(e);
        // }
    }

    private void selectPrinter(final Pojo pojo) {
        for (final PrintService printer : PrintServiceLookup.lookupPrintServices(null, null)) {
            if (printer.getName().equals(pojo.getSettings().getPrinter())) {
                PrinterSelector.getInstance().setPrinter(printer);
            }
        }
    }
}
