package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Popups.Listener.CreateMemberFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public final class CreateMemberFrame extends JFrame implements DefaultFrame {

    private static CreateMemberFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();
    private static final int TEXT_FIELD_SIZE = 5;

    private CreateMemberFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "CreateMember");
        this.addWindowListener(new MyWindowAdapter(this));

        this.builder.createLabel(this, "FirstName", 0, 1);
        this.builder.createLabel(this, "LastName", 0, 2);
        this.builder.createLabel(this, "E-Mail", 0, 3);
        this.builder.createLabel(this, "Groups", 0, 4);

        final JTextField firstNameField = this.builder.createTextField(this, "firstNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField lastNameField = this.builder.createTextField(this, "lastNameField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField eMailField = this.builder.createTextField(this, "eMailField", TEXT_FIELD_SIZE, 1, 3);
        final JTextField groupsField = this.builder.createTextField(this, "groupsField", TEXT_FIELD_SIZE, 1, 4);

        final JButton confirmationButton = this.builder.createButton(this, "confirmationButton", "Confirm", 0, 5);
        final JButton abortButton = this.builder.createButton(this, "abortButton", "Abort", 1, 5);

        this.pack();

        final CreateMemberFrameListener listener = new CreateMemberFrameListener(
                this,
                pojo,
                firstNameField,
                lastNameField,
                eMailField,
                groupsField);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }

    public static CreateMemberFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new CreateMemberFrame(pojo);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
