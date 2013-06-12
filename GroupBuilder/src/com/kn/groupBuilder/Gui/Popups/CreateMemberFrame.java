package com.kn.groupBuilder.Gui.Popups;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.CreateMemberListener;
import com.kn.groupBuilder.Storage.Member;

public class CreateMemberFrame extends JFrame {

    private static final long serialVersionUID = -2620743685703998617L;

    public CreateMemberFrame(final ArrayList<Member> memberList) {
        // basic attributes
        this.setTitle("GroupBuilder");
        this.setSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 2;
        this.setLayout(new GridBagLayout());

        final JLabel firstNameLabel = new JLabel("FirstName");
        final JLabel lastNameLabel = new JLabel("LastName");
        final JLabel eMailLabel = new JLabel("E-Mail");
        final JLabel groupsLabel = new JLabel("Groups");

        final JTextField firstNameField = new JTextField(5);
        final JTextField lastNameField = new JTextField(5);
        final JTextField eMailField = new JTextField(5);
        final JTextField groupsField = new JTextField(5);

        final JButton bestaetigenButton = new JButton("Bestätigen");
        bestaetigenButton.setName("bestaetigenButton");
        final JButton abbrechenButton = new JButton("Abbrechen");
        abbrechenButton.setName("abbrechenButton");

        c.gridx = 0;
        c.gridy = 1;
        this.add(firstNameLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(firstNameField, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(lastNameLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(lastNameField, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add(eMailLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        this.add(eMailField, c);

        c.gridx = 0;
        c.gridy = 4;
        this.add(groupsLabel, c);

        c.gridx = 1;
        c.gridy = 4;
        this.add(groupsField, c);

        c.gridx = 0;
        c.gridy = 5;
        this.add(bestaetigenButton, c);

        c.gridx = 1;
        c.gridy = 5;
        this.add(abbrechenButton, c);

        this.setVisible(true);
        this.pack();

        final CreateMemberListener listener = new CreateMemberListener(this, memberList);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);
    }
}
