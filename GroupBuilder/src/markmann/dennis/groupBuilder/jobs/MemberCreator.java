package markmann.dennis.groupBuilder.jobs;

import org.apache.log4j.Logger;

import markmann.dennis.groupBuilder.exceptions.DuplicateEntryException;
import markmann.dennis.groupBuilder.logging.LogHandler;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Used to create new member objects.
 *
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class MemberCreator {

    private static final Logger LOGGER = LogHandler.getLogger("./logs/GroupBuilder.log");

    private final Pojo pojo;

    public MemberCreator(final Pojo pojo) {
        this.pojo = pojo;
    }

    private void addMemberToList(final Member member) {
        try {
            this.checkDuplicates(member.getFirstName(), member.getLastName());
        } catch (final DuplicateEntryException e) {
            e.showDialog();
            return;
        }
        this.pojo.getMemberList().add(member);
    }

    private void checkDuplicates(final String firstName, final String lastName) throws DuplicateEntryException {
        if (this.pojo.getMemberByName(firstName, lastName) != null) {
            throw new DuplicateEntryException(firstName + "." + lastName);
        }
    }

    private String correctFormat(String string) {
        string = string.trim();
        string = string.toLowerCase();
        string = string.substring(0, 1).toUpperCase() + string.substring(1);
        return string;
    }

    public final void correctMemberFormat(final Member member) {
        LOGGER.info("Correcting member format.");

        final String firstName = member.getFirstName();
        final String lastName = member.getLastName();
        final String eMailAdress = member.getEMailAdress();
        final Group group = member.getGroup();

        this.addMemberToList(new Member(this.correctFormat(firstName), this.correctFormat(lastName), eMailAdress, group));
    }

    public final void createMember(final String firstName, final String lastName) {
        this.createMember(firstName, lastName, null);
    }

    public final void createMember(final String firstName, final String lastName, final String eMailAdress) {
        this.createMember(firstName, lastName, eMailAdress, null);
    }

    public final void createMember(final String firstName, final String lastName, final String eMailAdress, final Group group) {
        Member member = new Member(this.correctFormat(firstName), this.correctFormat(lastName), eMailAdress, group);
        this.addMemberToList(member);
        LOGGER.info("Creating member " + member.toString() + ".");
    }

    public final void editMember(final Member oldMember, final Member newMember) {
        LOGGER.info("Editing member " + oldMember);

        final Member member = this.pojo.getMemberByName(oldMember.getFirstName(), oldMember.getLastName());
        member.setFirstName(newMember.getFirstName());
        member.setLastName(newMember.getLastName());
        member.setEMailAdress(newMember.getEMailAdress());
        member.setGroup(newMember.getGroup());
    }

    public final void removeMember(final Member member) {
        LOGGER.info("Removing member " + member.getFullName() + ".");
        this.pojo.getMemberList().remove(this.pojo.getMemberByName(member.getFirstName(), member.getLastName()));
    }
}
