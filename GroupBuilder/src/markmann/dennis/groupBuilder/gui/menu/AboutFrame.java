package markmann.dennis.groupBuilder.gui.menu;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.menu.listener.AboutFrameListener;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Frame showing information about the author.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public final class AboutFrame extends JFrame implements DefaultFrame {

    private static AboutFrame instance = null;
    private static final long serialVersionUID = -7650216557475857971L;

    public static AboutFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new AboutFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    private Pojo pojo = null;

    private AboutFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("About"));
        this.setSize(600, 230);

        // The frame is too small for the long German text.
        if (pojo.getSettings().getLanguage().equals("German")) {
            this.setSize(700, 230);
        }

        this.addWindowListener(new MyWindowAdapter(this));
        final JLabel headLineLabel = BUILDER.createLabel(this, "GroupBuilder", 1, 0);
        headLineLabel.setFont(new Font("Arial", Font.BOLD, 22));
        BUILDER.createLabel(this, "", 1, 1);
        BUILDER.createLabel(this, "Version 1.0.", 1, 2);
        BUILDER.createLabel(this, "", 1, 3);
        BUILDER.createLabel(this, pojo.getTranslation("AboutLineOne"), 1, 4);
        BUILDER.createLabel(this, pojo.getTranslation("AboutLineTwo"), 1, 5);
        BUILDER.createLabel(this, pojo.getTranslation("AboutLineThree"), 1, 6);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getTranslation("Close"), 2, 7);
        this.getRootPane().setDefaultButton(closeButton);
        final ActionListener listener = new AboutFrameListener(this);

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
