package markmann.dennis.groupBuilder.gui.mainFrame;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import markmann.dennis.groupBuilder.gui.mainFrame.listener.GroupTabListener;
import markmann.dennis.groupBuilder.gui.tableModels.GroupTableModel;
import markmann.dennis.groupBuilder.gui.tableModels.listener.JTableButtonMouseListener;
import markmann.dennis.groupBuilder.gui.tableModels.listener.JTableButtonRenderer;
import markmann.dennis.groupBuilder.storage.Pojo;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultTab;

/**
 * Second tab of the GUI. Used to access many other operations and to see the different groups via table.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class GroupTab extends JPanel implements DefaultTab {

    private final TableRowSorter<TableModel> sorter;

    private static final long serialVersionUID = 1673516265342795696L;

    GroupTab(final Pojo pojo) {

        final ArrayList<String> buttonRenderCols = new ArrayList<String>();
        buttonRenderCols.add("Edit");
        buttonRenderCols.add("Remove");

        BUILDER.setDefaultTabSettings(this);

        final TableModel model = GroupTableModel.createTable(pojo);

        final JTable table = new JTable(model);
        final TableCellRenderer buttonRenderer = new JTableButtonRenderer();

        for (final String rowName : buttonRenderCols) {
            table.getColumn(rowName).setCellRenderer(buttonRenderer);
        }
        table.addMouseListener(new JTableButtonMouseListener(table));

        this.sorter = new TableRowSorter<TableModel>();
        table.setRowSorter(this.sorter);
        this.sorter.setModel(model);

        final JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        BUILDER.setPosition(this, BUILDER.getGridBagConstraints(), 0, 0, scrollPane);

        BUILDER.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = BUILDER.createButton(this, "addButton", "Add Group", 0, 5);
        final JButton createGroupsButton = BUILDER.createButton(this, "createGroupsButton", "Create Groups", 0, 6);
        final JButton saveButton = BUILDER.createButton(this, "saveButton", "Save", 0, 7);

        final GroupTabListener listener = new GroupTabListener(pojo);

        addButton.addActionListener(listener);
        createGroupsButton.addActionListener(listener);
        saveButton.addActionListener(listener);
    }

    public void sort(final int columnIndex, final Comparator<?> comparator) {
        this.sorter.setComparator(columnIndex, comparator);
    }
}
