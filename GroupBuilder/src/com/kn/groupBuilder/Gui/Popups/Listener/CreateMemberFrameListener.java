package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.CreateMemberFrame;
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

    public CreateMemberFrameListener(
            final CreateMemberFrame createMemberFrame,
            final Pojo pojo,
            final JTextField firstNameField,
            final JTextField lastNameField,
            final JTextField eMailField) {

        this.createMemberFrame = createMemberFrame;
        this.pojo = pojo;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.eMailField = eMailField;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();
        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            final String firstName = this.firstNameField.getText();
            final String lastName = this.lastNameField.getText();
            final String email = this.eMailField.getText();

            if (firstName.equals("")) {
                // TODO throw error
            }
            if (lastName.equals("")) {
                // TODO throw error
            }
            ConfirmationFrame.getInstance(this.pojo, "addMember", new Member(firstName, lastName, email));
        }
        this.createMemberFrame.closeWindow();

    }
}
