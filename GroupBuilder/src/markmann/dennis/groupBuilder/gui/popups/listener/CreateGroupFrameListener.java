package markmann.dennis.groupBuilder.gui.popups.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import markmann.dennis.groupBuilder.exceptions.EmptyValueException;
import markmann.dennis.groupBuilder.exceptions.NotToHandleException;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.gui.popups.CreateGroupFrame;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the groupFrame. Used to create groups and close the window.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class CreateGroupFrameListener implements ActionListener {

    private final CreateGroupFrame createGroupFrame;
    private final Pojo pojo;
    private final JTextField groupNameField;
    private final JTextField groupDescField;
    private final JTextField groupSizeField;

    public CreateGroupFrameListener(
            final CreateGroupFrame createGroupFrame,
            final Pojo pojo,
            final JTextField groupNameField,
            final JTextField groupDescField,
            final JTextField groupSizeField) {

        this.createGroupFrame = createGroupFrame;
        this.pojo = pojo;
        this.groupNameField = groupNameField;
        this.groupDescField = groupDescField;
        this.groupSizeField = groupSizeField;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            int fixSize = 0;
            final String groupName = this.groupNameField.getText();
            final String description = this.groupDescField.getText();
            try {
                fixSize = Integer.parseInt(this.groupSizeField.getText());
            } catch (final NumberFormatException e) {
                new NotToHandleException();
            }
            if (groupName.equals("")) {
                new EmptyValueException(this.pojo.getTranslation("GroupName")).showDialog();
                return;
            }

            ConfirmationFrame
                    .getInstance(this.pojo, this.pojo.getTranslation("AddGroup"), new Group(groupName, description, fixSize));
        }
        this.createGroupFrame.closeWindow();

    }
}
