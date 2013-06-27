package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Storage.Pojo;

class GroupListReader {

    final void readXmlFile(final Pojo pojo) {

        final FileReaderHelper helper = new FileReaderHelper();
        final GroupCreator creator = new GroupCreator(pojo);

        final Document doc = helper.createDocument(new File(pojo.getSettings().getPath() + "GroupList.xml"));

        final Node node = doc.getElementsByTagName("GroupList").item(0);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            // currently not in use.
            // final String groupListSize = helper.getElementValue((Element) node, "GroupListSize");
        }

        final NodeList nList = doc.getElementsByTagName("Group");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            final Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                final Element element = (Element) nNode;

                final String groupName = helper.getElementValue(element, "GroupName");
                final int fixSize = Integer.parseInt(helper.getElementValue(element, "FixSize"));
                final String description = helper.getElementValue(element, "Description");

                creator.createGroupsManually(groupName, fixSize, description);
            }
        }
    }
}
