package markmann.dennis.groupBuilder.fileOperations.reader;

import java.io.File;

import markmann.dennis.groupBuilder.storage.Pojo;
import markmann.dennis.groupBuilder.storage.Settings;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

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
            final Settings settings = pojo.getSettings();

            settings.setLanguage(helper.getElementValue(element, "Language"));
            settings.setArchived(Boolean.parseBoolean(helper.getElementValue(element, "Archive")));
            settings.setArchivingDays(Integer.parseInt(helper.getElementValue(element, "ArchivingDays")));
            settings.setSendMailAutomatically(Boolean.parseBoolean(helper.getElementValue(element, "SendMailAutomatically")));
            settings.setPrintAutomatically(Boolean.parseBoolean(helper.getElementValue(element, "PrintAutomatically")));
            settings.setPrinter(helper.getElementValue(element, "Printer"));
        }
    }
}
