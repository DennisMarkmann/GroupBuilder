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

public class MainFrame extends JFrame {

    private static final long serialVersionUID = -5660805007314188894L;
    private final JTabbedPane tabBar = new JTabbedPane();

    public final void createGui(final Pojo pojo) {

        // basic attributes
        this.setTitle("GroupBuilder");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adds menu
        final JMenu menu = new JMenu("Extras");
        menu.add(new JMenuItem("Settings"));
        menu.add(new JMenuItem("E-Mail"));
        menu.add(new JMenuItem("Print"));
        menu.add(new JMenuItem("Help"));
        menu.add(new JMenuItem("About"));

        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        this.addPane("Member", new MemberTab(pojo));
        this.addPane("Groups", new GroupTab(pojo));

        this.add(this.tabBar);
        this.setVisible(true);
        new MainFrameListener(menu, pojo);

    }

    // Methode zum Hinzufuegen von neuen Panes (Inklusive Closebutton etc.)
    private void addPane(final String title, final JPanel panel) {
        this.tabBar.add(title, panel);

        final JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.add(new JLabel(title));

    }
}
