package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.CreateGroupsFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to automatically create groups.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class CreateGroupsFrame extends JFrame implements DefaultFrame {

    private static CreateGroupsFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;
    private Pojo pojo = null;

    private CreateGroupsFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getMessages("CreateGroups"));
        this.addWindowListener(new MyWindowAdapter(this));

        BUILDER.createLabel(this, pojo.getMessages("CreateGroupsText"), 0, 0);
        final JTextField numberField = BUILDER.createTextField(this, "numberField", TEXT_FIELD_SIZE, 1, 0);
        final JButton createButton = BUILDER.createButton(this, "createButton", pojo.getMessages("Create"), 0, 1);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getMessages("Close"), 1, 1);

        final CreateGroupsFrameListener listener = new CreateGroupsFrameListener(this, pojo, numberField);

        createButton.addActionListener(listener);
        closeButton.addActionListener(listener);

    }

    public static CreateGroupsFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new CreateGroupsFrame(pojo);
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
