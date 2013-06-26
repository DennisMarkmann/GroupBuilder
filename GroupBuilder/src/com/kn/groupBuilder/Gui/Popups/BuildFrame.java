package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.HelperClasses.CheckBoxHelper;
import com.kn.groupBuilder.Gui.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Gui.Popups.Listener.BuildFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

public class BuildFrame extends JFrame {

    private static final long serialVersionUID = -6911722669720979718L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();
    private final CheckBoxHelper checkBoxHelper = new CheckBoxHelper();

    public BuildFrame(final Pojo pojo) {

        this.builder.setDefaultFrameSettings(this, "Build Groups");

        final JCheckBox buildCompleteCheckBox = this.checkBoxHelper.createSingleSelectionCheckBox(
                this,
                "buildCompleteCheckBox",
                "Build Everything",
                0,
                0);
        final JCheckBox buildUnassignedCheckBox = this.checkBoxHelper.createSingleSelectionCheckBox(
                this,
                "buildUnassignedCheckBox",
                "Build Unassigned",
                0,
                2);

        final JButton buildButton = this.builder.createButton(this, "buildButton", "Build", 0, 4);
        this.pack();

        final BuildFrameListener listener = new BuildFrameListener(this, pojo, buildCompleteCheckBox, buildUnassignedCheckBox);

        buildButton.addActionListener(listener);

    }
}
