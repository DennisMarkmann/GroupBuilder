package com.kn.groupBuilder.Gui.Popups;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Popups.Listener.BuildFrameListener;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.Builder.CheckBoxHelper;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to add information for the group building process.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class BuildFrame extends JFrame implements DefaultFrame {

    private static BuildFrame instance = null;
    private static final long serialVersionUID = -6911722669720979718L;
    private final CheckBoxHelper checkBoxHelper = new CheckBoxHelper();
    private Pojo pojo = null;

    private BuildFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getMessages("AssignGroups"));
        this.addWindowListener(new MyWindowAdapter(this));

        final JCheckBox buildCompleteCheckBox = this.checkBoxHelper.createSingleSelectionCheckBox(
                this,
                "buildCompleteCheckBox",
                pojo.getMessages("BuildEverything"),
                0,
                0);
        final JCheckBox buildUnassignedCheckBox = this.checkBoxHelper.createSingleSelectionCheckBox(
                this,
                "buildUnassignedCheckBox",
                pojo.getMessages("BuildUnassigned"),
                0,
                2);

        final JButton buildButton = BUILDER.createButton(this, "buildButton", pojo.getMessages("Build"), 0, 4);
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
    public void openClosingDialog(final String text) {
        ConfirmationFrame.getInstance(this.pojo, text, this);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }
}
