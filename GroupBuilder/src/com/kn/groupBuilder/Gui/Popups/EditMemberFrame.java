package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.EditMemberFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to start member editition.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class EditMemberFrame extends JFrame implements DefaultFrame {

    private static EditMemberFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;

    private EditMemberFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - EditMember");
        this.addWindowListener(new MyWindowAdapter(this));

        BUILDER.createLabel(this, "FirstName", 0, 1);
        BUILDER.createLabel(this, "LastName", 0, 2);
        BUILDER.createLabel(this, "E-Mail", 0, 3);

        // TODO initially fill these fields with the curret member values
        final JTextField firstNameField = BUILDER.createTextField(this, "firstNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField lastNameField = BUILDER.createTextField(this, "lastNameField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField eMailField = BUILDER.createTextField(this, "eMailField", TEXT_FIELD_SIZE, 1, 3);

        final JButton confirmationButton = BUILDER.createButton(this, "confirmationButton", "Confirm", 0, 4);
        final JButton abortButton = BUILDER.createButton(this, "abortButton", "Abort", 1, 4);

        this.pack();

        final EditMemberFrameListener listener = new EditMemberFrameListener(
                this,
                pojo,
                firstNameField,
                lastNameField,
                eMailField);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }

    public static EditMemberFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new EditMemberFrame(pojo);
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
