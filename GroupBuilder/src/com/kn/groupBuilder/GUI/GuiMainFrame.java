package com.kn.groupBuilder.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.kn.groupBuilder.Storage.Pojo;

public class GuiMainFrame {

    final private JTabbedPane tabBar = new JTabbedPane();

    public final void createGui(final Pojo pojo) {

        final JFrame mainFrame = new JFrame("GroupBuilder");
        mainFrame.setSize(800, 800);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addPane("Groups", new GroupTab(pojo.getGroupList()));
        this.addPane("Member", new MemberTab(pojo.getMemberList()));

        // new GroupTab(this.tabBar, pojo.getGroupList());
        // new GroupMixingTab(this.tabBar, pojo);

        mainFrame.add(this.tabBar);
        mainFrame.setVisible(true);

    }

    // Methode zum Hinzufuegen von neuen Panes (Inklusive Closebutton etc.)
    private void addPane(final String title, final JPanel panel) {
        this.tabBar.add(title, panel);

        final JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.add(new JLabel(title));

    }
}
