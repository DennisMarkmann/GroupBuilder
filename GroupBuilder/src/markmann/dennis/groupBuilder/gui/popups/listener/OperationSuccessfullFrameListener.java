package markmann.dennis.groupBuilder.gui.popups.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import markmann.dennis.groupBuilder.gui.popups.OperationSuccessfullFrame;

/**
 * Listener for the helpFrame. Used to close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class OperationSuccessfullFrameListener implements ActionListener {

    private final OperationSuccessfullFrame operationSuccesfullFrame;

    public OperationSuccessfullFrameListener(final OperationSuccessfullFrame operationSuccesfullFrame) {
        this.operationSuccesfullFrame = operationSuccesfullFrame;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {
            this.operationSuccesfullFrame.closeWindow();
        }
    }
}
