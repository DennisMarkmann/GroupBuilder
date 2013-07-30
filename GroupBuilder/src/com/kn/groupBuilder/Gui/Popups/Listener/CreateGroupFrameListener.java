package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Exceptions.EmptyValueException;
import com.kn.groupBuilder.Exceptions.NotToHandleException;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.CreateGroupFrame;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the groupFrame. Used to create groups and close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class CreateGroupFrameListener implements ActionListener {

    private final CreateGroupFrame createGroupFrame;
    private final Pojo pojo;
    private final JTextField groupNameField;
    private final JTextField groupDescField;
    private final JTextField groupSizeField;

    public CreateGroupFrameListener(
            final CreateGroupFrame createGroupFrame,
            final Pojo pojo,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        this.createGroupFrame = createGroupFrame;
        this.pojo = pojo;
        this.groupNameField = groupNameField;
        this.groupDescField = groupDescField;
        this.groupSizeField = groupSizeField;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            int fixSize = 0;
            final String groupName = this.groupNameField.getText();
            final String description = this.groupDescField.getText();
            try {
                fixSize = Integer.parseInt(this.groupSizeField.getText());
            } catch (final NumberFormatException e) {
                new NotToHandleException(e.getStackTrace());
            }
            if (groupName.equals("")) {
                new EmptyValueException("groupName").showDialog();
                return;
            }

            ConfirmationFrame.getInstance(this.pojo, this.pojo.getMessages("AddGroup"), new Group(
                    groupName,
                    description,
                    fixSize));
        }
        this.createGroupFrame.closeWindow();

    }
}
