package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Menu.Listener.EmailFrameListener;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to start emailMail sending.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class EmailFrame extends JFrame implements DefaultFrame {

    private static EmailFrame instance = null;
    private static final long serialVersionUID = 4767991083504569016L;

    private EmailFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - Email");
        this.addWindowListener(new MyWindowAdapter(this));

        final JTextField addressField = BUILDER.createTextField(this, "addressField", TEXT_FIELD_SIZE, 0, 0);
        final JButton sendButton = BUILDER.createButton(this, "sendButton", "Send", 1, 0);

        final JButton sendAllButton = BUILDER.createButton(this, "sendAllButton", "SendToAll", 0, 1);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", "Close", 1, 1);

        final EmailFrameListener listener = new EmailFrameListener(this, pojo, addressField);

        sendButton.addActionListener(listener);
        sendAllButton.addActionListener(listener);
        closeButton.addActionListener(listener);
    }

    public static EmailFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new EmailFrame(pojo);
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
