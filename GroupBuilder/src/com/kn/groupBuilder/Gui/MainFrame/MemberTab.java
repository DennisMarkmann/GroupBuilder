package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kn.groupBuilder.Gui.HelperClasses.GuiTabBuilder;
import com.kn.groupBuilder.Gui.MainFrame.Listener.MemberTabListener;
import com.kn.groupBuilder.Storage.Pojo;

class MemberTab extends JPanel {

    private static final long serialVersionUID = 3210114640051532404L;
    GuiTabBuilder builder = new GuiTabBuilder();

    MemberTab(final Pojo pojo) {

        this.setLayout(new GridBagLayout());

        this.builder.createMemberTable(pojo.getMemberList(), this, 0, 0);
        final JButton addButton = this.builder.createButton(this, "addButton", "Add member", 0, 5);

        addButton.addActionListener(new MemberTabListener(pojo));

    }
}
