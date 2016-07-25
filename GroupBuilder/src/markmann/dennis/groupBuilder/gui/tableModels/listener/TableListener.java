package markmann.dennis.groupBuilder.gui.tableModels.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import markmann.dennis.groupBuilder.gui.popups.EditGroupFrame;
import markmann.dennis.groupBuilder.gui.popups.EditMemberFrame;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the tableModels. Allows to edit and remove groups or member.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class TableListener implements ActionListener {

    private final Pojo pojo;
    private final int rowID;
    private final String action;

    public TableListener(final Pojo pojo, final int rowID, final String action) {
        this.pojo = pojo;
        this.rowID = rowID;
        this.action = action;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("RemoveButton") == 0) {
            // TODO add confirmationFrame
            // ConfirmationFrame.getInstance(this.pojo, this.action, this.rowID);

        } else if (buttonClicked.getName().compareTo("EditButton") == 0) {
            if (this.action.equals(this.pojo.getTranslation("EditMember"))) {
                EditMemberFrame.getInstance(this.pojo, this.rowID);
            } else if (this.action.equals(this.pojo.getTranslation("EditGroup"))) {
                EditGroupFrame.getInstance(this.pojo, this.rowID);
            }
        }
    }
}
