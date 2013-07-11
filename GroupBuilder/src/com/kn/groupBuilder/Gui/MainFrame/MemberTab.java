package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.GroupTabListener;
import com.kn.groupBuilder.Gui.MainFrame.Listener.MemberTabListener;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.Gui.Builder.TabBuilder;

class MemberTab extends JPanel {

    private static final long serialVersionUID = 3210114640051532404L;
    private final TabBuilder builder = new TabBuilder();

    MemberTab(final Pojo pojo) {

        this.setLayout(new GridBagLayout());
        this.builder.createTable(this, 0, 0, new JTable(new MemberTableModel(pojo.getMemberList())));

        this.builder.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = this.builder.createButton(this, "addButton", "Add Member", 0, 5);
        final JButton buildButton = this.builder.createButton(this, "buildButton", "Build Groups", 0, 6);
        final JButton saveButton = this.builder.createButton(this, "saveButton", "Save", 0, 7);
        this.builder.setDefaultGridBackValues();

        addButton.addActionListener(new MemberTabListener(pojo));
        buildButton.addActionListener(new GroupTabListener(pojo));
        saveButton.addActionListener(new MemberTabListener(pojo));

    }
}
