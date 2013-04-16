package com.kn.groupBuilder.GUI;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.kn.groupBuilder.Storage.Pojo;

public class GroupMixingPanel {

	public GroupMixingPanel(JTabbedPane tabBar, Pojo pojo) {

		JPanel groupsMixingPanel = new JPanel();
		groupsMixingPanel.add(new JButton("Button des groupMixingPanels"));
		tabBar.addTab("GroupMixingPanel", groupsMixingPanel);

	}
}
