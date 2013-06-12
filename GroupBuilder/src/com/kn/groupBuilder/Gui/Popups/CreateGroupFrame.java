package com.kn.groupBuilder.Gui.Popups;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.CreateGroupListener;
import com.kn.groupBuilder.HelperClasses.GuiBuilder;
import com.kn.groupBuilder.Storage.Group;

public class CreateGroupFrame extends JFrame {

    private static final long serialVersionUID = -2620743685703998617L;
    private final GuiBuilder builder = new GuiBuilder();
    private static final int TEXT_FIELD_SIZE = 3;

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

        this.builder.createLabel(this, "GroupName", c, 0, 1);
        this.builder.createLabel(this, "Description", c, 0, 2);
        this.builder.createLabel(this, "Size", c, 0, 3);

        final JTextField groupNameField = this.builder.createTextField(this, TEXT_FIELD_SIZE, c, 1, 1);
        final JTextField groupDescField = this.builder.createTextField(this, TEXT_FIELD_SIZE, c, 1, 2);
        final JTextField groupSizeField = this.builder.createTextField(this, TEXT_FIELD_SIZE, c, 1, 3);

        final JButton bestaetigenButton = this.builder.createButton(this, "bestaetigenButton", "Bestätigen", c, 0, 4);
        final JButton abbrechenButton = this.builder.createButton(this, "abbrechenButton", "Abbrechen", c, 1, 4);

        this.setVisible(true);
        this.pack();

        final CreateGroupListener listener = new CreateGroupListener(
                this,
                groupList,
                groupNameField,
                groupDescField,
                groupSizeField);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);
    }
}
