package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.MemberTabListener;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Storage.Member;

class MemberTab extends JPanel {

    private static final long serialVersionUID = 3210114640051532404L;

    MemberTab(final ArrayList<Member> memberList) {

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JTable memberTable = new JTable(new MemberTableModel(memberList));
        final JScrollPane scrollPane = new JScrollPane(memberTable);
        memberTable.setFillsViewportHeight(true);
        final JButton addButton = new JButton("Add member");
        addButton.setName("addButton");

        c.gridx = 0;
        c.gridy = 0;
        this.add(scrollPane, c);

        c.gridx = 0;
        c.gridy = 5;
        this.add(addButton, c);

        addButton.addActionListener(new MemberTabListener(memberList));

    }
}