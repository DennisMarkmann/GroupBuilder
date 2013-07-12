package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.FileOperations.Output.EmailJobHelper;
import com.kn.groupBuilder.FileOperations.Output.PrintJobHelper;
import com.kn.groupBuilder.FileOperations.Writer.FileWriteHelper;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Jobs.GroupCreator;
import com.kn.groupBuilder.Jobs.MemberCreator;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

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

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {
            if (this.action.equals("addGroup")) {
                final Group group = (Group) this.object;
                new GroupCreator(this.pojo).createGroup(group.getName(), group.getDescription(), group.getFixSize());
            } else if (this.action.equals("addMember")) {
                final Member member = (Member) this.object;
                new MemberCreator(this.pojo).createMember(member.getFirstName(), member.getLastName(), member.getEMailAdress());
            } else if (this.action.equals("printOutAll")) {
                new PrintJobHelper().printAllGroups(this.pojo);
            } else if (this.action.equals("sendMailToAll")) {
                new EmailJobHelper().initializeEmailSending(this.pojo);
            } else if (this.action.equals("printOut")) {
                // TODO implement single print
            } else if (this.action.equals("sendMail")) {
                // TODO implement single mail
            } else if (this.action.equals("save")) {
                new FileWriteHelper().createXMLFiles(this.pojo);
            }
        }
        this.confirmationFrame.closeWindow();

    }
}
