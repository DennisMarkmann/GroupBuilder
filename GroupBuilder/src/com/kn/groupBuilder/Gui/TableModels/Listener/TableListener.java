package com.kn.groupBuilder.Gui.TableModels.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the build frame. Allows to build all groups, build unassigned groups and close it.
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

        ConfirmationFrame.getInstance(this.pojo, this.action, this.rowID);
    }
}
