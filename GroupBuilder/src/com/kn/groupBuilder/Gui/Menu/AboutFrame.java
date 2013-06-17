package com.kn.groupBuilder.Gui.Menu;

import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Storage.Pojo;

public class AboutFrame extends JFrame {

    private static final long serialVersionUID = -7650216557475857971L;
    GuiFrameBuilder builder = new GuiFrameBuilder();

    public AboutFrame(final Pojo pojo) {
        this.builder.setDefaultFrameSettings(this);
        this.builder.createLabel(this, "Designed by Dennis Markmann", 2, 2);
    }
}
