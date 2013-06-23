package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Menu.EmailFrame;
import com.kn.groupBuilder.Gui.Popups.BestaetigenFrame;
import com.kn.groupBuilder.Storage.Pojo;

public class EmailFrameListener implements ActionListener {

    final EmailFrame emailFrame;
    final Pojo pojo;
    final JTextField addressField;

    public EmailFrameListener(final EmailFrame emailFrame, final Pojo pojo, final JTextField addressField) {
        this.emailFrame = emailFrame;
        this.pojo = pojo;
        this.addressField = addressField;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("sendButton") == 0) {
            new BestaetigenFrame(this.pojo, "sendMail", this.addressField.getText());
        } else if (buttonClicked.getName().compareTo("sendAllButton") == 0) {
            new BestaetigenFrame(this.pojo, "sendMailToAll", null);
        } else if (buttonClicked.getName().compareTo("closeButton") == 0) {
        }
        this.emailFrame.dispose();

    }
}
