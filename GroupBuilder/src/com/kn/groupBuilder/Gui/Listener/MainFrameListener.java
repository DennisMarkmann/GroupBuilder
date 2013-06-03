package com.kn.groupBuilder.Gui.Listener;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.kn.groupBuilder.Gui.SettingsFrame;

public class MainFrameListener extends MouseAdapter {

    public MainFrameListener(final JMenu menu) {
        for (final Component component : menu.getMenuComponents()) {
            component.addMouseListener(this);
        }
    }

    @Override
    public final void mouseReleased(final MouseEvent event) {
        final JMenuItem menuItem = (JMenuItem) event.getSource();

        if (menuItem.getText().equals("Settings")) {
            new SettingsFrame();
            System.out.println("test");
        }
    }
}
