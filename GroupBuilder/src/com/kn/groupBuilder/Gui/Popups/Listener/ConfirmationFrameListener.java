package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import com.kn.groupBuilder.FileOperations.Output.EmailJobHelper;
import com.kn.groupBuilder.FileOperations.Output.PrintJobHelper;
import com.kn.groupBuilder.FileOperations.Writer.FileWriteHelper;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

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
            } else if (this.action.equals("addMember")) {
                final Member member = (Member) this.object;
                new MemberCreator(this.pojo).createMember(member.getFirstName(), member.getLastName(), member.getEMailAdress());
                MemberTableModel.refreshTable();
            } else if (this.action.equals("printOutAll")) {
                new PrintJobHelper().printAllGroups(this.pojo);
            } else if (this.action.equals("sendMailToAll")) {
                new EmailJobHelper().initializeEmailSending(this.pojo);
            } else if (this.action.equals("printOut")) {
                new PrintJobHelper().printGroup(this.pojo.getGroupByName((String) this.object));
            } else if (this.action.equals("sendMail")) {
                // TODO implement single mail functionality
            } else if (this.action.equals("save")) {
                new FileWriteHelper().createXMLFiles(this.pojo);
            } else if (this.action.equals("editMember")) {
                new MemberCreator(this.pojo).editMember(
                        ((ArrayList<Member>) this.object).get(0),
                        ((ArrayList<Member>) this.object).get(1));
            } else if (this.action.equals("removeMember")) {
                new MemberCreator(this.pojo).removeMember((Member) this.object);
            }
        }
        this.confirmationFrame.closeWindow();

    }
}
