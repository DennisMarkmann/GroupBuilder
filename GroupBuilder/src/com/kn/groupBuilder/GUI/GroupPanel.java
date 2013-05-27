package com.kn.groupBuilder.GUI;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.kn.groupBuilder.Storage.Group;

public class GroupPanel {

    public GroupPanel(final JTabbedPane tabBar, final ArrayList<Group> groupList) {

        final JPanel groupPanel = new JPanel();
        final JPanel leftPanel = new JPanel();
        final JPanel rightPanel = new JPanel();

        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.PAGE_AXIS));
        groupPanel.add(leftPanel);

        final JTextArea textArea = new JTextArea(50, 25);
        this.fillTextArea(textArea, groupList);
        groupPanel.add(textArea);
        groupPanel.add(new JButton("Button des groupPanels"));
        tabBar.addTab("Groups", groupPanel);

    }

    public final void fillTextArea(final JTextArea textArea, final ArrayList<Group> groupList) {

        for (final Group group : groupList) {
            textArea.append(group.getName() + System.getProperty("line.separator"));
        }

    }
}
