package markmann.dennis.groupBuilder.gui.popups.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import markmann.dennis.groupBuilder.exceptions.EmptyValueException;
import markmann.dennis.groupBuilder.gui.popups.ConfirmationFrame;
import markmann.dennis.groupBuilder.gui.popups.EditMemberFrame;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;

/**
 * Listener for the createMemberFrame. Allows to start edit member and close the window.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class EditMemberFrameListener implements ActionListener {

    private final EditMemberFrame editMemberFrame;
    private final Pojo pojo;
    private final int rowID;
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JTextField eMailField;
    private final JComboBox<String> groupBox;

    public EditMemberFrameListener(
            final EditMemberFrame editMemberFrame,
            final Pojo pojo,
            final int rowID,
            final JTextField firstNameField,
            final JTextField lastNameField,
            final JTextField eMailField,
            final JComboBox<String> groupBox) {

        this.editMemberFrame = editMemberFrame;
        this.pojo = pojo;
        this.rowID = rowID;
        this.firstNameField = firstNameField;
        this.lastNameField = lastNameField;
        this.eMailField = eMailField;
        this.groupBox = groupBox;
    }

    @Override
    public final void actionPerformed(final ActionEvent event) {

        final JButton buttonClicked = (JButton) event.getSource();
        if (buttonClicked.getName().compareTo("confirmationButton") == 0) {

            final ArrayList<Member> memberList = new ArrayList<Member>();
            final String firstName = this.firstNameField.getText();
            final String lastName = this.lastNameField.getText();
            final String email = this.eMailField.getText();
            final String groupName = this.pojo.getGroupListAsArray()[this.groupBox.getSelectedIndex()];
            final Group group = this.pojo.getGroupByName(groupName);

            if (firstName.equals("")) {
                new EmptyValueException(this.pojo.getTranslation("FirstName")).showDialog();
                return;
            }
            if (lastName.equals("")) {
                new EmptyValueException(this.pojo.getTranslation("LastName")).showDialog();
                return;
            }

            memberList.add(this.pojo.getMemberList().get(this.rowID));
            memberList.add(new Member(firstName, lastName, email, group));

            ConfirmationFrame.getInstance(this.pojo, this.pojo.getTranslation("EditMember"), memberList);
        }
        this.editMemberFrame.closeWindow();

    }
}
