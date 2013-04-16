package com.kn.groupBuilder.GUI;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.kn.groupBuilder.Storage.Group;

public class GroupPanel {

	public GroupPanel(JTabbedPane tabBar, ArrayList<Group> groupList) {

		JPanel groupPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();

		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.PAGE_AXIS));
		groupPanel.add(leftPanel);

		JTextArea textArea = new JTextArea(50, 25);
		this.fillTextArea(textArea, groupList);
		groupPanel.add(textArea);
		groupPanel.add(new JButton("Button des groupPanels"));
		tabBar.addTab("Groups", groupPanel);

	}

	public void fillTextArea(JTextArea textArea, ArrayList<Group> groupList) {

		for (Group group : groupList) {
			textArea.append(group.getName()
					+ System.getProperty("line.separator"));
		}

	}
}
