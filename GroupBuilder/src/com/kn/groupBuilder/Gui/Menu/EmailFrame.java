package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Menu.Listener.EmailFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public final class EmailFrame extends JFrame implements DefaultFrame {

    private static EmailFrame instance = null;
    private static final long serialVersionUID = 4767991083504569016L;

    private EmailFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "Email");
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
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
