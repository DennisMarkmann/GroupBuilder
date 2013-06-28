package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Popups.Listener.CreateMemberFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public final class CreateMemberFrame extends JFrame implements DefaultFrame {

    private static CreateMemberFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;

    private CreateMemberFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "CreateMember");
        this.addWindowListener(new MyWindowAdapter(this));

        BUILDER.createLabel(this, "FirstName", 0, 1);
        BUILDER.createLabel(this, "LastName", 0, 2);
        BUILDER.createLabel(this, "E-Mail", 0, 3);

        final JTextField firstNameField = BUILDER.createTextField(this, "firstNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField lastNameField = BUILDER.createTextField(this, "lastNameField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField eMailField = BUILDER.createTextField(this, "eMailField", TEXT_FIELD_SIZE, 1, 3);

        final JButton confirmationButton = BUILDER.createButton(this, "confirmationButton", "Confirm", 0, 4);
        final JButton abortButton = BUILDER.createButton(this, "abortButton", "Abort", 1, 4);

        this.pack();

        final CreateMemberFrameListener listener = new CreateMemberFrameListener(
                this,
                pojo,
                firstNameField,
                lastNameField,
                eMailField);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }

    public static CreateMemberFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new CreateMemberFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
