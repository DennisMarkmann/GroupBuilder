package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Storage.Pojo;

public class BuildFrame extends JFrame {

    private static final long serialVersionUID = -6911722669720979718L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();

    public BuildFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "Build Groups");

        final JButton buildAllButton = this.builder.createButton(this, "buildAllButton", "Build All", 0, 0);
        final JButton buildButton = this.builder.createButton(this, "buildButton", "Build", 1, 0);
        final JButton buildSelectedButton = this.builder.createButton(this, "buildSelectedButton", "Build Selected", 0, 1);
        final JButton buildRemainingButton = this.builder.createButton(this, "buildRemainingButton", "Build Remaining", 1, 1);
    }
}
