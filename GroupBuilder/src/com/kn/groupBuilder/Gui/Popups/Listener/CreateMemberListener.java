package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.CreateMemberFrame;
import com.kn.groupBuilder.Storage.Member;

public class CreateMemberListener implements ActionListener {

    private final CreateMemberFrame createMemberFrame;
    private final ArrayList<Member> memberList;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField eMailField;
    private final JTextField groupsField;

    public CreateMemberListener(
            final CreateMemberFrame createMemberFrame,
            final ArrayList<Member> memberList,
            final JTextField firstNameField,
            final JTextField lastNameField,
            final JTextField eMailField,
            final JTextField groupsField) {

        this.createMemberFrame = createMemberFrame;
        this.memberList = memberList;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.eMailField = eMailField;
        this.groupsField = groupsField;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
