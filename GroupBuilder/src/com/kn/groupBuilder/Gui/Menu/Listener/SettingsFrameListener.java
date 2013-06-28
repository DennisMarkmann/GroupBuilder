package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Menu.SettingsFrame;
import com.kn.groupBuilder.Gui.Popups.PathChooser;
import com.kn.groupBuilder.Storage.Pojo;
import com.kn.groupBuilder.Storage.Settings;

public class SettingsFrameListener implements ActionListener {

    private final SettingsFrame settingsFrame;
    private final Pojo pojo;
    private final JTextField pathField;
    private final JComboBox<String> languageBox;
    private final JCheckBox archivingBox;
    private final JTextField archiveField;
    private final JCheckBox sendMailsAutomatically;
    private final JCheckBox printOutAutomatically;
    private final JComboBox<String> outputFormatBox;

    public SettingsFrameListener(
            final SettingsFrame settingsFrame,
            final Pojo pojo,
            final JTextField pathField,
            final JComboBox<String> languageBox,
            final JCheckBox archivingBox,
            final JTextField archiveField,
            final JComboBox<String> outputFormatBox,
            final JCheckBox sendMailsAutomatically,
            final JCheckBox printOutAutomatically) {

        this.settingsFrame = settingsFrame;
        this.pojo = pojo;
        this.pathField = pathField;
        this.languageBox = this.languageBox;
        this.archivingBox = this.archivingBox;
        this.archiveField = archiveField;
        this.outputFormatBox = outputFormatBox;
        this.sendMailsAutomatically = sendMailsAutomatically;
        this.printOutAutomatically = printOutAutomatically;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("pathButton") == 0) {
            new PathChooser().changePath(this.pojo);
            this.settingsFrame.updatePathField(this.pathField, this.pojo);

        } else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            final Settings settings = this.pojo.getSettings();

            this.languageBox.getSelectedItem();
            settings.setArchived(this.readCheckBox(this.archivingBox));
            settings.setSendMailAutomatically(this.readCheckBox(this.sendMailsAutomatically));
            settings.setPrintAutomatically(this.readCheckBox(this.printOutAutomatically));

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

    private boolean readCheckBox(final JCheckBox checkBox) {

        if (checkBox.isSelected()) {
            return (true);
        }
        return (false);

    }
}
