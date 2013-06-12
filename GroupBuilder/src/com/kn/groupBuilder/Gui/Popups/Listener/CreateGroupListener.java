package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.CreateGroupFrame;
import com.kn.groupBuilder.Storage.Group;

public class CreateGroupListener implements ActionListener {

    private final CreateGroupFrame createGroupFrame;
    private final ArrayList<Group> groupList;
    private final JTextField groupNameField;
    private final JTextField groupDescField;
    private final JTextField groupSizeField;

    public CreateGroupListener(
            final CreateGroupFrame createGroupFrame,
            final ArrayList<Group> groupList,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        this.createGroupFrame = createGroupFrame;
        this.groupList = groupList;
        this.groupNameField = groupNameField;
        this.groupDescField = groupDescField;
        this.groupSizeField = groupSizeField;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
