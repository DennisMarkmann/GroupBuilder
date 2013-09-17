package markmann.dennis.groupBuilder.gui.menu;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import markmann.dennis.groupBuilder.gui.menu.listener.EmailFrameListener;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;
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
    private Pojo pojo = null;

    private EmailFrame(final Pojo pojo) {

        this.pojo = pojo;
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

        // line filler
        y++;
        BUILDER.createLabel(this, "", 0, y);
        y++;

        final JButton selectAllButton = BUILDER.createButton(this, "selectAllButton", pojo.getTranslation("SelectAll"), 0, y);
        final JButton sendButton = BUILDER.createButton(this, "sendButton", pojo.getTranslation("Send"), 1, y);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getTranslation("Close"), 2, y);

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
        ConfirmationFrame.getInstance(this.pojo, text, this);
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
