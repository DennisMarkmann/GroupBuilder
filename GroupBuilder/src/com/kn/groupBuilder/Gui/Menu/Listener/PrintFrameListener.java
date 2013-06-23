package com.kn.groupBuilder.Gui.Menu.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import com.kn.groupBuilder.Gui.Menu.PrintFrame;
import com.kn.groupBuilder.Gui.Popups.BestaetigenFrame;
import com.kn.groupBuilder.Storage.Pojo;

public class PrintFrameListener implements ActionListener {

    final PrintFrame printFrame;
    final Pojo pojo;
    final JComboBox<String> groupBox;

    public PrintFrameListener(final PrintFrame printFrame, final Pojo pojo, final JComboBox<String> groupBox) {
        this.printFrame = printFrame;
        this.pojo = pojo;
        this.groupBox = groupBox;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("printOutButton") == 0) {
            new BestaetigenFrame(this.pojo, "printOut", this.groupBox.getSelectedItem());
        } else if (buttonClicked.getName().compareTo("printOutAllButton") == 0) {
            new BestaetigenFrame(this.pojo, "printOutAll", null);
        } else if (buttonClicked.getName().compareTo("closeButton") == 0) {
        }
        this.printFrame.dispose();

    }

}
