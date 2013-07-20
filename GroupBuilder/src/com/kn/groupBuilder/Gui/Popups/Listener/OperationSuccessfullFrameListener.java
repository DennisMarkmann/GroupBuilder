package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.OperationSuccesfullFrame;

/**
 * Listener for the helpFrame. Used to close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class OperationSuccessfullFrameListener implements ActionListener {

    private final OperationSuccesfullFrame operationSuccesfullFrame;

    public OperationSuccessfullFrameListener(final OperationSuccesfullFrame operationSuccesfullFrame) {
        this.operationSuccesfullFrame = operationSuccesfullFrame;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("closeButton") == 0) {
            this.operationSuccesfullFrame.closeWindow();
        }
    }
}
