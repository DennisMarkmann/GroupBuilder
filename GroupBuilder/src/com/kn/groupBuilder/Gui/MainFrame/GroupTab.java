package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.GroupTabListener;
import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.Builder.TabBuilder;

/**
 * Second tab of the GUI. Used to access many other operations and to see the different groups via table.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class GroupTab extends JPanel {

    private static final long serialVersionUID = 1673516265342795696L;
    private final TabBuilder builder = new TabBuilder();

    GroupTab(final Pojo pojo) {

        this.setLayout(new GridBagLayout());
        this.builder.createTable(this, 0, 0, new JTable(GroupTableModel.createTable(pojo.getGroupList())));

        this.builder.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = this.builder.createButton(this, "addButton", "Add Group", 0, 5);
        final JButton saveButton = this.builder.createButton(this, "saveButton", "Save", 0, 7);
        this.builder.setDefaultGridBackValues();

        final GroupTabListener listener = new GroupTabListener(pojo);

        addButton.addActionListener(listener);
        saveButton.addActionListener(listener);
    }
}
