package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public class ConfirmationFrameListener implements ActionListener {

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

    @SuppressWarnings("unchecked")
    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {
            if (this.action.equals("addGroup")) {
                final Group group = (Group) this.object;
                new GroupCreator(this.pojo).createGroup(group.getName(), group.getDescription(), group.getFixSize());
                GroupTableModel.refreshTable();
                OperationSuccessfullFrame.getInstance("Group " + group.getName() + " was succesfully added.");
            } else if (this.action.equals("addMember")) {
                final Member member = (Member) this.object;
                new MemberCreator(this.pojo).createMember(
                        member.getFirstName(),
                        member.getLastName(),
                        member.getEMailAdress(),
                        member.getGroup());
                MemberTableModel.refreshTable();
                OperationSuccessfullFrame.getInstance("Member " + member.getFirstName() + " " + member.getLastName()
                        + " was succesfully added.");
            } else if (this.action.equals("print")) {
                new PrintJobHelper().printOutForGroups(this.pojo, (ArrayList<Group>) this.object);
                OperationSuccessfullFrame.getInstance("All groups were successfully printed.");
            } else if (this.action.equals("sendMail")) {
                new EmailJobHelper().sendMailToGroups(this.pojo, (ArrayList<Group>) this.object);
                OperationSuccessfullFrame.getInstance("Emails were succesfully send.");
            } else if (this.action.equals("save")) {
                new FileWriteHelper().createXMLFiles(this.pojo);
                OperationSuccessfullFrame.getInstance("All files were successfully saved.");
            } else if (this.action.equals("editMember")) {
                final Member oldMember = ((ArrayList<Member>) this.object).get(0);
                final Member newMember = ((ArrayList<Member>) this.object).get(1);
                new MemberCreator(this.pojo).editMember(oldMember, newMember);
                MemberTableModel.refreshTable();
                OperationSuccessfullFrame.getInstance("Member " + oldMember.getFirstName() + " " + oldMember.getLastName()
                        + " was succesfully edited.");
            } else if (this.action.equals("removeMember")) {
                final Member member = this.pojo.getMemberList().get((int) (this.object));
                new MemberCreator(this.pojo).removeMember(member);
                MemberTableModel.refreshTable();
                OperationSuccessfullFrame.getInstance("Member " + member.getFirstName() + " " + member.getLastName()
                        + " was succesfully removed.");
            } else if (this.action.equals("editGroup")) {
                final Group oldGroup = ((ArrayList<Group>) this.object).get(0);
                final Group newGroup = ((ArrayList<Group>) this.object).get(1);
                new GroupCreator(this.pojo).editGroup(oldGroup, newGroup);
                GroupTableModel.refreshTable();
                OperationSuccessfullFrame.getInstance("Group " + oldGroup.getName() + " was succesfully edited.");
            } else if (this.action.equals("removeGroup")) {
                final Group group = this.pojo.getGroupList().get((int) (this.object));
                new GroupCreator(this.pojo).removeGroup(group);
                GroupTableModel.refreshTable();
                OperationSuccessfullFrame.getInstance("Group " + group.getName() + " was succesfully removed.");
            } else if (this.action.equals("automatically create groups")) {
                new GroupCreator(this.pojo).createGroupsAutmatically((int) this.object);
                new GroupBuilder().buildGroups(this.pojo);
                GroupTableModel.refreshTable();
                OperationSuccessfullFrame.getInstance("All groups were automatically created.");
            } else if (this.action.equals("close the window")) {
                final DefaultFrame frame = (DefaultFrame) this.object;
                frame.closeWindow();
            }
        }
        this.confirmationFrame.closeWindow();

    }
}
