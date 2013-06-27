package com.kn.groupBuilder.FileOperations.Writer;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Archiving.GroupFileArchiver;
import com.kn.groupBuilder.Storage.Pojo;

public class FileWriteHelper {

    public final void createXMLFiles(final Pojo pojo) {
        new MemberListWriter().createXmlFile(pojo);
        new GroupListWriter().createXmlFile(pojo);
        new GroupFileWriter().initializeXMLPrint(pojo);
        new GroupFileArchiver().archivGroupFiles(pojo);
        new SettingsFileWriter().createXmlFile(pojo);
    }

    public Element createElement(final Document doc, final Element superiorElement, final String name, final String value) {
        final Element element = doc.createElement(name);
        if (value != null) {
            element.appendChild(doc.createTextNode(value));
        }
        superiorElement.appendChild(element);

        return element;
    }

    public void createAttribute(final Document doc, final Element superiorElement, final String name, final String value) {
        final Attr attr = doc.createAttribute(name);
        attr.setValue(value);
        superiorElement.setAttributeNode(attr);
    }
}
