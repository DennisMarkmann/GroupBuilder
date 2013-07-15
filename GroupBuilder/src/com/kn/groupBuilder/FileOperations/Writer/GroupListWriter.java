package com.kn.groupBuilder.FileOperations.Writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to create the groupList.xml file and to store group information in it.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class GroupListWriter {

    final void createXmlFile(final Pojo pojo) {

        int groupNumber = 0;

        final FileWriteHelper helper = new FileWriteHelper();
        final Document doc = helper.createDocument();
        final Element groupListElement = helper.createMainElement(doc, "GroupList");

        helper.createElement(doc, groupListElement, "GroupListSize", pojo.getGroupList().size() + "");

        for (final Group group : pojo.getGroupList()) {

            final Element groupElement = helper.createElement(doc, groupListElement, "Group", null);
            helper.createAttribute(doc, groupElement, "id", groupNumber + "");
            helper.createElement(doc, groupElement, "GroupName", group.getName());
            helper.createElement(doc, groupElement, "FixSize", group.getFixSize() + "");
            helper.createElement(doc, groupElement, "Description", group.getDescription());

            groupNumber++;

        }
        helper.writeFile(pojo.getSettings().getPath(), "GroupList", doc);
    }
}
