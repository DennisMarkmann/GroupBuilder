package com.kn.groupBuilder.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.kn.groupBuilder.Storage.Format;
import com.kn.groupBuilder.Storage.Language;

public class SettingsFrame extends JFrame {

    private static final long serialVersionUID = 3141095634381522203L;

    public SettingsFrame() {
        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel pathLabel = new JLabel("Path: ");
        final JTextField pathField = new JTextField(10);
        final JButton pathButton = new JButton("Select path");

        final JLabel languageLabel = new JLabel();
        final JComboBox<Language> languageBox = new JComboBox<Language>();

        final JCheckBox archiveBox = new JCheckBox("Archiving: ");
        final JLabel archiveLabel = new JLabel("Archive duration: ");
        final JTextField archiveField = new JTextField(3);

        final JLabel formatLabel = new JLabel();
        final JComboBox<Format> formatBox = new JComboBox<Format>();

        final JCheckBox emailBox = new JCheckBox("Send e-Mails automatically: ");
        final JCheckBox printBox = new JCheckBox("Print automatically: ");

        final JButton close = new JButton();

        c.gridx = 0;
        c.gridy = 0;
        this.add(pathField, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(pathButton, c);

        this.setSize(300, 300);
        this.setVisible(true);
    }
}
