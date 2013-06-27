package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Popups.Listener.ConfirmationFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public final class ConfirmationFrame extends JFrame implements DefaultFrame {

    private static ConfirmationFrame instance = null;
    private static final long serialVersionUID = -6013891923961668832L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    private ConfirmationFrame(final Pojo pojo, final String action, final Object object) {

        this.builder.setDefaultFrameSettings(this, "Confirm");
        this.addWindowListener(new MyWindowAdapter(this));

        this.builder.createLabel(this, "Do you really want to ...?", 0, 1);
        final JButton confirmationButton = this.builder.createButton(this, "confirmationButton", "Confirm", 0, 4);
        final JButton abortButton = this.builder.createButton(this, "abortButton", "Abort", 3, 4);

        final ConfirmationFrameListener listener = new ConfirmationFrameListener(this, pojo, action, object);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }

    public static ConfirmationFrame getInstance(final Pojo pojo, final String action, final Object object) {
        if (instance == null) {
            instance = new ConfirmationFrame(pojo, action, object);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
