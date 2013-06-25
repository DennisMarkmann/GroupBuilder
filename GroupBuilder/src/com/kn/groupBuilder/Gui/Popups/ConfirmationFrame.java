package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Popups.Listener.ConfirmationFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public class ConfirmationFrame extends JFrame {

    private static final long serialVersionUID = -6013891923961668832L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    public ConfirmationFrame(final Pojo pojo, final String action, final Object object) {

        this.builder.setDefaultFrameSettings(this, "Confirm");

        this.builder.createLabel(this, "Do you really want to ...?", 0, 1);
        final JButton confirmationButton = this.builder.createButton(this, "confirmationButton", "Confirm", 0, 4);
        final JButton abortButton = this.builder.createButton(this, "abortButton", "Abort", 3, 4);

        final ConfirmationFrameListener listener = new ConfirmationFrameListener(this, pojo, action, object);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }
}
