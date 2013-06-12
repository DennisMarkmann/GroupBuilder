package com.kn.groupBuilder.Gui.Menu;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Storage.Pojo;

public class SettingsFrame extends JFrame {

    private static final long serialVersionUID = 3141095634381522203L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();
    private static final int TEXT_FIELD_SIZE = 5;

    public SettingsFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this);
        this.setTitle("GroupBuilder");
        this.setSize(600, 600);
        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel pathLabel = new JLabel("Path:");
        final JTextField pathField = new JTextField(10);
        final JButton pathButton = new JButton("Select path");

        final JLabel languageLabel = new JLabel("Language");
        final JComboBox<String> languageBox = new JComboBox<String>(pojo.getLanguageList());

        final JLabel archiveLabel = new JLabel("Archiving:");
        final JCheckBox archiveBox = new JCheckBox();
        final JLabel archiveDurationLabel = new JLabel("Duration [in days]: ");
        final JTextField archiveField = new JTextField(3);

        final JLabel formatLabel = new JLabel("Output format:");
        final JComboBox<String> formatBox = new JComboBox<String>(pojo.getFormatList());

        final JCheckBox emailBox = new JCheckBox("Send e-Mails automatically: ");
        final JCheckBox printBox = new JCheckBox("Print automatically: ");

        final JButton saveButton = new JButton("Save");
        final JButton closeButton = new JButton("Close");

        // path
        final JPanel pathPanel = new JPanel();
        pathPanel.setLayout(new FlowLayout());
        pathPanel.add(pathLabel);
        pathPanel.add(pathField);
        pathPanel.add(pathButton);
        c.gridx = 0;
        c.gridy = 0;
        this.add(pathPanel);

        // language
        final JPanel languagePanel = new JPanel();
        languagePanel.setLayout(new FlowLayout());
        languagePanel.add(languageLabel);
        languagePanel.add(languageBox);
        c.gridx = 0;
        c.gridy = 1;
        this.add(languagePanel, c);

        // archiving
        final JPanel archivePanel = new JPanel();
        archivePanel.setLayout(new FlowLayout());
        archivePanel.add(archiveLabel);
        archivePanel.add(archiveBox);
        archivePanel.add(archiveDurationLabel);
        archivePanel.add(archiveField);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 2;
        this.add(archivePanel, c);

        // format
        final JPanel formatPanel = new JPanel();
        formatPanel.setLayout(new FlowLayout());
        formatPanel.add(formatLabel);
        formatPanel.add(formatBox);
        c.gridx = 0;
        c.gridy = 3;
        this.add(formatPanel, c);

        // automatic
        final JPanel automacPanel = new JPanel();
        automacPanel.setLayout(new FlowLayout());
        automacPanel.add(emailBox);
        automacPanel.add(printBox);
        c.gridx = 0;
        c.gridy = 4;
        this.add(automacPanel, c);

        // close
        final JPanel closePanel = new JPanel();
        closePanel.setLayout(new FlowLayout());
        closePanel.add(saveButton);
        closePanel.add(closeButton);
        c.gridx = 0;
        c.gridy = 5;
        this.add(closePanel, c);

        this.setVisible(true);
    }
}
