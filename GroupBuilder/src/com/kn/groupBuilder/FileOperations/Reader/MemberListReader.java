package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Pojo;

class MemberListReader {

    final void readXmlFile(final Pojo pojo) {

        try {

            final File file = new File(pojo.getSettings().getPath() + "MemberList.xml");

            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            doc.getDocumentElement().normalize();

            final Node node = doc.getElementsByTagName("MemberList").item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // currently not in use.
                // final String memberListSize = this.getElementValue((Element) node, "MemberListSize");
            }

            final MemberCreator creator = new MemberCreator(pojo);

            final NodeList nList = doc.getElementsByTagName("Member");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                final Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element element = (Element) nNode;

                    final String firstName = this.getElementValue(element, "FirstName");
                    final String lastName = this.getElementValue(element, "LastName");
                    final String eMailAdress = this.getElementValue(element, "EmailAdress");

                    creator.createMember(firstName, lastName, eMailAdress);
                }
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
