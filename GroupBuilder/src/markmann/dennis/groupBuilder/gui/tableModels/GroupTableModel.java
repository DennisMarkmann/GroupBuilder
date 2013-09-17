package markmann.dennis.groupBuilder.gui.tableModels;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import markmann.dennis.groupBuilder.gui.tableModels.listener.TableListener;
import markmann.dennis.groupBuilder.storage.Group;
import markmann.dennis.groupBuilder.storage.Pojo;
import dennis.markmann.MyLibraries.DefaultJobs.IconHelper.FileNotFoundException;
import dennis.markmann.MyLibraries.DefaultJobs.IconHelper.IconHelper;
import dennis.markmann.MyLibraries.GuiJobs.Builder.ComponentBuilder;

/**
 * The table shown in the groupTab.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class GroupTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -3758449082711896808L;
	private final ComponentBuilder componentBuilder = new ComponentBuilder();
	private static GroupTableModel instance = null;
	private Pojo pojo = null;
	private final ArrayList<Group> groupList;
	private final String[] cols = { "GroupName", "Description", "FixSize",
			"Edit", "Remove" };
	private final Class<?>[] columnTypes = new Class<?>[] { String.class,
			String.class, String.class, JButton.class, JButton.class };

	private GroupTableModel(final Pojo pojo) {
		this.pojo = pojo;
		this.groupList = pojo.getGroupList();
		Collections.sort(this.groupList);
	}

	public static TableModel createTable(final Pojo pojo) {
		if (instance == null) {
			instance = new GroupTableModel(pojo);
		}
		return instance;
	}

	public static void refreshTable() {
		Collections.sort(instance.groupList);
		instance.fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return this.groupList.size();
	}

	@Override
	public int getColumnCount() {
		return this.cols.length;
	}

	@Override
	public String getColumnName(final int col) {
		return this.cols[col];
	}

	@Override
	public Class<?> getColumnClass(final int columnIndex) {
		return this.columnTypes[columnIndex];
	}

	@Override
	public Object getValueAt(final int rowIndex, final int columnIndex) {

		switch (columnIndex) {
		case 0:
			return this.groupList.get(rowIndex).getName();

		case 1:
			return this.groupList.get(rowIndex).getDescription();

		case 2:
			return this.groupList.get(rowIndex).getFixSize() + "";

		case 3:
		case 4:
			final JButton button = this.componentBuilder.createButton(
					this.cols[columnIndex] + "Button", "");

			if (this.cols[columnIndex].equals("Remove")) {
				try {
					button.setIcon(new IconHelper()
							.getIcon("com/kn/groupBuilder/Gui/TableModels/Icons/Delete_Icon.png"));
				} catch (final FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (this.cols[columnIndex].equals("Edit")) {
				try {
					button.setIcon(new IconHelper()
							.getIcon("com/kn/groupBuilder/Gui/TableModels/Icons/Edit_Icon.png"));
				} catch (final FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			button.addActionListener(new TableListener(this.pojo, rowIndex,
					this.pojo.getTranslation(this.cols[columnIndex] + "Group")));
			return button;

		default:
			return "Error";
		}
	}
}
