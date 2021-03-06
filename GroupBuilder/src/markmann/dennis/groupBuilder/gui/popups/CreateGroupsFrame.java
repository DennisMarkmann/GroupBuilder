package markmann.dennis.groupBuilder.gui.popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.popups.listener.CreateGroupsFrameListener;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Frame used to automatically create groups.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public final class CreateGroupsFrame extends JFrame implements DefaultFrame {

    private static CreateGroupsFrame instance = null;
    private static final long serialVersionUID = 416901635761617562L;

    public static CreateGroupsFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new CreateGroupsFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    private Pojo pojo = null;

    private CreateGroupsFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("CreateGroups"));
        this.addWindowListener(new MyWindowAdapter(this));

        BUILDER.createLabel(this, pojo.getTranslation("CreateGroupsText"), 0, 0);
        final JTextField numberField = BUILDER.createTextField(this, "numberField", TEXT_FIELD_SIZE, 1, 0);
        final JButton createButton = BUILDER.createButton(this, "createButton", pojo.getTranslation("Create"), 0, 1);
        final JButton closeButton = BUILDER.createButton(this, "closeButton", pojo.getTranslation("Close"), 1, 1);

        final CreateGroupsFrameListener listener = new CreateGroupsFrameListener(this, pojo, numberField);

        createButton.addActionListener(listener);
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
