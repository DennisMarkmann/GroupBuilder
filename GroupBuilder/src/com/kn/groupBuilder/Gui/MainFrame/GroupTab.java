package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.GroupTabListener;
import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultTab;

/**
 * Second tab of the GUI. Used to access many other operations and to see the different groups via table.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class GroupTab extends JPanel implements DefaultTab {

    private static final long serialVersionUID = 1673516265342795696L;

    GroupTab(final Pojo pojo) {

        final ArrayList<String> buttonRenderCols = new ArrayList<String>();
        buttonRenderCols.add("Edit");
        buttonRenderCols.add("Remove");

        BUILDER.setDefaultTabSettings(this);
        BUILDER.createTable(this, 0, 0, new JTable(GroupTableModel.createTable(pojo.getGroupList())), buttonRenderCols);

        BUILDER.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = BUILDER.createButton(this, "addButton", "Add Group", 0, 5);
        final JButton saveButton = BUILDER.createButton(this, "saveButton", "Save", 0, 7);

        final GroupTabListener listener = new GroupTabListener(pojo);

        addButton.addActionListener(listener);
        saveButton.addActionListener(listener);
    }
}
