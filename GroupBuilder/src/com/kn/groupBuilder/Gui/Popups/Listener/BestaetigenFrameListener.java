package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.BestaetigenFrame;
import com.kn.groupBuilder.Storage.Pojo;

public class BestaetigenFrameListener implements ActionListener {

    private final BestaetigenFrame bestaetigenFrame;
    private final Pojo pojo;

    public BestaetigenFrameListener(final BestaetigenFrame bestaetigenFrame, final Pojo pojo) {
        this.bestaetigenFrame = bestaetigenFrame;
        this.pojo = pojo;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Bestätigen") == 0) {
            this.pojo.setBestaetigt(true);
        } else if (buttonClicked.getText().compareTo("Abbrechen") == 0) {
            this.pojo.setBestaetigt(false);
        }
        this.bestaetigenFrame.dispose();

    }
}
