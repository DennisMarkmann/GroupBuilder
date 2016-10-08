package markmann.dennis.groupBuilder.fileOperations.reader;

import java.io.File;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import markmann.dennis.groupBuilder.jobs.MemberCreator;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Used to get and store the values of the memberList.xml in the pojo.
 *
 * @author dennis.markmann
 * @version 1.0
 */

class MemberListReader {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/XMLFile.log");

    final void readXmlFile(final Pojo pojo) {

        LOGGER.info("Reading member XML files.");

        final FileReaderHelper helper = new FileReaderHelper();
        final MemberCreator creator = new MemberCreator(pojo);

        final Document doc = helper.createDocument(new File(pojo.getSettings().getPath() + "MemberList.xml"));
        if (doc == null) {
            return;
        }
        // final Node node = doc.getElementsByTagName("MemberList").item(0);
        // if (node.getNodeType() == Node.ELEMENT_NODE) {
        // currently not in use.
        // final String memberListSize = helper.getElementValue((Element) node, "MemberListSize");
        // }

        final NodeList nList = doc.getElementsByTagName("Member");
        for (int temp = 0; temp < nList.getLength(); temp++) {

            final Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                final Element element = (Element) nNode;

                final String firstName = helper.getElementValue(element, "FirstName");
                final String lastName = helper.getElementValue(element, "LastName");
                final String eMailAdress = helper.getElementValue(element, "EmailAdress");
                final String groupName = helper.getElementValue(element, "Group");
                final Group group = pojo.getGroupByName(groupName);

                creator.createMember(firstName, lastName, eMailAdress, pojo.getGroupByName(groupName));
                if (group != null) {
                    group.addMember(pojo.getMemberByName(firstName, lastName));
                }
            }
        }
    }
}
