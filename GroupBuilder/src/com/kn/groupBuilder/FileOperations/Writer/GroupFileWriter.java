package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;
import java.util.ArrayList;

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
import com.kn.groupBuilder.Storage.Member;

public class GroupFileWriter {

    public final void initializeXMLPrint(final ArrayList<Group> groupArrayList, final String defaultPath) {

        for (final Group group : groupArrayList) {

            this.createXmlFile(group, defaultPath);

        }

    }

    private void createXmlFile(final Group group, final String defaultPath) {

        try {

            int memberNumber = 0;

            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document doc = builder.newDocument();

            // member elements
            final Element groupsElement = doc.createElement("Group");
            final Element groupNameElement = doc.createElement("GroupName");
            final Element groupSizeElement = doc.createElement("GroupSize");
            final Element groupDescElement = doc.createElement("Description");

            doc.appendChild(groupsElement);

            final String groupName = group.getName();
            final String description = group.getDescription();

            groupNameElement.appendChild(doc.createTextNode(groupName));
            groupsElement.appendChild(groupNameElement);

            groupSizeElement.appendChild(doc.createTextNode(group.getMemberList().size() + ""));
            groupsElement.appendChild(groupSizeElement);

            groupDescElement.appendChild(doc.createTextNode(description));
            groupsElement.appendChild(groupDescElement);

            for (final Member member : group.getMemberList()) {

                final String firstName = member.getFirstName();
                final String lastName = member.getLastName();
                final String emailAdress = member.getEMailAdress();

                final Element memberElement = doc.createElement("Member");
                groupsElement.appendChild(memberElement);

                // set attribute to member element
                final Attr attr = doc.createAttribute("id");
                attr.setValue(memberNumber + "");
                memberElement.setAttributeNode(attr);

                // firstname elements
                final Element firstNameElement = doc.createElement("FirstName");
                firstNameElement.appendChild(doc.createTextNode(firstName));
                memberElement.appendChild(firstNameElement);

                // lastname elements
                final Element lastNameElement = doc.createElement("LastName");
                lastNameElement.appendChild(doc.createTextNode(lastName));
                memberElement.appendChild(lastNameElement);

                // email elements
                final Element emailElement = doc.createElement("EmailAdress");
                emailElement.appendChild(doc.createTextNode(emailAdress));
                memberElement.appendChild(emailElement);

                memberNumber++;

            }

            // write the content into xml file
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer();
            final DOMSource source = new DOMSource(doc);

            File file = new File(defaultPath + "//Groups//");
            file.mkdirs();

            file = new File(defaultPath + "//Groups//" + group.getName() + ".xml");

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
