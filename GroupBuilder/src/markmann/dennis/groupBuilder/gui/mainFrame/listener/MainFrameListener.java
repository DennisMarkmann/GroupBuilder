package markmann.dennis.groupBuilder.gui.mainFrame.listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import markmann.dennis.groupBuilder.gui.menu.AboutFrame;
import markmann.dennis.groupBuilder.gui.menu.EmailFrame;
import markmann.dennis.groupBuilder.gui.menu.HelpFrame;
import markmann.dennis.groupBuilder.gui.menu.PrintFrame;
import markmann.dennis.groupBuilder.gui.menu.SettingsFrame;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the mainFrame. Allows to start operations via menubar.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class MainFrameListener extends MouseAdapter {

    private final Pojo pojo;

    public MainFrameListener(final JMenu menu, final Pojo pojo) {
        this.pojo = pojo;
        for (final Component component : menu.getMenuComponents()) {
            component.addMouseListener(this);
        }
    }

    @Override
    public final void mouseReleased(final MouseEvent event) {
        final JMenuItem menuItem = (JMenuItem) event.getSource();

        if (menuItem.getName().equals(this.pojo.getTranslation("Settings"))) {
            SettingsFrame.getInstance(this.pojo);
        } else if (menuItem.getName().equals(this.pojo.getTranslation("E-Mail"))) {
            EmailFrame.getInstance(this.pojo);
        } else if (menuItem.getName().equals(this.pojo.getTranslation("Print"))) {
            PrintFrame.getInstance(this.pojo);
        } else if (menuItem.getName().equals(this.pojo.getTranslation("Help"))) {
            HelpFrame.getInstance(this.pojo);
        } else if (menuItem.getName().equals(this.pojo.getTranslation("About"))) {
            AboutFrame.getInstance(this.pojo);
        }
    }
}
