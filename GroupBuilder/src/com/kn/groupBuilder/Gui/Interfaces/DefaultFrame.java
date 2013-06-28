package com.kn.groupBuilder.Gui.Interfaces;

import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;

public interface DefaultFrame {

    GuiFrameBuilder BUILDER = new GuiFrameBuilder();
    int TEXT_FIELD_SIZE = 5;

    void closeWindow();

    void dispose();
}
