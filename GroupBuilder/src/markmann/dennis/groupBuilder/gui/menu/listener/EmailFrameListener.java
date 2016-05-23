package markmann.dennis.groupBuilder.gui.menu.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import markmann.dennis.groupBuilder.gui.menu.EmailFrame;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the email frame. Allows to start the email sending process and to close the window.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class EmailFrameListener implements ActionListener {

    private final EmailFrame emailFrame;
    private final Pojo pojo;
    private final ArrayList<JCheckBox> checkBoxList;

    public EmailFrameListener(final EmailFrame emailFrame, final Pojo pojo, final ArrayList<JCheckBox> checkBoxList) {
        this.emailFrame = emailFrame;
        this.pojo = pojo;
        this.checkBoxList = checkBoxList;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();

        if (buttonClicked.getName().compareTo("sendButton") == 0) {
            final ArrayList<Group> groupList = new ArrayList<Group>();
            for (final JCheckBox checkBox : this.checkBoxList) {
                if (checkBox.isSelected()) {
                    groupList.add(this.pojo.getGroupByName(checkBox.getName()));
                }
            }
            ConfirmationFrame.getInstance(this.pojo, this.pojo.getTranslation("SendMail"), groupList);
        } else if (buttonClicked.getName().compareTo("selectAllButton") == 0) {
            boolean select = true;
            if (this.emailFrame.isSelected()) {
                select = false;
            }
            this.emailFrame.setSelected(select);

            for (final JCheckBox checkBox : this.checkBoxList) {
                checkBox.setSelected(select);
            }
            return;
        }
        this.emailFrame.closeWindow();

    }
}
