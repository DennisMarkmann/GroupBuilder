package markmann.dennis.groupBuilder.gui.popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.popups.listener.CreateGroupFrameListener;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Frame used to add information for the group creation.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public final class CreateGroupFrame extends JFrame implements DefaultFrame {

    private static CreateGroupFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;

    public static CreateGroupFrame getInstance(final Pojo pojo) {
        if (instance == null) {
            instance = new CreateGroupFrame(pojo);
        } else {
            instance.toFront();
        }
        return instance;
    }

    private Pojo pojo = null;

    private CreateGroupFrame(final Pojo pojo) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("CreateGroup"));
        this.addWindowListener(new MyWindowAdapter(this));
        this.setSize(350, 200);

        BUILDER.createLabel(this, pojo.getTranslation("GroupName"), 0, 1);
        BUILDER.createLabel(this, pojo.getTranslation("Description"), 0, 2);
        BUILDER.createLabel(this, pojo.getTranslation("Size"), 0, 3);

        final JTextField groupNameField = BUILDER.createTextField(this, "groupNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField groupDescField = BUILDER.createTextField(this, "groupDescField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField groupSizeField = BUILDER.createTextField(this, "groupSizeField", TEXT_FIELD_SIZE, 1, 3);

        final JButton confirmationButton = BUILDER
                .createButton(this, "confirmationButton", pojo.getTranslation("Confirm"), 0, 4);
        final JButton abortButton = BUILDER.createButton(this, "abortButton", pojo.getTranslation("Abort"), 1, 4);

        final CreateGroupFrameListener listener = new CreateGroupFrameListener(
                this,
                pojo,
                groupNameField,
                groupDescField,
                groupSizeField);

        confirmationButton.addActionListener(listener);
        abortButton.addActionListener(listener);
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
