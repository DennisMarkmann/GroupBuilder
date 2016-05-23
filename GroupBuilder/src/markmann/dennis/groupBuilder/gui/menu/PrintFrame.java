package markmann.dennis.groupBuilder.gui.menu;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import markmann.dennis.groupBuilder.gui.menu.listener.PrintFrameListener;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;

/**
 * Frame used to start print operation.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public final class PrintFrame extends JFrame implements DefaultFrame {

    private static PrintFrame instance = null;
    private static final long serialVersionUID = 4767991083504569016L;
    private boolean selected = true;
    private Pojo pojo = null;

    private PrintFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("Print"));
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
        final JButton printButton = BUILDER.createButton(this, "printButton", pojo.getTranslation("Print"), 1, y);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getTranslation("Close"), 2, y);

        final PrintFrameListener listener = new PrintFrameListener(this, pojo, checkBoxList);

        selectAllButton.addActionListener(listener);
        printButton.addActionListener(listener);
        closeButton.addActionListener(listener);
    }

    public static PrintFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new PrintFrame(pojo);
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
