package markmann.dennis.groupBuilder.gui.menu;

import javax.swing.JButton;
import javax.swing.JFrame;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.menu.listener.HelpFrameListener;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Frame used to show some useful introductions about the software.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public final class HelpFrame extends JFrame implements DefaultFrame {

    private static HelpFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;

    public static HelpFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new HelpFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    private Pojo pojo = null;

    private HelpFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("Help"));
        this.addWindowListener(new MyWindowAdapter(this));
        BUILDER.createLabel(this, pojo.getTranslation("HelpFrameLineOne"), 0, 1);
        BUILDER.createLabel(this, pojo.getTranslation("HelpFrameLineTwo"), 0, 2);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getTranslation("Close"), 1, 3);

        final HelpFrameListener listener = new HelpFrameListener(this);

        closeButton.addActionListener(listener);

    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }

    @Override
    public void openClosingDialog(WindowCloseDialogOptions request) {
        ConfirmationFrame.getInstance(this.pojo, request, this);
    }
}
