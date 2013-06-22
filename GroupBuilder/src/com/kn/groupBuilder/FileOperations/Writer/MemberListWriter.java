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

import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class MemberListWriter {

    public final void createXmlFile(final Pojo pojo) {

        try {

            int memberNumber = 0;

            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document doc = builder.newDocument();

            // member elements
            final Element memberListElement = doc.createElement("MemberList");
            final Element memberListSizeElement = doc.createElement("MemberListSize");

            doc.appendChild(memberListElement);

            memberListSizeElement.appendChild(doc.createTextNode(pojo.getMemberList().size() + ""));
            memberListElement.appendChild(memberListSizeElement);

            for (final Member member : pojo.getMemberList()) {

                final String firstName = member.getFirstName();
                final String lastName = member.getLastName();
                final String emailAdress = member.getEMailAdress();

                final Element memberElement = doc.createElement("Member");
                memberListElement.appendChild(memberElement);

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

            File file = new File(pojo.getSettings().getPath());
            file.mkdirs();

            file = new File(pojo.getSettings().getPath() + "//MemberList" + ".xml");

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
