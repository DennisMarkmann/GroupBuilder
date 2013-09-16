package com.kn.groupBuilder.Gui.TableModels.Implementations;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;

/**
 * MouseListener to enable mouse events on JTables.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class JTableButtonMouseListener extends MouseAdapter {

	private final JTable table;

	public JTableButtonMouseListener(final JTable table) {
		this.table = table;
	}

	@Override
	public final void mouseClicked(final MouseEvent e) {
		final int column = this.table.getColumnModel().getColumnIndexAtX(
				e.getX());
		final int row = e.getY() / this.table.getRowHeight();
		final int index = this.table.columnAtPoint(e.getPoint());

		if (index >= 0) {
			// TODO
			// System.out.println(this.table.getColumnName(index));
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
