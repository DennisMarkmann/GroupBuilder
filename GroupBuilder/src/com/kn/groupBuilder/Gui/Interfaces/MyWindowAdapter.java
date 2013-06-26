package com.kn.groupBuilder.Gui.Interfaces;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {

    private final DefaultFrame frame;

    public MyWindowAdapter(final DefaultFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowClosing(final WindowEvent e) {
        this.frame.closeWindow();
    }
}
