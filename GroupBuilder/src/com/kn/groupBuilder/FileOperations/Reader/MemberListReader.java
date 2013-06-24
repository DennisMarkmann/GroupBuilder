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

                // final Element element = (Element) node;
                // final String memberListSize = element.getElementsByTagName("MemberListSize").item(0).getTextContent();

            }
            String firstName = "";
            String lastName = "";
            String eMailAdress = "";
            final MemberCreator creator = new MemberCreator();

            final NodeList nList = doc.getElementsByTagName("Member");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                final Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element eElement = (Element) nNode;

                    firstName = eElement.getElementsByTagName("FirstName").item(0).getTextContent();
                    lastName = eElement.getElementsByTagName("LastName").item(0).getTextContent();
                    eMailAdress = eElement.getElementsByTagName("EmailAdress").item(0).getTextContent();

                    creator.createMember(firstName, lastName, eMailAdress, pojo);

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
}
