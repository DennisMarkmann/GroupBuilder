package com.kn.groupBuilder.Gui.MainFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.kn.groupBuilder.Gui.MainFrame.Listener.MainFrameListener;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Main GUI Frame. Used to access all other GUI components.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class MainFrame extends JFrame implements DefaultFrame {

    private static final long serialVersionUID = -5660805007314188894L;
    private final JTabbedPane tabBar = new JTabbedPane();
    private final JMenu menu = new JMenu("Extras");
    private static MainFrame instance = null;
    private Pojo pojo = null;

    public final void createGui(final Pojo pojo) {

        this.pojo = pojo;
        // basic attributes
        this.setTitle("GroupBuilder - Dennis Markmann");
        this.setSize(800, 680);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new MyWindowAdapter(this));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // adds menuItems
        this.addMenuItem(pojo.getMessages("Settings"));
        this.addMenuItem(pojo.getMessages("E-Mail"));
        this.addMenuItem(pojo.getMessages("Print"));
        // this.addMenuItem(pojo.getMessages("Help"));
        this.addMenuItem(pojo.getMessages("About"));

        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(this.menu);
        this.setJMenuBar(menuBar);

        this.addPane(pojo.getMessages("Member"), new MemberTab(pojo));
        this.addPane(pojo.getMessages("Groups"), new GroupTab(pojo));

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
        final JMenuItem menuItem = new JMenuItem();
        menuItem.setName(menuName);
        menuItem.setText(menuName);
        this.menu.add(menuItem);
    }

    @Override
    public final void openClosingDialog(final String text) {
        ConfirmationFrame.getInstance(this.pojo, text, this);
    }

    @Override
    public final void closeWindow() {
        System.exit(1);
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        } else {
            instance.toFront();
        }
        return instance;
    }

    public void reload(final MainFrame instance) {
        instance.dispose();
    }
}
