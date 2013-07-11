package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Menu.Listener.HelpFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrameClasses.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrameClasses.MyWindowAdapter;

public final class HelpFrame extends JFrame implements DefaultFrame {

    private static HelpFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;

    private HelpFrame(final Pojo pojo) {
        BUILDER.setDefaultFrameSettings(this, "Help");
        this.addWindowListener(new MyWindowAdapter(this));
        BUILDER.createLabel(this, "The documentation is still in progress.", 0, 1);
        BUILDER.createLabel(this, "It will be added in a later release.", 0, 2);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", "close", 1, 3);

        final HelpFrameListener listener = new HelpFrameListener(this);

        closeButton.addActionListener(listener);

    }

    public static HelpFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new HelpFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
