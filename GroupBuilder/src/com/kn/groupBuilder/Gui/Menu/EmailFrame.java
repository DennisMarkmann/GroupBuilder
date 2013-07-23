package com.kn.groupBuilder.Gui.Menu;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import com.kn.groupBuilder.Gui.Menu.Listener.EmailFrameListener;
import com.kn.groupBuilder.Gui.Popups.ConfirmationFrame;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to start emailMail sending.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class EmailFrame extends JFrame implements DefaultFrame {

    private static EmailFrame instance = null;
    private static final long serialVersionUID = 4767991083504569016L;
    private boolean selected = true;

    private EmailFrame(final Pojo pojo) {

        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - Email");
        this.addWindowListener(new MyWindowAdapter(this));

        int x = 0;
        int y = 0;
        final ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
        for (final Group group : pojo.getGroupList()) {
            if (x == 3) {
                y++;
                x = 0;
            }
            final String groupName = group.getName();
            final JCheckBox checkBox = BUILDER.createCheckBox(this, groupName, groupName, x, y);
            checkBox.setSelected(true);
            checkBoxList.add(checkBox);
            x++;
        }

        final JButton selectAllButton = BUILDER.createButton(this, "selectAllButton", "Select All", 0, y + 1);
        final JButton sendButton = BUILDER.createButton(this, "sendButton", "Send", 0, y + 2);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", "Close", 1, y + 2);

        final EmailFrameListener listener = new EmailFrameListener(this, pojo, checkBoxList);

        selectAllButton.addActionListener(listener);
        sendButton.addActionListener(listener);
        closeButton.addActionListener(listener);
    }

    public static EmailFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new EmailFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    @Override
    public void openClosingDialog(final String text) {
        ConfirmationFrame.getInstance(null, text, this);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setSelected(final boolean selected) {
        this.selected = selected;
    }
}
