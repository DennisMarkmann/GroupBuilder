package markmann.dennis.groupBuilder.gui.mainFrame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import markmann.dennis.groupBuilder.gui.popups.CreateGroupFrame;
import markmann.dennis.groupBuilder.gui.popups.CreateGroupsFrame;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the groupTab. Used to add groups and save all changes.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class GroupTabListener implements ActionListener {

    private final Pojo pojo;

    public GroupTabListener(final Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("addButton") == 0) {
            CreateGroupFrame.getInstance(this.pojo);
        } else if (buttonClicked.getName().compareTo("createGroupsButton") == 0) {
            CreateGroupsFrame.getInstance(this.pojo);
        } else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            // TODO add confirmationFrame
            // ConfirmationFrame.getInstance(this.pojo, this.pojo.getTranslation("Save"), null);
        }
    }
}
