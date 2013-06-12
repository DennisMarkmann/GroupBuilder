package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Popups.Listener.BestaetigenFrameListener;
import com.kn.groupBuilder.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Storage.Pojo;

public class BestaetigenFrame extends JFrame {

    private static final long serialVersionUID = -6013891923961668832L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    public BestaetigenFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this);

        this.builder.createLabel(this, "Wollen Sie wirklich ...?", 0, 1);
        final JButton bestaetigenButton = this.builder.createButton(this, "bestaetigenButton", "Bestätigen", 0, 4);
        final JButton abbrechenButton = this.builder.createButton(this, "abbrechenButton", "Abbrechen", 3, 4);

        final BestaetigenFrameListener listener = new BestaetigenFrameListener(this, pojo);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);
    }
}
