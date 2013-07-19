package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Exceptions.DataNotFoundException;
import com.kn.groupBuilder.Gui.Menu.EmailFrame;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the email frame. Allows to start the email sending process and to close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmailFrameListener implements ActionListener {

    private final EmailFrame emailFrame;
    private final Pojo pojo;
    private final JTextField addressField;

    public EmailFrameListener(final EmailFrame emailFrame, final Pojo pojo, final JTextField addressField) {
        this.emailFrame = emailFrame;
        this.pojo = pojo;
        this.addressField = addressField;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("sendButton") == 0) {
            final String eMailAddress = this.addressField.getText();
            for (final Member member : this.pojo.getMemberList()) {
                if (eMailAddress.equals(member.getEMailAdress())) {
                    ConfirmationFrame.getInstance(this.pojo, "sendMail", member);
                } else {
                    new DataNotFoundException("EmailAddress: \"" + eMailAddress + "\"").showDialog();
                    return;
                }
            }
        } else if (buttonClicked.getName().compareTo("sendAllButton") == 0) {
            ConfirmationFrame.getInstance(this.pojo, "sendMailToAll", null);
        }
        this.emailFrame.closeWindow();

    }
}
