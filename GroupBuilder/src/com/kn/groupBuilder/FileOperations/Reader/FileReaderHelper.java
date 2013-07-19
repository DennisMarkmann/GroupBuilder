package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.kn.groupBuilder.Exceptions.NotToHandleException;
import com.kn.groupBuilder.Exceptions.UnknownErrorException;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to start the different reading processes. Has general methods used by the readClasses.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class FileReaderHelper {

    public final void readXMLFiles(final Pojo pojo) {

        new GroupListReader().readXmlFile(pojo);
        new MemberListReader().readXmlFile(pojo);
        // new GroupFileReader().readFiles(pojo);
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
            new NotToHandleException(e.getStackTrace());
            return null;
        } catch (final SAXException e) {
            new UnknownErrorException("ReadXMLFiles", e.getStackTrace()).showDialog();
        } catch (final IOException e) {
            new UnknownErrorException("ReadXMLFiles", e.getStackTrace()).showDialog();
        } catch (final ParserConfigurationException e) {
            new UnknownErrorException("ReadXMLFiles", e.getStackTrace()).showDialog();
        }
        doc.getDocumentElement().normalize();
        return doc;

    }
}
