package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kn.groupBuilder.Gui.HelperClasses.GuiTabBuilder;
import com.kn.groupBuilder.Gui.MainFrame.Listener.MemberTabListener;
import com.kn.groupBuilder.Storage.Pojo;

class MemberTab extends JPanel {

    private static final long serialVersionUID = 3210114640051532404L;
    private final GuiTabBuilder builder = new GuiTabBuilder();

    MemberTab(final Pojo pojo) {

        this.setLayout(new GridBagLayout());

        this.builder.createMemberTable(pojo.getMemberList(), this, 0, 0);

        this.builder.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = this.builder.createButton(this, "addButton", "Add member", 0, 5);
        final JButton saveButton = this.builder.createButton(this, "saveButton", "Save", 0, 6);
        this.builder.setDefaultGridBackValues();

        saveButton.addActionListener(new MemberTabListener(pojo));
        addButton.addActionListener(new MemberTabListener(pojo));

    }
}
