package com.kn.groupBuilder.Gui.TableModels;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;

/**
 * The table shown in the memberTab.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public final class MemberTableModel extends AbstractTableModel {

    private static final long serialVersionUID = -3758449082711896808L;
    private final ArrayList<Member> memberList;
    private final String[] cols = { "FirstName", "LastName", "E-Mail", "Groups", "Edit", "Remove" };

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

        if (columnIndex == 0) {
            return (this.memberList.get(rowIndex).getFirstName());

        } else if (columnIndex == 1) {
            return (this.memberList.get(rowIndex).getLastName());

        } else if (columnIndex == 2) {
            return (this.memberList.get(rowIndex).getEMailAdress());

        } else if (columnIndex == 3) {
            return this.buildGroupList(rowIndex);

        } else if (columnIndex == 4) {
            return "";

        } else if (columnIndex == 5) {
            return "";
        }
        return null;
    }

    private String buildGroupList(final int index) {

        final StringBuilder text = new StringBuilder();
        final ArrayList<Group> groupList = this.memberList.get(index).getGroupList();

        for (final Group group : groupList) {
            if (text.length() != 0) {
                text.append(", ");
            }
            text.append(groupList.get(groupList.indexOf(group)).getName());
        }
        return text.toString();
    }
}
