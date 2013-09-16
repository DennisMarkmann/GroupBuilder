package com.kn.groupBuilder.Gui.TableModels.Implementations;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 * Renderer to enable adding JButtons to JTables.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class JTableButtonRenderer implements TableCellRenderer {

	@Override
	public final Component getTableCellRendererComponent(final JTable table,
			final Object value, final boolean isSelected,
			final boolean hasFocus, final int row, final int column) {
		final JButton button = (JButton) value;
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(UIManager.getColor("Button.background"));
		}
		return button;
	}
}
