package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupListWriter {

    public final void createXmlFile(final Pojo pojo) {

        try {

            int groupNumber = 0;

            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document doc = builder.newDocument();

            // member elements
            final Element groupListElement = doc.createElement("GroupList");
            final Element groupListSizeElement = doc.createElement("GroupListSize");

            doc.appendChild(groupListElement);

            groupListSizeElement.appendChild(doc.createTextNode(pojo.getGroupList().size() + ""));
            groupListElement.appendChild(groupListSizeElement);

            for (final Group group : pojo.getGroupList()) {

                final String groupName = group.getName();
                final int fixSize = group.getFixSize();
                final String description = group.getDescription();

                final Element groupElement = doc.createElement("Group");
                groupListElement.appendChild(groupElement);

                // set attribute to group element
                final Attr attr = doc.createAttribute("id");
                attr.setValue(groupNumber + "");
                groupElement.setAttributeNode(attr);

                // groupName elements
                final Element groupNameElement = doc.createElement("GroupName");
                groupNameElement.appendChild(doc.createTextNode(groupName));
                groupElement.appendChild(groupNameElement);

                // fixSize elements
                final Element fixSizeElement = doc.createElement("FixSize");
                fixSizeElement.appendChild(doc.createTextNode(fixSize + ""));
                groupElement.appendChild(fixSizeElement);

                // description elements
                final Element descriptionElement = doc.createElement("Description");
                descriptionElement.appendChild(doc.createTextNode(description));
                groupElement.appendChild(descriptionElement);

                groupNumber++;

            }

            // write the content into xml file
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource source = new DOMSource(doc);

            File file = new File(pojo.getDefaultPath());
            file.mkdirs();

            file = new File(pojo.getDefaultPath() + "//GroupList" + ".xml");

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
}
