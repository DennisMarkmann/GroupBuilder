package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.GroupTabListener;
import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.Gui.Builder.GuiTabBuilder;

class GroupTab extends JPanel {

    private static final long serialVersionUID = 1673516265342795696L;
    private final GuiTabBuilder builder = new GuiTabBuilder();

    GroupTab(final Pojo pojo) {

        this.setLayout(new GridBagLayout());
        this.builder.createTable(this, 0, 0, new JTable(new GroupTableModel(pojo.getGroupList())));

        this.builder.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = this.builder.createButton(this, "addButton", "Add Group", 0, 5);
        final JButton saveButton = this.builder.createButton(this, "saveButton", "Save", 0, 7);
        this.builder.setDefaultGridBackValues();

        addButton.addActionListener(new GroupTabListener(pojo));
        saveButton.addActionListener(new GroupTabListener(pojo));
    }
}
