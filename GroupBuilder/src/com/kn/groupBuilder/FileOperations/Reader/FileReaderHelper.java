package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.kn.groupBuilder.Storage.Pojo;

public class FileReaderHelper {

    public final void readXMLFiles(final Pojo pojo) {

        new GroupListReader().readXmlFile(pojo);
        new MemberListReader().readXmlFile(pojo);
        new GroupFileReader().readFiles(pojo);
        new SettingsFileReader().readXmlFile(pojo);
    }

    final String getElementValue(final Element element, final String name) {
        return element.getElementsByTagName(name).item(0).getTextContent();
    }

    final Document createDocument(final File file) {
        Document doc = null;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

        } catch (final java.io.FileNotFoundException e) {
            // nothing to do
            return null;
        } catch (final SAXException e) {
            // nothing to do
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        return doc;

    }
}
