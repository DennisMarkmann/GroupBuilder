package markmann.dennis.groupBuilder.gui.mainFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.mainFrame.listener.MainFrameListener;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Main GUI Frame. Used to access all other GUI components.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class MainFrame extends JFrame implements DefaultFrame {

    private static final long serialVersionUID = -5660805007314188894L;
    private static MainFrame instance = null;

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        } else {
            instance.toFront();
        }
        return instance;
    }

    private final JTabbedPane tabBar = new JTabbedPane();
    private final JMenu menu = new JMenu("Extras");

    private Pojo pojo = null;

    private void addMenuItem(final String menuName) {
        final JMenuItem menuItem = new JMenuItem();
        menuItem.setName(menuName);
        menuItem.setText(menuName);
        this.menu.add(menuItem);
    }

    // method to add new panes
    private void addPane(final String title, final JPanel panel) {
        this.tabBar.add(title, panel);

        final JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel(title));

    }

    @Override
    public final void closeWindow() {
        System.exit(1);
    }

    public final void createGui(final Pojo pojo) {

        this.pojo = pojo;
        // basic attributes
        this.setTitle("GroupBuilder - Dennis Markmann");
        this.setSize(800, 680);
        this.setLocationRelativeTo(null);
        this.addWindowListener(new MyWindowAdapter(this));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // adds menuItems
        this.addMenuItem(pojo.getTranslation("Settings"));
        this.addMenuItem(pojo.getTranslation("E-Mail"));
        this.addMenuItem(pojo.getTranslation("Print"));
        // this.addMenuItem(pojo.getMessages("Help"));
        this.addMenuItem(pojo.getTranslation("About"));

        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(this.menu);
        this.setJMenuBar(menuBar);

        this.addPane(pojo.getTranslation("Member"), new MemberTab(pojo));
        this.addPane(pojo.getTranslation("Groups"), new GroupTab(pojo));

        this.add(this.tabBar);
        this.setVisible(true);
        new MainFrameListener(this.menu, pojo);

    }

    // @Override
    // public final void openClosingDialog(final String text) {
    // ConfirmationFrame.getInstance(this.pojo, text, this);
    // }

    @Override
    public void openClosingDialog(WindowCloseDialogOptions request) {
        // TODO implement + remove old one
    }

    public final void reload() {
        instance.dispose();
        instance = new MainFrame();
        instance.createGui(this.pojo);
    }
}
