package markmann.dennis.groupBuilder.fileOperations.writer;

import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Pojo;
import markmann.dennis.groupBuilder.storage.Settings;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Writer class used to create an XML file for storing the settings.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class SettingsFileWriter {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/XMLFile.log");

    public final void createXmlFile(final Pojo pojo) {

        LOGGER.info("Creating XML files for settings.");

        final FileWriteHelper helper = new FileWriteHelper();
        final Document doc = helper.createDocument();
        final Element settingsElement = helper.createMainElement(doc, "Settings");

        final Settings settings = pojo.getSettings();

        helper.createElement(doc, settingsElement, "Path", settings.getPath());
        helper.createElement(doc, settingsElement, "Language", settings.getLanguage());
        helper.createElement(doc, settingsElement, "Archive", settings.isArchived() + "");
        helper.createElement(doc, settingsElement, "ArchivingDays", settings.getArchivingDays() + "");
        helper.createElement(doc, settingsElement, "SendMailAutomatically", settings.isSendMailAutomatically() + "");
        helper.createElement(doc, settingsElement, "PrintAutomatically", settings.isPrintAutomatically() + "");
        helper.createElement(doc, settingsElement, "Printer", settings.getPrinter());

        helper.writeFile(pojo.getSettings().getPath(), "Settings", doc);
    }
}
