package com.kn.groupBuilder.Gui.TableModels.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Gui.Popups.EditGroupFrame;
import com.kn.groupBuilder.Gui.Popups.EditMemberFrame;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the tableModels. Allows to edit and remove groups or member.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class TableListener implements ActionListener {

    private final Pojo pojo;
    private final int rowID;
    private final String action;

    public TableListener(final Pojo pojo, final int rowID, final String action) {
        this.pojo = pojo;
        this.rowID = rowID;
        this.action = action;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("RemoveButton") == 0) {
            ConfirmationFrame.getInstance(this.pojo, this.action, this.rowID);

        } else if (buttonClicked.getName().compareTo("EditButton") == 0) {
            if (this.action.equals(this.pojo.getMessages("EditMember"))) {
                EditMemberFrame.getInstance(this.pojo, this.rowID);
            } else if (this.action.equals(this.pojo.getMessages("EditGroup"))) {
                EditGroupFrame.getInstance(this.pojo, this.rowID);
            }
        }
    }
}
