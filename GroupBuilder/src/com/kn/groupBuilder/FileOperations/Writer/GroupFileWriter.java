package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

class GroupFileWriter {

    private String path = "";

    final void initializeXMLPrint(final Pojo pojo) {

        this.path = pojo.getSettings().getPath();

        for (final Group group : pojo.getGroupList()) {
            this.createXmlFile(group);
        }

    }

    private void createXmlFile(final Group group) {

        try {
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

            // write the content into xml file
            File file = new File(this.path + "Groups//");
            file.mkdirs();
            file = new File(this.path + "Groups//" + group.getName() + ".xml");

            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(file));

        } catch (final TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
