package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import com.kn.groupBuilder.Gui.Menu.EmailFrame;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Group;
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
    private final ArrayList<JCheckBox> checkBoxList;

    public EmailFrameListener(final EmailFrame emailFrame, final Pojo pojo, final ArrayList<JCheckBox> checkBoxList) {
        this.emailFrame = emailFrame;
        this.pojo = pojo;
        this.checkBoxList = checkBoxList;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("sendButton") == 0) {
            final ArrayList<Group> groupList = new ArrayList<Group>();
            for (final JCheckBox checkBox : this.checkBoxList) {
                if (checkBox.isSelected()) {
                    groupList.add(this.pojo.getGroupByName(checkBox.getName()));
                }
            }

            ConfirmationFrame.getInstance(this.pojo, "sendMail", groupList);

        }
        this.emailFrame.closeWindow();

    }
}
