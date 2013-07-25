package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

import com.kn.groupBuilder.FileOperations.Output.EmailJobHelper;
import com.kn.groupBuilder.FileOperations.Output.PrintJobHelper;
import com.kn.groupBuilder.FileOperations.Writer.FileWriteHelper;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.OperationSuccessfullFrame;
import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Jobs.GroupBuilder;
import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

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

    private static final List<String> OUTPUT_OPERATIONS = Arrays.asList("print", "sendMail", "save");
    private static final List<String> MEMBER_OPERATIONS = Arrays.asList("addMember", "editMember", "removeMember");
    private static final List<String> GROUP_OPERATIONS = Arrays.asList(
            "addGroup",
            "editGroup",
            "removeGroup",
            "automatically create groups");
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
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            if (OUTPUT_OPERATIONS.contains(this.action)) {
                this.useOutputOperation();
            } else if (MEMBER_OPERATIONS.contains(this.action)) {
                this.useMemberOperation();
            } else if (GROUP_OPERATIONS.contains(this.action)) {
                this.useGroupOperation();
            } else if (this.action.equals("close the window")) {
                ((DefaultFrame) this.object).closeWindow();
                this.confirmationFrame.closeWindow();
                return;
            }
            this.showSuccessMessage(this.message);
        }
        this.confirmationFrame.closeWindow();
    }

    private void useOutputOperation() {

        if (this.action.equals("print")) {
            new PrintJobHelper().printOutForGroups(this.pojo, (ArrayList<Group>) this.object);
            this.message = this.pojo.getMessages("PrintSuccess");

        } else if (this.action.equals("sendMail")) {
            new EmailJobHelper().sendMailToGroups(this.pojo, (ArrayList<Group>) this.object);
            this.message = this.pojo.getMessages("MainSuccess");

        } else if (this.action.equals("save")) {
            new FileWriteHelper().createXMLFiles(this.pojo);
            this.message = this.pojo.getMessages("SaveSuccess");
        }
    }

    private void useMemberOperation() {

        if (this.action.equals("addMember")) {
            final Member member = (Member) this.object;

            new MemberCreator(this.pojo).correctMemberFormat(member);
            this.generateMemberMessage(member, "added");

        } else if (this.action.equals("editMember")) {
            final Member oldMember = ((ArrayList<Member>) this.object).get(0);
            final Member newMember = ((ArrayList<Member>) this.object).get(1);

            new MemberCreator(this.pojo).editMember(oldMember, newMember);
            this.generateMemberMessage(oldMember, "edited");

        } else if (this.action.equals("removeMember")) {
            final Member member = this.pojo.getMemberList().get((int) (this.object));

            new MemberCreator(this.pojo).removeMember(member);
            this.generateMemberMessage(member, "removed");

        }
        MemberTableModel.refreshTable();
    }

    private void useGroupOperation() {

        if (this.action.equals("addGroup")) {
            final Group group = (Group) this.object;

            new GroupCreator(this.pojo).createGroup(group.getName(), group.getDescription(), group.getFixSize());
            this.generateGroupMessage(group, "added");

        } else if (this.action.equals("editGroup")) {
            final Group oldGroup = ((ArrayList<Group>) this.object).get(0);
            final Group newGroup = ((ArrayList<Group>) this.object).get(1);

            new GroupCreator(this.pojo).editGroup(oldGroup, newGroup);
            this.generateGroupMessage(oldGroup, "edited");

        } else if (this.action.equals("removeGroup")) {
            final Group group = this.pojo.getGroupList().get((int) (this.object));

            new GroupCreator(this.pojo).removeGroup(group);
            this.generateGroupMessage(group, "removed");

        } else if (this.action.equals("automatically create groups")) {
            new GroupCreator(this.pojo).createGroupsAutmatically((int) this.object);
            new GroupBuilder().buildGroups(this.pojo);
            this.message = this.pojo.getMessages("GroupsCreatedSuccess");
        }
        GroupTableModel.refreshTable();
    }

    private void generateMemberMessage(final Member member, final String operation) {

        final String firstName = member.getFirstName();
        final String lastName = member.getLastName();
        this.message = this.pojo.getMessages("Member") + " " + firstName + " " + lastName + " "
                + this.pojo.getMessages("WasSuccessfully") + " " + operation + ".";
    }

    private void generateGroupMessage(final Group group, final String operation) {

        final String groupName = group.getName();
        this.message = this.pojo.getMessages("Group") + " " + groupName + " " + this.pojo.getMessages("WasSuccessfully") + " "
                + operation + ".";
    }

    private void showSuccessMessage(final String text) {
        OperationSuccessfullFrame.getInstance(text, this.pojo);
    }
}
