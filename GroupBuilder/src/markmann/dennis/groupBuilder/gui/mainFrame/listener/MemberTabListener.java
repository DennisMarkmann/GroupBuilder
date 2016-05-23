package markmann.dennis.groupBuilder.gui.mainFrame.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import markmann.dennis.groupBuilder.gui.popups.BuildFrame;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.gui.popups.CreateMemberFrame;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the memberTab. Used to add member, start groupBuild processes and save all changes.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class MemberTabListener implements ActionListener {

    private final Pojo pojo;

    public MemberTabListener(final Pojo pojo) {
        this.pojo = pojo;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("addButton") == 0) {
            CreateMemberFrame.getInstance(this.pojo);

        } else if (buttonClicked.getName().compareTo("assignButton") == 0) {
            BuildFrame.getInstance(this.pojo);

        } else if (buttonClicked.getName().compareTo("saveButton") == 0) {
            ConfirmationFrame.getInstance(this.pojo, this.pojo.getTranslation("Save"), null);
        }

    }
}
