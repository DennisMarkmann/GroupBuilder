package com.kn.groupBuilder.Gui.MainFrame.Listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.kn.groupBuilder.Gui.Menu.AboutFrame;
import com.kn.groupBuilder.Gui.Menu.EmailFrame;
import com.kn.groupBuilder.Gui.Menu.HelpFrame;
import com.kn.groupBuilder.Gui.Menu.PrintFrame;
import com.kn.groupBuilder.Gui.Menu.SettingsFrame;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the mainFrame. Allows to start operations via menubar.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
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

		if (menuItem.getName().equals("Settings")) {
			SettingsFrame.getInstance(this.pojo);
		} else if (menuItem.getName().equals("E-Mail")) {
			EmailFrame.getInstance(this.pojo);
		} else if (menuItem.getName().equals("Print")) {
			PrintFrame.getInstance(this.pojo);
		} else if (menuItem.getName().equals("Help")) {
			HelpFrame.getInstance(this.pojo);
		} else if (menuItem.getName().equals("About")) {
			AboutFrame.getInstance(this.pojo);
		}
	}

}
