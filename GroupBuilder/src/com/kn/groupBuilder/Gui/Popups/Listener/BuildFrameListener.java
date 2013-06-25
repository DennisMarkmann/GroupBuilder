package com.kn.groupBuilder.Gui.Popups.Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kn.groupBuilder.Gui.Popups.BuildFrame;
import com.kn.groupBuilder.Storage.Pojo;

public class BuildFrameListener implements ActionListener {

    final BuildFrame buildFrame;
    final Pojo pojo;

    public BuildFrameListener(final BuildFrame buildFrame, final Pojo pojo) {
        this.buildFrame = buildFrame;
        this.pojo = pojo;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

    }
}
