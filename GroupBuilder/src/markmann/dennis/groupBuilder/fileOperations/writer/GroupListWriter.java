package markmann.dennis.groupBuilder.fileOperations.writer;

import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Used to create the groupList.xml file and to store group information in it.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

class GroupListWriter {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/XMLFile.log");

    final void createXmlFile(final Pojo pojo) {

        LOGGER.info("Creating XML files for all groups.");

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
