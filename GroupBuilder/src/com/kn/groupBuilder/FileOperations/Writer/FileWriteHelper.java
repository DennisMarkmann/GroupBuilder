package com.kn.groupBuilder.FileOperations.Writer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Archiving.GroupFileArchiver;
import com.kn.groupBuilder.FileOperations.Output.EmailJobHelper;
import com.kn.groupBuilder.FileOperations.Output.PrintJobHelper;
import com.kn.groupBuilder.Storage.Pojo;

public class FileWriteHelper {

    public final void createXMLFiles(final Pojo pojo) {
        new MemberListWriter().createXmlFile(pojo);
        new GroupListWriter().createXmlFile(pojo);
        new GroupFileWriter().initializeXMLPrint(pojo);
        new GroupFileArchiver().archivGroupFiles(pojo);
        new SettingsFileWriter().createXmlFile(pojo);
        new FileCleaner().updateArchive(pojo);

        if (pojo.getSettings().isPrintAutomatically()) {
            new PrintJobHelper().printAllGroups(pojo);
        }
        if (pojo.getSettings().isSendMailAutomatically()) {
            new EmailJobHelper().initializeEmailSending(pojo);
        }
    }

    final Element createElement(final Document doc, final Element superiorElement, final String name, final String value) {
        final Element element = doc.createElement(name);
        if (value != null) {
            element.appendChild(doc.createTextNode(value));
        }
        superiorElement.appendChild(element);
        return element;
    }

    final Attr createAttribute(final Document doc, final Element superiorElement, final String name, final String value) {
        final Attr attr = doc.createAttribute(name);
        attr.setValue(value);
        return superiorElement.setAttributeNode(attr);
    }

    final Element createMainElement(final Document doc, final String name) {
        final Element element = doc.createElement(name);
        doc.appendChild(element);
        return element;
    }

    final Document createDocument() {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
