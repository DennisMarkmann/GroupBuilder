package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Popups.Listener.CreateGroupFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public final class CreateGroupFrame extends JFrame implements DefaultFrame {

    private static CreateGroupFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;

    private CreateGroupFrame(final Pojo pojo) {

        builder.setDefaultFrameSettings(this, "CreateGroup");
        this.addWindowListener(new MyWindowAdapter(this));

        builder.createLabel(this, "GroupName", 0, 1);
        builder.createLabel(this, "Description", 0, 2);
        builder.createLabel(this, "Size", 0, 3);

        final JTextField groupNameField = builder.createTextField(this, "groupNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField groupDescField = builder.createTextField(this, "groupDescField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField groupSizeField = builder.createTextField(this, "groupSizeField", TEXT_FIELD_SIZE, 1, 3);

        final JButton confirmationButton = builder.createButton(this, "confirmationButton", "Confirm", 0, 4);
        final JButton abortButton = builder.createButton(this, "abortButton", "Abort", 1, 4);

        this.pack();

        final CreateGroupFrameListener listener = new CreateGroupFrameListener(
                this,
                pojo,
                groupNameField,
                groupDescField,
                groupSizeField);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }

    public static CreateGroupFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new CreateGroupFrame(pojo);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
