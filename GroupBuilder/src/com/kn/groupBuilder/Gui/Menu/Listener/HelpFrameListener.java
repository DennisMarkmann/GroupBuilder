package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Menu.HelpFrame;

/**
 * Listener for the helpFrame. Used to close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class HelpFrameListener implements ActionListener {

    private final HelpFrame helpFrame;

    public HelpFrameListener(final HelpFrame helpFrame) {
        this.helpFrame = helpFrame;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("closeButton") == 0) {
            this.helpFrame.closeWindow();
        }
    }
}
