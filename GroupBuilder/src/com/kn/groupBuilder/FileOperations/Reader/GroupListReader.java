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

import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Storage.Pojo;

class GroupListReader {

    final void readXmlFile(final Pojo pojo) {

        try {

            final File file = new File(pojo.getSettings().getPath() + "GroupList.xml");

            final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            doc.getDocumentElement().normalize();

            final Node node = doc.getElementsByTagName("GroupList").item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                // currently not in use.
                // final String groupListSize = this.getElementValue((Element) node, "GroupListSize");
            }

            final GroupCreator creator = new GroupCreator(pojo);

            final NodeList nList = doc.getElementsByTagName("Group");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                final Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element element = (Element) nNode;

                    final String groupName = this.getElementValue(element, "GroupName");
                    final int fixSize = Integer.parseInt(this.getElementValue(element, "FixSize"));
                    final String description = this.getElementValue(element, "Description");

                    creator.createGroupsManually(groupName, fixSize, description);
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
