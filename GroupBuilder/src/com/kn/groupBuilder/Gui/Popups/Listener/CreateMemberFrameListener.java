package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.kn.groupBuilder.Exceptions.EmptyValueException;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.CreateMemberFrame;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the createMemberFrame. Allows to start create member and close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class CreateMemberFrameListener implements ActionListener {

    private final CreateMemberFrame createMemberFrame;
    private final Pojo pojo;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField eMailField;
    private final JComboBox<String> groupBox;

    public CreateMemberFrameListener(
            final CreateMemberFrame createMemberFrame,
            final Pojo pojo,
            final JTextField firstNameField,
            final JTextField lastNameField,
            final JTextField eMailField,
            final JComboBox<String> groupBox) {

        this.createMemberFrame = createMemberFrame;
        this.pojo = pojo;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.eMailField = eMailField;
        this.groupBox = groupBox;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();
        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            final String firstName = this.firstNameField.getText();
            final String lastName = this.lastNameField.getText();
            final String eMailAdress = this.eMailField.getText();
            final String groupName = this.pojo.getGroupListAsArray()[this.groupBox.getSelectedIndex()];
            final Group group = this.pojo.getGroupByName(groupName);

            if (firstName.equals("")) {
                new EmptyValueException(this.pojo.getMessages("FirstName")).showDialog();
                return;
            }
            if (lastName.equals("")) {
                new EmptyValueException(this.pojo.getMessages("LastName")).showDialog();
                return;
            }

            ConfirmationFrame.getInstance(this.pojo, this.pojo.getMessages("AddMember"), new Member(
                    firstName,
                    lastName,
                    eMailAdress,
                    group));
        }
        this.createMemberFrame.closeWindow();

    }
}
