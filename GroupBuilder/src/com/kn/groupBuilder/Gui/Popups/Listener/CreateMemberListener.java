package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.BestaetigenFrame;
import com.kn.groupBuilder.Gui.Popups.CreateMemberFrame;
import com.kn.groupBuilder.Storage.Member;
import com.kn.groupBuilder.Storage.Pojo;

public class CreateMemberListener implements ActionListener {

    private final CreateMemberFrame createMemberFrame;
    private final Pojo pojo;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField eMailField;
    private final JTextField groupsField;

    public CreateMemberListener(
            final CreateMemberFrame createMemberFrame,
            final Pojo pojo,
            final JTextField firstNameField,
            final JTextField lastNameField,
            final JTextField eMailField,
            final JTextField groupsField) {

        this.createMemberFrame = createMemberFrame;
        this.pojo = pojo;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.eMailField = eMailField;
        this.groupsField = groupsField;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        // TODO add groups
        if (buttonClicked.getName().compareTo("bestaetigenButton") == 0) {
            new BestaetigenFrame(this.pojo, "addMember", new Member(
                    this.firstNameField.getText(),
                    this.lastNameField.getText(),
                    this.eMailField.getText()));
            this.createMemberFrame.dispose();
        } else if (buttonClicked.getText().compareTo("Abbrechen") == 0) {
        }
        this.createMemberFrame.dispose();

    }

}
