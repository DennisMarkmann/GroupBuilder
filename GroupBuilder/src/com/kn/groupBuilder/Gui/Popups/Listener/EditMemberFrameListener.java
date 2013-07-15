package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Exceptions.EmptyValueException;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.EditMemberFrame;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the createMemberFrame. Allows to start create member and close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EditMemberFrameListener implements ActionListener {

    private final EditMemberFrame editMemberFrame;
    private final Pojo pojo;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField eMailField;

    public EditMemberFrameListener(
            final EditMemberFrame editMemberFrame,
            final Pojo pojo,
            final JTextField firstNameField,
            final JTextField lastNameField,
            final JTextField eMailField) {

        this.editMemberFrame = editMemberFrame;
        this.pojo = pojo;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.eMailField = eMailField;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();
        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            final ArrayList<Member> memberList = new ArrayList<Member>();
            final String firstName = this.firstNameField.getText();
            final String lastName = this.lastNameField.getText();
            final String email = this.eMailField.getText();

            if (firstName.equals("")) {
                new EmptyValueException("firstName").showDialog();
                return;
            }
            if (lastName.equals("")) {
                new EmptyValueException("lastName").showDialog();
                return;
            }
            // TODO find a way to add the old member

            memberList.add(new Member(firstName, lastName, email));

            ConfirmationFrame.getInstance(this.pojo, "editMember", memberList);
        }
        this.editMemberFrame.closeWindow();

    }
}
