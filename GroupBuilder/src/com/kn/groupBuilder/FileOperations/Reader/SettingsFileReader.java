package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import com.kn.groupBuilder.Storage.Pojo;

public class SettingsFileReader {

    final void readXmlFile(final Pojo pojo) {

        try {

            final File file = new File(pojo.getSettings().getPath() + "Settings.xml");

            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            doc.getDocumentElement().normalize();

            final Node node = doc.getElementsByTagName("Settings").item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                final Element element = (Element) node;
                pojo.getSettings().setLanguage(this.getElementValue(element, "Language"));
                pojo.getSettings().setArchive(Boolean.parseBoolean(this.getElementValue(element, "Archive")));
                pojo.getSettings().setArchivingDays(Integer.parseInt(this.getElementValue(element, "ArchivingDays")));
                pojo.getSettings().setAusgabeFormat(this.getElementValue(element, "AusgabeFormat"));
                pojo.getSettings().setSendMailAutomatically(
                        Boolean.parseBoolean(this.getElementValue(element, "SendMailAutomatically")));
                pojo.getSettings().setPrintAutomatically(
                        Boolean.parseBoolean(this.getElementValue(element, "PrintAutomatically")));
            }

        } catch (final IOException e) {
            // nothing to do.
        } catch (final ParserConfigurationException e) {
            e.printStackTrace();
        } catch (final SAXException e) {
            e.printStackTrace();
        }
    }

    public String getElementValue(final Element element, final String name) {
        return element.getElementsByTagName(name).item(0).getTextContent();
    }
}
