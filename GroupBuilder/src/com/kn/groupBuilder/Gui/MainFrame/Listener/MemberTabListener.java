package com.kn.groupBuilder.Gui.MainFrame.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.BuildFrame;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.CreateMemberFrame;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the memberTab. Used to add member, start groupBuild processes and save all changes.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class MemberTabListener implements ActionListener {

    private final Pojo pojo;

    public MemberTabListener(final Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("addButton") == 0) {
            CreateMemberFrame.getInstance(this.pojo);

        } else if (buttonClicked.getName().compareTo("buildButton") == 0) {
            BuildFrame.getInstance(this.pojo);

        } else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            ConfirmationFrame.getInstance(this.pojo, "save", null);
        }
    }
}
