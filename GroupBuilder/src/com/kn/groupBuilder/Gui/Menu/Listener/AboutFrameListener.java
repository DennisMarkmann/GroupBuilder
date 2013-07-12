package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Menu.AboutFrame;

/**
 * Listener for the aboutFrame. Allows to close it.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class AboutFrameListener implements ActionListener {

    private final AboutFrame aboutFrame;

    public AboutFrameListener(final AboutFrame aboutFrame) {
        this.aboutFrame = aboutFrame;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("closeButton") == 0) {
            this.aboutFrame.closeWindow();
        }
    }
}
