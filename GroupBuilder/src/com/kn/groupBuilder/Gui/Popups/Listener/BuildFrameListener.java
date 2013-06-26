package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.kn.groupBuilder.Gui.Popups.BuildFrame;
import com.kn.groupBuilder.Jobs.GroupBuilder;
import com.kn.groupBuilder.Storage.Pojo;

public class BuildFrameListener implements ActionListener {

    private final BuildFrame buildFrame;
    final Pojo pojo;
    final JCheckBox buildCompleteCheckBox;
    final JCheckBox buildUnassignedCheckBox;

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
        this.buildFrame.dispose();
    }
}
