package com.kn.groupBuilder.Gui.TableModels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.kn.groupBuilder.Storage.Member;

public final class MemberTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -3758449082711896808L;
    ArrayList<Member> memberList;
    private final String[] cols = { "FirstName", "LastName", "E-Mail" };

    public MemberTableModel(final ArrayList<Member> memberList) {
        this.memberList = memberList;
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
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        String content = "";
        if (columnIndex == 0) {
            content = this.memberList.get(rowIndex).getFirstName();

        } else if (columnIndex == 1) {
            content = this.memberList.get(rowIndex).getLastName();

        } else if (columnIndex == 2) {
            content = this.memberList.get(rowIndex).getEMailAdress();
        }
        return content;

    }
}
