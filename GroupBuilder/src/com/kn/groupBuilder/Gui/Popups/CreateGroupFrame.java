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

import com.kn.groupBuilder.Gui.Popups.Listener.CreateGroupListener;
import com.kn.groupBuilder.HelperClasses.GuiBuilder;
import com.kn.groupBuilder.Storage.Group;

public class CreateGroupFrame extends JFrame {

    private static final long serialVersionUID = -2620743685703998617L;
    GuiBuilder builder = new GuiBuilder();

    public CreateGroupFrame(final ArrayList<Group> groupList) {
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

        final JLabel groupNameLabel = new JLabel("GroupName");
        final JLabel groupDescLabel = new JLabel("Description");
        final JLabel groupSizeLabel = new JLabel("Size");

        final JTextField groupNameField = new JTextField(5);
        final JTextField groupDescField = new JTextField(5);
        final JTextField groupSizeField = new JTextField(5);

        final JButton bestaetigenButton = this.builder.createButton(this, "bestaetigenButton", "Bestätigen", c, 0, 4);
        final JButton abbrechenButton = this.builder.createButton(this, "abbrechenButton", "Abbrechen", c, 1, 4);

        c.gridx = 0;
        c.gridy = 1;
        this.add(groupNameLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(groupNameField, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(groupDescLabel, c);

        c.gridx = 1;
        c.gridy = 2;
        this.add(groupDescField, c);

        c.gridx = 0;
        c.gridy = 3;
        this.add(groupSizeLabel, c);

        c.gridx = 1;
        c.gridy = 3;
        this.add(groupSizeField, c);

        this.setVisible(true);
        this.pack();

        final CreateGroupListener listener = new CreateGroupListener(this, groupList);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);
    }
}
