package com.kn.groupBuilder.Gui.Popups;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.kn.groupBuilder.Gui.Popups.Listener.CreateMemberListener;
import com.kn.groupBuilder.HelperClasses.GuiFrameBuilder;
import com.kn.groupBuilder.Storage.Member;

public class CreateMemberFrame extends JFrame {

    private static final long serialVersionUID = -2620743685703998617L;
    private final GuiFrameBuilder builder = new GuiFrameBuilder();
    private static final int TEXT_FIELD_SIZE = 5;

    public CreateMemberFrame(final ArrayList<Member> memberList) {

        this.builder.setDefaultFrameSettings(this);

        this.builder.createLabel(this, "FirstName", 0, 1);
        this.builder.createLabel(this, "LastName", 0, 2);
        this.builder.createLabel(this, "E-Mail", 0, 3);
        this.builder.createLabel(this, "Groups", 0, 4);

        final JTextField firstNameField = this.builder.createTextField(this, TEXT_FIELD_SIZE, 1, 1);
        final JTextField lastNameField = this.builder.createTextField(this, TEXT_FIELD_SIZE, 1, 2);
        final JTextField eMailField = this.builder.createTextField(this, TEXT_FIELD_SIZE, 1, 3);
        final JTextField groupsField = this.builder.createTextField(this, TEXT_FIELD_SIZE, 1, 4);

        final JButton bestaetigenButton = this.builder.createButton(this, "bestaetigenButton", "Bestätigen", 0, 5);
        final JButton abbrechenButton = this.builder.createButton(this, "abbrechenButton", "Abbrechen", 1, 5);

        this.pack();

        final CreateMemberListener listener = new CreateMemberListener(
                this,
                memberList,
                firstNameField,
                lastNameField,
                eMailField,
                groupsField);

        bestaetigenButton.addActionListener(listener);
        abbrechenButton.addActionListener(listener);
    }
}
