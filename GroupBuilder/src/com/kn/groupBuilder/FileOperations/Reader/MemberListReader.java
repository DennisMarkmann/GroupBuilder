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
            final FileReaderHelper helper = new FileReaderHelper();
            final File file = new File(pojo.getSettings().getPath() + "MemberList.xml");

            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            doc.getDocumentElement().normalize();

            final Node node = doc.getElementsByTagName("MemberList").item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // currently not in use.
                // final String memberListSize = helper.getElementValue((Element) node, "MemberListSize");
            }

            final MemberCreator creator = new MemberCreator(pojo);

            final NodeList nList = doc.getElementsByTagName("Member");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                final Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element element = (Element) nNode;

                    final String firstName = helper.getElementValue(element, "FirstName");
                    final String lastName = helper.getElementValue(element, "LastName");
                    final String eMailAdress = helper.getElementValue(element, "EmailAdress");

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
}
