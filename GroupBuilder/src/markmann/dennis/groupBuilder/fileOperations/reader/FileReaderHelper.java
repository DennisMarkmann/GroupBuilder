package markmann.dennis.groupBuilder.fileOperations.reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import markmann.dennis.groupBuilder.exceptions.NotToHandleException;
import markmann.dennis.groupBuilder.exceptions.UnknownErrorException;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Pojo;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Used to start the different reading processes. Has general methods used by the readClasses.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class FileReaderHelper {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/XMLFile.log");

    public final void readXMLFiles(final Pojo pojo) {

        LOGGER.info("Reading all XML files.");

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
            new NotToHandleException();
            return null;
        } catch (final SAXException e) {
            new UnknownErrorException("ReadXMLFiles").showDialog();
        } catch (final IOException e) {
            new UnknownErrorException("ReadXMLFiles").showDialog();
        } catch (final ParserConfigurationException e) {
            new UnknownErrorException("ReadXMLFiles").showDialog();
        }
        doc.getDocumentElement().normalize();
        return doc;

    }
}
