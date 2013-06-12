package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.BestaetigenFrame;
import com.kn.groupBuilder.Gui.Popups.CreateGroupFrame;
import com.kn.groupBuilder.Storage.Pojo;

public class CreateGroupListener implements ActionListener {

    private final CreateGroupFrame createGroupFrame;
    private final Pojo pojo;
    private final JTextField groupNameField;
    private final JTextField groupDescField;
    private final JTextField groupSizeField;

    public CreateGroupListener(
            final CreateGroupFrame createGroupFrame,
            final Pojo pojo,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        this.createGroupFrame = createGroupFrame;
        this.pojo = pojo;
        this.groupNameField = groupNameField;
        this.groupDescField = groupDescField;
        this.groupSizeField = groupSizeField;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        new BestaetigenFrame(this.pojo);
        this.createGroupFrame.dispose();

        if (this.pojo.isBestaetigt()) {

        }
    }

}
