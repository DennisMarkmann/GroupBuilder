package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.CreateGroupsFrame;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the createGroupsFrame. Automatically create groups.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class CreateGroupsFrameListener implements ActionListener {

    private final CreateGroupsFrame createGroupsAutomaticallyFrame;
    private final JTextField numberField;
    private final Pojo pojo;

    public CreateGroupsFrameListener(
            final CreateGroupsFrame createGroupsAutomaticallyFrame,
            final Pojo pojo,
            final JTextField numberField) {

        this.createGroupsAutomaticallyFrame = createGroupsAutomaticallyFrame;
        this.pojo = pojo;
        this.numberField = numberField;

    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("createButton") == 0) {
            this.createGroupsAutomaticallyFrame.closeWindow();
            final int memberPerGroup = Integer.parseInt(this.numberField.getText());

            ConfirmationFrame.getInstance(this.pojo, "automatically create groups", memberPerGroup);

        } else if (buttonClicked.getName().compareTo("closeButton") == 0) {
            this.createGroupsAutomaticallyFrame.closeWindow();
        }
    }
}
