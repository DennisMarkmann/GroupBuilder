package com.kn.groupBuilder.Gui.Interfaces;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;

public interface DefaultFrame {

    static final GuiFrameBuilder builder = new GuiFrameBuilder();
    static final int TEXT_FIELD_SIZE = 5;

    void closeWindow();

    void dispose();
}
