package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.GroupTabListener;
import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Storage.Group;

class GroupTab extends JPanel {

    private static final long serialVersionUID = 1673516265342795696L;

    GroupTab(final ArrayList<Group> groupList) {

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JButton addButton = new JButton("Add group");
        final JTable groupTable = new JTable(new GroupTableModel(groupList));

        c.gridx = 0;
        c.gridy = 0;
        this.add(groupTable, c);

        c.gridx = 0;
        c.gridy = 5;
        this.add(addButton, c);

        addButton.addActionListener(new GroupTabListener());

    }
}
