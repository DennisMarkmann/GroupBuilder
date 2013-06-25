package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Popups.Listener.BuildFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public class BuildFrame extends JFrame {

    private static final long serialVersionUID = -6911722669720979718L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    public BuildFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "Build Groups");

        this.builder.createCheckBox(this, "(Re)Build Everything", 0, 0);
        this.builder.createCheckBox(this, "Build Selected", 0, 1);
        this.builder.createCheckBox(this, "Build Unassigned", 0, 2);
        this.builder.createCheckBox(this, "Build Single", 0, 3);
        final JButton buildButton = this.builder.createButton(this, "buildButton", "Build", 0, 4);
        this.pack();

        final BuildFrameListener listener = new BuildFrameListener(this, pojo);

        buildButton.addActionListener(listener);
    }
}
