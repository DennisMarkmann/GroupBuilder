package markmann.dennis.groupBuilder.gui.popups;

import javax.swing.JButton;
import javax.swing.JFrame;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.popups.listener.ConfirmationFrameListener;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Frame used to ask if a operation should really be done.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public final class ConfirmationFrame extends JFrame implements DefaultFrame {

    private static ConfirmationFrame instance = null;
    private static final long serialVersionUID = -6013891923961668832L;

    public static ConfirmationFrame getInstance(final Pojo pojo, final String action, final Object object) {
        if (instance == null) {
            instance = new ConfirmationFrame(pojo, action, object);
        } else {
            instance.toFront();
        }
        return instance;
    }

    private ConfirmationFrame(final Pojo pojo, final String action, final Object object) {

        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("Confirm"));
        this.addWindowListener(new MyWindowAdapter(this));

        BUILDER.createLabel(this, pojo.getTranslation("ConfirmationText") + action + " ?", 0, 1);
        final JButton confirmationButton = BUILDER
                .createButton(this, "confirmationButton", pojo.getTranslation("Confirm"), 0, 4);
        final JButton abortButton = BUILDER.createButton(this, "abortButton", pojo.getTranslation("Abort"), 3, 4);

        final ConfirmationFrameListener listener = new ConfirmationFrameListener(this, pojo, action, object);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
    }

    @Override
    public void closeWindow() {
        this.dispose();
        instance = null;
    }

    // @Override
    // public void openClosingDialog(final String text) {
    // this.closeWindow();
    // }

    @Override
    public void openClosingDialog(WindowCloseDialogOptions request) {
        // TODO implement + remove old one
    }
}
