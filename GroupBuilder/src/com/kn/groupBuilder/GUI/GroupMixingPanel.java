package com.kn.groupBuilder.GUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.kn.groupBuilder.Storage.Pojo;

public class GroupMixingPanel {

    public GroupMixingPanel(final JTabbedPane tabBar, final Pojo pojo) {

        final JPanel groupsMixingPanel = new JPanel();
        groupsMixingPanel.add(new JButton("Button des groupMixingPanels"));
        tabBar.addTab("GroupMixingPanel", groupsMixingPanel);

    }
}
