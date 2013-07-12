package com.kn.groupBuilder.Gui.MainFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.kn.groupBuilder.Gui.MainFrame.Listener.MainFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Main GUI Frame. Used to access all other GUI components.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class MainFrame extends JFrame {

    private static final long serialVersionUID = -5660805007314188894L;
    private final JTabbedPane tabBar = new JTabbedPane();
    private final JMenu menu = new JMenu("Extras");

    public final void createGui(final Pojo pojo) {

        // basic attributes
        this.setTitle("GroupBuilder - Dennis Markmann");
        this.setSize(800, 680);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adds menuItems
        this.addMenuItem("Settings");
        this.addMenuItem("E-Mail");
        this.addMenuItem("Print");
        this.addMenuItem("Help");
        this.addMenuItem("About");

        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(this.menu);
        this.setJMenuBar(menuBar);

        this.addPane("Member", new MemberTab(pojo));
        this.addPane("Groups", new GroupTab(pojo));

        this.add(this.tabBar);
        this.setVisible(true);
        new MainFrameListener(this.menu, pojo);

    }

    // method to add new panes
    private void addPane(final String title, final JPanel panel) {
        this.tabBar.add(title, panel);

        final JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel(title));

    }

    private void addMenuItem(final String menuName) {
        this.menu.add(new JMenuItem(menuName));
    }
}
