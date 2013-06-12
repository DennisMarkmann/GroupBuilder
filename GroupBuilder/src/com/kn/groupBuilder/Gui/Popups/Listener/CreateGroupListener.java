package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.kn.groupBuilder.Gui.Popups.CreateGroupFrame;
import com.kn.groupBuilder.Storage.Group;

public class CreateGroupListener implements ActionListener {

    private final CreateGroupFrame createGroupFrame;
    private final ArrayList<Group> groupList;

    public CreateGroupListener(final CreateGroupFrame createGroupFrame, final ArrayList<Group> groupList) {

        this.createGroupFrame = createGroupFrame;
        this.groupList = groupList;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
