package com.kn.groupBuilder.Gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SettingsFrame extends JFrame {

    private static final long serialVersionUID = 3141095634381522203L;

    public SettingsFrame() {
        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JTextArea groupArea = new JTextArea(40, 40);
        final JButton addButton = new JButton("Add group");

        c.gridx = 0;
        c.gridy = 0;
        this.add(groupArea, c);

        c.gridx = 0;
        c.gridy = 5;
        this.add(addButton, c);

        this.setSize(300, 300);
        this.setVisible(true);
    }
}
