package markmann.dennis.groupBuilder.fileOperations.output;

import java.util.ArrayList;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import markmann.dennis.groupBuilder.exceptions.NothingToDoExeption;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

import org.apache.log4j.Logger;

import dennis.markmann.MyLibraries.DefaultJobs.Print.PrintJob;
import dennis.markmann.MyLibraries.DefaultJobs.Print.PrinterSelector;

/**
 * Initializes the different print operations.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class PrintJobHelper {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/Output.log");

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
        LOGGER.info("Printing out group: " + groupName + ".");

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
        LOGGER.info("Selecting printer.");

        for (final PrintService printer : PrintServiceLookup.lookupPrintServices(null, null)) {
            if (printer.getName().equals(pojo.getSettings().getPrinter())) {
                PrinterSelector.getInstance().setPrinter(printer);
            }
        }
    }
}
