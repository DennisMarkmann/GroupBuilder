package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Menu.Listener.EmailFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public class EmailFrame extends JFrame implements DefaultFrame {

    private static EmailFrame instance = null;
    private static final long serialVersionUID = 4767991083504569016L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();
    private static final int TEXT_FIELD_SIZE = 5;

    private EmailFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "Email");

        final JTextField addressField = this.builder.createTextField(this, "addressField", TEXT_FIELD_SIZE, 0, 0);
        final JButton sendButton = this.builder.createButton(this, "sendButton", "Send", 1, 0);

        final JButton sendAllButton = this.builder.createButton(this, "sendAllButton", "SendToAll", 0, 1);
        final JButton closeButton = this.builder.createButton(this, "closeButton", "Close", 1, 1);

        final EmailFrameListener listener = new EmailFrameListener(this, pojo, addressField);

        sendButton.addActionListener(listener);
        sendAllButton.addActionListener(listener);
        closeButton.addActionListener(listener);
    }

    public static EmailFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new EmailFrame(pojo);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
