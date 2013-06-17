package com.kn.groupBuilder.Gui.TableModels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.kn.groupBuilder.Storage.Group;

public final class GroupTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -3758449082711896808L;
    private final ArrayList<Group> groupList;
    private final String[] cols = { "GroupName", "Description", "Size", "Edit", "Remove" };

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
    public Object getValueAt(final int rowIndex, final int columnIndex) {

        if (columnIndex == 0) {
            return this.groupList.get(rowIndex).getName();

        } else if (columnIndex == 1) {
            return this.groupList.get(rowIndex).getDescription();

        } else if (columnIndex == 2) {
            return this.groupList.get(rowIndex).getFixSize() + "";

        } else if (columnIndex == 3) {
            return "";

        } else if (columnIndex == 4) {
            return "";
        }
        return null;
    }
}
