package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Menu.Listener.HelpFrameListener;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to show some useful introductions about the software.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class HelpFrame extends JFrame implements DefaultFrame {

    private static HelpFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;
    private Pojo pojo = null;

    private HelpFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("Help"));
        this.addWindowListener(new MyWindowAdapter(this));
        BUILDER.createLabel(this, pojo.getTranslation("HelpFrameLineOne"), 0, 1);
        BUILDER.createLabel(this, pojo.getTranslation("HelpFrameLineTwo"), 0, 2);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getTranslation("Close"), 1, 3);

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
    public void openClosingDialog(final String text) {
        ConfirmationFrame.getInstance(this.pojo, text, this);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
