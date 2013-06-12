package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.kn.groupBuilder.Gui.MainFrame.Listener.MemberTabListener;
import com.kn.groupBuilder.HelperClasses.GuiTabBuilder;
import com.kn.groupBuilder.Storage.Member;

class MemberTab extends JPanel {

    private static final long serialVersionUID = 3210114640051532404L;
    GuiTabBuilder builder = new GuiTabBuilder();

    MemberTab(final ArrayList<Member> memberList) {

        this.setLayout(new GridBagLayout());

        this.builder.createMemberTable(memberList, this, 0, 0);
        final JButton addButton = this.builder.createButton(this, "addButton", "Add member", 0, 5);

        addButton.addActionListener(new MemberTabListener(memberList));

    }
}
