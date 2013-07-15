package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Exceptions.EmptyValueException;
import com.kn.groupBuilder.Exceptions.NotToHandleException;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.EditGroupFrame;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the groupFrame. Used to edit groups and close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EditGroupFrameListener implements ActionListener {

    private final EditGroupFrame editGroupFrame;
    private final Pojo pojo;
    private final JTextField groupNameField;
    private final JTextField groupDescField;
    private final JTextField groupSizeField;

    public EditGroupFrameListener(
            final EditGroupFrame editGroupFrame,
            final Pojo pojo,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        this.editGroupFrame = editGroupFrame;
        this.pojo = pojo;
        this.groupNameField = groupNameField;
        this.groupDescField = groupDescField;
        this.groupSizeField = groupSizeField;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            final ArrayList<Group> groupList = new ArrayList<Group>();
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
            // TODO find a way to add the old group

            groupList.add(new Group(groupName, description, fixSize));

            ConfirmationFrame.getInstance(this.pojo, "editGroup", groupList);
        }
        this.editGroupFrame.closeWindow();

    }
}
