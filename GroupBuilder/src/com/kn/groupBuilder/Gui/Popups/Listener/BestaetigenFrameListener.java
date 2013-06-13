package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.BestaetigenFrame;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

public class BestaetigenFrameListener implements ActionListener {

    private final BestaetigenFrame bestaetigenFrame;
    private final Pojo pojo;
    private final String action;
    private final Object object;

    public BestaetigenFrameListener(
            final BestaetigenFrame bestaetigenFrame,
            final Pojo pojo,
            final String action,
            final Object object) {
        this.bestaetigenFrame = bestaetigenFrame;
        this.pojo = pojo;
        this.action = action;
        this.object = object;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getText().compareTo("Bestätigen") == 0) {
            if (this.action.equals("addGroup")) {
                this.pojo.getGroupList().add((Group) this.object);
            }

        } else if (buttonClicked.getText().compareTo("Abbrechen") == 0) {
        }
        this.bestaetigenFrame.dispose();

    }
}
