package com.kn.groupBuilder.Gui.TableModels;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.kn.groupBuilder.Storage.Group;

/**
 * The table shown in the groupTab.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class GroupTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -3758449082711896808L;
    private final ArrayList<Group> groupList;
    private final String[] cols = { "GroupName", "Description", "Size", "Edit", "Remove" };
    private final Class<?>[] columnTypes = new Class<?>[] {
            String.class,
            String.class,
            String.class,
            JButton.class,
            JButton.class };

    public GroupTableModel(final ArrayList<Group> groupList) {
        this.groupList = groupList;
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
            // final JButton button = new JButton(this.cols[columnIndex]);
            // return button;
            return "";
        case 4:
            // final JButton button = new JButton(this.cols[columnIndex]);
            // return button;
            return "";

        default:
            return "Error";
        }
    }
}
