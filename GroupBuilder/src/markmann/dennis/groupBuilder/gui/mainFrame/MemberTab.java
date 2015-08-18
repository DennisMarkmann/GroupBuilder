package markmann.dennis.groupBuilder.gui.mainFrame;

import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import markmann.dennis.groupBuilder.gui.mainFrame.listener.MemberTabListener;
import markmann.dennis.groupBuilder.gui.tableModels.MemberTableModel;
import markmann.dennis.groupBuilder.gui.tableModels.listener.JTableButtonMouseListener;
import markmann.dennis.groupBuilder.gui.tableModels.listener.JTableButtonRenderer;
import markmann.dennis.groupBuilder.storage.Pojo;
import dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations.DefaultTab;

/**
 * Main tab of the GUI. Used to access many other operations and to see the different member via table.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class MemberTab extends JPanel implements DefaultTab {

    private final TableRowSorter<TableModel> sorter;

    private static final long serialVersionUID = 3210114640051532404L;

    MemberTab(final Pojo pojo) {

        final ArrayList<String> buttonRenderCols = new ArrayList<String>();
        buttonRenderCols.add("Edit");
        buttonRenderCols.add("Remove");

        BUILDER.setDefaultTabSettings(this);

        final TableModel model = MemberTableModel.createTable(pojo);

        final JTable table = new JTable(model);
        final TableCellRenderer buttonRenderer = new JTableButtonRenderer();

        for (final String rowName : buttonRenderCols) {
            table.getColumn(rowName).setCellRenderer(buttonRenderer);
        }
        table.addMouseListener(new JTableButtonMouseListener(table));
        // table.getTableHeader().addMouseListener(
        // new JTableButtonMouseListener(table, null, this));

        final JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        BUILDER.setPosition(this, BUILDER.getGridBagConstraints(), 0, 0, scrollPane);

        this.sorter = new TableRowSorter<TableModel>();
        table.setRowSorter(this.sorter);
        this.sorter.setModel(model);

        BUILDER.getGridBagConstraints().fill = GridBagConstraints.NONE;
        final JButton addButton = BUILDER.createButton(this, "addButton", "Add Member", 0, 5);
        final JButton buildButton = BUILDER.createButton(this, "assignButton", "Assign Groups", 0, 6);
        final JButton saveButton = BUILDER.createButton(this, "saveButton", "Save", 0, 7);

        final MemberTabListener listener = new MemberTabListener(pojo);

        addButton.addActionListener(listener);
        buildButton.addActionListener(listener);
        saveButton.addActionListener(listener);

    }

}
