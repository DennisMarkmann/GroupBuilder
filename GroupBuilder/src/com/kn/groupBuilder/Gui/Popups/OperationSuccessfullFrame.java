package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Popups.Listener.OperationSuccessfullFrameListener;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to show some useful introductions about the software.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class OperationSuccessfullFrame extends JFrame implements DefaultFrame {

    private static OperationSuccessfullFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;

    private OperationSuccessfullFrame(final String text) {
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - Help");
        this.addWindowListener(new MyWindowAdapter(this));
        BUILDER.createLabel(this, text, 0, 1);
        final JButton confirmationButton = BUILDER.createButton(this, "confirmationButton", "Okay", 1, 3);

        final OperationSuccessfullFrameListener listener = new OperationSuccessfullFrameListener(this);

        confirmationButton.addActionListener(listener);

    }

    public static OperationSuccessfullFrame getInstance(final String text) {
        if (instance == null) {
            instance = new OperationSuccessfullFrame(text);
        } else {
            instance.toFront();
        }
        return instance;
    }

    @Override
    public void openClosingDialog(final String text) {
        ConfirmationFrame.getInstance(null, text, this);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
