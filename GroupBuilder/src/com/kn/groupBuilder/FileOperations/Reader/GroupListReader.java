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

import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupListReader {

    public final void readXmlFile(final Pojo pojo) {

        try {

            final File file = new File(pojo.getPath() + "GroupList.xml");

            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            final Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            final NodeList list = doc.getElementsByTagName("GroupList");
            final Node node = list.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                final Element element = (Element) node;

                @SuppressWarnings("unused")
                final String groupListSize = element.getElementsByTagName("GroupListSize").item(0).getTextContent();
            }

            String groupName = "";
            int fixSize = 0;
            String description = "";
            final GroupCreator creator = new GroupCreator();

            final NodeList nList = doc.getElementsByTagName("Group");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                final Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element eElement = (Element) nNode;

                    groupName = eElement.getElementsByTagName("GroupName").item(0).getTextContent();
                    fixSize = Integer.parseInt(eElement.getElementsByTagName("FixSize").item(0).getTextContent());
                    description = eElement.getElementsByTagName("Description").item(0).getTextContent();

                    creator.createGroupsManually(groupName, fixSize, description, pojo);
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
