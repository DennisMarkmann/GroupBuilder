package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to get and store the values of the settings.xml in the pojo.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class SettingsFileReader {

    final void readXmlFile(final Pojo pojo) {

        final FileReaderHelper helper = new FileReaderHelper();

        final Document doc = helper.createDocument(new File(pojo.getSettings().getPath() + "Settings.xml"));
        if (doc == null) {
            return;
        }
        final Node node = doc.getElementsByTagName("Settings").item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE) {

            final Element element = (Element) node;
            pojo.getSettings().setLanguage(helper.getElementValue(element, "Language"));
            pojo.getSettings().setArchived(Boolean.parseBoolean(helper.getElementValue(element, "Archive")));
            pojo.getSettings().setArchivingDays(Integer.parseInt(helper.getElementValue(element, "ArchivingDays")));
            pojo.getSettings().setSendMailAutomatically(
                    Boolean.parseBoolean(helper.getElementValue(element, "SendMailAutomatically")));
            pojo.getSettings().setPrintAutomatically(
                    Boolean.parseBoolean(helper.getElementValue(element, "PrintAutomatically")));
        }
    }
}
