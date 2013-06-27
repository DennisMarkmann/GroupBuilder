package com.kn.groupBuilder.FileOperations.Writer;

import java.io.File;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

class GroupListWriter {

    final void createXmlFile(final Pojo pojo) {

        try {
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

            // write the content into xml file
            File file = new File(pojo.getSettings().getPath());
            file.mkdirs();
            file = new File(pojo.getSettings().getPath() + "GroupList" + ".xml");

            TransformerFactory.newInstance().newTransformer().transform(new DOMSource(doc), new StreamResult(file));

        } catch (final TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}
