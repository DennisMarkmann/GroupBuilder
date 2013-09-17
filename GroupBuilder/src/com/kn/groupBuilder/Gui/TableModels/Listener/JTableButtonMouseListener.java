package com.kn.groupBuilder.Gui.TableModels.Listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.MainFrame.GroupTab;
import com.kn.groupBuilder.Gui.MainFrame.MemberTab;

/**
 * MouseListener to enable mouse events on JTables.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class JTableButtonMouseListener extends MouseAdapter {

	private final JTable table;
	private final GroupTab groupTab;
	private final MemberTab memberTab;

	public JTableButtonMouseListener(final JTable table,
			final GroupTab groupTab, final MemberTab memberTab) {

		this.table = table;
		this.groupTab = groupTab;
		this.memberTab = memberTab;
	}

	@Override
	public final void mouseClicked(final MouseEvent e) {
		final int column = this.table.getColumnModel().getColumnIndexAtX(
				e.getX());
		final int row = e.getY() / this.table.getRowHeight();
		final int index = this.table.columnAtPoint(e.getPoint());

		if (index >= 0) {

			System.out.println(this.table.getColumnName(index));
			// if (this.groupTab != null) {
			// // this.groupTab.sort(index, new LastNameComparator());
			// }
			// if (this.memberTab != null) {
			// this.memberTab.sort(index, new LastNameComparator());
			// }
		}

		if (row < this.table.getRowCount() && row >= 0
				&& column < this.table.getColumnCount() && column >= 0) {
			final Object value = this.table.getValueAt(row, column);
			if (value instanceof JButton) {
				((JButton) value).doClick();
			}
		}
	}
}
