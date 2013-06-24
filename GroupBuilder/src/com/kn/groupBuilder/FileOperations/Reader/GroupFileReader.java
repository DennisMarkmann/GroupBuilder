package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.kn.groupBuilder.Exceptions.NoFilesFoundException;
import com.kn.groupBuilder.Storage.Pojo;

class GroupFileReader {

    final void readFiles(final Pojo pojo) {

        try {

            final File[] files = new File(pojo.getSettings().getPath() + "Groups").listFiles();
            try {
                files.toString();
            } catch (final java.lang.NullPointerException exception) {
                new NoFilesFoundException(pojo.getSettings().getPath() + "Groups").showDialog();
                return;
            }

            for (final File file : files) {

                final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                final Document doc = dBuilder.parse(file);
                doc.getDocumentElement().normalize();

                final NodeList list = doc.getElementsByTagName("Group");
                final Node node = list.item(0);
                String groupName = null;
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    final Element element = (Element) node;

                    groupName = element.getElementsByTagName("GroupName").item(0).getTextContent();
                    // final String groupSize = element.getElementsByTagName("GroupSize").item(0).getTextContent();
                    // final String description = element.getElementsByTagName("Description").item(0).getTextContent();

                }

                final NodeList nList = doc.getElementsByTagName("Member");
                for (int temp = 0; temp < nList.getLength(); temp++) {

                    final Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        final Element eElement = (Element) nNode;

                        // final String memberID = eElement.getAttribute("id");
                        final String firstName = eElement.getElementsByTagName("FirstName").item(0).getTextContent();
                        final String lastName = eElement.getElementsByTagName("LastName").item(0).getTextContent();
                        // final String eMailAdress = eElement.getElementsByTagName("EmailAdress").item(0).getTextContent();

                        pojo.getGroupByName(groupName).getMemberList().add(pojo.getMemberByName(firstName, lastName));
                        pojo.getMemberByName(firstName, lastName).getGroupList().add(pojo.getGroupByName(groupName));
                    }
                }
            }

        } catch (final IOException e) {
            // nothing to do.
        } catch (final SAXException e) {
            e.printStackTrace();
        } catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
