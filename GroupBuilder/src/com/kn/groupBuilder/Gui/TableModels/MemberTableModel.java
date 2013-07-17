package com.kn.groupBuilder.Gui.TableModels;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;

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
    private final ArrayList<Member> memberList;
    private final String[] cols = { "FirstName", "LastName", "E-Mail", "Groups", "Edit", "Remove" };
    private final Class<?>[] columnTypes = new Class<?>[] {
            String.class,
            String.class,
            String.class,
            String.class,
            JButton.class,
            JButton.class };

    private MemberTableModel(final ArrayList<Member> memberList) {
        Collections.sort(memberList);
        this.memberList = memberList;
    }

    public static TableModel createTable(final ArrayList<Member> memberList) {
        if (instance == null) {
            instance = new MemberTableModel(memberList);
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
            return this.buildGroupList(rowIndex);

        case 4:
        case 5:
            ImageIcon buttonIcon = null;
            InputStream buttonName = null;
            try {
                if (this.cols[columnIndex].equals("Remove")) {
                    buttonName = this.getClass()
                            .getClassLoader()
                            .getResourceAsStream("com/kn/groupBuilder/Gui/TableModels/Icons/Delete_Icon2.png");
                } else if (this.cols[columnIndex].equals("Edit")) {
                    buttonName = this.getClass()
                            .getClassLoader()
                            .getResourceAsStream("com/kn/groupBuilder/Gui/TableModels/Icons/Edit_Icon.png");
                }
                buttonIcon = new ImageIcon(ImageIO.read(buttonName));
            } catch (final IOException e) {
                e.printStackTrace();
            }

            final JButton button = this.componentBuilder.createButton(this.cols[columnIndex] + "Button", "");

            button.setIcon(buttonIcon);
            return button;
        default:
            return "Error";
        }
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
