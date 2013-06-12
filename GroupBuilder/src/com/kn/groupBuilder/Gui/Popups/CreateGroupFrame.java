package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Popups.Listener.CreateGroupListener;
import com.kn.groupBuilder.Storage.Pojo;

public class CreateGroupFrame extends JFrame {

    private static final long serialVersionUID = -2620743685703998617L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();
    private static final int TEXT_FIELD_SIZE = 5;

    public CreateGroupFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this);

        this.builder.createLabel(this, "GroupName", 0, 1);
        this.builder.createLabel(this, "Description", 0, 2);
        this.builder.createLabel(this, "Size", 0, 3);

        final JTextField groupNameField = this.builder.createTextField(this, TEXT_FIELD_SIZE, 1, 1);
        final JTextField groupDescField = this.builder.createTextField(this, TEXT_FIELD_SIZE, 1, 2);
        final JTextField groupSizeField = this.builder.createTextField(this, TEXT_FIELD_SIZE, 1, 3);

        final JButton bestaetigenButton = this.builder.createButton(this, "bestaetigenButton", "Bestätigen", 0, 4);
        final JButton abbrechenButton = this.builder.createButton(this, "abbrechenButton", "Abbrechen", 1, 4);

        this.pack();

        final CreateGroupListener listener = new CreateGroupListener(this, pojo, groupNameField, groupDescField, groupSizeField);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);
    }
}
