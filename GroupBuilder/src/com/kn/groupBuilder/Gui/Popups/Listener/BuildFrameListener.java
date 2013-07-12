package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.kn.groupBuilder.Gui.Popups.BuildFrame;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Jobs.GroupBuilder;
import com.kn.groupBuilder.Storage.Pojo;

/**
 * Listener for the build frame. Allows to build all groups, build unassigned groups and close it.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class BuildFrameListener implements ActionListener {

    private final BuildFrame buildFrame;
    private final Pojo pojo;
    private final JCheckBox buildCompleteCheckBox;
    private final JCheckBox buildUnassignedCheckBox;

    public BuildFrameListener(
            final BuildFrame buildFrame,
            final Pojo pojo,
            final JCheckBox buildCompleteCheckBox,
            final JCheckBox buildUnassignedCheckBox) {

        this.buildFrame = buildFrame;
        this.pojo = pojo;
        this.buildCompleteCheckBox = buildCompleteCheckBox;
        this.buildUnassignedCheckBox = buildUnassignedCheckBox;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {
        final GroupBuilder groupBuilder = new GroupBuilder();
        if (this.buildCompleteCheckBox.isSelected()) {
            groupBuilder.removeGroups(this.pojo);
            groupBuilder.buildGroups(this.pojo);
        } else if (this.buildUnassignedCheckBox.isSelected()) {
            groupBuilder.buildUnassignedGroups(this.pojo);
        }
        MemberTableModel.refreshTable();
        this.buildFrame.closeWindow();
    }
}
