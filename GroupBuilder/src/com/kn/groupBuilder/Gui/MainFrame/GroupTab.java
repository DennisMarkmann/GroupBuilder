package com.kn.groupBuilder.Gui.MainFrame;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.kn.groupBuilder.Gui.MainFrame.Listener.GroupTabListener;
import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Gui.TableModels.Implementations.JTableButtonMouseListener;
import com.kn.groupBuilder.Gui.TableModels.Implementations.JTableButtonRenderer;
import com.kn.groupBuilder.Storage.Pojo;

import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultTab;

/**
 * Second tab of the GUI. Used to access many other operations and to see the
 * different groups via table.
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

		//
		final JTable table = new JTable(GroupTableModel.createTable(pojo));
		final TableCellRenderer buttonRenderer = new JTableButtonRenderer();

		for (final String rowName : buttonRenderCols) {
			table.getColumn(rowName).setCellRenderer(buttonRenderer);
		}
		table.addMouseListener(new JTableButtonMouseListener(table));
		table.getTableHeader().addMouseListener(
				new JTableButtonMouseListener(table));

		final JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		BUILDER.setPosition(this, BUILDER.getGridBagConstraints(), 0, 0,
				scrollPane);

		// BUILDER.createTable(this, 0, 0,
		// new JTable(GroupTableModel.createTable(pojo)), buttonRenderCols);

		BUILDER.getGridBagConstraints().fill = GridBagConstraints.NONE;
		final JButton addButton = BUILDER.createButton(this, "addButton",
				"Add Group", 0, 5);
		final JButton createGroupsButton = BUILDER.createButton(this,
				"createGroupsButton", "Create Groups", 0, 6);
		final JButton saveButton = BUILDER.createButton(this, "saveButton",
				"Save", 0, 7);

		final GroupTabListener listener = new GroupTabListener(pojo);

		addButton.addActionListener(listener);
		createGroupsButton.addActionListener(listener);
		saveButton.addActionListener(listener);
	}
}
