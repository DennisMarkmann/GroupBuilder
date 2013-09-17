package markmann.dennis.groupBuilder.gui.popups.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import markmann.dennis.groupBuilder.exceptions.EmptyValueException;
import markmann.dennis.groupBuilder.exceptions.NotToHandleException;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.gui.popups.EditGroupFrame;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the groupFrame. Used to edit groups and close the window.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EditGroupFrameListener implements ActionListener {

    private final EditGroupFrame editGroupFrame;
    private final Pojo pojo;
    private final int rowID;
    private final JTextField groupNameField;
    private final JTextField groupDescField;
    private final JTextField groupSizeField;

    public EditGroupFrameListener(
            final EditGroupFrame editGroupFrame,
            final Pojo pojo,
            final int rowID,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        this.editGroupFrame = editGroupFrame;
        this.pojo = pojo;
        this.rowID = rowID;
        this.groupNameField = groupNameField;
        this.groupDescField = groupDescField;
        this.groupSizeField = groupSizeField;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            final ArrayList<Group> groupList = new ArrayList<Group>();
            int fixSize = 0;
            final String groupName = this.groupNameField.getText();
            final String description = this.groupDescField.getText();
            try {
                fixSize = Integer.parseInt(this.groupSizeField.getText());
            } catch (final NumberFormatException e) {
                new NotToHandleException(e.getStackTrace());
            }
            if (groupName.equals("")) {
                new EmptyValueException(this.pojo.getTranslation("GroupName")).showDialog();
                return;
            }
            groupList.add(this.pojo.getGroupList().get(this.rowID));
            groupList.add(new Group(groupName, description, fixSize));

            ConfirmationFrame.getInstance(this.pojo, this.pojo.getTranslation("EditGroup"), groupList);
        }
        this.editGroupFrame.closeWindow();

    }
}
