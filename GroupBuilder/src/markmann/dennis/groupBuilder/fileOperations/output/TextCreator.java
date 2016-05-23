package markmann.dennis.groupBuilder.fileOperations.output;

import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Member;

import org.apache.log4j.Logger;

/**
 * Class for generating the default text used for output operations. (email & print)
 * 
 * @author dennis.markmann
 * @version 1.0
 */

class TextCreator {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/Output.log");

    String createGroupText(final Group group) {
        LOGGER.info("Creating groupText for group: " + group + ".");

        final StringBuilder sb = new StringBuilder();

        sb.append("GroupName: ");
        sb.append(group.getName());
        sb.append(System.lineSeparator());
        sb.append("GroupSize: ");
        sb.append(group.getMemberList().size());
        sb.append(System.lineSeparator());
        sb.append("Decription: ");
        sb.append(group.getDescription());
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Member: ");
        sb.append(System.lineSeparator());

        for (final Member member : group.getMemberList()) {
            sb.append(member.getLastName());
            sb.append(", ");
            sb.append(member.getFirstName());
            sb.append(" : ");
            sb.append(member.getEMailAdress());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    String generateMailText(final Group group, final String path) {
        LOGGER.info("Creating mailText for group: " + group + ".");

        final StringBuilder sb = new StringBuilder();

        sb.append("Hello! ");
        sb.append(System.lineSeparator());
        sb.append("This is an autmatic generated mail by the groupBuilder of Dennis Markmann.");
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append(new TextCreator().createGroupText(group));

        return sb.toString();
    }

}
