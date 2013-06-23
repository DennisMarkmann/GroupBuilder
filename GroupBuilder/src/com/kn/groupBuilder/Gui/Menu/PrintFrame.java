package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Menu.Listener.PrintFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public class PrintFrame extends JFrame {

    private static final long serialVersionUID = 4767991083504569016L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    public PrintFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "Print");

        final JComboBox<String> groupBox = this.builder.createComboBox(this, pojo.getGroupListAsArray(), 0, 0);
        final JButton printButton = this.builder.createButton(this, "printOutButton", "Print", 1, 0);

        final JButton printAllButton = this.builder.createButton(this, "printOutAllButton", "PrintAll", 0, 1);
        final JButton closeButton = this.builder.createButton(this, "closeButton", "Close", 1, 1);

        final PrintFrameListener listener = new PrintFrameListener(this, pojo, groupBox);

        printButton.addActionListener(listener);
        printAllButton.addActionListener(listener);
        closeButton.addActionListener(listener);
    }
}
