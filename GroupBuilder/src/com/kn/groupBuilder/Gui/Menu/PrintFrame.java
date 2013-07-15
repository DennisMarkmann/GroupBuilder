package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Menu.Listener.PrintFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to start print operation.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class PrintFrame extends JFrame implements DefaultFrame {

    private static PrintFrame instance = null;
    private static final long serialVersionUID = 4767991083504569016L;

    private PrintFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - Print");
        this.addWindowListener(new MyWindowAdapter(this));

        final JComboBox<String> groupBox = BUILDER.createComboBox(this, "groupBox", pojo.getGroupListAsArray(), 0, 0);
        final JButton printButton = BUILDER.createButton(this, "printOutButton", "Print", 1, 0);

        final JButton printAllButton = BUILDER.createButton(this, "printOutAllButton", "PrintAll", 0, 1);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", "Close", 1, 1);

        final PrintFrameListener listener = new PrintFrameListener(this, pojo, groupBox);

        printButton.addActionListener(listener);
        printAllButton.addActionListener(listener);
        closeButton.addActionListener(listener);
    }

    public static PrintFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new PrintFrame(pojo);
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
