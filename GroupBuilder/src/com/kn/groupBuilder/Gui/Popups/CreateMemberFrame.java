package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.CreateMemberFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to start member creation.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class CreateMemberFrame extends JFrame implements DefaultFrame {

    private static CreateMemberFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;
    private Pojo pojo = null;

    private CreateMemberFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getMessages("CreateMember"));
        this.addWindowListener(new MyWindowAdapter(this));
        this.setSize(350, 200);

        BUILDER.createLabel(this, pojo.getMessages("FirstName"), 0, 1);
        BUILDER.createLabel(this, pojo.getMessages("LastName"), 0, 2);
        BUILDER.createLabel(this, pojo.getMessages("E-Mail"), 0, 3);
        BUILDER.createLabel(this, pojo.getMessages("Group"), 0, 4);

        final JTextField firstNameField = BUILDER.createTextField(this, "firstNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField lastNameField = BUILDER.createTextField(this, "lastNameField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField eMailField = BUILDER.createTextField(this, "eMailField", TEXT_FIELD_SIZE, 1, 3);
        final JComboBox<String> groupBox = BUILDER.createComboBox(this, "groupBox", pojo.getGroupListAsArray(), 1, 4);
        final JButton confirmationButton = BUILDER.createButton(this, "confirmationButton", pojo.getMessages("Confirm"), 0, 5);
        final JButton abortButton = BUILDER.createButton(this, "abortButton", pojo.getMessages("Abort"), 1, 5);

        final CreateMemberFrameListener listener = new CreateMemberFrameListener(
                this,
                pojo,
                firstNameField,
                lastNameField,
                eMailField,
                groupBox);

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
    public void openClosingDialog(final String text) {
        ConfirmationFrame.getInstance(this.pojo, text, this);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
