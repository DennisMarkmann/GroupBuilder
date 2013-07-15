package com.kn.groupBuilder.FileOperations.Writer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Used to create the different group.xml files and to store group concerning information in it.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class GroupFileWriter {

    private String path = "";

    final void initializeXMLPrint(final Pojo pojo) {

        this.path = pojo.getSettings().getPath();

        for (final Group group : pojo.getGroupList()) {
            this.createXmlFile(group);
        }
    }

    private void createXmlFile(final Group group) {

        int memberNumber = 0;
        final FileWriteHelper helper = new FileWriteHelper();
        final Document doc = helper.createDocument();
        final Element groupsElement = helper.createMainElement(doc, "Group");

        helper.createElement(doc, groupsElement, "GroupName", group.getName());
        helper.createElement(doc, groupsElement, "GroupSize", group.getMemberList().size() + "");
        helper.createElement(doc, groupsElement, "Description", group.getDescription());

        for (final Member member : group.getMemberList()) {

            final Element memberElement = helper.createElement(doc, groupsElement, "Member", null);
            helper.createAttribute(doc, memberElement, "id", memberNumber + "");
            helper.createElement(doc, memberElement, "FirstName", member.getFirstName());
            helper.createElement(doc, memberElement, "LastName", member.getLastName());
            helper.createElement(doc, memberElement, "EmailAdress", member.getEMailAdress());

            memberNumber++;

        }
        helper.writeFile(this.path + "Groups//", group.getName(), doc);
    }
}
