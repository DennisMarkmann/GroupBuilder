package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.EditGroupFrameListener;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to edit information for the groups.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class EditGroupFrame extends JFrame implements DefaultFrame {

    private static EditGroupFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;
    private Pojo pojo = null;

    private EditGroupFrame(final Pojo pojo, final int rowID) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getMessages("EditGroup"));
        this.addWindowListener(new MyWindowAdapter(this));

        BUILDER.createLabel(this, pojo.getMessages("GroupName"), 0, 1);
        BUILDER.createLabel(this, pojo.getMessages("Description"), 0, 2);
        BUILDER.createLabel(this, pojo.getMessages("Size"), 0, 3);

        final JTextField groupNameField = BUILDER.createTextField(this, "groupNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField groupDescField = BUILDER.createTextField(this, "groupDescField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField groupSizeField = BUILDER.createTextField(this, "groupSizeField", TEXT_FIELD_SIZE, 1, 3);

        final JButton confirmationButton = BUILDER.createButton(this, "confirmationButton", pojo.getMessages("Confirm"), 0, 4);
        final JButton abortButton = BUILDER.createButton(this, "abortButton", pojo.getMessages("Abort"), 1, 4);

        this.pack();

        this.fillFields(pojo, rowID, groupNameField, groupDescField, groupSizeField);

        final EditGroupFrameListener listener = new EditGroupFrameListener(
                this,
                pojo,
                rowID,
                groupNameField,
                groupDescField,
                groupSizeField);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }

    public static EditGroupFrame getInstance(final Pojo pojo, final int rowID) {
        if (instance == null) {
            instance = new EditGroupFrame(pojo, rowID);
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

    private void fillFields(
            final Pojo pojo,
            final int rowID,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        final Group group = pojo.getGroupList().get(rowID);
        groupNameField.setText(group.getName());
        groupDescField.setText(group.getDescription());
        groupSizeField.setText(group.getFixSize() + "");

    }
}
