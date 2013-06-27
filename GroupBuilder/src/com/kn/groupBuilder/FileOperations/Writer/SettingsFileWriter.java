package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Storage.Settings;

class SettingsFileWriter {

    final void createXmlFile(final Pojo pojo) {

        try {
            final FileWriteHelper helper = new FileWriteHelper();
            final Document doc = helper.createDocument();
            final Element settingsElement = helper.createMainElement(doc, "Settings");

            final Settings settings = pojo.getSettings();

            helper.createElement(doc, settingsElement, "Path", settings.getPath());
            helper.createElement(doc, settingsElement, "Language", settings.getLanguage());
            helper.createElement(doc, settingsElement, "Archive", settings.isArchive() + "");
            helper.createElement(doc, settingsElement, "ArchivingDays", settings.getArchivingDays() + "");
            helper.createElement(doc, settingsElement, "AusgabeFormat", settings.getAusgabeFormat());
            helper.createElement(doc, settingsElement, "SendMailAutomatically", settings.isSendMailAutomatically() + "");
            helper.createElement(doc, settingsElement, "PrintAutomatically", settings.isPrintAutomatically() + "");

            // write the content into xml file
            File file = new File(pojo.getSettings().getPath());
            file.mkdirs();
            file = new File(pojo.getSettings().getPath() + "Settings" + ".xml");

            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(file));

        } catch (final TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
