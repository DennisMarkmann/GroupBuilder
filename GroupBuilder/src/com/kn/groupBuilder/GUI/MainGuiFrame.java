package com.kn.groupBuilder.GUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.kn.groupBuilder.Storage.Pojo;

public class MainGuiFrame {

	public void createGui(Pojo pojo) {

		JFrame mainFrame = new JFrame("GroupBuilder");
		mainFrame.setSize(800, 800);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabBar = new JTabbedPane();

		new GroupPanel(tabBar, pojo.getGroupList());
		new MemberPanel(tabBar, pojo.getMemberList());
		new GroupMixingPanel(tabBar, pojo);

		mainFrame.add(tabBar);
		mainFrame.setVisible(true);

	}
}