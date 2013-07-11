package com.kn.groupBuilder.Gui.MainFrame.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
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
            CreateGroupFrame.getInstance(this.pojo);

        } else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            ConfirmationFrame.getInstance(this.pojo, "save", null);
        }
    }
}
