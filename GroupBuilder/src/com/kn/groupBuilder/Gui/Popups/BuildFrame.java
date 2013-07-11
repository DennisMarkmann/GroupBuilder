package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Popups.Listener.BuildFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.ComponentHelper.CheckBoxHelper;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

public class BuildFrame extends JFrame implements DefaultFrame {

    private static BuildFrame instance = null;
    private static final long serialVersionUID = -6911722669720979718L;
    private final CheckBoxHelper checkBoxHelper = new CheckBoxHelper();

    public BuildFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "Build Groups");
        this.addWindowListener(new MyWindowAdapter(this));

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

        final JButton buildButton = BUILDER.createButton(this, "buildButton", "Build", 0, 4);
        this.pack();

        final BuildFrameListener listener = new BuildFrameListener(this, pojo, buildCompleteCheckBox, buildUnassignedCheckBox);

        buildButton.addActionListener(listener);

    }

    public static BuildFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new BuildFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    @Override
    public final void closeWindow() {
        this.dispose();
        instance = null;
    }
}
