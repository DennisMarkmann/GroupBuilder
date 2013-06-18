package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Menu.SettingsFrame;
import com.kn.groupBuilder.Gui.Popups.PathChooser;
import com.kn.groupBuilder.Storage.Pojo;

public class SettingsFrameListener implements ActionListener {

    private final SettingsFrame settingsFrame;
    private final Pojo pojo;
    private final JTextField pathField;

    public SettingsFrameListener(final SettingsFrame settingsFrame, final Pojo pojo, final JTextField pathField) {

        this.settingsFrame = settingsFrame;
        this.pojo = pojo;
        this.pathField = pathField;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("pathButton") == 0) {
            new PathChooser().changePath(this.pojo);
            this.settingsFrame.refreshTextFields(this.pathField, this.pojo);
        }
    }
}
