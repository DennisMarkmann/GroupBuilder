package markmann.dennis.groupBuilder.gui.popups;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.popups.listener.EditGroupFrameListener;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Frame used to edit information for the groups.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public final class EditGroupFrame extends JFrame implements DefaultFrame {

    private static EditGroupFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;

    public static EditGroupFrame getInstance(final Pojo pojo, final int rowID) {
        if (instance == null) {
            instance = new EditGroupFrame(pojo, rowID);
        } else {
            instance.toFront();
        }
        return instance;
    }

    private Pojo pojo = null;

    private EditGroupFrame(final Pojo pojo, final int rowID) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("EditGroup"));
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

        this.fillFields(pojo, rowID, groupNameField, groupDescField, groupSizeField);

        final EditGroupFrameListener listener = new EditGroupFrameListener(
                this,
                pojo,
                rowID,
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

    private void fillFields(
            final Pojo pojo,
            final int rowID,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        final Group group = pojo.getGroupList().get(rowID);
        groupNameField.setText(group.getName());
        groupDescField.setText(group.getDescription());
        groupSizeField.setText(group.getFixSize() + "");

    }

    @Override
    public void openClosingDialog(WindowCloseDialogOptions request) {
        ConfirmationFrame.getInstance(this.pojo, request, this);
    }
}
