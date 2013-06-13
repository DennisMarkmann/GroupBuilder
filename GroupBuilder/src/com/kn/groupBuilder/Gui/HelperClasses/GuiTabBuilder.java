package com.kn.groupBuilder.Gui.HelperClasses;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.kn.groupBuilder.Gui.TableModels.GroupTableModel;
import com.kn.groupBuilder.Gui.TableModels.MemberTableModel;
import com.kn.groupBuilder.Storage.Group;
import com.kn.groupBuilder.Storage.Member;

public class GuiTabBuilder {

    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public GuiTabBuilder() {

        this.gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        this.gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.gridBagConstraints.weightx = 2;
    }

    public final JButton createButton(
            final JPanel jPanel,
            final String buttonName,
            final String buttonText,
            final int gridxValue,
            final int gridyValue) {

        final JButton button = new JButton(buttonText);
        this.setName(button, buttonName);
        this.setPosition(jPanel, this.gridBagConstraints, gridxValue, gridyValue, button);

        return button;
    }

    private final JScrollPane createTable(final JPanel jPanel, final int gridxValue, final int gridyValue, final JTable jTable) {

        final JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        this.setPosition(jPanel, this.gridBagConstraints, gridxValue, gridyValue, scrollPane);
        return scrollPane;

    }

    public final JScrollPane createGroupTable(
            final ArrayList<Group> tableContent,
            final JPanel jPanel,
            final int gridxValue,
            final int gridyValue) {

        final JTable groupTable = new JTable(new GroupTableModel(tableContent));
        final JScrollPane scrollPane = this.createTable(jPanel, gridxValue, gridyValue, groupTable);

        return scrollPane;
    }

    public final JScrollPane createMemberTable(
            final ArrayList<Member> tableContent,
            final JPanel jPanel,
            final int gridxValue,
            final int gridyValue) {

        final JTable memberTable = new JTable(new MemberTableModel(tableContent));
        final JScrollPane scrollPane = this.createTable(jPanel, gridxValue, gridyValue, memberTable);

        return scrollPane;
    }

    private void setName(final Component object, final String objectName) {
        object.setName(objectName);
    }

    private void setPosition(
            final JPanel jPanel,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue,
            final Component object) {

        c.gridx = gridxValue;
        c.gridy = gridyValue;
        jPanel.add(object, c);
    }

    public final GridBagConstraints getGridBagConstraints() {
        return this.gridBagConstraints;

    }
}
