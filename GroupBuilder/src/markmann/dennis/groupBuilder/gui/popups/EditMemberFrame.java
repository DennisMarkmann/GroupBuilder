package markmann.dennis.groupBuilder.gui.popups;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultFrame;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.MyWindowAdapter;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.WindowCloseDialogOptions;
import markmann.dennis.groupBuilder.gui.popups.listener.EditMemberFrameListener;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Frame used to start member editition.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public final class EditMemberFrame extends JFrame implements DefaultFrame {

    private static EditMemberFrame instance = null;
    private static final long serialVersionUID = -2620743685703998617L;

    public static EditMemberFrame getInstance(final Pojo pojo, final int rowID) {
        if (instance == null) {
            instance = new EditMemberFrame(pojo, rowID);
        } else {
            instance.toFront();
        }
        return instance;
    }

    private Pojo pojo = null;

    private EditMemberFrame(final Pojo pojo, final int rowID) {

        this.pojo = pojo;
        BUILDER.setDefaultFrameSettings(this, "GroupBuilder - " + pojo.getTranslation("EditMember"));
        this.addWindowListener(new MyWindowAdapter(this));
        this.setSize(350, 200);

        BUILDER.createLabel(this, pojo.getTranslation("FirstName"), 0, 1);
        BUILDER.createLabel(this, pojo.getTranslation("LastName"), 0, 2);
        BUILDER.createLabel(this, pojo.getTranslation("E-Mail"), 0, 3);
        BUILDER.createLabel(this, pojo.getTranslation("Group"), 0, 4);

        final JTextField firstNameField = BUILDER.createTextField(this, "firstNameField", TEXT_FIELD_SIZE, 1, 1);
        final JTextField lastNameField = BUILDER.createTextField(this, "lastNameField", TEXT_FIELD_SIZE, 1, 2);
        final JTextField eMailField = BUILDER.createTextField(this, "eMailField", TEXT_FIELD_SIZE, 1, 3);
        final JComboBox<Object> groupBox = BUILDER.createComboBox(this, "groupBox", pojo.getGroupListAsArray(), 1, 4);

        final JButton confirmationButton = BUILDER
                .createButton(this, "confirmationButton", pojo.getTranslation("Confirm"), 0, 5);
        final JButton abortButton = BUILDER.createButton(this, "abortButton", pojo.getTranslation("Abort"), 1, 5);

        this.fillFields(pojo, rowID, firstNameField, lastNameField, eMailField, groupBox);

        final EditMemberFrameListener listener = new EditMemberFrameListener(
                this,
                pojo,
                rowID,
                firstNameField,
                lastNameField,
                eMailField,
                groupBox);

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
            final JTextField firstNameField,
            final JTextField lastNameField,
            final JTextField eMailField,
            final JComboBox<Object> groupBox) {
        final Member member = pojo.getMemberList().get(rowID);
        firstNameField.setText(member.getFirstName());
        lastNameField.setText(member.getLastName());
        eMailField.setText(member.getEMailAdress());
        if (member.getGroup() != null) {
            groupBox.setSelectedIndex(this.getIndexOfEntry(pojo.getGroupListAsArray(), member.getGroup().getName()));
        }
    }

    private int getIndexOfEntry(final String[] array, final String string) {

        for (int index = 0; index < array.length; index++) {
            if (array[index].equals(string)) {
                return index;
            }
        }
        return 0;
    }

    @Override
    public void openClosingDialog(WindowCloseDialogOptions request) {
        ConfirmationFrame.getInstance(this.pojo, request, this);
    }
}
