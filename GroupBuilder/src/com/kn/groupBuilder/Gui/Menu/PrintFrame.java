package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Interfaces.DefaultFrame;
import com.kn.groupBuilder.Gui.Interfaces.MyWindowAdapter;
import com.kn.groupBuilder.Gui.Menu.Listener.PrintFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public final class PrintFrame extends JFrame implements DefaultFrame {

    private static PrintFrame instance = null;
    private static final long serialVersionUID = 4767991083504569016L;

    private PrintFrame(final Pojo pojo) {

        builder.setDefaultFrameSettings(this, "Print");
        this.addWindowListener(new MyWindowAdapter(this));

        final JComboBox<String> groupBox = builder.createComboBox(this, "groupBox", pojo.getGroupListAsArray(), 0, 0);
        final JButton printButton = builder.createButton(this, "printOutButton", "Print", 1, 0);

        final JButton printAllButton = builder.createButton(this, "printOutAllButton", "PrintAll", 0, 1);
        final JButton closeButton = builder.createButton(this, "closeButton", "Close", 1, 1);

        final PrintFrameListener listener = new PrintFrameListener(this, pojo, groupBox);

        printButton.addActionListener(listener);
        printAllButton.addActionListener(listener);
        closeButton.addActionListener(listener);
    }

    public static PrintFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new PrintFrame(pojo);
        }
        return instance;
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
