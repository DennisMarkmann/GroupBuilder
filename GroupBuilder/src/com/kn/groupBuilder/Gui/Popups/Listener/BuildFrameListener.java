package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import com.kn.groupBuilder.Gui.Popups.BuildFrame;
import com.kn.groupBuilder.Storage.Pojo;

public class BuildFrameListener implements ActionListener {

    private final BuildFrame buildFrame;
    final Pojo pojo;
    final JCheckBox buildCompleteCheckBox;
    final JCheckBox buildSelectedCheckBox;
    final JCheckBox buildUnassignedCheckBox;
    final JCheckBox buildSingleCheckBox;

    public BuildFrameListener(
            final BuildFrame buildFrame,
            final Pojo pojo,
            final JCheckBox buildCompleteCheckBox,
            final JCheckBox buildSelectedCheckBox,
            final JCheckBox buildUnassignedCheckBox,
            final JCheckBox buildSingleCheckBox) {

        this.buildFrame = buildFrame;
        this.pojo = pojo;
        this.buildCompleteCheckBox = buildCompleteCheckBox;
        this.buildSelectedCheckBox = buildSelectedCheckBox;
        this.buildUnassignedCheckBox = buildUnassignedCheckBox;
        this.buildSingleCheckBox = buildSingleCheckBox;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        this.buildFrame.dispose();
    }
}
