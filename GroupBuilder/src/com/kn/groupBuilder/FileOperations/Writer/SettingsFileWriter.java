package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Storage.Settings;

public class SettingsFileWriter {

    final void createXmlFile(final Pojo pojo) {

        try {

            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            final Element settingsElement = doc.createElement("Settings");
            doc.appendChild(settingsElement);

            final Settings settings = pojo.getSettings();

            this.createElement(doc, settingsElement, "Path", settings.getPath());
            this.createElement(doc, settingsElement, "Language", settings.getLanguage());
            this.createElement(doc, settingsElement, "Archive", settings.isArchive() + "");
            this.createElement(doc, settingsElement, "ArchivingDays", settings.getArchivingDays() + "");
            this.createElement(doc, settingsElement, "AusgabeFormat", settings.getAusgabeFormat());
            this.createElement(doc, settingsElement, "SendMailAutomatically", settings.isSendMailAutomatically() + "");
            this.createElement(doc, settingsElement, "PrintAutomatically", settings.isPrintAutomatically() + "");

            // write the content into xml file
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource source = new DOMSource(doc);

            File file = new File(pojo.getSettings().getPath());
            file.mkdirs();

            file = new File(pojo.getSettings().getPath() + "Settings" + ".xml");

            final StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);

        } catch (final ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (final TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public void createElement(final Document doc, final Element superiorElement, final String name, final String value) {
        final Element element = doc.createElement(name);
        if (value != null) {
            element.appendChild(doc.createTextNode(value));
        }
        superiorElement.appendChild(element);
    }
}
