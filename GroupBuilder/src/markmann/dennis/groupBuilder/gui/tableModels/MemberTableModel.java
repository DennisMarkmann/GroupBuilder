package markmann.dennis.groupBuilder.gui.tableModels;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import markmann.dennis.groupBuilder.gui.tableModels.listener.TableListener;
import markmann.dennis.groupBuilder.storage.Member;
import markmann.dennis.groupBuilder.storage.Pojo;
import dennis.markmann.MyLibraries.DefaultJobs.IconHelper.FileNotFoundException;
import dennis.markmann.MyLibraries.DefaultJobs.IconHelper.IconHelper;
import dennis.markmann.MyLibraries.GuiJobs.Builder.ComponentBuilder;

/**
 * The table shown in the memberTab.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class MemberTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -3758449082711896808L;
	private final ComponentBuilder componentBuilder = new ComponentBuilder();
	private static MemberTableModel instance = null;
	private Pojo pojo = null;
	private final ArrayList<Member> memberList;
	private final String[] cols = { "FirstName", "LastName", "E-Mail", "Group",
			"Edit", "Remove" };
	private final Class<?>[] columnTypes = new Class<?>[] { String.class,
			String.class, String.class, String.class, JButton.class,
			JButton.class };

	private MemberTableModel(final Pojo pojo) {
		this.pojo = pojo;
		this.memberList = pojo.getMemberList();
		Collections.sort(this.memberList);

	}

	public static TableModel createTable(final Pojo pojo) {
		if (instance == null) {
			instance = new MemberTableModel(pojo);
		}
		return instance;
	}

	public static void refreshTable() {
		Collections.sort(instance.memberList);
		instance.fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return this.memberList.size();
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
			return (this.memberList.get(rowIndex).getFirstName());

		case 1:
			return (this.memberList.get(rowIndex).getLastName());

		case 2:
			return (this.memberList.get(rowIndex).getEMailAdress());

		case 3:
			try {
				return (this.memberList.get(rowIndex).getGroup().getName());
			} catch (final java.lang.NullPointerException e) {
				return "";
			}

		case 4:
		case 5:
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
					this.pojo.getTranslation(this.cols[columnIndex] + "Member")));
			return button;

		default:
			return "Error";
		}
	}
}
