package com.kn.groupBuilder.FileOperations.Reader;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.kn.groupBuilder.Exceptions.NoFilesFoundException;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * GroupSize, Description, id, EmailAdress are currently unused.
 * 
 * @author dennis.markmann
 * 
 */
class GroupFileReader {

    final void readFiles(final Pojo pojo) {

        final FileReaderHelper helper = new FileReaderHelper();
        final File[] files = new File(pojo.getSettings().getPath() + "Groups").listFiles();
        try {
            files.toString();
        } catch (final java.lang.NullPointerException e) {
            new NoFilesFoundException(pojo.getSettings().getPath() + "Groups", e.getStackTrace()).showDialog();
            return;
        }

        for (final File file : files) {

            final Document doc = helper.createDocument(file);
            if (doc == null) {
                return;
            }
            final Node node = doc.getElementsByTagName("Group").item(0);
            String groupName = null;

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                final Element element = (Element) node;
                groupName = helper.getElementValue(element, "GroupName");

            }

            final NodeList nList = doc.getElementsByTagName("Member");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                final Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    final Element element = (Element) nNode;

                    final String firstName = helper.getElementValue(element, "FirstName");
                    final String lastName = helper.getElementValue(element, "LastName");

                    final Group group = pojo.getGroupByName(groupName);
                    final Member member = pojo.getMemberByName(firstName, lastName);

                    group.addMemberToGroup(group, member);

                }
            }
        }
    }
}
