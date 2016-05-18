package markmann.dennis.groupBuilder.fileOperations.writer;

import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Used to create the mmemberList.xml file and to store member information in it.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class MemberListWriter {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/XMLFile.log");

    final void createXmlFile(final Pojo pojo) {

        LOGGER.info("Creating XML files for all members.");

        int memberNumber = 0;

        final FileWriteHelper helper = new FileWriteHelper();
        final Document doc = helper.createDocument();
        final Element memberListElement = helper.createMainElement(doc, "MemberList");

        helper.createElement(doc, memberListElement, "MemberListSize", pojo.getMemberList().size() + "");

        for (final Member member : pojo.getMemberList()) {

            final Element memberElement = helper.createElement(doc, memberListElement, "Member", null);
            helper.createAttribute(doc, memberElement, "id", memberNumber + "");
            helper.createElement(doc, memberElement, "FirstName", member.getFirstName());
            helper.createElement(doc, memberElement, "LastName", member.getLastName());
            helper.createElement(doc, memberElement, "EmailAdress", member.getEMailAdress());
            if (member.getGroup() != null) {
                helper.createElement(doc, memberElement, "Group", member.getGroup().getName());
            } else {
                helper.createElement(doc, memberElement, "Group", "");
            }
            memberNumber++;

        }
        helper.writeFile(pojo.getSettings().getPath(), "MemberList", doc);
    }
}
