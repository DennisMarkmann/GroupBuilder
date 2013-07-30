package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.MemberTabListener;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultTab;

/**
 * Main tab of the GUI. Used to access many other operations and to see the different member via table.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class MemberTab extends JPanel implements DefaultTab {

    private static final long serialVersionUID = 3210114640051532404L;

    MemberTab(final Pojo pojo) {

        final ArrayList<String> buttonRenderCols = new ArrayList<String>();
        buttonRenderCols.add("Edit");
        buttonRenderCols.add("Remove");

        BUILDER.setDefaultTabSettings(this);
        BUILDER.createTable(this, 0, 0, new JTable(MemberTableModel.createTable(pojo)), buttonRenderCols);

        BUILDER.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = BUILDER.createButton(this, "addButton", "Add Member", 0, 5);
        final JButton buildButton = BUILDER.createButton(this, "assignButton", "Assign Groups", 0, 6);
        final JButton saveButton = BUILDER.createButton(this, "saveButton", "Save", 0, 7);

        final MemberTabListener listener = new MemberTabListener(pojo);

        addButton.addActionListener(listener);
        buildButton.addActionListener(listener);
        saveButton.addActionListener(listener);

    }
}
