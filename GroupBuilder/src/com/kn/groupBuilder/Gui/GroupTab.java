package com.kn.groupBuilder.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kn.groupBuilder.Gui.Listener.GroupTabListener;
import com.kn.groupBuilder.Storage.Group;

public class GroupTab extends JPanel {

    private static final long serialVersionUID = 1673516265342795696L;

    public GroupTab(final ArrayList<Group> groupList) {

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JTextArea groupArea = new JTextArea(40, 40);
        final JButton addButton = new JButton("Add group");

        c.gridx = 0;
        c.gridy = 0;
        this.add(groupArea, c);

        c.gridx = 0;
        c.gridy = 5;
        this.add(addButton, c);
        this.fillTextArea(groupArea, groupList);

        addButton.addActionListener(new GroupTabListener());

    }

    public final void fillTextArea(final JTextArea textArea, final ArrayList<Group> groupList) {

        for (final Group group : groupList) {
            textArea.append(group.getName() + System.getProperty("line.separator"));
        }

    }
}
