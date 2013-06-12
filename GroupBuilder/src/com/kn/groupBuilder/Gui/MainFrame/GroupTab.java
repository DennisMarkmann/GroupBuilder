package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kn.groupBuilder.Gui.MainFrame.Listener.GroupTabListener;
import com.kn.groupBuilder.HelperClasses.GuiTabBuilder;
import com.kn.groupBuilder.Storage.Group;

class GroupTab extends JPanel {

    private static final long serialVersionUID = 1673516265342795696L;
    GuiTabBuilder builder = new GuiTabBuilder();

    GroupTab(final ArrayList<Group> groupList) {

        this.setLayout(new GridBagLayout());

        this.builder.createGroupTable(groupList, this, 0, 0);
        final JButton addButton = this.builder.createButton(this, "addButton", "Add group", 0, 5);

        addButton.addActionListener(new GroupTabListener(groupList));

    }
}
