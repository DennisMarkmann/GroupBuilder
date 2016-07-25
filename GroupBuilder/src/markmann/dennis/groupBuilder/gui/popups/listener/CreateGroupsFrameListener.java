package markmann.dennis.groupBuilder.gui.popups.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import markmann.dennis.groupBuilder.exceptions.EmptyValueException;
import markmann.dennis.groupBuilder.gui.popups.CreateGroupsFrame;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the createGroupsFrame. Automatically create groups.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class CreateGroupsFrameListener implements ActionListener {

    private final CreateGroupsFrame createGroupsAutomaticallyFrame;
    private final JTextField numberField;
    private final Pojo pojo;

    public CreateGroupsFrameListener(
            final CreateGroupsFrame createGroupsAutomaticallyFrame,
            final Pojo pojo,
            final JTextField numberField) {

        this.createGroupsAutomaticallyFrame = createGroupsAutomaticallyFrame;
        this.pojo = pojo;
        this.numberField = numberField;

    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("createButton") == 0) {
            final int memberPerGroup;
            try {
                memberPerGroup = Integer.parseInt(this.numberField.getText());
            } catch (final java.lang.NumberFormatException e) {
                new EmptyValueException(this.pojo.getTranslation("MemberPerGroup")).showDialog();
                return;
            }

            // TODO add confirmationFrame
            // ConfirmationFrame.getInstance(this.pojo, this.pojo.getTranslation("AutoCreateGroups"), memberPerGroup);
            this.createGroupsAutomaticallyFrame.closeWindow();

        } else if (buttonClicked.getName().compareTo("closeButton") == 0) {
            this.createGroupsAutomaticallyFrame.closeWindow();
        }
    }
}
