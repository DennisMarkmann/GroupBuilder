package com.kn.groupBuilder.Gui.MainFrame.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.BestaetigenFrame;
import com.kn.groupBuilder.Gui.Popups.BuildFrame;
import com.kn.groupBuilder.Gui.Popups.CreateGroupFrame;
import com.kn.groupBuilder.Storage.Pojo;

public class GroupTabListener implements ActionListener {

    private final Pojo pojo;

    public GroupTabListener(final Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("addButton") == 0) {
            new CreateGroupFrame(this.pojo);

        } else if (buttonClicked.getName().compareTo("buildButton") == 0) {
            new BuildFrame(this.pojo);

        } else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            new BestaetigenFrame(this.pojo, "save", null);
        }
    }
}
