package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Popups.Listener.OperationSuccessfullFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to show some useful introductions about the software.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class OperationSuccesfullFrame extends JFrame implements DefaultFrame {

    private static OperationSuccesfullFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;

    private OperationSuccesfullFrame(final Pojo pojo) {
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - Help");
        this.addWindowListener(new MyWindowAdapter(this));
        BUILDER.createLabel(this, "The documentation is still in progress.", 0, 1);
        BUILDER.createLabel(this, "It will be added in a later release.", 0, 2);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", "close", 1, 3);

        final OperationSuccessfullFrameListener listener = new OperationSuccessfullFrameListener(this);

        closeButton.addActionListener(listener);

    }

    public static OperationSuccesfullFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new OperationSuccesfullFrame(pojo);
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