package com.kn.groupBuilder.FileOperations.Writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Storage.Settings;

/**
 * Writer class used to create an XML file for storing the settings.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class SettingsFileWriter {

    final void createXmlFile(final Pojo pojo) {

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
