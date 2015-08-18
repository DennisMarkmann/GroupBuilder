package markmann.dennis.groupBuilder.gui.popups.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import markmann.dennis.groupBuilder.fileOperations.output.EmailJobHelper;
import markmann.dennis.groupBuilder.fileOperations.output.PrintJobHelper;
import markmann.dennis.groupBuilder.fileOperations.writer.FileWriteHelper;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.gui.popups.OperationSuccessfullFrame;
import markmann.dennis.groupBuilder.gui.tableModels.GroupTableModel;
import markmann.dennis.groupBuilder.gui.tableModels.MemberTableModel;
import markmann.dennis.groupBuilder.jobs.GroupBuilder;
import markmann.dennis.groupBuilder.jobs.GroupCreator;
import markmann.dennis.groupBuilder.jobs.MemberCreator;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;

/**
 * Listener for the confirmation frame. Allows to start several operations.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

@SuppressWarnings("unchecked")
public class ConfirmationFrameListener implements ActionListener {

    private static List<String> outputOperations;
    private static List<String> memberOperations;
    private static List<String> groupOperations;
    private String message = "";
    private final ConfirmationFrame confirmationFrame;
    private final Pojo pojo;
    private final String action;
    private final Object object;

    public ConfirmationFrameListener(
            final ConfirmationFrame confirmationFrame,
            final Pojo pojo,
            final String action,
            final Object object) {

        this.confirmationFrame = confirmationFrame;
        this.pojo = pojo;
        this.action = action;
        this.object = object;

        outputOperations = Arrays
                .asList(pojo.getTranslation("Print"), pojo.getTranslation("SendMail"), pojo.getTranslation("Save"));
        memberOperations = Arrays.asList(
                pojo.getTranslation("AddMember"),
                pojo.getTranslation("EditMember"),
                pojo.getTranslation("RemoveMember"));
        groupOperations = Arrays.asList(
                pojo.getTranslation("AddGroup"),
                pojo.getTranslation("EditGroup"),
                pojo.getTranslation("RemoveGroup"),
                pojo.getTranslation("AutoCreateGroups"));

    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            if (outputOperations.contains(this.action)) {
                this.useOutputOperation();
            } else if (memberOperations.contains(this.action)) {
                this.useMemberOperation();
            } else if (groupOperations.contains(this.action)) {
                this.useGroupOperation();
            } else if (this.action.equals("CloseWindow")) {
                ((DefaultFrame) this.object).closeWindow();
                this.confirmationFrame.closeWindow();
                return;
            }
            if (!this.pojo.hasError()) {
                this.showSuccessMessage(this.message);
            } else {
                this.pojo.setError(false);
            }
        }
        this.confirmationFrame.closeWindow();
    }

    private void useOutputOperation() {

        if (this.action.equals(this.pojo.getTranslation("Print"))) {
            new PrintJobHelper().printOutForGroups(this.pojo, (ArrayList<Group>) this.object);
            this.message = this.pojo.getTranslation("PrintSuccess");

        } else if (this.action.equals(this.pojo.getTranslation("SendMail"))) {
            new EmailJobHelper().sendMailToGroups(this.pojo, (ArrayList<Group>) this.object);
            this.message = this.pojo.getTranslation("MailSuccess");

        } else if (this.action.equals(this.pojo.getTranslation("Save"))) {
            new FileWriteHelper().createXMLFiles(this.pojo);
            this.message = this.pojo.getTranslation("SaveSuccess");
        }
    }

    private void useMemberOperation() {

        if (this.action.equals(this.pojo.getTranslation("AddMember"))) {
            final Member member = (Member) this.object;

            new MemberCreator(this.pojo).correctMemberFormat(member);
            this.generateMemberMessage(member, "Added");

        } else if (this.action.equals(this.pojo.getTranslation("EditMember"))) {
            final Member oldMember = ((ArrayList<Member>) this.object).get(0);
            final Member newMember = ((ArrayList<Member>) this.object).get(1);

            new MemberCreator(this.pojo).editMember(oldMember, newMember);
            this.generateMemberMessage(oldMember, "Edited");

        } else if (this.action.equals(this.pojo.getTranslation("RemoveMember"))) {
            final Member member = this.pojo.getMemberList().get((int) (this.object));

            new MemberCreator(this.pojo).removeMember(member);
            this.generateMemberMessage(member, "Removed");

        }
        MemberTableModel.refreshTable();
    }

    private void useGroupOperation() {

        if (this.action.equals(this.pojo.getTranslation("AddGroup"))) {
            final Group group = (Group) this.object;

            new GroupCreator(this.pojo).createGroup(group.getName(), group.getDescription(), group.getFixSize());
            this.generateGroupMessage(group, "Added");

        } else if (this.action.equals(this.pojo.getTranslation("EditGroup"))) {
            final Group oldGroup = ((ArrayList<Group>) this.object).get(0);
            final Group newGroup = ((ArrayList<Group>) this.object).get(1);

            new GroupCreator(this.pojo).editGroup(oldGroup, newGroup);
            this.generateGroupMessage(oldGroup, "Edited");

        } else if (this.action.equals(this.pojo.getTranslation("RemoveGroup"))) {
            final Group group = this.pojo.getGroupList().get((int) (this.object));

            new GroupCreator(this.pojo).removeGroup(group);
            this.generateGroupMessage(group, "Removed");

        } else if (this.action.equals(this.pojo.getTranslation("AutoCreateGroups"))) {
            new GroupCreator(this.pojo).createGroupsAutmatically((int) this.object);
            new GroupBuilder().buildGroups(this.pojo);
            this.message = this.pojo.getTranslation("GroupsCreatedSuccess");
        }
        GroupTableModel.refreshTable();
    }

    private void generateMemberMessage(final Member member, final String operation) {

        final String firstName = member.getFirstName();
        final String lastName = member.getLastName();
        this.message = this.pojo.getTranslation("Member") + " " + firstName + " " + lastName + " "
                + this.pojo.getTranslation("WasSuccessfully") + " " + this.pojo.getTranslation(operation) + ".";
    }

    private void generateGroupMessage(final Group group, final String operation) {

        final String groupName = group.getName();
        this.message = this.pojo.getTranslation("Group") + " " + groupName + " " + this.pojo.getTranslation("WasSuccessfully")
                + " " + this.pojo.getTranslation(operation) + ".";
    }

    private void showSuccessMessage(final String text) {
        OperationSuccessfullFrame.getInstance(text, this.pojo);
    }
}
