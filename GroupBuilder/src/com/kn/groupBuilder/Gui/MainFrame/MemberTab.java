package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.Listener.MemberTabListener;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.Builder.TabBuilder;

/**
 * Main tab of the GUI. Used to access many other operations and to see the different member via table.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class MemberTab extends JPanel {

    private static final long serialVersionUID = 3210114640051532404L;
    private final TabBuilder builder = new TabBuilder();

    MemberTab(final Pojo pojo) {

        this.setLayout(new GridBagLayout());
        this.builder.createTable(this, 0, 0, new JTable(MemberTableModel.createTable(pojo.getMemberList())));

        this.builder.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = this.builder.createButton(this, "addButton", "Add Member", 0, 5);
        final JButton buildButton = this.builder.createButton(this, "buildButton", "Build Groups", 0, 6);
        final JButton saveButton = this.builder.createButton(this, "saveButton", "Save", 0, 7);
        this.builder.setDefaultGridBackValues();

        final MemberTabListener listener = new MemberTabListener(pojo);

        addButton.addActionListener(listener);
        buildButton.addActionListener(listener);
        saveButton.addActionListener(listener);

    }
}
