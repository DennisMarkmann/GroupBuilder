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

import com.kn.groupBuilder.Exceptions.NoFilesFoundException;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

class GroupFileReader {

    final void readFiles(final Pojo pojo) {

        try {

            final File[] files = new File(pojo.getSettings().getPath() + "Groups").listFiles();
            try {
                files.toString();
            } catch (final java.lang.NullPointerException e) {
                new NoFilesFoundException(pojo.getSettings().getPath() + "Groups", e.getStackTrace()).showDialog();
                return;
            }

            for (final File file : files) {

                final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                doc.getDocumentElement().normalize();

                final Node node = doc.getElementsByTagName("Group").item(0);
                String groupName = null;

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    final Element element = (Element) node;

                    groupName = this.getElementValue(element, "GroupName");

                    // final currently not in final use.
                    // groupName = this.getElementValue(element, "GroupSize");
                    // groupName = this.getElementValue(element, "Description");

                }

                final NodeList nList = doc.getElementsByTagName("Member");
                for (int temp = 0; temp < nList.getLength(); temp++) {

                    final Node nNode = nList.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        final Element element = (Element) nNode;

                        // currently not in use.
                        // final String memberID = eElement.getAttribute("id");
                        final String firstName = this.getElementValue(element, "FirstName");
                        final String lastName = this.getElementValue(element, "LastName");
                        // currently not in use.
                        // final String eMailAdress = this.getElementValue(element, "EmailAdress");

                        final Group group = pojo.getGroupByName(groupName);
                        final Member member = pojo.getMemberByName(firstName, lastName);

                        group.addMemberToGroup(group, member);

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

    public String getElementValue(final Element element, final String name) {
        return element.getElementsByTagName(name).item(0).getTextContent();
    }
}
