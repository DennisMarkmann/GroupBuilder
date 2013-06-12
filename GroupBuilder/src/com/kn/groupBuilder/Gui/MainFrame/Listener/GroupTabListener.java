package com.kn.groupBuilder.Gui.MainFrame.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.CreateGroupFrame;
import com.kn.groupBuilder.Storage.Group;

public class GroupTabListener implements ActionListener {

    private final ArrayList<Group> groupList;

    public GroupTabListener(final ArrayList<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();
        if (buttonClicked.getName().compareTo("addButton") == 0) {
            new CreateGroupFrame(this.groupList);
        }
    }
}
