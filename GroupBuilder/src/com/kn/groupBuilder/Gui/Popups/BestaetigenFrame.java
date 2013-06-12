package com.kn.groupBuilder.Gui.Popups;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.BestaetigenFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public class BestaetigenFrame extends JFrame {

    private static final long serialVersionUID = -6013891923961668832L;

    public BestaetigenFrame(final Pojo pojo) {
        // basic attributes
        this.setTitle("GroupBuilder");
        this.setSize(new Dimension(280, 100));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        final GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 3;
        this.setLayout(new GridBagLayout());

        final JButton bestaetigenButton = new JButton("Bestätigen");
        bestaetigenButton.setName("bestaetigenButton");
        final JButton abbrechenButton = new JButton("Abbrechen");
        abbrechenButton.setName("abbrechenButton");
        final JLabel frageLabel = new JLabel("Wollen Sie wirklich ...?");

        final JTextField kundenNummerField = new JTextField();

        c.gridx = 0;
        c.gridy = 1;
        this.add(frageLabel, c);

        c.gridx = 3;
        c.gridy = 1;
        this.add(kundenNummerField, c);

        c.gridx = 0;
        c.gridy = 4;
        this.add(bestaetigenButton, c);

        c.gridx = 3;
        c.gridy = 4;
        this.add(abbrechenButton, c);

        this.setVisible(true);

        final BestaetigenFrameListener listener = new BestaetigenFrameListener(this, pojo);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);
    }
}
