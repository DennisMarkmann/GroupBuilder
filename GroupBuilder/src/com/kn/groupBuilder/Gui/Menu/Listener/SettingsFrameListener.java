package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Menu.SettingsFrame;
import com.kn.groupBuilder.Gui.Popups.PathChooser;
import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Storage.Settings;

public class SettingsFrameListener implements ActionListener {

    private final SettingsFrame settingsFrame;
    private final Pojo pojo;
    private final JTextField pathField;
    private final JCheckBox archivingCheckBox;
    private final JTextField archiveField;
    private final JCheckBox sendMailsAutomaticallyCheckBox;
    private final JCheckBox printOutAutomaticallyCheckBox;

    public SettingsFrameListener(
            final SettingsFrame settingsFrame,
            final Pojo pojo,
            final JTextField pathField,
            final JCheckBox archivingCheckBox,
            final JTextField archiveField,
            final JCheckBox sendMailsAutomaticallyCheckBox,
            final JCheckBox printOutAutomaticallyCheckBox) {

        this.settingsFrame = settingsFrame;
        this.pojo = pojo;
        this.pathField = pathField;
        this.archivingCheckBox = archivingCheckBox;
        this.archiveField = archiveField;
        this.sendMailsAutomaticallyCheckBox = sendMailsAutomaticallyCheckBox;
        this.printOutAutomaticallyCheckBox = printOutAutomaticallyCheckBox;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("pathButton") == 0) {
            new PathChooser().changePath(this.pojo);
            this.settingsFrame.refreshTextFields(this.pathField, this.pojo);

        } else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            final Settings settings = this.pojo.getSettings();

            if (this.archivingCheckBox.isSelected()) {
                settings.setArchive(true);
            } else {
                settings.setArchive(false);
            }

            if (this.sendMailsAutomaticallyCheckBox.isSelected()) {
                settings.setSendMailAutomatically(true);
            } else {
                settings.setSendMailAutomatically(false);
            }

            if (this.printOutAutomaticallyCheckBox.isSelected()) {
                settings.setPrintAutomatically(true);
            } else {
                settings.setPrintAutomatically(false);
            }

            if (this.archiveField.getText() != null && !this.archiveField.getText().equals("")) {
                settings.setArchivingDays(Integer.parseInt(this.archiveField.getText()));
            } else {
                settings.setArchivingDays(0);
            }

            this.settingsFrame.closeWindow();

        } else if (buttonClicked.getName().compareTo("closeButton") == 0) {
            this.settingsFrame.closeWindow();
        }
    }
}
