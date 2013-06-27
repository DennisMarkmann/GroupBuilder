package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Pojo;

class MemberListReader {

    final void readXmlFile(final Pojo pojo) {

        final FileReaderHelper helper = new FileReaderHelper();
        final MemberCreator creator = new MemberCreator(pojo);

        final Document doc = helper.createDocument(new File(pojo.getSettings().getPath() + "MemberList.xml"));

        final Node node = doc.getElementsByTagName("MemberList").item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            // currently not in use.
            // final String memberListSize = helper.getElementValue((Element) node, "MemberListSize");
        }

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
    }
}
